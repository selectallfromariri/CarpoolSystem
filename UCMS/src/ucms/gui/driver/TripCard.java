package ucms.gui.driver;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class TripCard extends JPanel {

    public TripCard(String route, String datetime, String seats, String status) {
        setLayout(new BorderLayout(10, 0));
        setBackground(new Color(48, 48, 46));
        setBorder(new EmptyBorder(12, 15, 12, 15));
        setOpaque(true);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

        JPanel infoPanel = new JPanel();
        infoPanel.setLayout(new BoxLayout(infoPanel, BoxLayout.Y_AXIS));
        infoPanel.setOpaque(false);

        JLabel routeLabel = new JLabel(route);
        routeLabel.setFont(new Font("Segoe UI", Font.BOLD, 14));
        routeLabel.setForeground(Color.WHITE);

        JLabel detailLabel = new JLabel(datetime + "  ·  " + seats);
        detailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        detailLabel.setForeground(new Color(160, 160, 160));

        infoPanel.add(routeLabel);
        infoPanel.add(Box.createVerticalStrut(4));
        infoPanel.add(detailLabel);

        // Badge
        JLabel badge = new JLabel(status, SwingConstants.CENTER) {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
                g2.dispose();
                super.paintComponent(g);
            }
        };
        badge.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        badge.setPreferredSize(new Dimension(90, 28));
        badge.setOpaque(false);

        if (status.equals("Scheduled")) {
            badge.setForeground(new Color(40, 40, 38));
            badge.setBackground(new Color(100, 220, 130));
        } else {
            badge.setForeground(new Color(40, 40, 38));
            badge.setBackground(new Color(245, 166, 35));
        }

        add(infoPanel, BorderLayout.CENTER);
        add(badge, BorderLayout.EAST);
    }
}