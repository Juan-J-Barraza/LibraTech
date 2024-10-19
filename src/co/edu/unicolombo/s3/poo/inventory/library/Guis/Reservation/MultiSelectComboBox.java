/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Guis.Reservation;

/**
 *
 * @author Deiver Vasquez
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

public class MultiSelectComboBox extends JPanel {
    private final JComboBox<String> comboBox;
    private final JPopupMenu popupMenu;
    private final List<JCheckBox> checkBoxes;
    private final JButton arrowButton;
    private boolean isPopupVisible = false;

    public MultiSelectComboBox(String[] items) {
        setLayout(new BorderLayout());

        // Inicializar el JComboBox con un solo elemento por defecto
        comboBox = new JComboBox<>();
        comboBox.setEditable(false);
        comboBox.addItem("Seleccionar...");
        comboBox.setPreferredSize(new Dimension(200, 25));

        // Botón para desplegar el popup
        arrowButton = new JButton("\u25BC"); // Símbolo de flecha hacia abajo
        arrowButton.setFocusable(false);
        arrowButton.setMargin(new Insets(0, 5, 0, 5));

        // Inicializar el popup y los checkboxes
        popupMenu = new JPopupMenu();
        checkBoxes = new ArrayList<>();

        for (String item : items) {
            JCheckBox checkBox = new JCheckBox(item);
            checkBox.addItemListener(e -> updateComboBox());
            checkBoxes.add(checkBox);
            popupMenu.add(checkBox);
        }

        // Añadir ActionListener al JComboBox para manejar el clic
        comboBox.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                togglePopup();
            }
        });

        // Añadir ActionListener al botón de flecha
        arrowButton.addActionListener(e -> togglePopup());

        // Añadir componentes al panel
        add(comboBox, BorderLayout.CENTER);
        add(arrowButton, BorderLayout.EAST);
    }

    // Método para mostrar u ocultar el popup
    private void togglePopup() {
        if (isPopupVisible) {
            popupMenu.setVisible(false);
        } else {
            popupMenu.show(this, 0, this.getHeight());
        }
        isPopupVisible = !isPopupVisible;
    }

    // Método para actualizar el texto del JComboBox según las selecciones
    private void updateComboBox() {
        List<String> selectedItems = getSelectedItems();
        String displayText = String.join(", ", selectedItems);
        if (displayText.isEmpty()) {
            comboBox.removeAllItems();
            comboBox.addItem("Seleccionar...");
        } else {
            comboBox.removeAllItems();
            comboBox.addItem(displayText);
        }
    }

    // Método para obtener los elementos seleccionados
    public List<String> getSelectedItems() {
        List<String> selectedItems = new ArrayList<>();
        for (JCheckBox cb : checkBoxes) {
            if (cb.isSelected()) {
                selectedItems.add(cb.getText());
            }
        }
        return selectedItems;
    }

    // Método para cerrar el popup al hacer clic fuera
    public void addGlobalClickListener() {
        Toolkit.getDefaultToolkit().addAWTEventListener(event -> {
            if (event instanceof MouseEvent) {
                MouseEvent me = (MouseEvent) event;
                if (me.getID() == MouseEvent.MOUSE_PRESSED) {
                    if (isPopupVisible && !SwingUtilities.isDescendingFrom(me.getComponent(), popupMenu)) {
                        popupMenu.setVisible(false);
                        isPopupVisible = false;
                    }
                }
            }
        }, AWTEvent.MOUSE_EVENT_MASK);
    }
}

