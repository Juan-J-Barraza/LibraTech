package co.edu.unicolombo.s3.poo.inventory.library.Service;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Db;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Loan;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan
 */
public class LoanService {

    private final Db db = Db.getInstance();
    private BookService bookService;

    public void addloanBook(Loan loan) throws Exception {
        if (loan != null) {
            for (Book book : loan.getBooks()) {
                var title = book.getTitle();
                var quantity = loan.getQuantity();
                bookService.removeBookFromStock(quantity, title);
            }
            db.getListLoans().add(loan);
        }
        throw new Exception("You can not borrow");
    }

    public void returnBook(Loan loan) throws Exception {
        if (loan != null) {
            for (Book book : loan.getBooks()) {
                var title = book.getTitle();
                var quantity = loan.getQuantity();
                bookService.addBookToStock(quantity, title);
            }
            var indexLo = db.getIndexLoanById(loan.getID());
            db.getListLoans().remove(indexLo);
        }
        throw new Exception();
    }

    public List<Loan> getLoans() throws Exception {
        if (db.getListLoans() == null) {
            throw new Exception("the list loan is empty");
        }
        return db.getListLoans();
    }

    public Client getListClientsFromLoan(int idClient)
            throws Exception {
        if (idClient == 0) {
            throw new Exception("ID of client is invalid");
        }
        Optional<Client> firstClient = db.getListClients()
                .stream().filter(c -> c.getID() == idClient)
                .findFirst();

        if (!firstClient.isPresent()) {
            throw new Exception("client not found");
        }
        return firstClient.get();
    }

}
