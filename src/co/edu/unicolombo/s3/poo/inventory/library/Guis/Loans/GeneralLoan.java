/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Guis.Loans;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Category;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Guis.Client.ClientsWithLoans;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.DB;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book.SetTrueBookIsAvailable;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Loan.ReturnLoanCommandsController;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Book.GetListBookByCategoryQueries;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan.FindLoanByBook;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan.GetAllLoansQueries;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan.GetBooksWithLoanByCateg;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan.GetListClientsWithLoanQueries;
import java.util.stream.Collectors;
import java.util.*;
import javax.swing.*;

/**
 *
 * @author Juan
 */
public class GeneralLoan extends javax.swing.JDialog {
        private DB db;
        private Map<Integer, Loan> loanMap = new HashMap<>();
        private ReturnLoanCommandsController returnLoanCommandsController;
        private GetListClientsWithLoanQueries getListClientsWithLoanQueries;
        private GetAllLoansQueries getAllLoansQueries;
        private FindLoanByBook findLoan;
        private SetTrueBookIsAvailable setTrueBookIsAvailable;
        private GetBooksWithLoanByCateg getBooksWithLoanByCateg;

        /**
         * Creates new form GeneralLoan
         */
        public GeneralLoan(java.awt.Frame parent, boolean modal,
                        ReturnLoanCommandsController returnLoanCommandsController,
                        GetListClientsWithLoanQueries getListClientsWithLoanQueries,
                        GetAllLoansQueries getAllLoansQueries,
                        FindLoanByBook findLoanByBook,
                        SetTrueBookIsAvailable setTrueBookIsAvailable,
                        GetBooksWithLoanByCateg getBooksWithLoanByCateg) {
                super(parent, modal);
                initComponents();
                this.db = DB.getInstance();
                this.returnLoanCommandsController = returnLoanCommandsController;
                this.getAllLoansQueries = getAllLoansQueries;
                this.getListClientsWithLoanQueries = getListClientsWithLoanQueries;
                this.getBooksWithLoanByCateg = getBooksWithLoanByCateg;
                this.findLoan = findLoanByBook;
                listCategories();
                setToBooksOnTable();
        }

        private void listCategories() {
                Category allCategories = new Category("ALL");
                comBoxCategory.addItem(allCategories);
                var showCategories = db.getCategories();
                if (showCategories.isEmpty()) {
                        comBoxCategory.addItem(new Category("not category"));
                }
                for (Category category : showCategories) {
                        comBoxCategory.addItem(category);
                }
                comBoxCategory.repaint();
        }

        private void setToBooksOnTable() {
                try {
                        var loans = getAllLoansQueries.getLoans();
                        System.out.println("totals books: " + loans.size());
                        if (loans.isEmpty()) {
                                System.out.println("No loans found.");
                        }

                        // for (Loan loan : loans) {
                        //         if (loan.getBooks() != null && !loan.getBooks().isEmpty()) {
                        //                 Book lonedBook = loan.getBooks().get(0);
                        //                 System.out.println("Book in Selected Loan: " + lonedBook.getTitle());
                        //                 System.out.println("Books in Selected loan: " + lonedBook);
                        //                 books.add(lonedBook);
                        //         }
                        // }
                        // System.out.println("Total books to display: " + books.size());
                        // books = books.stream().distinct().collect(Collectors.toList());
                       filterTableWithBooks(loans);
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, e.getMessage());
                }
        }

        /**
         * This method is called from within the constructor to initialize the form.
         * WARNING: Do NOT modify this code. The content of this method is always
         * regenerated by the Form Editor.
         */
        @SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // <editor-fold defaultstate="collapsed" desc="Generated
        // Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jPanel1 = new javax.swing.JPanel();
                jScrollPane1 = new javax.swing.JScrollPane();
                loansTable = new javax.swing.JTable();
                jLabel2 = new javax.swing.JLabel();
                comBoxCategory = new javax.swing.JComboBox<>();
                buttonReturn = new javax.swing.JButton();
                buttonClients = new javax.swing.JButton();
                jLabel1 = new javax.swing.JLabel();

                setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

                jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
                                new javax.swing.border.LineBorder(new java.awt.Color(0, 153, 153), 3, true),
                                "books loans", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION,
                                javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial", 1, 12))); // NOI18N

                loansTable.setModel(new javax.swing.table.DefaultTableModel(
                                new Object[][] {
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null },
                                                { null, null, null }
                                },
                                new String[] {
                                                "ISB", "Title", "Quantity"
                                }));
                jScrollPane1.setViewportView(loansTable);

                jLabel2.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
                jLabel2.setText("Categories: ");

                comBoxCategory.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                comBoxCategoryActionPerformed(evt);
                        }
                });

                buttonReturn.setBackground(new java.awt.Color(0, 153, 153));
                buttonReturn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
                buttonReturn.setText("ReturnBook");
                buttonReturn.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonReturnActionPerformed(evt);
                        }
                });

                buttonClients.setBackground(new java.awt.Color(204, 255, 255));
                buttonClients.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
                buttonClients.setText("ClientsLoans");
                buttonClients.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                buttonClientsActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
                jPanel1.setLayout(jPanel1Layout);
                jPanel1Layout.setHorizontalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jScrollPane1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                472,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addGap(18, 18, 18)
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(jLabel2)
                                                                                                .addGap(18, 18, 18)
                                                                                                .addComponent(comBoxCategory,
                                                                                                                0,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addContainerGap())
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addComponent(buttonReturn)
                                                                                                .addPreferredGap(
                                                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                                                                                43,
                                                                                                                Short.MAX_VALUE)
                                                                                                .addComponent(buttonClients)
                                                                                                .addGap(7, 7, 7)))));
                jPanel1Layout.setVerticalGroup(
                                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(jPanel1Layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addGroup(jPanel1Layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.TRAILING)
                                                                                .addGroup(jPanel1Layout
                                                                                                .createSequentialGroup()
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(jLabel2,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                24,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                                                .addComponent(comBoxCategory,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                                24,
                                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                                .addGap(372, 372, 372)
                                                                                                .addGroup(jPanel1Layout
                                                                                                                .createParallelGroup(
                                                                                                                                javax.swing.GroupLayout.Alignment.BASELINE)
                                                                                                                .addComponent(buttonReturn)
                                                                                                                .addComponent(buttonClients)))
                                                                                .addComponent(jScrollPane1,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                419,
                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addContainerGap(14, Short.MAX_VALUE)));

                jLabel1.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
                jLabel1.setText("Books on Loans");

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
                getContentPane().setLayout(layout);
                layout.setHorizontalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(
                                                                                javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(43, 43, 43)
                                                                                                .addComponent(jLabel1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                185,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                                .addGroup(layout.createSequentialGroup()
                                                                                                .addGap(21, 21, 21)
                                                                                                .addComponent(jPanel1,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                                .addContainerGap(8, Short.MAX_VALUE)));
                layout.setVerticalGroup(
                                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                                .addContainerGap()
                                                                .addComponent(jLabel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                28,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(
                                                                                javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(jPanel1,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addContainerGap(11, Short.MAX_VALUE)));

                pack();
        }// </editor-fold>//GEN-END:initComponents

        private void comBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_comBoxCategoryActionPerformed
                var selectedCategory = (Category) comBoxCategory.getSelectedItem();
                // List<Book> books = new ArrayList<>();

                try {
                        if ("ALL".equals(selectedCategory.getName())) {

                                var loans = getAllLoansQueries.getLoans();
                                // for (Loan loan : loans) {
                                //         if (loan.getBooks() != null && !loan.getBooks().isEmpty()) {
                                //                 Book lonedBook = loan.getBooks().get(0);
                                //                 System.out.println("Books in Selected loan: " + lonedBook);
                                //                 System.out.println("Selected Category: " + selectedCategory.getName());
                                //                 books.add(lonedBook);
                                //         }
                                // }
                                // books = books.stream().distinct().collect(Collectors.toList());
                                filterTableWithBooks(loans);
                        } else {
                                var loans = getBooksWithLoanByCateg.getBooksByCategoryWithLoans(selectedCategory.getName());
                                if (loans.isEmpty()) {
                                        javax.swing.JOptionPane.showMessageDialog(this,
                                        "No books found in this category");
                                }
                                // loans = books.stream().distinct().collect(Collectors.toList());
                                filterTableWithBooks(loans);
                        }
                        
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                }

        }// GEN-LAST:event_comBoxCategoryActionPerformed

        private void buttonReturnActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonReturnActionPerformed
                // int selectedRow = loansTable.getSelectedRow();
                // Loan selectBook = loanMap.get(selectedRow);
                // if (selectedRow >= 0) {
                //         try {
                //                 Loan loan = findLoan.findLoanByBook(selectBook);
                //                 if (loan != null) {
                //                         returnLoanCommandsController.returnLoan(loan);
                //                         JOptionPane.showMessageDialog(this, "Book returned successfully.");
                //                         setTrueBookIsAvailable.setTrueIsAvailable(selectBook.getISB());
                //                         // updateTable();
                //                 }
                //         } catch (Exception e) {
                //                 JOptionPane.showMessageDialog(this, "Please select a book from the table.");
                //         }
                // }
        }// GEN-LAST:event_buttonReturnActionPerformed

        // private void updateTable() {
        // loanMap.clear();
        // DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // model.setRowCount(0);
        // try {
        // List<Book> books = bookList.getAllBooks();

        // if (books.isEmpty()) {
        // JOptionPane.showMessageDialog(this, "The list is empty.");
        // }

        // for (int i = 0; i < books.size(); i++) {
        // Book book = books.get(i);
        // loanMap.put(i, book);
        // boolean isAvailable = book.isAvailable();
        // String availableSrt = isAvailable ? "yes" : "no";
        // model.addRow(new Object[] {
        // book.getISB(),
        // book.getTitle(),
        // book.getStock(),
        // availableSrt
        // });
        // }
        // } catch (Exception e) {
        // javax.swing.JOptionPane.showMessageDialog(this,
        // e.getMessage());
        // }

        // }

        private void buttonClientsActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonClientsActionPerformed
                openListClientWithLoanWindow();
        }// GEN-LAST:event_buttonClientsActionPerformed

        private void openListClientWithLoanWindow() {
                var listClientwithLoan = new ClientsWithLoans(new JFrame(), true,
                                getListClientsWithLoanQueries,
                                returnLoanCommandsController);
                listClientwithLoan.setLocationRelativeTo(this);
                listClientwithLoan.setVisible(true);

        }

        private void filterTableWithBooks(List<Loan> loans) {
                var tableModel = new javax.swing.table.DefaultTableModel(
                                new Object[][] {},
                                new String[] { "ISBN", "Title", "Quantity" });
                tableModel.setRowCount(0);
                loanMap.clear();
                int rowIndex = 0;
                for (Loan loan : loans) {
                        tableModel.addRow(new Object[] {
                                        loan.getBooks().get(0).getISB(),
                                        loan.getBooks().get(0).getTitle(),
                                        loan.getQuantity()
                        });

                        loanMap.put(rowIndex++, loan);
                }
                loansTable.setModel(tableModel);
                loansTable.repaint();
        }

        // private void updateBooksList(List<Book> books) {
        // DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        // model.setRowCount(0);

        // for (Book book : books) {
        // boolean isAvailable = book.isAvailable();
        // String availableSrt = isAvailable ? "yes" : "no";
        // Object[] row = new Object[] {
        // book.getISB(),
        // book.getTitle(),
        // book.getStock(),
        // availableSrt,
        // };
        // model.addRow(row);
        // }
        // }

        /**
         * @param args the command line arguments
         */
        // public static void main(String args[]) {
        // /* Set the Nimbus look and feel */
        // //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code
        // (optional) ">
        // /* If Nimbus (introduced in Java SE 6) is not available, stay with the
        // default look and feel.
        // * For details see
        // http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
        // */
        // try {
        // for (javax.swing.UIManager.LookAndFeelInfo info :
        // javax.swing.UIManager.getInstalledLookAndFeels()) {
        // if ("Nimbus".equals(info.getName())) {
        // javax.swing.UIManager.setLookAndFeel(info.getClassName());
        // break;
        // }
        // }
        // } catch (ClassNotFoundException ex) {
        // java.util.logging.Logger.getLogger(GeneralLoan.class.getName()).log(java.util.logging.Level.SEVERE,
        // null, ex);
        // } catch (InstantiationException ex) {
        // java.util.logging.Logger.getLogger(GeneralLoan.class.getName()).log(java.util.logging.Level.SEVERE,
        // null, ex);
        // } catch (IllegalAccessException ex) {
        // java.util.logging.Logger.getLogger(GeneralLoan.class.getName()).log(java.util.logging.Level.SEVERE,
        // null, ex);
        // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
        // java.util.logging.Logger.getLogger(GeneralLoan.class.getName()).log(java.util.logging.Level.SEVERE,
        // null, ex);
        // }
        // //</editor-fold>
        //
        // /* Create and display the dialog */
        // java.awt.EventQueue.invokeLater(new Runnable() {
        // public void run() {
        // GeneralLoan dialog = new GeneralLoan(new javax.swing.JFrame(), true);
        // dialog.addWindowListener(new java.awt.event.WindowAdapter() {
        // @Override
        // public void windowClosing(java.awt.event.WindowEvent e) {
        // System.exit(0);
        // }
        // });
        // dialog.setVisible(true);
        // }
        // });
        // }

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton buttonClients;
        private javax.swing.JButton buttonReturn;
        private javax.swing.JComboBox<Category> comBoxCategory;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable loansTable;
        // End of variables declaration//GEN-END:variables
}
