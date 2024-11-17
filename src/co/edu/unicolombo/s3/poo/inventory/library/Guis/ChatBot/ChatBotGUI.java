package co.edu.unicolombo.s3.poo.inventory.library.Guis.ChatBot;

import javax.swing.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.AiService;

import java.awt.*;

public class ChatBotGUI extends JFrame {

    private JPanel chatPanel;
    private JScrollPane scrollPane;
    private JTextField inputField;
    private JButton sendButton;
    private AiService aiService;

    public ChatBotGUI(AiService aiService) {
        this.aiService = aiService;
        initUI();
    }

    private void initUI() {
        // Panel del chat para contener los mensajes
        chatPanel = new JPanel();
        chatPanel.setLayout(new GridBagLayout());
        chatPanel.setBackground(Color.WHITE);

        scrollPane = new JScrollPane(chatPanel);
        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.getVerticalScrollBar().setUnitIncrement(16);
        scrollPane.setBorder(null);

        // Campo de entrada y botón enviar
        inputField = new JTextField();
        sendButton = new JButton("Enviar");

        // Estilo del campo de entrada y botón
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        sendButton.setBackground(new Color(30, 144, 255));
        sendButton.setForeground(Color.WHITE);
        sendButton.setFocusPainted(false);
        sendButton.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new BorderLayout());
        inputPanel.add(inputField, BorderLayout.CENTER);
        inputPanel.add(sendButton, BorderLayout.EAST);

        setLayout(new BorderLayout());
        add(scrollPane, BorderLayout.CENTER);
        add(inputPanel, BorderLayout.SOUTH);

        setTitle("Chatbot con Google AI");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        sendButton.addActionListener(e -> sendMessage());
        inputField.addActionListener(e -> sendMessage());
    }

    private void sendMessage() {
        String userInput = inputField.getText().trim();
        if (userInput.isEmpty()) {
            return;
        }

        addMessage(userInput, true);
        inputField.setText("");

        // Deshabilitar la entrada mientras se procesa
        inputField.setEditable(false);
        sendButton.setEnabled(false);

        // Ejecutar la respuesta de la IA en un hilo separado
        SwingWorker<String, Void> worker = new SwingWorker<>() {
            @Override
            protected String doInBackground() throws Exception {
                return aiService.getAIResponse(userInput);
            }

            @Override
            protected void done() {
                try {
                    String response = get();
                    addMessage(response, false);
                } catch (Exception ex) {
                    addMessage("Error al comunicarse con Google AI.", false);
                    ex.printStackTrace();
                } finally {
                    // Rehabilitar la entrada
                    inputField.setEditable(true);
                    sendButton.setEnabled(true);
                    inputField.requestFocus();
                }
            }
        };

        worker.execute();
    }

    private void addMessage(String message, boolean isUser) {
        ChatMessage chatMessage = new ChatMessage(message, isUser);

        SwingUtilities.invokeLater(() -> {
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridx = 0;
            gbc.gridy = chatPanel.getComponentCount();
            gbc.weightx = 1.0;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            gbc.anchor = GridBagConstraints.NORTHWEST;
            gbc.insets = new Insets(5, 5, 5, 5);

            chatPanel.add(chatMessage, gbc);
            chatPanel.revalidate();
            chatPanel.repaint();

            // Desplazar hacia abajo
            JScrollBar verticalBar = scrollPane.getVerticalScrollBar();
            verticalBar.setValue(verticalBar.getMaximum());
        });
    }

}
