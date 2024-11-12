/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan;

// import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Loan;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.LoanEntity;

import java.util.List;

/**
 *
 * @author Juan
 */
public interface IGetLoansQueries {
    
    public List<LoanEntity> getLoans() throws Exception;
}
