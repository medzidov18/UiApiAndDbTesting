package database.commands;

import database.connection.Database;
import java.sql.*;

import static dataread.DataRead.configDataDbDTO;

public class DbCommands {
    public static void deleteTestById(String idOfTest) {
        try (PreparedStatement preparedStatement = Database.getConnection().prepareStatement(configDataDbDTO.getDeleteTestCommand());) {
            preparedStatement.setInt(1, Integer.parseInt(idOfTest));
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void deleteProjectById(String nameOfProject) {
        try (PreparedStatement preparedStatement = Database.getConnection().prepareStatement(configDataDbDTO.getDeleteProjectCommand());) {
            preparedStatement.setString(1, nameOfProject);
            preparedStatement.execute();
        } catch (SQLException e) {
            throw new IllegalStateException(e);
        }
    }
}
