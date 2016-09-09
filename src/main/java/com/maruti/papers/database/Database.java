package com.maruti.papers.database;

import java.sql.*;



public class Database {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DATABASE_URL = "jdbc:mysql://localhost/maruti_schema";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "";

    private Connection connection = null;
    private Statement statement = null;

    public Database() throws Exception{
        Class.forName(JDBC_DRIVER);
        connection = DriverManager.getConnection(DATABASE_URL,USERNAME,PASSWORD);
        statement = connection.createStatement();
    }

    public ResultSet executeSqlQuery(String sql) throws SQLException {
        return statement.executeQuery(sql);






    }

}
