package RW.controller_dao;

import RW.connection.Conexao;
import RW.forms.CadastroTela;
import RW.forms.CadastroEventosTela;
import RW.forms.CadastroMudasTela;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DecimalFormat;
import java.util.Map;
import java.util.Random;
import javax.swing.ImageIcon;

public class ConexaoController {

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

    public void cadastroEvento(CadastroEventosTela view) throws SQLException {
        ConexaoDAO cadastro = new ConexaoDAO();
        cadastro.cadastrarEvento(
                view.getNomeEventoTextField().getText(),
                view.getDataEventoTextField().getText(),
                view.getLocalTextField().getText(),
                view.getDescricaoTextArea().getText(),
                1
        );
    }

    public void cadastroMuda(CadastroMudasTela view) throws Exception {
        ConexaoDAO cadastro = new ConexaoDAO();
        String estado = view.getEstadoTextField().getText();
        String status_muda = view.getStatusTextField().getText();
        cadastro.cadastrarMuda(
                view.getNomeCientificoTextField().getText(),
                view.getNomeComercialTextField().getText(),
                Double.parseDouble(view.getValorTextField().getText()),
                //            if (estado.equals("Acre")){
                //                return 1;
                //            }else if(estado.equals("Alagoas")){
                //                return 2;
                //            }else{
                //                return 3;
                //            };,
                //            if (status_muda.equals("Ativa")){
                //                return 1;
                //            };,
                1, 1,
                view.getCaracteristicasTextArea().getText(),
                view.getUsosTextArea().getText(),
                view.getFis(),
                view.getTamanho(),
                1
        );
    }

    public Map<String, Object> buscaCadastroMuda(CadastroMudasTela view) throws Exception {
        ConexaoDAO cadastro = new ConexaoDAO();
        Map<String, Object> resultadoConsulta = cadastro.buscaCadastroMuda(view.getBuscarTextField().getText());
        if (resultadoConsulta != null) {
            String nomeCientifico = (String) resultadoConsulta.get("nome_cientifico");
            String nomeComercial = (String) resultadoConsulta.get("nome_comercial");
            byte[] imagemMudaBytes = (byte[]) resultadoConsulta.get("imagem_muda");
            view.setNomeCientificoTextField(nomeCientifico);
            view.setNomeComercialTextField(nomeComercial);

            // Verifica se há uma imagem para exibir
            if (imagemMudaBytes != null && imagemMudaBytes.length > 0) {
                // Cria um ImageIcon a partir dos bytes da imagem
                ImageIcon imagemIcon = new ImageIcon(imagemMudaBytes);

                // Define o ImageIcon como o ícone da JLabel
                view.getImagemMudaLabel().setIcon(imagemIcon);
            } else {
                // Se não houver imagem, limpa o ícone da JLabel
                view.getImagemMudaLabel().setIcon(null);
            }
        } else {
            // Se a consulta não retornou nenhum resultado, limpa os campos
            view.setNomeCientificoTextField("");
            view.setNomeComercialTextField("");
            view.getImagemMudaLabel().setIcon(null);
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
        PreparedStatement p = conexao.prepareStatement("select id from `users` where cod_verificacao=? limit 1", ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
        p.setString(1, code);
        ResultSet r = p.executeQuery();
        if (r.first()) {
            duplicate = true;
        }
        r.close();
        p.close();
        return duplicate;
    }
}
