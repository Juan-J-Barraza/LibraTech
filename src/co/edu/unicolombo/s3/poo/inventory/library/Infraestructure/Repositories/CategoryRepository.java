package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Models.Category;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.DB;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ICategoryRepository;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Juan
 */
public class CategoryRepository implements ICategoryRepository {

    private DB db = DB.getInstance();

    @Override
    public List<Book> listBookByCategoty(String name) throws Exception {
        if (name != null) {
            Optional<Category> firstCategory = db.getCategories().stream()
                    .filter(c -> c.getName().equalsIgnoreCase(name))
                    .findFirst();

            if (!firstCategory.isPresent()) {
                throw new Exception("The list is empty");
            }
            return firstCategory.get().getBooks();
        }

        return null;
    }

}
