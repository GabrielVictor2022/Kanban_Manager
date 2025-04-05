package me.dio;

import java.sql.SQLException;
import me.dio.persistence.migration.MigrationStrategy;
import me.dio.ui.MainMenu;

import static me.dio.persistence.config.ConnectionConfig.getConnection;

public class Main {
    
    public static void main(String[] args) throws SQLException{
        try(var connection = getConnection()){
            new MigrationStrategy(connection).executeMigration();
        }
        new MainMenu().execute();
    }
}
