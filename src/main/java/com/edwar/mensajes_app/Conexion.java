/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.edwar.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author edwcode
 */
public class Conexion {
    public Connection get_connection(){
        Connection connection = null;
        try {
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app", "root", "Boden123*");
            if(connection != null){
                System.out.println("conexion exitosa");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
        
        return connection;
    }
}
