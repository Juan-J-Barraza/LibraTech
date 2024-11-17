package co.edu.unicolombo.s3.poo.inventory.library.Guis.ChatBot;

import javax.swing.*;
import javax.swing.text.View;
import java.awt.*;

public class ChatMessage extends JPanel {

    public ChatMessage(String message, boolean isUser) {
        setLayout(new BorderLayout());
        setOpaque(false);

        // Ancho máximo para el mensaje
        int maxWidth = 300;

        // Crear el JLabel para el mensaje
        JLabel messageLabel = new JLabel();
        messageLabel.setText("<html><body style='width: " + maxWidth + "px'>" + message + "</body></html>");
        messageLabel.setFont(new Font("Arial", Font.PLAIN, 14));
        messageLabel.setBorder(BorderFactory.createEmptyBorder(5, 10, 5, 10));
        messageLabel.setForeground(Color.BLACK);
        messageLabel.setOpaque(false); // Fondo transparente para que se vea el BubblePanel

        // Colores para usuario y bot
        Color userColor = new Color(220, 248, 198); // Verde claro
        Color botColor = new Color(237, 237, 237); // Gris claro

        // Panel para la burbuja del mensaje
        BubblePanel bubble = new BubblePanel(isUser ? userColor : botColor);
        bubble.setLayout(new BorderLayout());
        bubble.add(messageLabel, BorderLayout.CENTER);
        bubble.setBorder(messageLabel.getBorder());
        bubble.setOpaque(false);

        // Panel para alinear la burbuja
        JPanel alignPanel = new JPanel(new BorderLayout());
        alignPanel.setOpaque(false);
        if (isUser) {
            alignPanel.add(bubble, BorderLayout.EAST);
        } else {
            alignPanel.add(bubble, BorderLayout.WEST);
        }

        add(alignPanel, BorderLayout.CENTER);
        setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
    }
}
