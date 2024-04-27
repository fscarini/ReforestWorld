/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RW.controller;

import RW.forms.CadastroTela;
import RW.dao.Conexao;
import RW.dao.LoginDAO;
import java.sql.Connection;
import java.sql.SQLException;

/**
 *
 * @author rauls
 */
public class LoginController {
    
    public void cadastroUsuario(CadastroTela view) throws SQLException{
        Connection conexao = new Conexao().getConnection();
        LoginDAO cadastro = new LoginDAO();
        cadastro.cadastrarUsuario(
                view.getUsuarioTextField().getText(),
                view.getEmailTextField().getText(),
                view.getSenhaPasswordField().getText());
    }
}
