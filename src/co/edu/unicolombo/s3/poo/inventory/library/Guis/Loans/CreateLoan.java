/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Guis.Loans;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Reservation;
import co.edu.unicolombo.s3.poo.inventory.library.Guis.Client.CreateClient;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ClientEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.ReservationEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book.RemoveQuantityFromStock;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book.SetBookToFalseAviailable;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Client.CreateClientCommmands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Loan.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Client.GetClientByNameQueries;

import java.text.SimpleDateFormat;
import java.util.*;

import javax.swing.JOptionPane;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Juan
 */
public class CreateLoan extends javax.swing.JDialog {

        private Runnable onLoanCreated;
        private CreateLoanCommandsController createLoanCommandsController;
        private GetClientByNameQueries getClientByNameQueries;
        private CreateClientCommmands createClientCommmands;
        private RemoveQuantityFromStock removeQuantityFromStock;
        private SetBookToFalseAviailable setBookToFalseAviailable;
        private BookEntity book;
        private ReservationEntity reservation;
        private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        /**
         * Creates new form CreateLoan
         */
        public CreateLoan(java.awt.Frame parent, boolean modal,
                        ReservationEntity reservation,
                        CreateLoanCommandsController commandsController,
                        CreateClientCommmands createClientCommmands,
                        GetClientByNameQueries getClientByNameQueries,
                        RemoveQuantityFromStock removeQuantityFromStock,
                        SetBookToFalseAviailable setBookToFalseAviailable) {
                super(parent, modal);
                initComponents();
                this.getClientByNameQueries = getClientByNameQueries;
                this.createClientCommmands = createClientCommmands;
                this.createLoanCommandsController = commandsController;
                this.removeQuantityFromStock = removeQuantityFromStock;
                this.setBookToFalseAviailable = setBookToFalseAviailable;
                this.book = reservation.getBookEntity();
                this.reservation = reservation;
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
                String formattedDate = currentDate.format(formatter);
                fieldInitialDate.setText(formattedDate);
                labelOfTitle.setText(book.getTitle());
                comboBoxClient.addItem(reservation.getClientEntity());
                quantityToInt();
        }

        public CreateLoan(java.awt.Frame parent, boolean modal,
                        BookEntity book,
                        CreateLoanCommandsController commandsController,
                        CreateClientCommmands createClientCommmands,
                        GetClientByNameQueries getClientByNameQueries,
                        RemoveQuantityFromStock removeQuantityFromStock,
                        SetBookToFalseAviailable setBookToFalseAviailable) {
                super(parent, modal);
                initComponents();
                this.getClientByNameQueries = getClientByNameQueries;
                this.createClientCommmands = createClientCommmands;
                this.createLoanCommandsController = commandsController;
                this.removeQuantityFromStock = removeQuantityFromStock;
                this.setBookToFalseAviailable = setBookToFalseAviailable;
                this.book = book;
                LocalDate currentDate = LocalDate.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yy");
                String formattedDate = currentDate.format(formatter);
                fieldInitialDate.setText(formattedDate);
                labelOfTitle.setText(book.getTitle());

        }

        private void quantityToInt() {
                int quantity = reservation.getQuantity();
                try {
                        String quantityStr = String.valueOf(quantity);
                        fieldQuantity.setText(quantityStr);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                }
        }

        public void setOnLoanCreated(Runnable onLoanCreated) {
                this.onLoanCreated = onLoanCreated;
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

                jPanel1 = new javax.swing.JPanel();
                labelTitle = new javax.swing.JLabel();
                labelOfTitle = new javax.swing.JLabel();
                labelDate = new javax.swing.JLabel();
                fieldInitialDate = new javax.swing.JTextField();
                labelFinalDate = new javax.swing.JLabel();
                labelQuantity = new javax.swing.JLabel();
                fieldQuantity = new javax.swing.JTextField();
                jLabel2 = new javax.swing.JLabel();
                comboBoxClient = new javax.swing.JComboBox<>();
                fieldDate = new org.jdesktop.swingx.JXDatePicker();
                jLabel1 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                fieldLookForClient = new javax.swing.JTextField();
                buttonSearch = new javax.swing.JButton();
                buttonNewClient = new javax.swing.JButton();
                buttonAddLoan = new javax.swing.JButton();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jPanel1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 2, true));

                labelTitle.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
                labelTitle.setText("Title:");

                labelOfTitle.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N

                labelDate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
                labelDate.setText("Initial date:");

                labelFinalDate.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
                labelFinalDate.setText("Return date:");

                labelQuantity.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
                labelQuantity.setText("Quantity:");

                jLabel2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
                jLabel2.setText("Client:");

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(26, 26, 26)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createParallelGroup(
                                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                                false)
                                                                                                .addComponent(labelFinalDate,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(labelDate,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(labelTitle)
                                                                                                .addComponent(labelQuantity))
                                                                                .addComponent(jLabel2))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                26,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(labelOfTitle,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(fieldInitialDate)
                                                                                .addComponent(fieldQuantity,
                                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addComponent(comboBoxClient, 0, 227,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(fieldDate,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(127, 127, 127)));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addGap(24, 24, 24)
                                                                .addGroup(jPanel1Layout
                                                                                .createParallelGroup(
                                                                                                javax.swing.GroupLayout.Alignment.LEADING,
                                                                                                false)
                                                                                .addComponent(labelOfTitle,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(labelTitle,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                Short.MAX_VALUE))
                                                                .addGap(28, 28, 28)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labelDate,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                28,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(fieldInitialDate,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(29, 29, 29)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labelFinalDate,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                24,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(fieldDate,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(32, 32, 32)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(labelQuantity,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                24,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(fieldQuantity,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                29,
                                                                                Short.MAX_VALUE)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel2)
                                                                                .addComponent(comboBoxClient,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGap(24, 24, 24)));

                jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
                jLabel1.setText("Loan Book");
                jLabel1.setVerticalAlignment(javax.swing.SwingConstants.TOP);

                jLabel3.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                jLabel3.setText("Search for Client:");

                buttonSearch.setBackground(new java.awt.Color(153, 255, 255));
                buttonSearch.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                buttonSearch.setText("Search");
                buttonSearch.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonSearchActionPerformed(evt);
                        }
                });

                buttonNewClient.setBackground(new java.awt.Color(204, 204, 204));
                buttonNewClient.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
                buttonNewClient.setText("New Client");
                buttonNewClient.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonNewClientActionPerformed(evt);
                        }
                });

                buttonAddLoan.setBackground(new java.awt.Color(0, 153, 153));
                buttonAddLoan.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
                buttonAddLoan.setText("Add Loan");
                buttonAddLoan.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonAddLoanActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(32, 32, 32)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jLabel1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                143,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(jLabel3)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                                                .addComponent(fieldLookForClient,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                148,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(179, 179, 179)
                                                                                                .addComponent(buttonAddLoan,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                126,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(295, 295, 295)
                                                                                                .addComponent(buttonNewClient,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                105,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addGap(0, 17, Short.MAX_VALUE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addComponent(jPanel1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(buttonSearch)
                                                                                                .addGap(32, 32, 32)))
                                                                .addContainerGap()));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGap(3, 3, 3)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                .addComponent(jLabel3)
                                                                                .addComponent(jLabel1)
                                                                                .addComponent(fieldLookForClient,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(12, 12, 12)
                                                                                                .addComponent(jPanel1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(buttonSearch)))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(buttonAddLoan,
                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                35,
                                                                                                Short.MAX_VALUE)
                                                                                .addComponent(buttonNewClient))
                                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                Short.MAX_VALUE)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void buttonSearchActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonSearchActionPerformed
                var selectedClient = fieldLookForClient.getText();

                try {
                        if (fieldLookForClient != null && !fieldLookForClient.getText().isEmpty()) {
                                ClientEntity client = getClientByNameQueries.getClientByName(selectedClient);
                                if (client != null) {
                                        filterComboBoxClient(client);
                                } else {
                                        javax.swing.JOptionPane.showMessageDialog(this, "Client not found.");
                                }
                        } else {
                                javax.swing.JOptionPane.showMessageDialog(this, "Please enter a client name.");
                        }
                } catch (Exception e) {
                        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
                        return;
                }

        }// GEN-LAST:event_buttonSearchActionPerformed

        private void filterComboBoxClient(ClientEntity client) {
                System.out.println("the client is :" + client);
                System.out.println("id of client is: " + client.getId());
                comboBoxClient.addItem(client);
                comboBoxClient.setSelectedItem(client);
        }

        private void buttonAddLoanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAddLoanActionPerformed
                var returnDate = fieldDate.getDate();
                var quantityStr = fieldQuantity.getText();
                var initialDatestr = fieldInitialDate.getText();
                var client = (ClientEntity) comboBoxClient.getSelectedItem();
                var title = labelOfTitle.getText();
                java.sql.Date sqlReturnDate = new java.sql.Date(returnDate.getTime());

                if (client == null || quantityStr.isEmpty() || returnDate == null) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Please fill all fields.");
                        return;
                }

                int quantity;

                java.sql.Date sqlInitialDate = null;

                try {
                        quantity = Integer.parseInt(quantityStr);
                } catch (Exception e) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Invalid quantity number.");
                        return;
                }

                try {
                        Date initisalDate = dateFormat.parse(initialDatestr);
                        sqlInitialDate = new java.sql.Date(initisalDate.getTime());

                } catch (Exception e) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Invalid quantity number.");
                        return;
                }

                var newLoan = new LoanEntity(sqlInitialDate, sqlReturnDate, quantity, client);

                newLoan.getBooks().add(book);
                book.getLoans().add(newLoan);
                try {
                        System.out.println("ingresanado a crear el prestamo");
                        createLoanCommandsController.addLoan(newLoan);
                } catch (Exception e) {
                        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
                        return;
                }

                client.getLoans().add(newLoan);
                try {
                        removeQuantityFromStock.removeStock(quantity, title);
                } catch (Exception e) {
                        javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
                        return;
                }
                javax.swing.JOptionPane.showMessageDialog(this, "Loan successfully!");
                this.dispose();
                if (onLoanCreated != null) {
                        onLoanCreated.run();
                }

        }// GEN-LAST:event_buttonAddLoanActionPerformed

        private void buttonNewClientActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonNewClientActionPerformed
                openCreateClientWIndow();
        }// GEN-LAST:event_buttonNewClientActionPerformed

        private void openCreateClientWIndow() {
                var createClientWindow = new CreateClient(new javax.swing.JFrame(), true,
                                createClientCommmands);
                createClientWindow.setLocationRelativeTo(this);
                createClientWindow.setVisible(true);
        }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton buttonAddLoan;
        private javax.swing.JButton buttonNewClient;
        private javax.swing.JButton buttonSearch;
        private javax.swing.JComboBox<ClientEntity> comboBoxClient;
        private org.jdesktop.swingx.JXDatePicker fieldDate;
        private javax.swing.JTextField fieldInitialDate;
        private javax.swing.JTextField fieldLookForClient;
        private javax.swing.JTextField fieldQuantity;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JLabel labelDate;
        private javax.swing.JLabel labelFinalDate;
        private javax.swing.JLabel labelOfTitle;
        private javax.swing.JLabel labelQuantity;
        private javax.swing.JLabel labelTitle;
        // End of variables declaration//GEN-END:variables
}
