package test;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestDBConnection {
    public static void main(String[] args) {
        try {
            String url = "jdbc:mysql://127.0.0.1:3306/database_librateach";
            String username = "root";
            String password = "12345678";

            Connection connection = DriverManager.getConnection(url, username, password);
            System.out.println("Conexión exitosa a la base de datos MySQL: " + connection);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
