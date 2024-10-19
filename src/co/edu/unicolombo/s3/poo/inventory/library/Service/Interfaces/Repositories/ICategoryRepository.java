/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import java.util.List;

/**
 *
 * @author Juan
 */
public interface ICategoryRepository {

    public List<Book> listBookByCategoty(String name) throws Exception;
}
