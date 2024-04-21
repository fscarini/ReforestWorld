package RW.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class CadastroDAO {
    public void cadastrarUsuario(
            String nome, String email, String senha, String dt_nascimento, String sexo, String cpf ) throws SQLException {
                Connection conexao = new Conexao().getConnection();
                PreparedStatement p = conexao.prepareStatement(
                        "INSERT INTO users(id, nome, email, senha, dt_nascimento, sexo, cpf) values (null,?,?,?,?,?,?);");
                p.setString(1, nome);
                p.setString(2, email);
                p.setString(3, senha);
                p.setString(4, dt_nascimento);
                p.setString(5, sexo);
                p.setString(6, cpf);
                p.execute();
    }
}
 


