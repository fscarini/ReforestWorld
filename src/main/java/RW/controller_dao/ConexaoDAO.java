package RW.controller_dao;

import RW.connection.Conexao;
import RW.forms.Evento;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;

public class ConexaoDAO {

    //private Conexao conexao;
    public void cadastrarUsuario(
            String nome, String email, String senha, String dt_nascimento, String sexo, String cpf, String code) throws SQLException {
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement(
                "INSERT INTO users(nome, email, senha, dt_nascimento, sexo, cpf, cod_verificacao) values (?,?,?,?,?,?,?);");
        p.setString(1, nome);
        p.setString(2, email);
        p.setString(3, senha);
        p.setString(4, dt_nascimento);
        p.setString(5, sexo);
        p.setString(6, cpf);
        p.setString(7, code);
        p.execute();
        p.close();
        conexao.close();
    }

    public int cadastrarMensagem(String assunto, String mensagem, int cod_usuario) throws Exception {
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement(
                "INSERT INTO mensagens_suporte (assunto_mensagem, mensagens_suporte, cod_usuario, data_alteracao) VALUES (?, ?, ?, CURRENT_TIMESTAMP)");
        p.setString(1, assunto);
        p.setString(2, mensagem);
        p.setInt(3, cod_usuario);
        int confirma = p.executeUpdate();
        p.close();
        conexao.close();
        return confirma;
    }

    public Map<String, Object> buscaPerfilUsuario(int codUsuario) throws Exception {
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement("SELECT * FROM users WHERE cod_usuario = ? limit 1;");
        p.setInt(1, codUsuario);
        var rs = p.executeQuery();
        Map<String, Object> resultadoConsulta = new HashMap<>();
        if (rs.next()) {
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String dtNascimento = rs.getString("dt_nascimento");
            String sexo = rs.getString("sexo");
            String cpf = rs.getString("cpf");
            String tipoPagamento = rs.getString("tipo_pagamento");
            String numeroCartao = rs.getString("numero_cartao");
            String dataVencimentoCartao = rs.getString("data_vencimento");
            String cvv = rs.getString("cvv_cartao");
            String nomeTitular = rs.getString("nome_titular");
            String cfpCartao = rs.getString("cpf_cartao");
            String statusUsuario = rs.getString("status_usuario");
            Blob blob = (Blob) rs.getBlob("foto_usuario");
            BufferedImage imagem = null;
            if (blob != null) {
            byte[] img = blob.getBytes(1, (int) blob.length());
            imagem = ImageIO.read(new ByteArrayInputStream(img));
            }
            resultadoConsulta.put("nome", nome);
            resultadoConsulta.put("email", email);
            resultadoConsulta.put("dt_nascimento", dtNascimento);
            resultadoConsulta.put("sexo", sexo);
            resultadoConsulta.put("cpf", cpf);
            resultadoConsulta.put("cod_tipo_pagamento", tipoPagamento);
            resultadoConsulta.put("numero_cartao", numeroCartao);
            resultadoConsulta.put("data_vencimento", dataVencimentoCartao);
            resultadoConsulta.put("cvv_cartao", cvv);
            resultadoConsulta.put("nome_titular", nomeTitular);
            resultadoConsulta.put("cpf_cartao", cfpCartao);
            resultadoConsulta.put("status_usuario", statusUsuario);
            resultadoConsulta.put("foto_usuario", imagem);
            rs.close();
            p.close();
            conexao.close();
        }
        return resultadoConsulta;
    }

    public int atualizaCadastroUsuario(String nome, String email, String dtNascimento,
            String sexo, String cpf, String tipoPagamento, int numeroCartao, String dataVencimento,
            int cvv, String nomeTitular, String cpfCartao, FileInputStream fis, int tamanho, int codUsuario) throws Exception {

        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement(
                "UPDATE users SET nome = ?,"
                        + "email= ?,"
                        + "dt_nascimento= ?,"
                        + "sexo= ?,"
                        + "cpf= ?,"
                        + "tipo_pagamento= ?,"
                        + "numero_cartao= ?,"
                        + "data_vencimento= ?,"
                        + "cvv_cartao= ?,"
                        + "nome_titular= ?,"
                        + "cpf_cartao= ?,"
                        + "foto_usuario= ?"
                        + "WHERE cod_usuario = ?");

        p.setString(1, nome);
        p.setString(2, email);
        p.setString(3, dtNascimento);
        p.setString(4, sexo);
        p.setString(5, cpf);
        p.setString(6, tipoPagamento);
        p.setInt(7, numeroCartao);
        p.setString(8, dataVencimento);
        p.setInt(9, cvv);
        p.setString(10, nomeTitular);
        p.setString(11, cpfCartao);
        p.setBlob(12, fis, tamanho);
        p.setInt(13, codUsuario);

        int confirma = p.executeUpdate();
        p.close();
        conexao.close();
        return confirma;
    }

    public int cadastrarEvento(String nome, String inicio, String termino, String descricao,
            int meta_doacao, int cod_estado, String cidade, String codUsuario, FileInputStream fis, int tamanho) throws SQLException {
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement(
                "INSERT INTO eventos(nome, inicio, termino, descricao, meta_doacao, cod_estado, cidade, id_usuario, foto) "
                + "values (?,?,?,?,?,?,?,?,?);");
        p.setString(1, nome);
        p.setString(2, inicio);
        p.setString(3, termino);
        p.setString(4, descricao);
        p.setInt(5, meta_doacao);
        p.setInt(6, cod_estado);
        p.setString(7, cidade);
        p.setString(8, codUsuario);
        p.setBlob(9, fis, tamanho);
        int confirma = p.executeUpdate();
        p.close();
        conexao.close();
        return confirma;
    }
    
//    public List<Evento> consultarEvento(String nome, String inicio, String termino,
//            int metaDoacao, int estado, String cidade) throws SQLException{
//        List <Evento> eventos = new ArrayList<>();
//        var conexao = new Conexao().conectar();
//        var p = conexao.prepareStatement(
//                "SELECT nome, inicio, termino, meta_doacao, cod_estado, cidade FROM eventos WHERE termino >= CURDATE()");
//        var rs = p.executeQuery();
//        while (rs.next()) {
//                nome = rs.getString("nome");
//                inicio = rs.getString("inicio");
//                termino = rs.getString("termino");
//                metaDoacao = rs.getInt("meta_doacao");
//                estado = rs.getInt("cod_estado");
//                cidade = rs.getString("cidade");  
//                
//                eventos.add(new Evento(nome, inicio, termino, metaDoacao, cod_estado, cidade, fis, tamanho));
//            }
//        return eventos;
//    }

    public int cadastrarMuda(String nome_cientifico, String nome_comercial, double valor_muda,
            int cod_estado, int status_muda, String caracteristicas_gerais, String usos_comuns,
            FileInputStream fis, int tamanho, int cod_usuario) throws Exception {
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement(
                "INSERT INTO muda (nome_cientifico, nome_comercial, valor_muda, cod_estado, status_muda,"
                + "caracteristicas_gerais, usos_comuns, imagem_muda, cod_usuario) "
                + "values (?,?,?,?,?,?,?,?,?);");

        p.setString(1, nome_cientifico);
        p.setString(2, nome_comercial);
        p.setDouble(3, valor_muda);
        p.setInt(4, cod_estado);
        p.setInt(5, status_muda);
        p.setString(6, caracteristicas_gerais);
        p.setString(7, usos_comuns);
        p.setBlob(8, fis, tamanho);
        p.setInt(9, cod_usuario);
        int confirma = p.executeUpdate();
        p.close();
        conexao.close();
        return confirma;
    }

    public int atualizaMuda(String nome_cientifico, String nome_comercial, double valor_muda,
            int cod_estado, int status_muda, String caracteristicas_gerais, String usos_comuns,
            FileInputStream fis, int tamanho, int cod_usuario, int cod_muda) throws Exception {

        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement(
                "UPDATE muda "
                + "SET nome_cientifico = ?, "
                + "nome_comercial = ?, "
                + "valor_muda = ?, "
                + "cod_estado = ?, "
                + "status_muda = ?, "
                + "caracteristicas_gerais = ?, "
                + "usos_comuns = ?, "
                + "imagem_muda = ?, "
                + "cod_usuario = ?, "
                + "dt_operacao = CURRENT_DATE "
                + "WHERE cod_muda = ?");

        p.setString(1, nome_cientifico);
        p.setString(2, nome_comercial);
        p.setDouble(3, valor_muda);
        p.setInt(4, cod_estado);
        p.setInt(5, status_muda);
        p.setString(6, caracteristicas_gerais);
        p.setString(7, usos_comuns);
        p.setBlob(8, fis, tamanho);
        p.setInt(9, cod_usuario);
        p.setInt(10, cod_muda);

        int confirma = p.executeUpdate();
        p.close();
        conexao.close();
        return confirma;
    }

    public int tornarAdm(Integer cod_usuario) throws Exception {
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement(
                "UPDATE users SET cod_perfil = 1 WHERE cod_usuario = ?");
        p.setInt(1, cod_usuario);
        int confirma = p.executeUpdate();
        p.close();
        conexao.close();
        return confirma;
    }

    public Map<String, Object> buscaCadastroMuda(String nome_cientifico) throws Exception {
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement("SELECT * FROM muda WHERE lower(nome_cientifico) = ? limit 1;");
        p.setString(1, nome_cientifico);
        var rs = p.executeQuery();
        Map<String, Object> resultadoConsulta = new HashMap<>();
        if (rs.next()) {
            String nomeCientifico = rs.getString("nome_cientifico");
            String nomeComercial = rs.getString("nome_comercial");
            String valorMuda = rs.getString("valor_muda");
            String status = rs.getString("status_muda");
            String estado = rs.getString("cod_estado");
            String caracteristicasGerais = rs.getString("caracteristicas_gerais");
            String usosComuns = rs.getString("usos_comuns");
            String codigoMuda = rs.getString("cod_muda");
            Blob blob = (Blob) rs.getBlob("imagem_muda");
            byte[] img = blob.getBytes(1, (int) blob.length());
            BufferedImage imagem = null;
            imagem = ImageIO.read(new ByteArrayInputStream(img));
            resultadoConsulta.put("nome_cientifico", nomeCientifico);
            resultadoConsulta.put("nome_comercial", nomeComercial);
            resultadoConsulta.put("valor_muda", valorMuda);
            resultadoConsulta.put("status_muda", status);
            resultadoConsulta.put("cod_estado", estado);
            resultadoConsulta.put("caracteristicas_gerais", caracteristicasGerais);
            resultadoConsulta.put("usos_comuns", usosComuns);
            resultadoConsulta.put("cod_muda", codigoMuda);
            resultadoConsulta.put("imagem_muda", imagem);
            rs.close();
            p.close();
            conexao.close();
        }
        return resultadoConsulta;
    }

    public Map<String, String> existeVerificado(LoginController u) throws Exception {
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement("SELECT * FROM users WHERE email = ? AND  senha = ? AND status_verificacao='Verificado';");
        p.setString(1, u.login);
        p.setString(2, u.senha);
        System.out.println("DAO Login: " + u.login);
        System.out.println("DAO Senha: " + u.senha);
        var rs = p.executeQuery();
        Map<String, String> resultadoConsulta = new HashMap<>();
        if (rs.next()) {
            String nome = rs.getString("nome");
            String email = rs.getString("email");
            String codPerfil = rs.getString("cod_perfil");
            String codUsuario = rs.getString("cod_usuario");
//            System.out.println("DAO Nome: " + nome);
//            System.out.println("DAO Email: " + email);
//            System.out.println("DAO CodPerfil: " + codPerfil);
            resultadoConsulta.put("nome", nome);
            resultadoConsulta.put("email", email);
            resultadoConsulta.put("cod_perfil", codPerfil);
            resultadoConsulta.put("cod_usuario", codUsuario);
            rs.close();
            p.close();
            conexao.close();
        } else {
            resultadoConsulta = null;
            System.out.println("DAO: Nenhum usuário encontrado com as credenciais fornecidas.");
        }
        return resultadoConsulta;
    }

    public boolean existeNaoVerificado(LoginController u) throws Exception {
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement("SELECT * FROM users WHERE email = ? AND  senha = ? AND status_verificacao='Não Verificado' limit 1;");
        p.setString(1, u.login);
        p.setString(2, u.senha);
        var rs = p.executeQuery();
        var usuarioExiste = rs.next();
        p.close();
        conexao.close();
        return usuarioExiste;
    }

    public void verificacaoUsuarioOk(String email) throws SQLException {
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement("UPDATE users SET cod_verificacao='', status_verificacao='Verificado', dt_verificacao=CURRENT_TIMESTAMP where email=?");
        p.setString(1, email);
        p.execute();
        p.close();
        conexao.close();
    }

    public boolean verificacaoUsuarioCodigo(String email, String cod_verificacao) throws SQLException {
        boolean verify = false;
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement("SELECT * FROM users WHERE email=? and cod_verificacao=? limit 1",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        p.setString(1, email);
        p.setString(2, cod_verificacao);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            verify = true;
        }
        r.close();
        p.close();
        conexao.close();
        return verify;
    }

    public boolean checkCPFDuplicado(String cpf) throws SQLException {
        boolean duplicate = false;
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement("SELECT cod_usuario FROM users WHERE CPF=? limit 1",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        p.setString(1, cpf);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            duplicate = true;
        }
        r.close();
        p.close();
        conexao.close();
        return duplicate;
    }

    public boolean checkEmailDuplicado(String email) throws SQLException {
        boolean duplicate = false;
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement("SELECT cod_usuario FROM users WHERE email=? limit 1",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        p.setString(1, email);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            duplicate = true;
        }
        r.close();
        p.close();
        conexao.close();
        return duplicate;
    }

    public boolean checkMudaDuplicada(String nome_cientifico) throws SQLException {
        boolean duplicate = false;
        var conexao = new Conexao().conectar();
        var p = conexao.prepareStatement("SELECT cod_muda FROM muda WHERE nome_cientifico=? limit 1",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        p.setString(1, nome_cientifico);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            duplicate = true;
        }
        r.close();
        p.close();
        conexao.close();
        return duplicate;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        Conexao conexao = new Conexao();
        Connection conn = conexao.conectar();
        PreparedStatement p = conn.prepareStatement("SELECT cod_usuario FROM users WHERE cod_verificacao = ? LIMIT 1");
        p.setString(1, code);
        ResultSet r = p.executeQuery();
        if (r.next()) {
            duplicate = true;
        }
        r.close();
        p.close();
        conn.close();
        return duplicate;
    }
}
