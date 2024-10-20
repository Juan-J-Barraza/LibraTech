/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Guis.Reservation;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Reservation.AddReservationCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Reservation.DeleteReservationCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Book.GetListBookQueries;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Client.GetAllClientsQueries;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Reservation.GetListReservationsQueries;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Deiver Vasquez
 */
public class CreateReservation extends javax.swing.JDialog {

    // private final GetListReservationsQueries getListReservationsQueries
    private final GetListBookQueries getBooksQueries;
    private final GetAllClientsQueries getAllClientsQueries;
    private final AddReservationCommands addReservationCommands;
    private final DeleteReservationCommands deleteReservationCommands;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

    /**
     * Creates new form CreateReservation
     * 
     * @param parent
     * @param modal
     * @param addReservationCommands
     * @param getListReservationsQueries
     * @param deleteReservationCommands
     * @param getBooksQueries
     * @param getAllClientsQueries
     * @throws java.lang.Exception
     */
    public CreateReservation(
            java.awt.Frame parent,
            boolean modal,
            AddReservationCommands addReservationCommands,
            GetListReservationsQueries getListReservationsQueries,
            DeleteReservationCommands deleteReservationCommands,
            GetListBookQueries getBooksQueries,
            GetAllClientsQueries getAllClientsQueries) throws Exception {
        super(parent, modal);
        initComponents();

        // this.getListReservationsQueries = getListReservationsQueries;
        this.getBooksQueries = getBooksQueries;
        this.getAllClientsQueries = getAllClientsQueries;
        this.addReservationCommands = addReservationCommands;
        // this.getListReservationsQueries = getListReservationsQueries;
        this.deleteReservationCommands = deleteReservationCommands;

        listClients();
        listBooks();
    }

    private void listClients() throws Exception {
        fieldClient.removeAllItems();
        List<Client> showClients = getAllClientsQueries.getListClients();

        for (Client client : showClients) {
            fieldClient.addItem(client.getName());
        }
        fieldClient.repaint();
    }

    private void listBooks() throws Exception {
        fieldBook.removeAllItems();
        List<Book> showBooks = getBooksQueries.getAllBooks();

        for (Book book : showBooks) {
            fieldBook.addItem(book.getTitle());
        }
        fieldBook.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        Quantity = new javax.swing.JLabel();
        fieldQuantity = new javax.swing.JTextField();
        Date = new javax.swing.JLabel();
        fieldDate = new javax.swing.JTextField();
        Client = new javax.swing.JLabel();
        fieldClient = new javax.swing.JComboBox<>();
        Book = new javax.swing.JLabel();
        fieldBook = new javax.swing.JComboBox<>();
        ButtonAddReservation = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel.setPreferredSize(new java.awt.Dimension(2, 354));

        javax.swing.GroupLayout jPanelLayout = new javax.swing.GroupLayout(jPanel);
        jPanel.setLayout(jPanelLayout);
        jPanelLayout.setHorizontalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 588, Short.MAX_VALUE));
        jPanelLayout.setVerticalGroup(
                jPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 100, Short.MAX_VALUE));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setText("FORM TO ADD RESERVATION");
        jLabel1.setMaximumSize(new java.awt.Dimension(242, 28));
        jLabel1.setMinimumSize(new java.awt.Dimension(242, 28));
        jLabel1.setName(""); // NOI18N
        jLabel1.setOpaque(true);
        jLabel1.setPreferredSize(new java.awt.Dimension(242, 28));

        Quantity.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Quantity.setText("Quantity");

        Date.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Date.setText("Date:");

        Client.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Client.setText("Client:");

        fieldClient.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fieldClient.setName(""); // NOI18N

        Book.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        Book.setText("Product:");

        fieldBook.setModel(
                new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        fieldBook.setName(""); // NOI18N

        ButtonAddReservation.setBackground(new java.awt.Color(0, 153, 153));
        ButtonAddReservation.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        ButtonAddReservation.setText("ADD");
        ButtonAddReservation.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    ButtonAddReservationActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 79,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Date, javax.swing.GroupLayout.PREFERRED_SIZE, 50,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(Client)
                                        .addComponent(Book))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fieldBook, javax.swing.GroupLayout.PREFERRED_SIZE, 380,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, 380,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 380,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 380,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(121, Short.MAX_VALUE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(ButtonAddReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 141,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(29, 29, 29)));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Quantity, javax.swing.GroupLayout.PREFERRED_SIZE, 26,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(fieldQuantity, javax.swing.GroupLayout.PREFERRED_SIZE, 27,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Date)
                                        .addComponent(fieldDate, javax.swing.GroupLayout.PREFERRED_SIZE, 28,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Client)
                                        .addComponent(fieldClient, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(Book)
                                        .addComponent(fieldBook, javax.swing.GroupLayout.PREFERRED_SIZE, 32,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 140,
                                        Short.MAX_VALUE)
                                .addComponent(ButtonAddReservation, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(23, 23, 23)));

        Quantity.getAccessibleContext().setAccessibleName("Quantity:");
        Book.getAccessibleContext().setAccessibleName("Product");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(33, 33, 33)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 602,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(2, 2, 2)
                                                .addGroup(layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jPanel, javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                588, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addContainerGap(241, Short.MAX_VALUE)));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addGap(35, 35, 35)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void ButtonAddReservationActionPerformed(java.awt.event.ActionEvent evt) throws Exception {// GEN-FIRST:event_ButtonAddReservationActionPerformed
        String quantityText = this.fieldQuantity.getText();
        String dateText = fieldDate.getText();
        Optional<Client> clientObj = getAllClientsQueries.getListClients()
                .stream()
                .filter(c -> c.getName().equalsIgnoreCase((String) fieldClient.getSelectedItem()))
                .findFirst();
        Optional<Book> bookObj = getBooksQueries.getAllBooks()
                .stream()
                .filter(c -> c.getTitle().equalsIgnoreCase((String) fieldBook.getSelectedItem()))
                .findFirst();

        if (quantityText.isEmpty() || !bookObj.isPresent() || dateText.isEmpty() || !clientObj.isPresent()) {
            javax.swing.JOptionPane.showMessageDialog(this, "Please fill all fields.");
            return;
        }

        int quantity;
        try {
            quantity = Integer.parseInt(quantityText);
        } catch (NumberFormatException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid stock number.");
            return;
        }

        Date date;

        try {
            date = dateFormat.parse(dateText);
        } catch (ParseException e) {
            javax.swing.JOptionPane.showMessageDialog(this, "Invalid date format. Please use dd/MM/yyyy.");
            return;
        }

        Reservation newReservation = new Reservation(
                date,
                clientObj.get(),
                quantity);
        newReservation.addBook(bookObj.get());

        try {
            this.addReservationCommands.createReservation(newReservation);
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, e);
            return;
        }

        javax.swing.JOptionPane.showMessageDialog(this, "Book added successfully!");

        fieldQuantity.setText("");
        fieldDate.setText("");
    }// GEN-LAST:event_ButtonAddReservationActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        // <editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        /*
         * If Nimbus (introduced in Java SE 6) is not available, stay with the default
         * look and feel.
         * For details see
         * http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CreateReservation.class.getName()).log(java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        // </editor-fold>
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Book;
    private javax.swing.JButton ButtonAddReservation;
    private javax.swing.JLabel Client;
    private javax.swing.JLabel Date;
    private javax.swing.JLabel Quantity;
    private javax.swing.JComboBox<String> fieldBook;
    private javax.swing.JComboBox<String> fieldClient;
    private javax.swing.JTextField fieldDate;
    private javax.swing.JTextField fieldQuantity;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
