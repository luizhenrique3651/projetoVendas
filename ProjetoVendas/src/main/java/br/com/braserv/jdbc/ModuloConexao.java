/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.braserv.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author luiz
 */
public class ModuloConexao {
    
    public Connection getConnection(){
    
        try {
           
            return DriverManager.getConnection("jdbc:mysql://localhost/BDVENDAS?useSSL=true", "luiz", "luiz123");
            
            
        } catch (Exception e) {
            
            throw new RuntimeException(e);
            
        }
    
    }
    

}
