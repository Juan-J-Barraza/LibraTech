package co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Queries.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;

public interface IGetBookIsAvailable {
    
    public Boolean bookIsAvailable(BookEntity book);
}
