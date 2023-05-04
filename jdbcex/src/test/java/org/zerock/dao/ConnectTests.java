package org.zerock.dao;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.zerock.jdbcex.dao.ConnectionUtil;
import org.zerock.jdbcex.domain.TodoVO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.time.LocalDate;

public class ConnectTests {

    @Test
    public void test1(){
        int v1 =10;
        int v2 =10;

        Assertions.assertEquals(v1,v2);
    }

    @Test
    public void testConnection() throws Exception {
        Class.forName("org.mariadb.jdbc.Driver");

        Connection connection = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/webdb",
                "webuser",
                "1q2w3e4r1!"
        );
        Assertions.assertNotNull(connection);
        connection.close();
    }

    @Test
    public void testHikariCP() throws Exception {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName("org.mariadb.jdbc.Driver");
        config.setJdbcUrl("jdbc:mariadb://localhost:3306/webdb");
        config.setUsername("webuser");
        config.setPassword("1q2w3e4r1!");
        config.addDataSourceProperty("cachePrepStmts", true);
        config.addDataSourceProperty("prepStmtCacheSize", "250");
        config.addDataSourceProperty("prepStmtCacheSqlLimit", "2048");

        HikariDataSource dataSource = new HikariDataSource(config);

        Connection connection = dataSource.getConnection();
        System.out.println(connection);

        connection.close();
    }

}
