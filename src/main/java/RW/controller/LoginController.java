/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RW.controller;

import RW.forms.CadastroTela;
import RW.dao.Conexao;
import RW.dao.LoginDAO;
import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.SQLException;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

/**
 *
 * @author rauls
 */
public class LoginController {
    
    /*public void cadastroUsuario(CadastroTela view) throws SQLException, IOException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, InvalidKeyException{
        
        //leitura do properties
        Connection conexao = new Conexao().getConnection();
        LoginDAO cadastro = new LoginDAO();
        cadastro.cadastrarUsuario(
                
                view.getNomeUsuarioTextField().getText(),
                view.getEmailTextField().getText(),
                view.getSenhaPasswordField().getText(),
                view.getIdadeTextField().getText(),
                (String) view.getSexoComboBox().getSelectedItem(),
                view.getCpfTextField().getText());
    }*/
    public void cadastroUsuario(CadastroTela view) {
        // leitura do properties
        Connection conexao = new Conexao().getConnection();
        LoginDAO cadastro = new LoginDAO();
        cadastro.cadastrarUsuario(
                view.getNomeUsuarioTextField().getText(),
                view.getEmailTextField().getText(),
                view.getSenhaPasswordField().getText(),
                view.getIdadeTextField().getText(),
                (String) view.getSexoComboBox().getSelectedItem(),
                view.getCpfTextField().getText()
        );
}

}
