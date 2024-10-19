/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Guis.Books;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.*;
import co.edu.unicolombo.s3.poo.inventory.library.Guis.Loans.CreateLoan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.DB;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Book.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Client.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Loan.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Book.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Client.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Juan
 */
public class GeneralBook extends javax.swing.JDialog {

    private DB db;
    private GetBookByISB bookByISB;
    private GetListBookQueries bookList;
    private UpdateBookCommandController bookUpdate;
    private GetListBookByCategoryQueries categoryService;
    private DeleteBookCommands deleteBookCommands;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Map<Integer, Book> bookMap = new HashMap<>();
    private CreateLoanCommandsController createLoanCommandsController;
    private CreateClientCommmands createClientCommmands;
    private GetClientByNameQueries getClientByNameQueries;
    private RemoveQuantityFromStock removeQuantityFromStock;
    private SetBookToFalseAviailable setBookToFalseAviailable;

    /**
     * Creates new form ListBook
     */
    public GeneralBook(java.awt.Frame parent, boolean modal,
            GetBookByISB bookByISB,
            GetListBookByCategoryQueries categoryService,
            GetListBookQueries bookList,
            UpdateBookCommandController bookUpdate,
            DeleteBookCommands deleteBookCommands,
            CreateLoanCommandsController createLoanCommandsController,
            CreateClientCommmands createClientCommmands,
            GetClientByNameQueries getClientByNameQueries,
            RemoveQuantityFromStock removeQuantityFromStock,
            SetBookToFalseAviailable setBookToFalseAviailable) {
        super(parent, modal);
        db = DB.getInstance();
        this.bookByISB = bookByISB;
        this.bookList = bookList;
        this.categoryService = categoryService;
        this.bookUpdate = bookUpdate;
        this.deleteBookCommands = deleteBookCommands;
        this.createLoanCommandsController = createLoanCommandsController;
        this.getClientByNameQueries = getClientByNameQueries;
        this.createClientCommmands = createClientCommmands;
        this.removeQuantityFromStock = removeQuantityFromStock;
        this.setBookToFalseAviailable = setBookToFalseAviailable;
        initComponents();
        listCategories();
    }

    private void listCategories() {
        Category allCategories = new Category("ALL");
        comboBoxCategory.addItem(allCategories);
        var showCategories = db.getCategories();
        if (showCategories.isEmpty()) {
            comboBoxCategory.addItem(new Category("not category"));
        }
        for (Category category : showCategories) {
            comboBoxCategory.addItem(category);
        }
        comboBoxCategory.repaint();
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
    // <editor-fold defaultstate="collapsed" desc="Generated
    // <editor-fold defaultstate="collapsed" desc="Generated
    // Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        textLookfor = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        comboBoxCategory = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        buttonLookFor = new javax.swing.JButton();
        buttonUpdate = new javax.swing.JButton();
        buttonDelete = new javax.swing.JButton();
        buttonLoan = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(
                new javax.swing.border.LineBorder(new java.awt.Color(0, 102, 102), 4, true), "ListBooks"));

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("BOOKS");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][] {
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null },
                        { null, null, null, null, null, null }
                },
                new String[] {
                        "ISB", "Title ", "Publication", "Stock", "Category", "IsAvailable"
                }));
        jScrollPane1.setViewportView(jTable1);

        jLabel3.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel3.setText("Look For:");

        // textLookfor.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {
        // textLookforActionPerformed(evt);
        // }
        // });

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Categories:");

        // comboBoxCategory.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]
        // { "Item 1", "Item 2", "Item 3", "Item 4" }));
        // comboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
        // public void actionPerformed(java.awt.event.ActionEvent evt) {
        // comboBoxCategoryActionPerformed(evt);
        // }
        // });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(36, 36, 36)
                                                .addComponent(jLabel1)
                                                .addGap(185, 185, 185)
                                                .addComponent(jLabel3)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(textLookfor, javax.swing.GroupLayout.PREFERRED_SIZE, 173,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
                                                        javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 87,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 595,
                                                        javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(comboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 125,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));
        jPanel1Layout.setVerticalGroup(
                jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 34,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addGap(10, 10, 10)
                                                .addGroup(jPanel1Layout
                                                        .createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(textLookfor)
                                                        .addComponent(jLabel4)
                                                        .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                        .addComponent(comboBoxCategory,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE,
                                                                javax.swing.GroupLayout.DEFAULT_SIZE,
                                                                javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 383,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap()));

        jLabel2.setFont(new java.awt.Font("Arial", 1, 24)); // NOI18N
        jLabel2.setText("GENERAL BOOKS");

        buttonLookFor.setBackground(new java.awt.Color(204, 255, 255));
        buttonLookFor.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        buttonLookFor.setForeground(new java.awt.Color(0, 102, 102));
        buttonLookFor.setText("Look For");
        buttonLookFor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLookForActionPerformed(evt);
            }
        });

        buttonUpdate.setBackground(new java.awt.Color(204, 204, 255));
        buttonUpdate.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        buttonUpdate.setForeground(new java.awt.Color(0, 102, 102));
        buttonUpdate.setText("Update");
        buttonUpdate.setToolTipText("");
        buttonUpdate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonUpdateActionPerformed(evt);
            }
        });

        buttonDelete.setBackground(new java.awt.Color(255, 0, 0));
        buttonDelete.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        buttonDelete.setForeground(new java.awt.Color(255, 255, 255));
        buttonDelete.setText("Delete");
        buttonDelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonDeleteActionPerformed(evt);
            }
        });

        buttonLoan.setBackground(new java.awt.Color(204, 255, 204));
        buttonLoan.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        buttonLoan.setText("Loan");
        buttonLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonLoanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel2)
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(buttonLookFor, javax.swing.GroupLayout.PREFERRED_SIZE, 137,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(54, 54, 54)
                                .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 139,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(47, 47, 47)
                                .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 133,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 211,
                                        Short.MAX_VALUE)
                                .addComponent(buttonLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 85,
                                        javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(15, 15, 15))
                        .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE,
                                javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE,
                                        javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(buttonLookFor, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonUpdate, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonDelete, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                                javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(buttonLoan, javax.swing.GroupLayout.PREFERRED_SIZE, 38,
                                                javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(14, 14, 14)));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    // private void textLookforActionPerformed(java.awt.event.ActionEvent evt) {//
    // GEN-FIRST:event_textLookforActionPerformed
    // try {
    // if (textLookfor != null && !textLookfor.getText().isEmpty()) {
    // Book book = bookByISB.getBookByISB(textLookfor.getText());
    // filterTableWithBooks(Collections.singletonList(book));
    // textLookfor.setText("");
    // }
    // } catch (Exception e) {
    // javax.swing.JOptionPane.showMessageDialog(this, e.getMessage());
    // }
    // }// GEN-LAST:event_textLookforActionPerformed

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textLookforActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            Book selectedBook = bookMap.get(selectedRow);
            deleteBook(selectedBook);
            JOptionPane.showMessageDialog(this, "Book delete sucessfully");
            updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a book from the table.");
        }

    }// GEN-LAST:event_textLookforActionPerformed

    private void deleteBook(Book book) {
        try {
            deleteBookCommands.deleteBook(book);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void updateTable() {
        bookMap.clear();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            List<Book> books = bookList.getAllBooks();

            if (books.isEmpty()) {
                JOptionPane.showMessageDialog(this, "The list is empty.");
            }

            for (int i = 0; i < books.size(); i++) {
                Book book = books.get(i);
                bookMap.put(i, book);
                boolean isAvailable = book.isAvailable();
                String availableSrt = isAvailable ? "yes" : "no";
                model.addRow(new Object[] {
                        book.getISB(), 
                        book.getTitle(),
                        dateFormat.format(book.getPublicaion()),
                        book.getStock(),
                        book.getCategory().getName(),
                        availableSrt
                    });
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this,
                    e.getMessage());
        }

    }


    private void buttonLoanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonLoanActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            Book selectedBook = bookMap.get(selectedRow);
            try {
                boolean isAvailable = setBookToFalseAviailable.bookSetTofalseAvailable(selectedBook.getISB());

                if (!isAvailable) {
                    JOptionPane.showMessageDialog(this, "The book is not Available");
                } else {
                    openCreateLoanWindow(selectedBook);
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
            }
        } else {
            JOptionPane.showMessageDialog(null, "Please select a book from the table.");
        }

    }// GEN-LAST:event_buttonLoanActionPerformed

    private void openCreateLoanWindow(Book book) {
        var createLoanWindow = new CreateLoan(new javax.swing.JFrame(), true,
                book,
                createLoanCommandsController,
                createClientCommmands, getClientByNameQueries,
                removeQuantityFromStock,
                setBookToFalseAviailable);
        createLoanWindow.setLocationRelativeTo(this);
        createLoanWindow.setVisible(true);
    }

    private void buttonLookForActionPerformed(java.awt.event.ActionEvent evt) {
        var selectedCategory = (Category) comboBoxCategory.getSelectedItem();
        List<Book> books = new ArrayList<>();

        try {
            if (textLookfor != null && !textLookfor.getText().isEmpty()) {
                Book book = bookByISB.getBookByISB(textLookfor.getText().toLowerCase());
                filterTableWithBooks(Collections.singletonList(book));
                textLookfor.setText("");
            } else if ("ALL".equals(selectedCategory.getName())) {
                books = bookList.getAllBooks();
                filterTableWithBooks(books);
            } else {
                books = categoryService.listBookByCategoty(selectedCategory.getName());
                if (books.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(this,
                            "No books found in this category");
                }
                books = books.stream().distinct().collect(Collectors.toList());
                filterTableWithBooks(books);
                textLookfor.setText("");
            }
        } catch (Exception e) {
            javax.swing.JOptionPane.showMessageDialog(this, "The list is empty");
        }
    }

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            Book selectedBook = bookMap.get(selectedRow);
            openUpdateBookWindow(selectedBook);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a book from the table.");
        }
    }

    private void openUpdateBookWindow(Book book) {
        BookUpdate updateBookWindow = new BookUpdate(new javax.swing.JFrame(), true, book, bookUpdate);
        updateBookWindow.setLocationRelativeTo(this);
        updateBookWindow.setVisible(true);
        updateTable();
    }

    private void filterTableWithBooks(List<Book> books) {
        var tableModel = new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ISBN", "Title", "Publication", "Stock", "Category", "IsAvailable" });
        tableModel.setRowCount(0);
        bookMap.clear();
        int rowIndex = 0;
        for (Book book : books) {
            String formattedDate = dateFormat.format(book.getPublicaion());
            boolean isAvailable = book.isAvailable();
            String availableSrt = isAvailable ? "yes" : "no";
            tableModel.addRow(new Object[] {
                    book.getISB(),
                    book.getTitle(),
                    formattedDate,
                    book.getStock(),
                    book.getCategory().getName(),
                    availableSrt, });

            jTable1.setModel(tableModel);
            jTable1.repaint();
            bookMap.put(rowIndex++, book);
        }
    }

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
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GeneralBook.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GeneralBook.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GeneralBook.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GeneralBook.class.getName()).log(
                    java.util.logging.Level.SEVERE,
                    null, ex);
        }
        // </editor-fold>

        /* Create and display the dialog */
        // java.awt.EventQueue.invokeLater(new Runnable() {
        // public void run() {
        // GeneralBook dialog = new GeneralBook(new javax.swing.JFrame(), true, new
        // BookService(),
        // new CategoryService());
        // dialog.addWindowListener(new java.awt.event.WindowAdapter() {
        // @Override
        // public void windowClosing(java.awt.event.WindowEvent e) {
        // System.exit(0);
        // }
        // });
        // dialog.setVisible(true);
        // }
        // });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonLoan;
    private javax.swing.JButton buttonLookFor;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox<Category> comboBoxCategory;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField textLookfor;
    // End of variables declaration//GEN-END:variables
}
