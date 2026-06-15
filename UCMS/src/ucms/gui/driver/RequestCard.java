package ucms.gui.driver;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class RequestCard extends JPanel {

    public RequestCard(String initials, String name, String route, String seats) {
        setLayout(new BorderLayout(12, 0));
        setBackground(new Color(48, 48, 46));
        setBorder(new EmptyBorder(12, 15, 12, 15));
        setOpaque(true);
        setMaximumSize(new Dimension(Integer.MAX_VALUE, 70));

        // Avatar
        JPanel avatar = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(new Color(70, 90, 110));
                g2.fillOval(0, 0, getWidth(), getHeight());
                g2.setColor(Color.WHITE);
                g2.setFont(new Font("Segoe UI", Font.BOLD, 13));
                FontMetrics fm = g2.getFontMetrics();
                int x = (getWidth() - fm.stringWidth(initials)) / 2;
                int y = (getHeight() + fm.getAscent() - fm.getDescent()) / 2;
                g2.drawString(initials, x, y);
                g2.dispose();
            }
        };
        avatar.setPreferredSize(new Dimension(44, 44));
        avatar.setOpaque(false);

        // Info
        JPanel info = new JPanel();
        info.setLayout(new BoxLayout(info, BoxLayout.Y_AXIS));
        info.setOpaque(false);

        JLabel nameLabel = new JLabel(name);
        nameLabel.setFont(new Font("Segoe UI", Font.BOLD, 13));
        nameLabel.setForeground(Color.WHITE);

        JLabel detailLabel = new JLabel(route + "  ·  " + seats);
        detailLabel.setFont(new Font("Segoe UI", Font.PLAIN, 12));
        detailLabel.setForeground(new Color(160, 160, 160));

        info.add(nameLabel);
        info.add(Box.createVerticalStrut(4));
        info.add(detailLabel);

        add(avatar, BorderLayout.WEST);
        add(info, BorderLayout.CENTER);
    }
}