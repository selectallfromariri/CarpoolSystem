package ucms.gui.driver;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RecentRequestsPanel extends JPanel {

    public RecentRequestsPanel() {
        setLayout(new BorderLayout());
        setBackground(new Color(40, 40, 38));
        setBorder(BorderFactory.createLineBorder(new Color(70, 70, 68), 1, true));

        // Header
        JPanel header = new JPanel(new BorderLayout());
        header.setOpaque(false);
        header.setBorder(new EmptyBorder(15, 15, 10, 15));

        JLabel title = new JLabel("Recent Requests");
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

        String[][] requests = {
            {"SN", "Siti Nurhaliza", "Gambang → UMP Pekan", "1 seat"},
            {"RH", "Razif Hakim",    "Gambang → UMP Pekan", "2 seats"},
            {"NA", "Nurul Ain",      "UMP Pekan → Kuantan", "1 seat"},
        };

        for (int i = 0; i < requests.length; i++) {
            listPanel.add(new RequestCard(requests[i][0], requests[i][1], requests[i][2], requests[i][3]));
            if (i < requests.length - 1) {
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

        add(header, BorderLayout.NORTH);
        add(scroll, BorderLayout.CENTER);
    }
}