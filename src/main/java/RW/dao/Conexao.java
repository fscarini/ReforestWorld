/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RW.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {



    public Connection getConnection() throws SQLException{
    Connection conexao = DriverManager.getConnection(
    "jdbc:mysql://:/","","");
        return conexao;
        
    }

}


