/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edwar.mensajes_app;

import java.sql.Connection;
import java.util.Scanner;

/**
 *
 * @author edwcode
 */
public class Initiation {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int opcion = 0;

        do {
            System.out.println("-----------------");
            System.out.println(" Aplication of messages");
            System.out.println(" 1. Create new message");
            System.out.println(" 2. List messages");
            System.out.println(" 3. Delete message");
            System.out.println(" 4. Edit message");
            System.out.println(" 5. Exit");
            // We read the option of the user
            opcion = sc.nextInt();

            switch (opcion) {
                case 1:
                    MessagesService.createMessage();
                    break;
                case 2:
                    MessagesService.listMessages();
                    break;
                case 3:
                    MessagesService.deleteMessage();
                    break;
                case 4:
                    MessagesService.updateMessage();
                    break;
                default:
                    break;
            }
        } while (opcion != 5);

        /*
        ConnectionDB conexion = new ConnectionDB();

        try (Connection cnx = conexion.get_connection()) {

        } catch (Exception e) {
            System.out.println(e);
        }
         */
    }
}
