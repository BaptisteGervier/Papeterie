package fr.eni.papeterie.bo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:sqlite:identifier.sqlite";
        try {
            Connection connection = DriverManager.getConnection(url);
            String sql = "INSERT INTO personne VALUES(?, ?);";
            PreparedStatement reqPreparee = connection.prepareStatement(sql);
            reqPreparee.setString(1, "Brigitte");
            reqPreparee.setString(2, "Bardot");
            reqPreparee.executeUpdate();
            reqPreparee.setString(1, "Brigitte");
            reqPreparee.setString(2, "Macron");
            reqPreparee.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
