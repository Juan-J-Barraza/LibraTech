/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JDialog.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Guis.Books;

import co.edu.unicolombo.s3.poo.inventory.library.Guis.Loans.CreateLoan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Config.HibernateUtil;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.CategoryEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Book.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Client.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Commands.Loan.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Book.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Client.*;

import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import org.hibernate.Session;

/**
 *
 * @author Juan
 */
public class GeneralBook extends javax.swing.JDialog {

    private GetBookByISB bookByISB;
    private GetListBookQueries bookList;
    private UpdateBookCommandController bookUpdate;
    private GetListBookByCategoryQueries categoryService;
    private DeleteBookCommands deleteBookCommands;
    SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
    private Map<Integer, BookEntity> bookMap = new HashMap<>();
    private CreateLoanCommandsController createLoanCommandsController;
    private CreateClientCommmands createClientCommmands;
    private GetClientByNameQueries getClientByNameQueries;
    private RemoveQuantityFromStock removeQuantityFromStock;
    private SetBookToFalseAviailable setBookToFalseAviailable;
    private GetBookBytitleQueries getBookBytitleQueries;
    private GetBookIsAvailableQueries getBookIsAvailableQueries;

    /**
     * Creates new form ListBook
     */
    public GeneralBook(java.awt.Frame parent, boolean modal,
            GetBookByISB bookByISB,
            GetBookIsAvailableQueries getBookIsAvailableQueries,
            GetBookBytitleQueries getBookBytitleQueries,
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
        this.getBookBytitleQueries = getBookBytitleQueries;
        this.getBookIsAvailableQueries = getBookIsAvailableQueries;
        initComponents();
        setToBooksOnTable();
        listCategories();
    }

    private void listCategories() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            List<CategoryEntity> categories = session.createQuery("FROM CategoryEntity", CategoryEntity.class).list();

            CategoryEntity allCategory = new CategoryEntity("ALL");
            comboBoxCategory.addItem(allCategory);

            if (categories.isEmpty()) {
                comboBoxCategory.addItem(new CategoryEntity("not category"));
            } else {
                for (CategoryEntity category : categories) {
                    System.out.println("Adding category: " + category.getName());
                    comboBoxCategory.addItem(category);
                }
            }
            comboBoxCategory.repaint();
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error al cargar categorías ");
        } finally {
            session.close();
        }
    }

    private void setToBooksOnTable() {
        try {
            var books = bookList.getAllBooks();
            filterTableWithBooks(books);
        } catch (Exception e) {
            System.out.println("");
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

        jLabel4.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jLabel4.setText("Categories:");

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

        comboBoxCategory.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comBoxCategoryActionPerformed(evt);
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

    private void comBoxCategoryActionPerformed(java.awt.event.ActionEvent evt) {
        var selectedCategory = (CategoryEntity) comboBoxCategory.getSelectedItem();
        List<BookEntity> books = new ArrayList<>();

        try {
            if ("ALL".equals(selectedCategory.getName())) {
                books = bookList.getAllBooks();
                filterTableWithBooks(books);

            } else {
                books = categoryService.listBookByCategoty(selectedCategory.getName());
                System.out.println("Books in category " + selectedCategory.getName() + ": " + books);
                if (books.isEmpty()) {
                    javax.swing.JOptionPane.showMessageDialog(this, "No books found in this category");
                } else {
                    books = books.stream().distinct().collect(Collectors.toList());
                    filterTableWithBooks(books);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error filtering books by category: " + e.getMessage());
        }

    }

    private void buttonDeleteActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_textLookforActionPerformed
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            BookEntity selectedBook = bookMap.get(selectedRow);
            deleteBook(selectedBook);
            JOptionPane.showMessageDialog(this, "Book delete sucessfully");
            updateTable();
        } else {
            JOptionPane.showMessageDialog(null, "Please select a book from the table.");
        }

    }// GEN-LAST:event_textLookforActionPerformed

    private void deleteBook(BookEntity book) {
        try {
            deleteBookCommands.deleteBook(book);
        } catch (Exception e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void updateTable() {
        bookMap.clear();
        DefaultTableModel model = (DefaultTableModel) jTable1.getModel();
        model.setRowCount(0);
        try {
            List<BookEntity> books = bookList.getAllBooks();

            if (books.isEmpty()) {
                JOptionPane.showMessageDialog(this, "The list is empty.");
            }

            for (int i = 0; i < books.size(); i++) {
                BookEntity book = books.get(i);
                bookMap.put(i, book);
                boolean isAvailable = book.isAvailable();
                String availableSrt = isAvailable ? "yes" : "no";
                model.addRow(new Object[] {
                        book.getISB(),
                        book.getTitle(),
                        dateFormat.format(book.getPublication()),
                        book.getStock(),
                        book.getCategoryEntity().getName(),
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
            BookEntity selectedBook = bookMap.get(selectedRow);
            try {
                boolean isAvailable = getBookIsAvailableQueries.bookIsAvailable(selectedBook);

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

    private void openCreateLoanWindow(BookEntity book) {
        var createLoanWindow = new CreateLoan(new javax.swing.JFrame(), true,
                book,
                createLoanCommandsController,
                createClientCommmands, getClientByNameQueries,
                removeQuantityFromStock,
                setBookToFalseAviailable);
        createLoanWindow.setOnLoanCreated(() -> {
            updateTable();
        });
        createLoanWindow.setLocationRelativeTo(this);
        createLoanWindow.setVisible(true);
    }

    private void buttonLookForActionPerformed(java.awt.event.ActionEvent evt) {
        try {
            if (textLookfor != null && !textLookfor.getText().isEmpty()) {
                BookEntity book = getBookBytitleQueries.getBookByTitle(textLookfor.getText());
                if (book != null) {
                    filterTableWithBooks(Collections.singletonList(book));
                } else {
                    javax.swing.JOptionPane.showMessageDialog(this, "No book found with this ISBN.");
                }
                textLookfor.setText("");
            }
        } catch (Exception e) {
            e.printStackTrace();
            javax.swing.JOptionPane.showMessageDialog(this, "Error finding book: " + e.getMessage());
        }
    }

    private void buttonUpdateActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = jTable1.getSelectedRow();
        if (selectedRow >= 0) {
            BookEntity selectedBook = bookMap.get(selectedRow);
            openUpdateBookWindow(selectedBook);
        } else {
            JOptionPane.showMessageDialog(null, "Please select a book from the table.");
        }
    }

    private void openUpdateBookWindow(BookEntity book) {
        BookUpdate updateBookWindow = new BookUpdate(new javax.swing.JFrame(), true, book, bookUpdate);
        updateBookWindow.setLocationRelativeTo(this);
        updateBookWindow.setVisible(true);
        updateTable();
    }

    private void filterTableWithBooks(List<BookEntity> books) {
        var tableModel = new javax.swing.table.DefaultTableModel(
                new Object[][] {},
                new String[] { "ISBN", "Title", "Publication", "Stock", "Category", "IsAvailable" });
        tableModel.setRowCount(0);
        bookMap.clear();
        int rowIndex = 0;
        for (BookEntity book : books) {
            String formattedDate = dateFormat.format(book.getPublication());
            boolean isAvailable = book.isAvailable();
            String availableSrt = isAvailable ? "yes" : "no";
            tableModel.addRow(new Object[] {
                    book.getISB(),
                    book.getTitle(),
                    formattedDate,
                    book.getStock(),
                    book.getCategoryEntity().getName(),
                    availableSrt, });

            jTable1.setModel(tableModel);
            jTable1.repaint();
            bookMap.put(rowIndex++, book);
        }
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonDelete;
    private javax.swing.JButton buttonLoan;
    private javax.swing.JButton buttonLookFor;
    private javax.swing.JButton buttonUpdate;
    private javax.swing.JComboBox<CategoryEntity> comboBoxCategory;
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
