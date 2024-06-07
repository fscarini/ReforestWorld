package RW.controller_dao;

import RW.connection.Conexao;
import RW.forms.CadastroTela;
import RW.forms.CadastroEventosTela;
import RW.forms.CadastroMudasTela;
import RW.forms.ConsultaEventosTela;
import RW.forms.FaleConoscoTela;
import RW.forms.GestaoUsuariosTela;
import RW.forms.MeuPerfilTela;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class ConexaoController {

    public void buscaUsuarios(GestaoUsuariosTela tela) {
        try {
            Conexao conexao = new Conexao(); // Crie uma conexão com o banco de dados
            PreparedStatement ps = conexao.conectar().prepareStatement("SELECT * FROM users"); // Consulta SQL para selecionar todos os usuários
            ResultSet rs = ps.executeQuery(); // Execute a consulta

            DefaultTableModel model = (DefaultTableModel) tela.getTabela().getModel(); // Obtenha o modelo da tabela

            // Limpe os dados existentes na tabela
            model.setRowCount(0);

            // Preencha a tabela com os dados do ResultSet
            while (rs.next()) {
                Object[] rowData = {
                    rs.getString("Cod_usuario"),
                    rs.getString("Nome"),
                    rs.getString("Email"),
                    rs.getString("CPF"),
                    "Ação" // Ação será preenchida pelos renderizadores e editores de célula
                };
                model.addRow(rowData); // Adicione a linha à tabela
            }

            // Feche os recursos
            rs.close();
            ps.close();
            conexao.conectar().close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao carregar dados da tabela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }
    
       public void buscaEventos(ConsultaEventosTela tela) {
        try {
            Conexao conexao = new Conexao(); // Crie uma conexão com o banco de dados
            PreparedStatement ps = conexao.conectar().prepareStatement("SELECT * FROM eventos"); // Consulta SQL para selecionar todos os usuários
            ResultSet rs = ps.executeQuery(); // Execute a consulta

            DefaultTableModel model = (DefaultTableModel) tela.getTabela().getModel(); // Obtenha o modelo da tabela

            // Limpe os dados existentes na tabela
            model.setRowCount(0);

            // Preencha a tabela com os dados do ResultSet
            while (rs.next()) {
                Object[] rowData = {
                    rs.getString("nome"),
                    rs.getString("inicio"),
                    rs.getString("termino"),
                    rs.getString("cidade"),
                    rs.getInt("meta_doacao"),
                    "Ação" // Ação será preenchida pelos renderizadores e editores de célula
                };
                model.addRow(rowData); // Adicione a linha à tabela
            }

            // Feche os recursos
            rs.close();
            ps.close();
            conexao.conectar().close();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(tela, "Erro ao carregar dados da tabela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }


    public String cadastroUsuario(CadastroTela view) throws SQLException {

        ConexaoDAO cadastro = new ConexaoDAO();
        String code = generateVerifyCode();
        cadastro.cadastrarUsuario(
                view.getNomeUsuarioTextField().getText(),
                view.getEmailTextField().getText(),
                String.valueOf(view.getSenhaPasswordField().getPassword()),
                view.getIdadeTextField().getText(),
                (String) view.getSexoComboBox().getSelectedItem(),
                view.getCpfTextField().getText(),
                code);
        return code;

    }


    public int atualizaCadastroUsuario(MeuPerfilTela view) throws Exception {
        ConexaoDAO cadastro = new ConexaoDAO();

        int retorno = cadastro.atualizaCadastroUsuario(
                view.getNomeTextField().getText(),
                view.getEmailTextField().getText(),
                view.getDataNascimentoTextField().getText(),
                (String) view.getSexoComboBox().getSelectedItem(),
                view.getCpfTextField().getText(),
                (String) view.getTipoCartaoComboBox().getSelectedItem(),
                Integer.parseInt(view.getNumeroCartaoTextField().getText()),
                view.getValidadeCartaoTextField().getText(),
                Integer.parseInt(view.getCvvCartaoTextField().getText()),
                view.getTitularCartaoTextField().getText(),
                view.getCpfTitularCartaoTextField().getText(),
                view.getFis(),
                view.getTamanho(),
                view.getCodigoLabel()
        );
        return retorno;
    }


    public Map<String, Object> buscaPerfilUsuario(MeuPerfilTela view) throws Exception {
        ConexaoDAO cadastro = new ConexaoDAO();
        Map<String, Object> resultadoConsulta = cadastro.buscaPerfilUsuario(view.getCodigoLabel());
        if (resultadoConsulta != null) {
            var nome = (String) resultadoConsulta.get("nome");
            var email = (String) resultadoConsulta.get("email");
            var dtNascimento = (String) resultadoConsulta.get("dt_nascimento");
            var sexo = (String) resultadoConsulta.get("sexo");
            var cpf = (String) resultadoConsulta.get("cpf");
            var tipoPagamento = (String) resultadoConsulta.get("cod_tipo_pagamento");
            var numeroCartao = (String) resultadoConsulta.get("numero_cartao");
            var dataVencimentoCartao = (String) resultadoConsulta.get("data_vencimento");
            var cvv = (String) resultadoConsulta.get("cvv_cartao");
            var nomeTitular = (String) resultadoConsulta.get("nome_titular");
            var cfpCartao = (String) resultadoConsulta.get("cpf_cartao");
            var statusUsuario = (String) resultadoConsulta.get("status_usuario");
            var imagemUsuarioBytes = (BufferedImage) resultadoConsulta.get("foto_usuario");
            view.setNomeTextField(nome);
            view.setEmailTextField(email);
            view.setDataNascimentoTextField(dtNascimento);
            view.setSexoComboBox(sexo);
            view.setCpfTextField(cpf);
            view.setTipoCartaoComboBox(tipoPagamento);
            view.setValidadeCartaoTextField(dataVencimentoCartao);
            view.setNumeroCartaoTextField(numeroCartao);
            view.setCvvCartaoTextField(cvv);
            view.setTitularCartaoTextField(nomeTitular);
            view.setCpfTitularCartaoTextField(cfpCartao);
            view.setStatusLabel(statusUsuario);
            if (imagemUsuarioBytes != null) {
                ImageIcon imagemIcon = new ImageIcon(imagemUsuarioBytes);
                Icon foto = new ImageIcon(imagemIcon.getImage().getScaledInstance(
                        view.getImagemUsuarioLabel().getWidth(),
                        view.getImagemUsuarioLabel().getHeight(),
                        Image.SCALE_SMOOTH));
                // Define o ImageIcon como o ícone da JLabel
                view.setImagemUsuarioLabel(foto);
            } else {
                // Se não houver imagem, limpa o ícone da JLabel
                view.setImagemUsuarioLabel(new javax.swing.ImageIcon(getClass().getResource("/Imagens/camera (1).png")));
            }
        } else {
            // Se a consulta não retornou nenhum resultado, limpa os campos
            view.setNomeTextField("");
            view.setEmailTextField("");
            view.setDataNascimentoTextField("");
            view.setSexoComboBox("");
            view.setCpfTextField("");
            view.setTipoCartaoComboBox("");
            view.setValidadeCartaoTextField("");
            view.setNumeroCartaoTextField("");
            view.setCvvCartaoTextField("");
            view.setTitularCartaoTextField("");
            view.setCpfTitularCartaoTextField("");
            view.setStatusLabel("");
            view.setImagemUsuarioLabel(new javax.swing.ImageIcon(getClass().getResource("/Imagens/camera (1).png")));
            view.setCodigoLabel("");
        }

        // Retorna o mapa contendo os valores
        return resultadoConsulta;
    }

    public int cadastroEvento(CadastroEventosTela view) throws SQLException {
        ConexaoDAO cadastro = new ConexaoDAO();
        int retorno = cadastro.cadastrarEvento(
                view.getNomeEventoTextField().getText(),
                view.getDataInicio(),
                view.getDataTermino(),
                view.getDescricaoTextArea().getText(),
                view.getDoacoesSlider().getValue(),
                view.getEstadoComboBox(),
                view.getCidadeTextField(),
                view.getCodUsuario(),
                view.getFis(),
                view.getTamanho()
        );

        return retorno;

    }

//    public void consultaEventos(ConsultaEventosTela view) throws SQLException {
//        try {
//            ConexaoDAO conexao = new ConexaoDAO();
//            var consultar = conexao.consultarEvento();
//
//            DefaultTableModel model = (DefaultTableModel) view.getTabela().getModel();
//
//            // Limpe os dados existentes na tabela
//            model.setRowCount(0);
//
//            // Preencha a tabela com os dados do ResultSet
//            while (rs.next()) {
//                Object[] rowData = {
//                    rs.getString("Cod_usuario"),
//                    rs.getString("Nome"),
//                    rs.getString("Email"),
//                    rs.getString("CPF"),
//                    "Ação" // Ação será preenchida pelos renderizadores e editores de célula
//                };
//                model.addRow(rowData); // Adicione a linha à tabela
//            }
//
//            // Feche os recursos
//            rs.close();
//            ps.close();
//            conexao.conectar().close();
//        } catch (SQLException e) {
//            JOptionPane.showMessageDialog(tela, "Erro ao carregar dados da tabela: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
//        }
//        )
//       return retorno;
//    }

    public int cadastroMensagem(FaleConoscoTela view) throws Exception {
        ConexaoDAO enviar = new ConexaoDAO();

        int retorno = enviar.cadastrarMensagem(
                view.getAssuntoComboBox(),
                view.getMensagemTextArea(),
                Integer.parseInt(view.getCodUsuario()));
        return retorno;
    }

    public int cadastroMuda(CadastroMudasTela view) throws Exception {
        ConexaoDAO cadastro = new ConexaoDAO();

        int retorno = cadastro.cadastrarMuda(
                view.getNomeCientificoTextField().getText(),
                view.getNomeComercialTextField().getText(),
                Double.parseDouble(view.getValorTextField().getText()),
                view.getEstadoComboBox(),
                view.getStatusComboBox(),
                view.getCaracteristicasTextArea().getText(),
                view.getUsosTextArea().getText(),
                view.getFis(),
                view.getTamanho(),
                1
        );
        return retorno;
    }

    public int atualizaMuda(CadastroMudasTela view) throws Exception {
        ConexaoDAO cadastro = new ConexaoDAO();

        int retorno = cadastro.atualizaMuda(
                view.getNomeCientificoTextField().getText(),
                view.getNomeComercialTextField().getText(),
                Double.parseDouble(view.getValorTextField().getText()),
                view.getEstadoComboBox(),
                view.getStatusComboBox(),
                view.getCaracteristicasTextArea().getText(),
                view.getUsosTextArea().getText(),
                view.getFis(),
                view.getTamanho(),
                1,
                view.getCodigoLabel()
        );
        return retorno;
    }

    public int tornarAdm(MeuPerfilTela view) throws Exception {
        ConexaoDAO tornarAdm = new ConexaoDAO();
        int retorno = tornarAdm.tornarAdm(
                view.getCodigoLabel()
        );
        return retorno;
    }

    public Map<String, Object> buscaCadastroMuda(CadastroMudasTela view) throws Exception {
        ConexaoDAO cadastro = new ConexaoDAO();
        Map<String, Object> resultadoConsulta = cadastro.buscaCadastroMuda(view.getBuscarTextField().getText());
        if (resultadoConsulta != null) {
            var nomeCientifico = (String) resultadoConsulta.get("nome_cientifico");
            var nomeComercial = (String) resultadoConsulta.get("nome_comercial");
            var valorMuda = (String) resultadoConsulta.get("valor_muda");
            var estado = (String) resultadoConsulta.get("cod_estado");
            var status = (String) resultadoConsulta.get("status_muda");
            var caracteristicas = (String) resultadoConsulta.get("caracteristicas_gerais");
            var usos = (String) resultadoConsulta.get("usos_comuns");
            var codigo = (String) resultadoConsulta.get("cod_muda");
            var imagemMudaBytes = (BufferedImage) resultadoConsulta.get("imagem_muda");
            view.setNomeCientificoTextField(nomeCientifico);
            view.setNomeComercialTextField(nomeComercial);
            view.setCaracteristicasTextArea(caracteristicas);
            view.setUsosTextArea(usos);
            view.setEstadoComboBox(Integer.parseInt(estado));
            view.setStatusComboBox(Integer.parseInt(status));
            view.setValorTextField(valorMuda);
            view.setCodigoLabel(codigo);

            if (imagemMudaBytes != null) {
                ImageIcon imagemIcon = new ImageIcon(imagemMudaBytes);
                Icon foto = new ImageIcon(imagemIcon.getImage().getScaledInstance(
                        view.getImagemMudaLabel().getWidth(),
                        view.getImagemMudaLabel().getHeight(),
                        Image.SCALE_SMOOTH));
                // Define o ImageIcon como o ícone da JLabel
                view.getImagemMudaLabel().setIcon(foto);
            } else {
                // Se não houver imagem, limpa o ícone da JLabel
                view.getImagemMudaLabel().setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/camera (1).png")));
            }
        } else {
            // Se a consulta não retornou nenhum resultado, limpa os campos
            view.setNomeCientificoTextField("");
            view.setNomeComercialTextField("");
            view.setValorTextField("");
            view.setEstadoComboBox(0);
            view.getImagemMudaLabel().setIcon(null);
            view.setCodigoLabel("");
        }

        // Retorna o mapa contendo os valores
        return resultadoConsulta;
    }

    private String generateVerifyCode() throws SQLException {
        DecimalFormat df = new DecimalFormat("000000");
        Random ran = new Random();
        String code = df.format(ran.nextInt(1000000));  //  Random from 0 to 999999
        while (checkDuplicateCode(code)) {
            code = df.format(ran.nextInt(1000000));
        }
        return code;
    }

    private boolean checkDuplicateCode(String code) throws SQLException {
        boolean duplicate = false;
        var conexao = new Conexao().conectar();
        try (PreparedStatement p = conexao.prepareStatement("SELECT cod_usuario FROM users WHERE cod_verificacao=? limit 1",
                ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY)) {
            p.setString(1, code);
            try (ResultSet r = p.executeQuery()) {
                if (r.first()) {
                    duplicate = true;
                }
            }
        }
        return duplicate;
    }

}
