package co.edu.unicolombo.s3.poo.inventory.library.Service.Controller.Queries.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories.LoanRepository;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan.IFindLoanByBook;

public class FindLoanByBook implements IFindLoanByBook {

    private LoanRepository loanRepository;

    public FindLoanByBook(LoanRepository loanRepository) {
        this.loanRepository = loanRepository;
    }

    @Override
    public Loan findLoanByBook(Book book) throws Exception {
        return loanRepository.findLoanByBook(book);
    }

}
