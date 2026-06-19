package ucms.gui.driver;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.table.DefaultTableModel;
import ucms.Driver;
import ucms.database.DBConnection;

public class DriverDB {
    
    /**
     * Load pending bookings for the driver's carpools
     */
    public static void loadPendingBookings(Driver driver, DefaultTableModel model) {
    System.out.println("DEBUG >> student_id passed in: " + driver.getStudent_id());  // ADD THIS
        try {
            // Clear existing rows
            model.setRowCount(0);
            
            Connection conn = DBConnection.getConnection();
            
            // Find driver_id from student_id
            String driverIdQuery = "SELECT driver_id FROM driver WHERE student_id = ?";
            PreparedStatement driverStmt = conn.prepareStatement(driverIdQuery);
            driverStmt.setString(1, driver.getStudent_id());
            ResultSet driverRs = driverStmt.executeQuery();
            
            if (!driverRs.next()) {
                conn.close();
                return;
            }
            
            String driverId = driverRs.getString("driver_id");
            
            // Query to get pending bookings for this driver's carpools
            String query = "SELECT b.booking_id, s.student_name, s.student_id, b.booking_date, b.booking_status " +
                          "FROM booking b " +
                          "JOIN carpool c ON b.carpool_id = c.carpool_id " +
                          "JOIN passenger p ON b.passenger_id = p.passenger_id " +
                          "JOIN student s ON p.student_id = s.student_id " +
                          "WHERE c.driver_id = ? AND b.booking_status = 'PENDING' " +
                          "ORDER BY b.booking_id";
            
            PreparedStatement pstmt = conn.prepareStatement(query);
            pstmt.setString(1, driverId);
            ResultSet rs = pstmt.executeQuery();
            
            int rowNum = 1;
            while (rs.next()) {
                Object[] row = {
                    rowNum++,
                    rs.getString("student_name"),
                    rs.getString("student_id"),
                    rs.getDate("booking_date"),
                    rs.getString("booking_status")
                };
                model.addRow(row);
            }
            
            rs.close();
            pstmt.close();
            driverRs.close();
            driverStmt.close();
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Error loading pending bookings: " + e.getMessage());
            e.printStackTrace();
        }
    }
    
    /**
     * Update booking status to APPROVED or REJECTED
     */
    public static void updateBookingStatus(int rowIndex, String status, DefaultTableModel model) {
        try {
            // Get booking_id from the model (stored in first column, but we need to find actual booking_id)
            // We need to query the database to get the actual booking_id based on student_name and status
            String studentName = (String) model.getValueAt(rowIndex, 1);
            String studentId = (String) model.getValueAt(rowIndex, 2);
            
            Connection conn = DBConnection.getConnection();
            
            // Find the booking_id for this student with PENDING status
            String bookingQuery = "SELECT b.booking_id FROM booking b " +
                                "JOIN passenger p ON b.passenger_id = p.passenger_id " +
                                "JOIN student s ON p.student_id = s.student_id " +
                                "WHERE s.student_name = ? AND s.student_id = ? AND b.booking_status = 'PENDING' " +
                                "LIMIT 1";
            
            PreparedStatement bookingStmt = conn.prepareStatement(bookingQuery);
            bookingStmt.setString(1, studentName);
            bookingStmt.setString(2, studentId);
            ResultSet bookingRs = bookingStmt.executeQuery();
            
            if (!bookingRs.next()) {
                conn.close();
                return;
            }
            
            String bookingId = bookingRs.getString("booking_id");
            
            // Update booking status
            String updateQuery = "UPDATE booking SET booking_status = ? WHERE booking_id = ?";
            PreparedStatement updateStmt = conn.prepareStatement(updateQuery);
            updateStmt.setString(1, status);
            updateStmt.setString(2, bookingId);
            updateStmt.executeUpdate();
            
            updateStmt.close();
            bookingRs.close();
            bookingStmt.close();
            conn.close();
            
        } catch (Exception e) {
            System.err.println("Error updating booking status: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
