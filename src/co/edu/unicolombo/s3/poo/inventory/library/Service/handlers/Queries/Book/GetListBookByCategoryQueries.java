
package co.edu.unicolombo.s3.poo.inventory.library.Service.Handlers.Queries.Book;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ICategoryRepository;
import java.util.List;

/**
 *
 * @author Juan
 */
public class GetListBookByCategoryQueries implements ICategoryRepository{
    
    private ICategoryRepository categoryRepository;
    
    public GetListBookByCategoryQueries(ICategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<Book> listBookByCategoty(String name) throws Exception {
        return categoryRepository.listBookByCategoty(name);
    }
    
    
}
