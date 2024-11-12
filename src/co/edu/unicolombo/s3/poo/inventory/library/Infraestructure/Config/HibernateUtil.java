package co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Config;

import org.hibernate.SessionFactory;
// import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
// import org.hibernate.service.ServiceRegistry;

import co.edu.unicolombo.s3.poo.inventory.library.Infraestructure.Persistences.Entities.*;

public class HibernateUtil {

    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory() {
        if (sessionFactory == null) {
            try {
                Configuration configuration = new Configuration();

                configuration.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
                configuration.setProperty("hibernate.hbm2ddl.auto", "update");
                configuration.setProperty("hibernate.show_sql", "true");
                configuration.setProperty("hibernate.format_sql", "true");
                configuration.setProperty("hibernate.connection.url", "jdbc:mysql://127.0.0.1:3306/database_librateach?serverTimezone=UTC");
                configuration.setProperty("hibernate.connection.username", "root");
                configuration.setProperty("hibernate.connection.password", "12345678");

                configuration.addAnnotatedClass(BookEntity.class);
                configuration.addAnnotatedClass(PublisherEntity.class);
                configuration.addAnnotatedClass(CategoryEntity.class);
                configuration.addAnnotatedClass(ClientEntity.class);
                configuration.addAnnotatedClass(LoanEntity.class);
                configuration.addAnnotatedClass(ReservationEntity.class);
                
                // ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                //         .applySettings(configuration.getProperties()).build();

                sessionFactory = configuration.buildSessionFactory();
            } catch (Throwable e) {
                System.err.println("Unexpected error: " + e.getMessage());
                e.printStackTrace();
                throw new ExceptionInInitializerError("Fallo al crear la SessionFactory: " + e.getMessage());
            }
        }

        return sessionFactory;
    }
}
