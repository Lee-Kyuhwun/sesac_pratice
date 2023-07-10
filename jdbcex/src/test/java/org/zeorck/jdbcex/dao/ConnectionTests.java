package org.zeorck.jdbcex.dao;


import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.zeorck.jdbcex.domain.TodoVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

public class ConnectionTests {

    @Test
    public void testConnection() throws Exception{

        Class.forName("org.mariadb.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "root",
                "1234"
        );

        Assertions.assertNotNull(connection);

        connection.close();


    }


    @Test
    public void testHikariCP() throws Exception{
        HikariConfig config = new HikariConfig();

        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("root");
        config.setPassword("1234");
        config.addDataSourceProperty("cachePrepStmts","true");
        config.addDataSourceProperty("prepStmtCacheSize","250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit","2048");

        HikariDataSource ds = new HikariDataSource(config);
        Connection connection = ds.getConnection();
        System.out.println("connection = " + connection);

        connection.close();

    }



}
