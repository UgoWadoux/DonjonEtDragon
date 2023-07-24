package fr.campus.dd.database;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbManager {
    Connection con;

    public Connection getCon() {
        return con;
    }

    public DbManager() {
        try {
            this.con = DriverManager.getConnection("jdbc:mysql://localhost:3306/DonjonsEtDragons", "root", "");
            // use con here
//            System.out.println("Connexion fonctionne");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
