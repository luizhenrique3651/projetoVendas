/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.braserv.jdbc;

import javax.swing.JOptionPane;

/**
 *
 * @author luiz
 */
public class testaConexao {
    public static void main(String[] args) {
        try {
            new ModuloConexao().getConnection();
            JOptionPane.showMessageDialog(null, "YOOOOOHHHH");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "nao vai da nao\n \n "+ e);
        }
    }
}
