package fr.eni.papeterie.ihm;

import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {


        SwingUtilities.invokeLater(new Runnable() {   //permet de lancer un nouveau thread
            @Override
            public void run() {
                JFrame app = new GUI();
            }
        });
    }
}
