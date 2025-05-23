package com.pokemon.connection;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Esta clase crea una conexión con MySQL 8
 * usando JDBC 8.0.33
 */
public class DatabaseConnetion {
    private static DatabaseConnetion instance;
    private Connection connection;
    private static String URL;
    private static String USER;
    private static String PASSWORD;

    static {
        try (InputStream input = DatabaseConnetion.class.getClassLoader().getResourceAsStream("database.properties")) {
            Properties prop = new Properties();
            if (input == null) {
                throw new RuntimeException("Unable to find database.properties");
            }
            prop.load(input);
            URL = prop.getProperty("db.url");
            USER = prop.getProperty("db.user");
            PASSWORD = prop.getProperty("db.password");
        } catch (IOException ex) {
            throw new RuntimeException("Failed to load database properties", ex);
        }
    }

    private DatabaseConnetion()throws SQLException{
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Obtiene una instancia de DataBaseConnection usando singleton
     * @return instancia de DatabaseConnection
     * @throws SQLException
     */
    public  static DatabaseConnetion getInstance() throws SQLException{
        if(instance==null || instance.getConnection().isClosed()){
            instance = new DatabaseConnetion();
        }
        return instance;
    }

    public Connection getConnection(){
        return connection;
    }



}
