package co.edu.unicolombo.s3.poo.inventory.library.Guis.ChatBot;

import javax.swing.*;
import java.awt.*;

public class BubblePanel extends JPanel {

    private Color backgroundColor;
    private int radius = 15;

    public BubblePanel(Color bgColor) {
        this.backgroundColor = bgColor;
        setOpaque(false);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); // Asegura que los componentes hijos se rendericen correctamente

        Graphics2D g2 = (Graphics2D) g.create();
        g2.setColor(backgroundColor);
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();
    }
}
