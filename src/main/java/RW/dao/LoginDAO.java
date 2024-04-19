/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RW.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author rauls
 */
public class LoginDAO {
    
    private String usuario;
    
    public LoginDAO(String usuario){
        this.usuario = usuario;
    }
    
    public void cadastrarUsuario(String nome, String email, String senha, 
                                 String sexo, String dt_nascimento, String cpf )
            throws SQLException{
    Connection conexao = new Conexao(usuario).getConnection();
    String sql = 
    "INSERT INTO users(id, nome, email, senha, dt_nascimento, sexo, cpf) "
            + "values (null,'"+nome+"','"+email+"','"+senha+"','"+sexo+"','"+dt_nascimento+"','"+cpf+"');";
    System.out.println(sql);
    PreparedStatement statment = conexao.prepareStatement(sql);
    statment.execute();
    conexao.close();
    }
    
}

