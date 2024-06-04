package RW.controller_dao;

import RW.connection.Conexao;
import RW.forms.CadastroTela;
import RW.forms.CadastroEventosTela;
import RW.forms.CadastroMudasTela;
import RW.forms.FaleConoscoTela;
import RW.forms.GestaoUsuariosTela;
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

    public int cadastroEvento(CadastroEventosTela view) throws SQLException {
        ConexaoDAO cadastro = new ConexaoDAO();
        int retorno = cadastro.cadastrarEvento(
                view.getNomeEventoTextField().getText(),
                view.getInicioTextField().getText(),
                view.getTerminoTextField().getText(),
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
        try (PreparedStatement p = conexao.prepareStatement("SELECT id FROM users WHERE cod_verificacao=? limit 1",
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
