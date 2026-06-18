package ucms.gui.passenger;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.time.LocalDate;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;
import ucms.Passenger;

final class PassengerDB {

    private PassengerDB() {
    }

    static String findPassengerId(Connection conn, Passenger passenger) throws Exception {
        String sql = "SELECT passenger_id FROM passenger WHERE student_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, passenger.getStudent_id());
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getString("passenger_id");
                }
            }
        }
        throw new Exception("Passenger record not found for " + passenger.getStudent_id());
    }

    static void loadCarpools(DefaultTableModel model, String keyword) throws Exception {
        model.setRowCount(0);
        String search = keyword == null ? "" : keyword.trim();

        String sql
                = "SELECT c.carpool_id, s.student_name, c.destination, c.date, "
                + "c.available_seat, c.luggage_capacity, c.pickup_location "
                + "FROM carpool c "
                + "JOIN driver d ON c.driver_id = d.driver_id "
                + "JOIN student s ON d.student_id = s.student_id "
                + "WHERE (? = '' OR c.destination LIKE ? OR c.pickup_location LIKE ? OR s.student_name LIKE ?) "
                + "ORDER BY c.date, c.carpool_id";

        try (Connection conn = ucms.database.DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            String like = "%" + search + "%";
            ps.setString(1, search);
            ps.setString(2, like);
            ps.setString(3, like);
            ps.setString(4, like);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("carpool_id"),
                        rs.getString("student_name"),
                        rs.getString("destination"),
                        rs.getDate("date").toString(),
                        rs.getInt("available_seat"),
                        rs.getInt("luggage_capacity"),
                        rs.getString("pickup_location")
                    });
                }
            }
        }
    }

    static void loadBookings(Passenger passenger, DefaultTableModel model, boolean ongoingOnly) throws Exception {
        model.setRowCount(0);
        String statusFilter = ongoingOnly ? "AND b.booking_status = 'ONGOING' " : "AND b.booking_status <> 'COMPLETED' ";
        String action = ongoingOnly ? "Complete / Feedback" : "Cancel";

        String sql
                = "SELECT b.booking_id, c.carpool_id, c.destination, c.date, b.booking_status "
                + "FROM booking b "
                + "JOIN passenger p ON b.passenger_id = p.passenger_id "
                + "JOIN carpool c ON b.carpool_id = c.carpool_id "
                + "WHERE p.student_id = ? "
                + statusFilter
                + "ORDER BY c.date, b.booking_id";

        try (Connection conn = ucms.database.DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, passenger.getStudent_id());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("booking_id"),
                        rs.getString("carpool_id"),
                        rs.getString("destination"),
                        rs.getDate("date").toString(),
                        rs.getString("booking_status"),
                        action
                    });
                }
            }
        }
    }

    static void loadHistory(Passenger passenger, DefaultTableModel model) throws Exception {
        model.setRowCount(0);
        String sql
                = "SELECT b.booking_id, c.destination, b.booking_date, b.booking_status "
                + "FROM booking b "
                + "JOIN passenger p ON b.passenger_id = p.passenger_id "
                + "JOIN carpool c ON b.carpool_id = c.carpool_id "
                + "WHERE p.student_id = ? "
                + "AND b.booking_status IN ('COMPLETED', 'CANCELLED', 'REJECTED') "
                + "ORDER BY b.booking_date DESC, b.booking_id";

        try (Connection conn = ucms.database.DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, passenger.getStudent_id());
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    model.addRow(new Object[]{
                        rs.getString("booking_id"),
                        rs.getString("destination"),
                        rs.getDate("booking_date").toString(),
                        rs.getString("booking_status")
                    });
                }
            }
        }
    }

    static void createBooking(Passenger passenger, String carpoolId) throws Exception {
        try (Connection conn = ucms.database.DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                String passengerId = findPassengerId(conn, passenger);
                int seats;
                try (PreparedStatement ps = conn.prepareStatement(
                        "SELECT available_seat FROM carpool WHERE carpool_id = ? FOR UPDATE")) {
                    ps.setString(1, carpoolId);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (!rs.next()) {
                            throw new Exception("Carpool not found.");
                        }
                        seats = rs.getInt("available_seat");
                    }
                }

                if (seats <= 0) {
                    throw new Exception("No seats available.");
                }

                try (PreparedStatement ps = conn.prepareStatement(
                        "SELECT booking_id FROM booking WHERE passenger_id = ? AND carpool_id = ? "
                        + "AND booking_status IN ('PENDING', 'APPROVED', 'CONFIRMED', 'ONGOING')")) {
                    ps.setString(1, passengerId);
                    ps.setString(2, carpoolId);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            throw new Exception("You already booked this carpool.");
                        }
                    }
                }

                String bookingId = nextId(conn, "booking", "booking_id", "BK");
                try (PreparedStatement ps = conn.prepareStatement(
                        "INSERT INTO booking (booking_id, booking_date, booking_status, passenger_id, carpool_id) "
                        + "VALUES (?, ?, 'PENDING', ?, ?)")) {
                    ps.setString(1, bookingId);
                    ps.setDate(2, Date.valueOf(LocalDate.now()));
                    ps.setString(3, passengerId);
                    ps.setString(4, carpoolId);
                    ps.executeUpdate();
                }

                try (PreparedStatement ps = conn.prepareStatement(
                        "UPDATE carpool SET available_seat = available_seat - 1 WHERE carpool_id = ?")) {
                    ps.setString(1, carpoolId);
                    ps.executeUpdate();
                }

                conn.commit();
            } catch (Exception ex) {
                conn.rollback();
                throw ex;
            }
        }
    }

    static void cancelBooking(String bookingId) throws Exception {
        try (Connection conn = ucms.database.DBConnection.getConnection()) {
            conn.setAutoCommit(false);
            try {
                String carpoolId = null;
                String status = null;
                try (PreparedStatement ps = conn.prepareStatement(
                        "SELECT carpool_id, booking_status FROM booking WHERE booking_id = ? FOR UPDATE")) {
                    ps.setString(1, bookingId);
                    try (ResultSet rs = ps.executeQuery()) {
                        if (rs.next()) {
                            carpoolId = rs.getString("carpool_id");
                            status = rs.getString("booking_status");
                        }
                    }
                }

                if (carpoolId == null) {
                    throw new Exception("Booking not found.");
                }
                if ("COMPLETED".equalsIgnoreCase(status) || "CANCELLED".equalsIgnoreCase(status)) {
                    throw new Exception("Booking cannot be cancelled.");
                }

                try (PreparedStatement ps = conn.prepareStatement(
                        "UPDATE booking SET booking_status = 'CANCELLED' WHERE booking_id = ?")) {
                    ps.setString(1, bookingId);
                    ps.executeUpdate();
                }
                try (PreparedStatement ps = conn.prepareStatement(
                        "UPDATE carpool SET available_seat = available_seat + 1 WHERE carpool_id = ?")) {
                    ps.setString(1, carpoolId);
                    ps.executeUpdate();
                }
                conn.commit();
            } catch (Exception ex) {
                conn.rollback();
                throw ex;
            }
        }
    }

    static void completeBooking(String bookingId) throws Exception {
        try (Connection conn = ucms.database.DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(
                        "UPDATE booking SET booking_status = 'COMPLETED' WHERE booking_id = ?")) {
            ps.setString(1, bookingId);
            if (ps.executeUpdate() == 0) {
                throw new Exception("Booking not found.");
            }
        }
    }

    static void loadDrivers(JComboBox<String> comboBox) throws Exception {
        comboBox.removeAllItems();
        String sql
                = "SELECT d.driver_id, s.student_name "
                + "FROM driver d JOIN student s ON d.student_id = s.student_id "
                + "WHERE d.approved = 1 ORDER BY s.student_name";
        try (Connection conn = ucms.database.DBConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                comboBox.addItem(rs.getString("driver_id") + " - " + rs.getString("student_name"));
            }
        }
    }

    static void submitFeedback(Passenger passenger, String driverItem, String comment) throws Exception {
        String driverId = driverItem.split(" - ", 2)[0];
        try (Connection conn = ucms.database.DBConnection.getConnection()) {
            String feedbackId = nextId(conn, "feedback", "feedback_id", "FB");
            try (PreparedStatement ps = conn.prepareStatement(
                    "INSERT INTO feedback (feedback_id, comment, driver_id, student_id) VALUES (?, ?, ?, ?)")) {
                ps.setString(1, feedbackId);
                ps.setString(2, comment);
                ps.setString(3, driverId);
                ps.setString(4, passenger.getStudent_id());
                ps.executeUpdate();
            }
        }
    }

    private static String nextId(Connection conn, String table, String column, String prefix) throws Exception {
        String sql = "SELECT " + column + " FROM " + table + " WHERE " + column + " LIKE ? ORDER BY " + column + " DESC LIMIT 1";
        int next = 1;
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, prefix + "%");
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    String current = rs.getString(1).replaceAll("\\D+", "");
                    if (!current.isEmpty()) {
                        next = Integer.parseInt(current) + 1;
                    }
                }
            }
        }
        return String.format("%s%03d", prefix, next);
    }
}
