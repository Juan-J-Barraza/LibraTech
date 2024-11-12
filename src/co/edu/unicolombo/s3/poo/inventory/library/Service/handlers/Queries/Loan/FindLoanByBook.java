package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan.IFindLoanByBook;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ILoanRepository;

public class FindLoanByBook implements IFindLoanByBook {

    private ILoanRepository loanRepository;

    public FindLoanByBook(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public LoanEntity findLoanByBook(BookEntity book) throws Exception {
        return loanRepository.findLoanByBook(book);
    }

}
