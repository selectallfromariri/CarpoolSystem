package ucms.gui.driver;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class UpcomingTripsPanel extends JPanel {

    public UpcomingTripsPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(40, 40, 38));
        setBorder(BorderFactory.createLineBorder(new Color(70, 70, 68), 1, true));

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        header.setBorder(new EmptyBorder(15, 15, 10, 15));

        JLabel title = new JLabel("Upcoming Trips");
        title.setFont(new Font("Segoe UI", Font.BOLD, 16));
        title.setForeground(Color.WHITE);

        JLabel viewAll = new JLabel("View all >");
        viewAll.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        viewAll.setForeground(new Color(160, 160, 160));
        viewAll.setCursor(new Cursor(Cursor.HAND_CURSOR));

        header.add(title, BorderLayout.WEST);
        header.add(viewAll, BorderLayout.EAST);

        // List
        JPanel listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(new Color(40, 40, 38));
        listPanel.setBorder(new EmptyBorder(0, 5, 10, 5));

        String[][] trips = {
            {"Gambang → UMP Pekan",  "Today, 4:30 PM",    "3/4 seats filled", "Scheduled"},
            {"UMP Pekan → Kuantan",  "Tomorrow, 8:00 AM", "1/3 seats filled", "Scheduled"},
            {"Kuantan → Gambang",    "14 June, 5:00 PM",  "0/4 seats filled", "Open"},
        };

        for (int i = 0; i < trips.length; i++) {
            listPanel.add(new TripCard(trips[i][0], trips[i][1], trips[i][2], trips[i][3]));
            if (i < trips.length - 1) {
                JSeparator sep = new JSeparator();
                sep.setForeground(new Color(70, 70, 68));
                sep.setMaximumSize(new Dimension(Integer.MAX_VALUE, 1));
                listPanel.add(sep);
            }
        }

        JScrollPane scroll = new JScrollPane(listPanel);
        scroll.setOpaque(false);
        scroll.getViewport().setOpaque(false);
        scroll.setBorder(null);
        scroll.getVerticalScrollBar().setUnitIncrement(10);

        add(header, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
}