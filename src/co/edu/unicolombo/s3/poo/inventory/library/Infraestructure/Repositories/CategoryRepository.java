package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Repositories;


import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Config.HibernateUtil;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.BookEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.CategoryEntity;
import co.edu.unicolombo.s3.poo.inventory.library.Service.Interfaces.Repositories.ICategoryRepository;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;

/**
 *
 * @author Juan
 */
public class CategoryRepository implements ICategoryRepository {

    private SessionFactory sessionFactory;

    public CategoryRepository() {
        this.sessionFactory = HibernateUtil.getSessionFactory();
    }

    @Override
    public List<BookEntity> listBookByCategoty(String name) throws Exception {
        if (name == null || name.isEmpty()) {
            throw new Exception("Category name cannot be null or empty");
        }

        try (Session session = sessionFactory.openSession()) {
            Query<CategoryEntity> categoryQuery = session.createQuery(
                    "FROM CategoryEntity c WHERE c.name = :name", CategoryEntity.class);
            categoryQuery.setParameter("name", name);

            CategoryEntity category = categoryQuery.uniqueResult();

            if (category == null) {
                throw new Exception("Category not found or no books in this category");
            }

            return category.getBooks();
        }
    }

}
