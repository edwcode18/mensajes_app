/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edwar.mensajes_app;

import com.google.protobuf.Message;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author edwcode
 */
public class MessagesDAO {

    public static void createMessageDB(Messages message) {
        ConnectionDB connectionDB = new ConnectionDB();

        try (Connection connection = connectionDB.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?, ?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setString(2, message.getAuthorMessage());
                ps.executeUpdate();
                System.out.println("Message created");
            } catch (SQLException e) {
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void listMessagesDB() {
        ConnectionDB connectionDB = new ConnectionDB();

        try (Connection connection = connectionDB.get_connection()) {
            PreparedStatement ps = null;
            ResultSet rs = null;
            try {
                String query = "SELECT * FROM mensajes";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();
                while (rs.next()) {
                    System.out.println("ID: " + rs.getInt("id_mensaje"));
                    System.out.println("Message: " + rs.getString("mensaje"));
                    System.out.println("Author: " + rs.getString("autor_mensaje"));
                    System.out.println("Date: " + rs.getString("fecha_mensaje"));
                    System.out.println("");
                }
            } catch (SQLException e) {
                System.out.println("Can't get the messages");
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void deleteMessageDB(int idMessage) {
        ConnectionDB connectionDB = new ConnectionDB();

        try (Connection connection = connectionDB.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "DELETE FROM mensajes WHERE id_mensaje = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1, idMessage);
                ps.executeUpdate();
                System.out.println("The message was deleted");
            } catch (SQLException e) {
                System.out.println("Can't delete the message");
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }

    public static void updateMessageDB(Messages message) {
        ConnectionDB connectionDB = new ConnectionDB();

        try (Connection connection = connectionDB.get_connection()) {
            PreparedStatement ps = null;
            try {
                String query = "UPDATE mensajes SET mensaje = ? WHERE id_mensaje = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1, message.getMessage());
                ps.setInt(2, message.getIdMessage());
                ps.executeUpdate();
                System.out.println("The message was updated");
            } catch (SQLException e) {
                System.out.println("Can't update the message");
                System.out.println(e);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
    }
}
