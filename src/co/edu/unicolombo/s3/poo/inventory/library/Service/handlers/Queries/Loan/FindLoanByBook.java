package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan.IFindLoanByBook;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ILoanRepository;

public class FindLoanByBook implements IFindLoanByBook {

    private ILoanRepository loanRepository;

    public FindLoanByBook(ILoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan findLoanByBook(Book book) throws Exception {
        return loanRepository.findLoanByBook(book);
    }

}
