package me.dio.persistence.config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public final class ConnectionConfig {
    public static Connection getConnection() throws SQLException{
        var url = "jdbc:mysql://localhost/board";
        var user = "board";
        var password = "board";
        var Connection = DriverManager.getConnection(url, user, password);
        Connection.setAutoCommit(false);
        return Connection;
    }
}
