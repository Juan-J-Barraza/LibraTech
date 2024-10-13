package co.edu.unicolombo.s3.poo.inventory.library.Service;

import co.edu.unicolombo.s3.poo.inventory.library.Domain.Book;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Category;
import co.edu.unicolombo.s3.poo.inventory.library.Domain.Db;
import java.util.*;

/**
 *
 * @author Juan
 */
public class CategoryService {

    private final Db db = Db.getInstance();

    public List<Book> listBookByCategoty(String name) throws Exception {
        if (name != null) {
            Optional<Category> firstCategory = db.getCategories().stream()
                    .filter(c -> c.getName().equalsIgnoreCase(name))
                    .findFirst();

            if (!firstCategory.isPresent()) {
                throw new Exception();
            }
            return firstCategory.get().getBooks();
        }

        return null;
    }
}
