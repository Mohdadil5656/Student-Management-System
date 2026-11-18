package com.DbConfig;

import java.sql.Connection;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

public class DbConnectio {

    private static HikariDataSource ds;

    static {

        HikariConfig con = new HikariConfig();

        con.setDriverClassName("com.mysql.cj.jdbc.Driver");
        con.setJdbcUrl("jdbc:mysql://localhost:3306/sqlDrive");
        con.setUsername("adil");
        con.setPassword("Adil@12345");

        con.setMaximumPoolSize(10);
        con.setMinimumIdle(2);

        ds = new HikariDataSource(con);
    }

    public static Connection getConnection() throws java.sql.SQLException {

        return ds.getConnection();
    }
}