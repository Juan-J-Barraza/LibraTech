/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Guis;

import co.edu.unicolombo.s3.poo.inventory.library.Guis.Books.*;
import co.edu.unicolombo.s3.poo.inventory.library.Guis.Client.ManageClient;
import co.edu.unicolombo.s3.poo.inventory.library.Guis.Loans.GeneralLoan;
import co.edu.unicolombo.s3.poo.inventory.library.Guis.Reservation.CreateReservation;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Book.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Client.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Loan.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Reservation.AddReservationCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Commands.Reservation.DeleteReservationCommands;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Book.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Client.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Loan.*;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Reservation.GetListReservationsQueries;

/**
 *
 * @author Juan
 */
public class MainView extends javax.swing.JFrame {
    // Repositories
    private final BookRepository bookRepository = new BookRepository();
    private final CategoryRepository categoryepository = new CategoryRepository();
    private final ClientRepository clientRepository = new ClientRepository();
    private final LoanRepository loanRepository = new LoanRepository(bookRepository);
    private final ReservationRepository reservationRepository = new ReservationRepository();

    // Queries
    private final GetListBookByCategoryQueries categoryService = new GetListBookByCategoryQueries(categoryepository);
    private final GetListBookQueries bookList = new GetListBookQueries(bookRepository);
    private final GetBookByISB bookByISB = new GetBookByISB(bookRepository);
    private final GetAllClientsQueries getAllClientsQueries = new GetAllClientsQueries(clientRepository);
    private final GetClientByNameQueries getClientByNameQueries = new GetClientByNameQueries(clientRepository);
    private final GetClientFromLoanQueries getClientFromLoanQueries = new GetClientFromLoanQueries(loanRepository);
    private final GetListClientsWithLoanQueries getListClientsWithLoanQueries = new GetListClientsWithLoanQueries(
            loanRepository);
    private final FindLoanByBook findLoanByBook = new FindLoanByBook(loanRepository);
    private final GetAllLoansQueries getAllLoansQueries = new GetAllLoansQueries(loanRepository);
    private final GetListReservationsQueries getListReservationsQueries = new GetListReservationsQueries(
            reservationRepository);

    // Commands
    private final CreateBookCommandController bookCreate = new CreateBookCommandController(bookRepository);
    private final UpdateBookCommandController bookUpdate = new UpdateBookCommandController(bookRepository);
    private final DeleteBookCommands deleteBookCommands = new DeleteBookCommands(bookRepository);
    private final RemoveQuantityFromStock removeQuantityFromStock = new RemoveQuantityFromStock(bookRepository);
    private final SetBookToFalseAviailable setBookToFalseAviailable = new SetBookToFalseAviailable(bookRepository);
    private final SetTrueBookIsAvailable sTrueBookIsAvailable = new SetTrueBookIsAvailable(bookRepository);
    private final CreateClientCommmands createClientCommmands = new CreateClientCommmands(clientRepository);
    private final UpdatecClientCommands updatecClientCommands = new UpdatecClientCommands(clientRepository);
    private final DeleteCLientCommands deleteCLientCommands = new DeleteCLientCommands(clientRepository);
    private final CreateLoanCommandsController createLoanCommandsController = new CreateLoanCommandsController(
            loanRepository);
    private final ReturnLoanCommandsController returnLoanCommandsController = new ReturnLoanCommandsController(
            loanRepository);
    private final AddReservationCommands addReservationCommands = new AddReservationCommands(reservationRepository);
    private final DeleteReservationCommands deleteReservationCommands = new DeleteReservationCommands(
            reservationRepository);

    /**
     * Creates new form MainView
     */
    public MainView() {
        initComponents();
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

        MainMenu = new javax.swing.JMenuBar();
        BooksMenu = new javax.swing.JMenu();
        itemBookCreate = new javax.swing.JMenuItem();
        itemGeneralBooks = new javax.swing.JMenuItem();
        LoanMenu = new javax.swing.JMenu();
        itemGeneralLoan = new javax.swing.JMenuItem();
        ReservationMenu = new javax.swing.JMenu();
        itemReservationCreate = new javax.swing.JMenuItem();
        itemGeneralReservations = new javax.swing.JMenuItem();
        ClientsMenu = new javax.swing.JMenu();
        itemClientMenu = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BooksMenu.setMnemonic('B');
        BooksMenu.setText("Books");

        itemBookCreate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_A,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemBookCreate.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemBookCreate.setMnemonic('A');
        itemBookCreate.setText("Add...");
        itemBookCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemBookCreateActionPerformed(evt);
            }
        });
        BooksMenu.add(itemBookCreate);

        itemGeneralBooks.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G,
                java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemGeneralBooks.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemGeneralBooks.setMnemonic('L');
        itemGeneralBooks.setText("General...");
        itemGeneralBooks.setToolTipText("");
        itemGeneralBooks.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGeneralBooksActionPerformed(evt);
            }
        });
        BooksMenu.add(itemGeneralBooks);

        MainMenu.add(BooksMenu);

        LoanMenu.setMnemonic('L');
        LoanMenu.setText("Loans");

        itemGeneralLoan.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_G,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemGeneralLoan.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemGeneralLoan.setText("General...");
        itemGeneralLoan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemGeneralLoanActionPerformed(evt);
            }
        });
        LoanMenu.add(itemGeneralLoan);

        MainMenu.add(LoanMenu);

        ReservationMenu.setMnemonic('L');
        ReservationMenu.setText("Reservations...");

        itemReservationCreate.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R,
                java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemReservationCreate.setText("Add...");
        itemReservationCreate.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                try {
                    itemReservationCreateActionPerformed(evt);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
        ReservationMenu.add(itemReservationCreate);
        itemReservationCreate.getAccessibleContext().setAccessibleName("Add");

        itemGeneralReservations.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_R,
                java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        itemGeneralReservations.setLabel("General");
        ReservationMenu.add(itemGeneralReservations);

        MainMenu.add(ReservationMenu);

        ClientsMenu.setMnemonic('L');
        ClientsMenu.setText("Clients");

        itemClientMenu.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_C,
                java.awt.event.InputEvent.ALT_DOWN_MASK));
        itemClientMenu.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        itemClientMenu.setText("ManageClients...");
        itemClientMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                itemClientMenuActionPerformed(evt);
            }
        });
        ClientsMenu.add(itemClientMenu);

        MainMenu.add(ClientsMenu);

        setJMenuBar(MainMenu);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 776, Short.MAX_VALUE));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 402, Short.MAX_VALUE));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void itemReservationCreateActionPerformed(java.awt.event.ActionEvent evt) throws Exception {// GEN-FIRST:event_itemReservationCreateActionPerformed
        var manageClient = new CreateReservation(
                this,
                true,
                addReservationCommands,
                getListReservationsQueries,
                deleteReservationCommands,
                bookList,
                getAllClientsQueries);
        manageClient.setLocationRelativeTo(this);
        manageClient.setVisible(true);
    }// GEN-LAST:event_itemReservationCreateActionPerformed

    private void itemBookCreateActionPerformed(java.awt.event.ActionEvent evt) {
        var createBookDialog = new CreateBook(this, true, bookCreate);
        createBookDialog.setLocationRelativeTo(this);
        createBookDialog.setVisible(true);
    }

    private void itemGeneralBooksActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_itemGeneralBooksActionPerformed
        GeneralBook GeneralBookDialog = new GeneralBook(this, true, bookByISB,
                categoryService, bookList, bookUpdate, deleteBookCommands,
                createLoanCommandsController,
                createClientCommmands,
                getClientByNameQueries,
                removeQuantityFromStock,
                setBookToFalseAviailable);
        GeneralBookDialog.setLocationRelativeTo(this);
        GeneralBookDialog.setVisible(true);
    }// GEN-LAST:event_itemGeneralBooksActionPerformed

    private void itemGeneralLoanActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_itemGeneralLoanActionPerformed
        var generalLoan = new GeneralLoan(this, true,
                returnLoanCommandsController,
                getListClientsWithLoanQueries,
                getAllLoansQueries,
                findLoanByBook,
                sTrueBookIsAvailable,
                categoryService);
        generalLoan.setLocationRelativeTo(this);
        generalLoan.setVisible(true);
    }// GEN-LAST:event_itemGeneralLoanActionPerformed

    private void itemClientMenuActionPerformed(java.awt.event.ActionEvent evt) {// GEN-FIRST:event_itemClientMenuActionPerformed
        var manageClient = new ManageClient(null, true,
                createClientCommmands,
                getAllClientsQueries,
                getClientByNameQueries,
                updatecClientCommands,
                deleteCLientCommands);
        manageClient.setLocationRelativeTo(this);
        manageClient.setVisible(true);
    }// GEN-LAST:event_itemClientMenuActionPerformed

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
    // java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (InstantiationException ex) {
    // java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (IllegalAccessException ex) {
    // java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // } catch (javax.swing.UnsupportedLookAndFeelException ex) {
    // java.util.logging.Logger.getLogger(MainView.class.getName()).log(java.util.logging.Level.SEVERE,
    // null, ex);
    // }
    // //</editor-fold>
    //
    // /* Create and display the form */
    // java.awt.EventQueue.invokeLater(new Runnable() {
    // public void run() {
    // new MainView().setVisible(true);
    // }
    // });
    // }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JMenu BooksMenu;
    private javax.swing.JMenu ClientsMenu;
    private javax.swing.JMenu LoanMenu;
    private javax.swing.JMenuBar MainMenu;
    private javax.swing.JMenu ReservationMenu;
    private javax.swing.JMenuItem itemBookCreate;
    private javax.swing.JMenuItem itemClientMenu;
    private javax.swing.JMenuItem itemGeneralBooks;
    private javax.swing.JMenuItem itemGeneralLoan;
    private javax.swing.JMenuItem itemGeneralReservations;
    private javax.swing.JMenuItem itemReservationCreate;
    // End of variables declaration//GEN-END:variables
}
