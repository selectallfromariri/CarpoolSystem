package ucms.gui.authentication;

import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.BorderFactory;
import javax.swing.JButton;

public class RoundedButton extends JButton {
    private static final int RADIUS = 24;
    private static final int SHADOW_SIZE = 1;
    private Color fillColor;

    public RoundedButton(String text, Color fillColor) {
        super(text);
        this.fillColor = fillColor;
        setContentAreaFilled(false);
        setFocusPainted(false);
        setForeground(Color.WHITE);
        setBorder(BorderFactory.createEmptyBorder(8, 22, 8 + SHADOW_SIZE, 22));
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        int w = getWidth();
        boolean pressed = getModel().isPressed();
        int shadowGap = pressed ? 2 : SHADOW_SIZE;
        int h = getHeight() - SHADOW_SIZE;

        // shadow
        for (int i = 0; i < shadowGap; i++) {
            int alpha = 60 - (i * (60 / shadowGap));
            g2.setColor(new Color(0, 0, 0, Math.max(alpha, 0)));
            g2.fillRoundRect(2, h - 2 + i, w - 4, 4, RADIUS, RADIUS);
        }

        // gradient
        Color top = getModel().isRollover() ? fillColor.brighter() : fillColor;
        Color bottom = fillColor.darker();
        GradientPaint gp = new GradientPaint(0, 0, top, 0, h, bottom);
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, w - 1, h - 1, RADIUS, RADIUS);

        // shighlight
        g2.setColor(new Color(255, 255, 255, 40));
        g2.fillRoundRect(2, 2, w - 5, h / 2, RADIUS, RADIUS);

        g2.dispose();
        super.paintComponent(g);
    }
}