package RW.controller_dao;

import RW.connection.Conexao;

public class LoginDAO {
    public boolean existe(LoginController u) throws Exception {      
                var conexao = new Conexao().conectar();
                var p = conexao.prepareStatement("SELECT * FROM users WHERE email = ? AND  senha = ?;");
                p.setString(1, u.login);
                p.setString(2, u.senha);
                var rs = p.executeQuery();
                var usuarioExiste = rs.next();
                p.close();
                conexao.close();
                
                return usuarioExiste;
    }
}