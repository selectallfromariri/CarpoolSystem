/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ucms.gui.authentication;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GradientPaint;
import java.awt.RenderingHints;
import javax.swing.JPanel;

public class RoundedPanel extends JPanel {
    private int radius = 16;
    private Color strokeColor = new Color(0x33, 0x33, 0x33);

    public RoundedPanel(int radius, Color background, Color strokeColor) {
        this.radius = radius;
        this.strokeColor = strokeColor;
        setOpaque(false);
        setBackground(background);
    }

    @Override    
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                        RenderingHints.VALUE_ANTIALIAS_ON);

        int shadowSize = 8;

        // shadow
        for (int i = shadowSize; i >= 1; i--) {
        int alpha = (int) (20.0 * (i / (float) shadowSize));
        g2.setColor(new Color(0, 0, 0, alpha));

        g2.fillRoundRect(i,i,getWidth() - i * 2,getHeight() - i * 2,radius,radius);
        }

        // main panel
        GradientPaint gp = new GradientPaint(0, 0, getBackground().brighter(),0, getHeight(), getBackground());
        g2.setPaint(gp);
        g2.fillRoundRect(0,0,getWidth() - shadowSize, getHeight() - shadowSize,radius,radius);    
        
        // Border
        g2.setColor(strokeColor);
        g2.drawRoundRect(0,0,getWidth() - shadowSize,getHeight() - shadowSize,radius,radius);
        g2.dispose();
        }
}