
package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.DB;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ILoanRepository;
import java.util.*;

/**
 *
 * @author Juan
 */
public class LoanRepository implements ILoanRepository {
    private final DB db = DB.getInstance();
    private final BookRepository bookRepository;

    public LoanRepository(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    @Override
    public void addloanBook(Loan loan) throws Exception {
        if (loan == null) {
            throw new Exception("You can not borrow");
        }
        for (Book book : loan.getBooks()) {
            var title = book.getTitle();
            var quantity = loan.getQuantity();
            bookRepository.removeBookFromStock(quantity, title);
        }
        db.getListLoans().add(loan);
    }

    @Override
    public List<Loan> getLoans() throws Exception {
        if (db.getListLoans() == null) {
            throw new Exception("the list loan is empty");
        }
        return db.getListLoans();
    }

    @Override
    public Client getClientFromLoan(int idClient) throws Exception {
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

    @Override
    public void returnBook(Loan loan) throws Exception {
        if (loan == null) {
            throw new Exception();
        }
        for (Book book : loan.getBooks()) {
            var title = book.getTitle();
            var quantity = loan.getQuantity();
            bookRepository.addBookToStock(quantity, title);
        }
        var indexLo = db.getIndexLoanById(loan.getID());
        db.getListLoans().remove(indexLo);
    }

    @Override
    public List<Client> getListClientsWithLoan() throws Exception {
        var loans = db.getListLoans();

        if (loans == null || loans.isEmpty()) {
            throw new Exception();
        }

        List<Client> clients = new ArrayList<>();
        for (Loan loan : loans) {
            clients.add(loan.getClient());
        }

        return clients;
    }

    @Override
    public Loan findLoanByBook(Book book) throws Exception {
        for (Loan loan : db.getListLoans()) {
            if (loan.getBooks().contains(book)) {
                return loan;
            }
        }
        throw new Exception("No loan found for the selected book.");
    }

}
