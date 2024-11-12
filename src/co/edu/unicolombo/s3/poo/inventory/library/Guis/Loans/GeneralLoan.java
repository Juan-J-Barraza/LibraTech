/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Guis.Loans;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Category;
// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Guis.Client.ClientsWithLoans;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Config.HibernateUtil;
// import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.DB;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.CategoryEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book.SetTrueBookIsAvailable;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Loan.ReturnLoanCommandsController;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan.FindLoanByBook;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan.GetAllLoansQueries;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan.GetBooksWithLoanByCateg;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan.GetListClientsWithLoanQueries;
import java.util.*;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

/**
 *
 * @author Juan
 */
public class GeneralLoan extends javax.swing.JDialog {
        // private DB db;
        private Map<Integer, LoanEntity> loanMap = new HashMap<>();
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
                // this.db = DB.getInstance();
                this.returnLoanCommandsController = returnLoanCommandsController;
                this.getAllLoansQueries = getAllLoansQueries;
                this.getListClientsWithLoanQueries = getListClientsWithLoanQueries;
                this.getBooksWithLoanByCateg = getBooksWithLoanByCateg;
                this.findLoan = findLoanByBook;
                this.setTrueBookIsAvailable = setTrueBookIsAvailable;
                listCategories();
                setToBooksOnTable();
        }

        private void listCategories() {
                Session session = HibernateUtil.getSessionFactory().openSession();
                try {
                        List<CategoryEntity> categories = session
                                        .createQuery("FROM CategoryEntity", CategoryEntity.class).list();

                        CategoryEntity allCategory = new CategoryEntity("ALL");
                        comBoxCategory.addItem(allCategory);

                        if (categories.isEmpty()) {
                                comBoxCategory.addItem(new CategoryEntity("not category"));
                        } else {
                                for (CategoryEntity category : categories) {
                                        System.out.println("Adding category: " + category.getName());
                                        comBoxCategory.addItem(category);
                                }
                        }
                        comBoxCategory.repaint();
                } catch (Exception e) {
                        e.printStackTrace();
                        javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar categorías ");
                } finally {
                        session.close();
                }
        }

        private void setToBooksOnTable() {
                try {
                        var loans = getAllLoansQueries.getLoans();
                        System.out.println("totals books: " + loans.size());
                        System.out.println("The book is: " + loans);
                        if (loans.isEmpty()) {
                                System.out.println("No loans found.");
                                return;
                        }

                        for (LoanEntity loan : loans) {
                                if (loan.getBooks() != null && !loan.getBooks().isEmpty()) {
                                        BookEntity lonedBook = loan.getBooks().iterator().next();
                                        System.out.println("Book in Selected Loan: " + lonedBook.getTitle());
                                        // books.add(lonedBook);
                                }
                        }
                        filterTableWithBooks(loans);
                        // System.out.println("Total books to display: " + books.size());
                        // books = books.stream().distinct().collect(Collectors.toList());
                } catch (Exception e) {
                        JOptionPane.showMessageDialog(this, "Error para mapear los libros");
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
                var selectedCategory = (CategoryEntity) comBoxCategory.getSelectedItem();
                // List<Book> books = new ArrayList<>();

                try {
                        if ("ALL".equals(selectedCategory.getName())) {

                                var loans = getAllLoansQueries.getLoans();
                                // for (Loan loan : loans) {
                                // if (loan.getBooks() != null && !loan.getBooks().isEmpty()) {
                                // Book lonedBook = loan.getBooks().get(0);
                                // System.out.println("Books in Selected loan: " + lonedBook);
                                // System.out.println("Selected Category: " + selectedCategory.getName());
                                // books.add(lonedBook);
                                // }
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
                int selectedRow = loansTable.getSelectedRow();
                LoanEntity selectBook = loanMap.get(selectedRow);
                if (selectedRow >= 0) {
                        try {
                                LoanEntity loan = findLoan.findLoanByBook(selectBook.getBooks().iterator().next());
                                BookEntity book = loan.getBooks().iterator().next();
                                if (loan != null) {
                                        System.out.println("si se guardo");
                                        System.out.println("stock: " + book.getStock());
                                        if (book.getStock() == 0) {
                                                returnLoanCommandsController.returnLoan(loan);
                                                setTrueBookIsAvailable.setTrueIsAvailable(book.getISB());
                                        } else {
                                                returnLoanCommandsController.returnLoan(loan);
                                                JOptionPane.showMessageDialog(this, "Book returned successfully.");
                                        }
                                        updateTable();
                                }
                        } catch (Exception e) {
                                JOptionPane.showMessageDialog(this,
                                                "Error processing the return. Please check the selection and try again.");
                        }
                } else {
                        JOptionPane.showMessageDialog(this, "Please select a book from the table.");
                }
        }// GEN-LAST:event_buttonReturnActionPerformed

        private void updateTable() {
                loanMap.clear();
                DefaultTableModel model = (DefaultTableModel) loansTable.getModel();
                model.setRowCount(0);
                try {
                        List<LoanEntity> loans = getAllLoansQueries.getLoans();

                        if (loans.isEmpty()) {
                                JOptionPane.showMessageDialog(this, "The list is empty.");
                        }

                        for (int i = 0; i < loans.size(); i++) {
                                LoanEntity loan = loans.get(i);
                                loanMap.put(i, loan);
                                model.addRow(new Object[] {
                                                loan.getBooks().iterator().next().getISB(),
                                                loan.getBooks().iterator().next().getTitle(),
                                                loan.getQuantity(),
                                                loan.getDateReturn()
                                });
                        }
                } catch (Exception e) {
                        javax.swing.JOptionPane.showMessageDialog(this,
                                        e.getMessage());
                }

        }

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

        private void filterTableWithBooks(List<LoanEntity> loans) {
                var tableModel = new javax.swing.table.DefaultTableModel(
                                new Object[][] {},
                                new String[] { "ISBN", "Title", "Quantity", "Date Return" });
                tableModel.setRowCount(0);
                loanMap.clear();
                int rowIndex = 0;
                for (LoanEntity loan : loans) {
                        if (loan.getBooks() != null && !loan.getBooks().isEmpty()) {
                                BookEntity book = loan.getBooks().iterator().next();
                                tableModel.addRow(new Object[] {
                                                book.getISB(),
                                                book.getTitle(),
                                                loan.getQuantity(),
                                                loan.getDateReturn()
                                });
                                loanMap.put(rowIndex++, loan);
                        } else {
                                // Si no hay libros asociados al préstamo, puedes decidir cómo manejar este caso
                                System.out.println("Loan ID " + loan.getId() + " has no books associated.");
                        }
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

        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton buttonClients;
        private javax.swing.JButton buttonReturn;
        private javax.swing.JComboBox<CategoryEntity> comBoxCategory;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JPanel jPanel1;
        private javax.swing.JScrollPane jScrollPane1;
        private javax.swing.JTable loansTable;
        // End of variables declaration//GEN-END:variables
}
