package com.example.casestudy;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBC {
    public String connectionURL = "jdbc:mysql://localhost:3306/caseStudy";
    public String username = "root";
    public String password = "password";
    public Connection getConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection(connectionURL,username,password);
        return connection;
    }
}
