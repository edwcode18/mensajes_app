/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edwar.mensajes_app;

import java.util.Scanner;

/**
 *
 * @author edwcode
 */
public class MessagesService {
    
    public static void createMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your message");
        String messageByUser = sc.nextLine();
        
        System.out.println("Write your name");
        String nameByUser = sc.nextLine();
        
        Messages message = new Messages();
        message.setMessage(messageByUser);
        message.setAuthorMessage(nameByUser);
        MessagesDAO.createMessageDB(message);
    }
    
    public static void listMessages() {
        MessagesDAO.listMessagesDB();
    }
    
    public static void deleteMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write the ID of the message that you need to delete");
        int idMessage = sc.nextInt();
        MessagesDAO.deleteMessageDB(idMessage);
    }
    
    public static void updateMessage() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Write your new message");
        String newMessage = sc.nextLine();
        
        System.out.println("Write the ID of the message that you need to update");
        int idMessage = sc.nextInt();
        Messages message = new Messages();
        message.setIdMessage(idMessage);
        message.setMessage(newMessage);
        MessagesDAO.updateMessageDB(message);
    }
}
