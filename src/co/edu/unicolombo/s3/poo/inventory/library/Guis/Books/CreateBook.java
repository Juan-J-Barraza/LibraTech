
package co.edu.unicolombo.s3.poo.inventory.library.Guis.Books;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.*;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.DB;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Book.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Juan
 */
public class CreateBook extends javax.swing.JDialog {
        private DB db;
        private CreateBookCommandController bookCreateService;
        private SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");

        /**
         * Creates new form CreateBook
         */
        public CreateBook(java.awt.Frame parent, boolean modal,
                        CreateBookCommandController bookCreateService) {
                super(parent, modal);
                initComponents();
                this.bookCreateService = bookCreateService;
                db = DB.getInstance();
                listCategories();
                listPublishers();

        }

        private void listPublishers() {
                var showPublishers = db.getListPublishers();
                if (showPublishers.isEmpty()) {
                        comboBoxCategory.addItem(new Category("not editorial"));
                }
                for (Publisher publisher : showPublishers) {
                        comboBoxPublisher.addItem(publisher);
                }
                comboBoxPublisher.repaint();
        }

        private void listCategories() {
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
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        jPanel1 = new javax.swing.JPanel();
        ISB = new javax.swing.JLabel();
        fieldTitlle = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        fieldISB1 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        labelPublisher = new javax.swing.JLabel();
        labelCategory = new javax.swing.JLabel();
        fieldPublication = new javax.swing.JTextField();
        fieldStock = new javax.swing.JTextField();
        comboBoxPublisher = new javax.swing.JComboBox<>();
        comboBoxCategory = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        buttonAddBook = new javax.swing.JButton();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jScrollPane2.setViewportView(jEditorPane1);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jPanel1.setMinimumSize(new java.awt.Dimension(100, 100));
        jPanel1.setPreferredSize(new java.awt.Dimension(2, 354));

        ISB.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        ISB.setText("ISB:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel3.setText("Title:");

        jLabel4.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel4.setText("Publication:");

        jLabel5.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        jLabel5.setText("Stock:");

        labelPublisher.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelPublisher.setText("Publisher:");

        labelCategory.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        labelCategory.setText("Category:");

        comboBoxPublisher.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N


        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(85, 85, 85)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ISB, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelPublisher, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(labelCategory, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(fieldTitlle, javax.swing.GroupLayout.DEFAULT_SIZE, 308, Short.MAX_VALUE)
                    .addComponent(fieldISB1)
                    .addComponent(fieldPublication)
                    .addComponent(fieldStock)
                    .addComponent(comboBoxPublisher, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(comboBoxCategory, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(61, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldISB1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ISB, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(fieldTitlle, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(fieldPublication, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fieldStock, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelPublisher)
                    .addComponent(comboBoxPublisher, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelCategory)
                    .addComponent(comboBoxCategory, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        jLabel1.setFont(new java.awt.Font("Arial", 0, 24)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel1.setText("FORM TO ADD BOOK");
        jLabel1.setToolTipText("");

        buttonAddBook.setBackground(new java.awt.Color(0, 153, 153));
        buttonAddBook.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        buttonAddBook.setText("ADD");
        buttonAddBook.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonAddBookActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(buttonAddBook, javax.swing.GroupLayout.PREFERRED_SIZE, 136, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 519, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(69, 69, 69))))
                .addContainerGap(36, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 327, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(buttonAddBook)
                .addGap(20, 20, 20))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

        private void buttonAddBookActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_buttonAddBookActionPerformed
                var title = fieldTitlle.getText();
                var ISB = fieldISB1.getText();
                var stockstr = fieldStock.getText();
                var publicationDateString = fieldPublication.getText();
                var selectedPublisher = (Publisher) comboBoxPublisher.getSelectedItem();
                var selectedCategory = (Category) comboBoxCategory.getSelectedItem();

                if (title.isEmpty() || ISB.isEmpty() || stockstr.isEmpty() || selectedPublisher == null
                                
                        
                        || selectedCategory == null) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Please fill all fields.");
                        return;
                }
                Date publicaDate = null;

                int stock;
                try {
                        stock = Integer.parseInt(stockstr);
                } catch (NumberFormatException e) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Invalid stock number.");
                        return;
                }

                try {
                        publicaDate = dateFormat.parse(publicationDateString);
                } catch (ParseException e) {
                        javax.swing.JOptionPane.showMessageDialog(this, "Invalid date format. Please use dd/MM/yyyy.");
                        return;
                }
                var newBook = new Book(ISB, title, publicaDate, stock, selectedPublisher, selectedCategory);
                try {
                        bookCreateService.createBook(newBook);
                } catch (Exception e) {
                        javax.swing.JOptionPane.showMessageDialog(this, e);
                        return;
                }
                selectedCategory.getBooks().add(newBook);
                selectedPublisher.getBooks().add(newBook);

                javax.swing.JOptionPane.showMessageDialog(this, "Book added successfully!");
                // this.dispose();
                fieldTitlle.setText("");
                fieldISB1.setText("");
                fieldStock.setText("");

        }// GEN-LAST:event_buttonAddBookActionPerformed

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
                        java.util.logging.Logger.getLogger(CreateBook.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (InstantiationException ex) {
                        java.util.logging.Logger.getLogger(CreateBook.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (IllegalAccessException ex) {
                        java.util.logging.Logger.getLogger(CreateBook.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                } catch (javax.swing.UnsupportedLookAndFeelException ex) {
                        java.util.logging.Logger.getLogger(CreateBook.class.getName()).log(
                                        java.util.logging.Level.SEVERE, null,
                                        ex);
                }
                // </editor-fold>

                /* Create and display the dialog */
                // java.awt.EventQueue.invokeLater(new Runnable() {
                // public void run() {
                // CreateBook dialog = new CreateBook(new javax.swing.JFrame(), true, new
                // BookService());
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
    private javax.swing.JLabel ISB;
    private javax.swing.JButton buttonAddBook;
    private javax.swing.JComboBox<Category> comboBoxCategory;
    private javax.swing.JComboBox<Publisher> comboBoxPublisher;
    private javax.swing.JTextField fieldISB1;
    private javax.swing.JTextField fieldPublication;
    private javax.swing.JTextField fieldStock;
    private javax.swing.JTextField fieldTitlle;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelCategory;
    private javax.swing.JLabel labelPublisher;
    // End of variables declaration//GEN-END:variables
}
