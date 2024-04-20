/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RW.dao;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author rauls
 */
public class LoginDAO {
    
    /*public void cadastrarUsuario(String nome, String email, String senha, 
                                 String sexo, String dt_nascimento, String cpf )
            throws SQLException, IOException, NoSuchAlgorithmException, InvalidKeyException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException{
    Connection conexao = new Conexao().getConnection();
    String sql = 
    "INSERT INTO users(id, nome, email, senha, dt_nascimento, sexo, cpf) "
            + "values (null,'"+nome+"','"+email+"','"+senha+"','"+sexo+"','"+dt_nascimento+"','"+cpf+"');";
    System.out.println(sql);
    PreparedStatement statment = conexao.prepareStatement(sql);
    statment.execute();
    conexao.close();
    }*/
    public void cadastrarUsuario(String nome, String email, String senha, 
                              String sexo, String dt_nascimento, String cpf ) {
    try {
        Connection conexao = new Conexao().getConnection();
        String sql = "INSERT INTO users(id, nome, email, senha, dt_nascimento, sexo, cpf) "
                     + "values (null,'"+nome+"','"+email+"','"+senha+"','"+sexo+"','"+dt_nascimento+"','"+cpf+"');";
        System.out.println(sql);
        PreparedStatement statement = conexao.prepareStatement(sql);
        statement.execute();
        conexao.close();
    } catch (SQLException e) {
        // Aqui você pode tratar as exceções específicas ou apenas registrar o erro
        e.printStackTrace();
        // Você também pode exibir uma mensagem de erro para o usuário informando que ocorreu um problema
    }
}

    
}

