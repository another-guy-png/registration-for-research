package factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author joaomiranda
 */
public class ConnectionFactory {

    public Connection getConnection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/cadastro", "root", "Maconha.308");
        } catch (SQLException excecao) {
            throw new RuntimeException(excecao);
        }
    }
}
