package RW.controller_dao;

import RW.connection.Conexao;
import java.sql.SQLException;

public class CadastroDAO {
    public void cadastrarUsuario(
            String nome, String email, String senha, String dt_nascimento, String sexo, String cpf ) throws SQLException {      
                var conexao = new Conexao().conectar();
                var p = conexao.prepareStatement(
                        "INSERT INTO users(id, nome, email, senha, dt_nascimento, sexo, cpf) values (null,?,?,?,?,?,?);");
                p.setString(1, nome);
                p.setString(2, email);
                p.setString(3, senha);
                p.setString(4, dt_nascimento);
                p.setString(5, sexo);
                p.setString(6, cpf);
                p.execute();
                p.close();
                conexao.close();               
    }
}
 


