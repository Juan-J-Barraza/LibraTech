/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Loan;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Client;

/**
 *
 * @author Juan
 */
public interface IGetClientLoanQueries {
    
    public Client getClientLoan(int idClient) throws Exception;
}
