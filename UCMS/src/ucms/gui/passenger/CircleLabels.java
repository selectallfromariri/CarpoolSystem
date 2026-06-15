/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms.gui.passenger;

/**
 *
 * @author User
 */
import ucms.gui.driver.*;
import java.awt.*;
import javax.swing.*;
public class CircleLabels extends JLabel {

    private BasicStroke stroke;
    private Color borderColor;

    public CircleLabels() {
        this(Color.YELLOW, 2);
    }

    public CircleLabels(Color borderColor, int borderWidth) {
        this.stroke = new BasicStroke(borderWidth);
        this.borderColor = borderColor;
        setPreferredSize(new Dimension(100, 100));
        setText("DA");
        setFont(new Font("Segoe UI", Font.BOLD, 20));
        setForeground(borderColor);
        setHorizontalAlignment(JLabel.CENTER);
        setVerticalAlignment(JLabel.CENTER);
        setOpaque(false); 
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillOval(0, 0, getWidth(), getHeight());

        g2.dispose();

        super.paintComponent(g);
    }

    @Override
    protected void paintBorder(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
        RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(borderColor);
        g2.setStroke(stroke);
        g2.drawOval(1, 1, getWidth() - 2, getHeight() - 2);
        g2.dispose();
    }

    @Override
    public boolean contains(int x, int y) {
        int radius = getWidth() / 2;
        return Math.pow(x - radius, 2) + Math.pow(y - radius, 2) <= radius * radius;
    }
}
