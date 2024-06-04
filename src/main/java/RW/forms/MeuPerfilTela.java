package RW.forms;

import RW.Tabbed.TabbedForm;
import RW.controller_dao.ConexaoController;
import com.formdev.flatlaf.FlatClientProperties;
import java.awt.Image;
import java.io.FileInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class MeuPerfilTela extends TabbedForm {

    private String codUsuario;
    private String codPerfil;
    private FileInputStream fis;
    private int tamanho;
    private boolean fotoCarregada = false;

    public MeuPerfilTela(String codPerfil, String codUsuario) {
        this.codPerfil = codPerfil;
        this.codUsuario = codUsuario;
        initComponents();
        estilizarSenha();
        acessarPerfil();
        carregarDados();
        //buscarPerfilUsuario();
    }

    private void carregarDados() {
        codigoLabel.setText(codUsuario);
    }

    private void estilizarSenha() {
        senhaAntigaPasswordField.putClientProperty(FlatClientProperties.STYLE, ""
                + "margin:5,10,5,10;"
                + "focusWidth:1;"
                + "innerFocusWidth:0;"
                + "showRevealButton:true");
        senhaAntigaPasswordField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite sua senha atual");
        senhaNovaPasswordField.putClientProperty(FlatClientProperties.STYLE, ""
                + "margin:5,10,5,10;"
                + "focusWidth:1;"
                + "innerFocusWidth:0;"
                + "showRevealButton:true");
        senhaNovaPasswordField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite sua nova senha");
        confirmaSenhaPasswordField.putClientProperty(FlatClientProperties.STYLE, ""
                + "margin:5,10,5,10;"
                + "focusWidth:1;"
                + "innerFocusWidth:0;"
                + "showRevealButton:true");
        confirmaSenhaPasswordField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite novamente a nova senha");
        statusForcaSenha.initPasswordField(senhaNovaPasswordField);
    }

    private void acessarPerfil() {
        if ("1".equals(codPerfil)) {
            atualizarCadastroButton.setVisible(true);
            inativarCadastroButton.setVisible(true);
            reativarCadastroButton.setVisible(true);
            tornarAdminButton.setVisible(true);
            cpfTextField.setEditable(true);
            nomeTextField.setEditable(true);
            dataNascimentoTextField.setEditable(true);
        } else {
            atualizarCadastroButton.setVisible(true);
            inativarCadastroButton.setVisible(false);
            reativarCadastroButton.setVisible(false);
            tornarAdminButton.setVisible(false);
            cpfTextField.setEditable(false);
            nomeTextField.setEditable(false);
            dataNascimentoTextField.setEditable(false);
        }
    }

    private void carregarFoto() {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Selecionar arquivo");
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens (*.PNG,*.JPG,*.JPEG)", "png", "jpg", "jpeg"));
        int resultado = jfc.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(jfc.getSelectedFile());
                tamanho = (int) jfc.getSelectedFile().length();
                Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(imagemUsuarioLabel.getWidth(),
                        imagemUsuarioLabel.getHeight(), Image.SCALE_SMOOTH);
                imagemUsuarioLabel.setIcon(new ImageIcon(foto));
                imagemUsuarioLabel.updateUI();
                fotoCarregada = true;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }
    private void buscarPerfilUsuario(){
        ConexaoController cadastro = new ConexaoController();
        try {
            cadastro.buscaPerfilUsuario(this);
      
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro. Por favor, tente novamente em alguns instantes.\n Caso o erro persista acione o suporte.");
            Logger.getLogger(CadastroMudasTela.class.getName()).log(Level.SEVERE, null, ex);
        }
      }

    private void tornarAdm() {
        try {
            ConexaoController adm = new ConexaoController();
            int retorno = adm.tornarAdm(this);
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Permissões atualizadas com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar as permissões do usuário.");
            };
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro. Por favor, tente novamente em alguns instantes.\n Caso o erro persista acione o suporte.");
            ex.printStackTrace();
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipalScrollPane = new javax.swing.JScrollPane();
        painelPrincipalPanel = new javax.swing.JPanel();
        imagemPanel = new javax.swing.JPanel();
        imagemUsuarioLabel = new javax.swing.JLabel();
        imagemLabel = new javax.swing.JLabel();
        carregarImagemButton = new javax.swing.JButton();
        dadosPanel = new javax.swing.JPanel();
        dataNascimentoLabel = new javax.swing.JLabel();
        cpfLabel = new javax.swing.JLabel();
        nomeTextField = new javax.swing.JTextField();
        nomeLabel = new javax.swing.JLabel();
        sexoLabel = new javax.swing.JLabel();
        dataNascimentoTextField = new javax.swing.JTextField();
        statusTxtLabel = new javax.swing.JLabel();
        codigoTxtLabel = new javax.swing.JLabel();
        codigoLabel = new javax.swing.JLabel();
        cpfTextField = new javax.swing.JTextField();
        emailTextField = new javax.swing.JTextField();
        emailLabel = new javax.swing.JLabel();
        statusLabel = new javax.swing.JLabel();
        sexoComboBox = new javax.swing.JComboBox<>();
        SenhaPanel = new javax.swing.JPanel();
        confirmaSenhaLabel = new javax.swing.JLabel();
        senhaNovaLabel = new javax.swing.JLabel();
        senhaAntigaLabel = new javax.swing.JLabel();
        forcaSenhaLabel = new javax.swing.JLabel();
        statusForcaSenha = new RW.components.StatusForcaSenha();
        senhaAntigaPasswordField = new javax.swing.JPasswordField();
        senhaNovaPasswordField = new javax.swing.JPasswordField();
        confirmaSenhaPasswordField = new javax.swing.JPasswordField();
        FormasPagamentoPanel = new javax.swing.JPanel();
        validadeCartaoLabel = new javax.swing.JLabel();
        titularCartaoLabel = new javax.swing.JLabel();
        numeroCartaoTextField = new javax.swing.JTextField();
        numeroCartaoLabel = new javax.swing.JLabel();
        validadeCartaoTextField = new javax.swing.JTextField();
        titularCartaoTextField = new javax.swing.JTextField();
        cvvCartaoTextField = new javax.swing.JTextField();
        cvvCartaoLabel = new javax.swing.JLabel();
        cpfTitularCartaoTextField = new javax.swing.JTextField();
        cpfTitularCartaoLabel = new javax.swing.JLabel();
        tipoCartaoLabel = new javax.swing.JLabel();
        tipoCartaoComboBox = new javax.swing.JComboBox<>();
        jSeparator2 = new javax.swing.JSeparator();
        jSeparator3 = new javax.swing.JSeparator();
        botoesPanel = new javax.swing.JPanel();
        atualizarCadastroButton = new javax.swing.JButton();
        tornarAdminButton = new javax.swing.JButton();
        inativarCadastroButton = new javax.swing.JButton();
        reativarCadastroButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        painelPrincipalScrollPane.setMaximumSize(new java.awt.Dimension(1024, 768));
        painelPrincipalScrollPane.setMinimumSize(new java.awt.Dimension(1024, 768));

        painelPrincipalPanel.setMaximumSize(new java.awt.Dimension(1024, 768));
        painelPrincipalPanel.setMinimumSize(new java.awt.Dimension(1024, 768));
        painelPrincipalPanel.setPreferredSize(new java.awt.Dimension(1024, 768));

        imagemUsuarioLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        imagemUsuarioLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/camera (1).png"))); // NOI18N
        imagemUsuarioLabel.setAlignmentY(0.0F);

        imagemLabel.setText("Imagem do Perfil");

        carregarImagemButton.setText("Anexar Imagem");
        carregarImagemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                carregarImagemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout imagemPanelLayout = new javax.swing.GroupLayout(imagemPanel);
        imagemPanel.setLayout(imagemPanelLayout);
        imagemPanelLayout.setHorizontalGroup(
            imagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagemPanelLayout.createSequentialGroup()
                .addGap(130, 130, 130)
                .addComponent(imagemLabel)
                .addContainerGap(130, Short.MAX_VALUE))
            .addComponent(imagemUsuarioLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, imagemPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(carregarImagemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(100, 100, 100))
        );
        imagemPanelLayout.setVerticalGroup(
            imagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(imagemPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(imagemLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagemUsuarioLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(carregarImagemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        dataNascimentoLabel.setText("Data de Nascimento");

        cpfLabel.setText("CPF");

        nomeLabel.setText("Nome");

        sexoLabel.setText("Sexo");

        statusTxtLabel.setText("Status");

        codigoTxtLabel.setText("Código");

        emailLabel.setText("E-mail");

        sexoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "F", "M" }));

        confirmaSenhaLabel.setText("Confirmação da senha");

        senhaNovaLabel.setText("Senha nova");

        senhaAntigaLabel.setText("Senha antiga");

        forcaSenhaLabel.setText("Força da senha");

        javax.swing.GroupLayout SenhaPanelLayout = new javax.swing.GroupLayout(SenhaPanel);
        SenhaPanel.setLayout(SenhaPanelLayout);
        SenhaPanelLayout.setHorizontalGroup(
            SenhaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SenhaPanelLayout.createSequentialGroup()
                .addGroup(SenhaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(SenhaPanelLayout.createSequentialGroup()
                        .addGap(63, 63, 63)
                        .addGroup(SenhaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(SenhaPanelLayout.createSequentialGroup()
                                .addComponent(senhaNovaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(senhaNovaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(SenhaPanelLayout.createSequentialGroup()
                                .addComponent(senhaAntigaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(senhaAntigaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(SenhaPanelLayout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(forcaSenhaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(statusForcaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(SenhaPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addComponent(confirmaSenhaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(confirmaSenhaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        SenhaPanelLayout.setVerticalGroup(
            SenhaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(SenhaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(SenhaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaAntigaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaAntigaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SenhaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(senhaNovaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(senhaNovaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(SenhaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(confirmaSenhaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(confirmaSenhaPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(SenhaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(forcaSenhaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusForcaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout dadosPanelLayout = new javax.swing.GroupLayout(dadosPanel);
        dadosPanel.setLayout(dadosPanelLayout);
        dadosPanelLayout.setHorizontalGroup(
            dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosPanelLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosPanelLayout.createSequentialGroup()
                        .addComponent(sexoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(sexoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosPanelLayout.createSequentialGroup()
                        .addComponent(cpfLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosPanelLayout.createSequentialGroup()
                        .addComponent(dataNascimentoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(dataNascimentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosPanelLayout.createSequentialGroup()
                        .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(statusTxtLabel)
                            .addComponent(emailLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(dadosPanelLayout.createSequentialGroup()
                            .addComponent(codigoTxtLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(codigoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(dadosPanelLayout.createSequentialGroup()
                            .addComponent(nomeLabel)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, dadosPanelLayout.createSequentialGroup()
                .addGap(0, 12, Short.MAX_VALUE)
                .addComponent(SenhaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        dadosPanelLayout.setVerticalGroup(
            dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(dadosPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoTxtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(nomeLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dataNascimentoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dataNascimentoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(sexoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(sexoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(emailLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(emailTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(dadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(statusLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(statusTxtLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SenhaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
        );

        validadeCartaoLabel.setText("Data de validade");

        titularCartaoLabel.setText("Nome do Titular");

        numeroCartaoLabel.setText("Número do Cartão");

        cvvCartaoLabel.setText("CVV");

        cpfTitularCartaoLabel.setText("CPF do Titular");

        tipoCartaoLabel.setText("Tipo de Cartão");

        tipoCartaoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Crédito", "Débito" }));

        javax.swing.GroupLayout FormasPagamentoPanelLayout = new javax.swing.GroupLayout(FormasPagamentoPanel);
        FormasPagamentoPanel.setLayout(FormasPagamentoPanelLayout);
        FormasPagamentoPanelLayout.setHorizontalGroup(
            FormasPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormasPagamentoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormasPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FormasPagamentoPanelLayout.createSequentialGroup()
                        .addComponent(cvvCartaoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cvvCartaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FormasPagamentoPanelLayout.createSequentialGroup()
                        .addComponent(cpfTitularCartaoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cpfTitularCartaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FormasPagamentoPanelLayout.createSequentialGroup()
                        .addComponent(titularCartaoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(titularCartaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FormasPagamentoPanelLayout.createSequentialGroup()
                        .addComponent(validadeCartaoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(validadeCartaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FormasPagamentoPanelLayout.createSequentialGroup()
                        .addComponent(numeroCartaoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(numeroCartaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FormasPagamentoPanelLayout.createSequentialGroup()
                        .addComponent(tipoCartaoLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tipoCartaoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        FormasPagamentoPanelLayout.setVerticalGroup(
            FormasPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FormasPagamentoPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(FormasPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(numeroCartaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(numeroCartaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FormasPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(titularCartaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(titularCartaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FormasPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(validadeCartaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(validadeCartaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FormasPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cvvCartaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cvvCartaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(FormasPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cpfTitularCartaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cpfTitularCartaoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(FormasPagamentoPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipoCartaoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipoCartaoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jSeparator3.setOrientation(javax.swing.SwingConstants.VERTICAL);

        atualizarCadastroButton.setText("Atualizar Cadastro");

        tornarAdminButton.setText("Tornar Adm");
        tornarAdminButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tornarAdminButtonActionPerformed(evt);
            }
        });

        inativarCadastroButton.setText("Inativar Cadastro");

        reativarCadastroButton.setText("Reativar Cadastro");

        javax.swing.GroupLayout botoesPanelLayout = new javax.swing.GroupLayout(botoesPanel);
        botoesPanel.setLayout(botoesPanelLayout);
        botoesPanelLayout.setHorizontalGroup(
            botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(atualizarCadastroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inativarCadastroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(reativarCadastroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tornarAdminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        botoesPanelLayout.setVerticalGroup(
            botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(botoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(atualizarCadastroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tornarAdminButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(botoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reativarCadastroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inativarCadastroButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout painelPrincipalPanelLayout = new javax.swing.GroupLayout(painelPrincipalPanel);
        painelPrincipalPanel.setLayout(painelPrincipalPanelLayout);
        painelPrincipalPanelLayout.setHorizontalGroup(
            painelPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalPanelLayout.createSequentialGroup()
                        .addComponent(dadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalPanelLayout.createSequentialGroup()
                        .addComponent(botoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(76, 76, 76)))
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 11, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 421, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FormasPagamentoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(70, Short.MAX_VALUE))
        );
        painelPrincipalPanelLayout.setVerticalGroup(
            painelPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(painelPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalPanelLayout.createSequentialGroup()
                        .addComponent(dadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(botoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(painelPrincipalPanelLayout.createSequentialGroup()
                        .addComponent(imagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jSeparator2, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(FormasPagamentoPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 617, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(115, 115, 115))
        );

        painelPrincipalScrollPane.setViewportView(painelPrincipalPanel);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipalScrollPane, javax.swing.GroupLayout.DEFAULT_SIZE, 1024, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(painelPrincipalScrollPane, javax.swing.GroupLayout.PREFERRED_SIZE, 768, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void carregarImagemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_carregarImagemButtonActionPerformed
        carregarFoto();
    }//GEN-LAST:event_carregarImagemButtonActionPerformed

    private void tornarAdminButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tornarAdminButtonActionPerformed
        tornarAdm();
    }//GEN-LAST:event_tornarAdminButtonActionPerformed

    
    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public JLabel getImagemUsuarioLabel() {
        return imagemUsuarioLabel;
    }

    public void setImagemUsuarioLabel(ImageIcon icon) {
        imagemUsuarioLabel.setIcon(icon);
    }

    public int getCodigoLabel() {
        int codigo = Integer.parseInt(codigoLabel.getText());
        return codigo;
    }

    public void setCodigoLabel(String codigo) {
        codigoLabel.setText(codigo);
    }

    public JTextField getValidadeCartaoTextField() {
        return validadeCartaoTextField;
    }

    public void setValidadeCartaoTextField(JTextField validadeCartaoTextField) {
        this.validadeCartaoTextField = validadeCartaoTextField;
    }

    public JTextField getCpfTextField() {
        return cpfTextField;
    }

    public void setCpfTextField(JTextField cpfTextField) {
        this.cpfTextField = cpfTextField;
    }

    public JTextField getCpfTitularCartaoTextField() {
        return cpfTitularCartaoTextField;
    }

    public void setCpfTitularCartaoTextField(JTextField cpfTitularCartaoTextField) {
        this.cpfTitularCartaoTextField = cpfTitularCartaoTextField;
    }

    public JTextField getCvvCartaoTextField() {
        return cvvCartaoTextField;
    }

    public void setCvvCartaoTextField(JTextField cvvCartaoTextField) {
        this.cvvCartaoTextField = cvvCartaoTextField;
    }

    public JTextField getDataNascimentoTextField() {
        return dataNascimentoTextField;
    }

    public void setDataNascimentoTextField(JTextField dataNascimentoTextField) {
        this.dataNascimentoTextField = dataNascimentoTextField;
    }

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JTextField getNomeTextField() {
        return nomeTextField;
    }

    public void setNomeTextField(JTextField nomeTextField) {
        this.nomeTextField = nomeTextField;
    }

    public JTextField getNumeroCartaoTextField() {
        return numeroCartaoTextField;
    }

    public void setNumeroCartaoTextField(JTextField numeroCartaoTextField) {
        this.numeroCartaoTextField = numeroCartaoTextField;
    }

    public JPasswordField getSenhaAntigaPasswordField() {
        return senhaAntigaPasswordField;
    }

    public void setSenhaAntigaPasswordField(JPasswordField senhaAntigaPasswordField) {
        this.senhaAntigaPasswordField = senhaAntigaPasswordField;
    }

    public JPasswordField getSenhaNovaPasswordField() {
        return senhaNovaPasswordField;
    }

    public void setSenhaNovaPasswordField(JPasswordField senhaNovaPasswordField) {
        this.senhaNovaPasswordField = senhaNovaPasswordField;
    }

    public JComboBox<String> getSexoComboBox() {
        return sexoComboBox;
    }

    public void setSexoComboBox(JComboBox<String> sexoComboBox) {
        this.sexoComboBox = sexoComboBox;
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(JLabel statusLabel) {
        this.statusLabel = statusLabel;
    }

    public JComboBox<String> getTipoCartaoComboBox() {
        return tipoCartaoComboBox;
    }

    public void setTipoCartaoComboBox(JComboBox<String> tipoCartaoComboBox) {
        this.tipoCartaoComboBox = tipoCartaoComboBox;
    }

    public JTextField getTitularCartaoTextField() {
        return titularCartaoTextField;
    }

    public void setTitularCartaoTextField(JTextField titularCartaoTextField) {
        this.titularCartaoTextField = titularCartaoTextField;
    }
    public void setSexoComboBox(String sexo) {
        sexoComboBox.setSelectedItem(sexo);
    }
    public void setNomeTextField(String nome) {
      nomeTextField.setText(nome);
    }
    public void setEmailTextField(String email) {
      emailTextField.setText(email);
    }
    public void setDataNascimentoTextField(String dtNascimento) {
      dataNascimentoTextField.setText(dtNascimento);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel FormasPagamentoPanel;
    private javax.swing.JPanel SenhaPanel;
    private javax.swing.JButton atualizarCadastroButton;
    private javax.swing.JPanel botoesPanel;
    private javax.swing.JButton carregarImagemButton;
    private javax.swing.JLabel codigoLabel;
    private javax.swing.JLabel codigoTxtLabel;
    private javax.swing.JLabel confirmaSenhaLabel;
    private javax.swing.JPasswordField confirmaSenhaPasswordField;
    private javax.swing.JLabel cpfLabel;
    private javax.swing.JTextField cpfTextField;
    private javax.swing.JLabel cpfTitularCartaoLabel;
    private javax.swing.JTextField cpfTitularCartaoTextField;
    private javax.swing.JLabel cvvCartaoLabel;
    private javax.swing.JTextField cvvCartaoTextField;
    private javax.swing.JPanel dadosPanel;
    private javax.swing.JLabel dataNascimentoLabel;
    private javax.swing.JTextField dataNascimentoTextField;
    private javax.swing.JLabel emailLabel;
    private javax.swing.JTextField emailTextField;
    private javax.swing.JLabel forcaSenhaLabel;
    private javax.swing.JLabel imagemLabel;
    private javax.swing.JPanel imagemPanel;
    private javax.swing.JLabel imagemUsuarioLabel;
    private javax.swing.JButton inativarCadastroButton;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JLabel nomeLabel;
    private javax.swing.JTextField nomeTextField;
    private javax.swing.JLabel numeroCartaoLabel;
    private javax.swing.JTextField numeroCartaoTextField;
    private javax.swing.JPanel painelPrincipalPanel;
    private javax.swing.JScrollPane painelPrincipalScrollPane;
    private javax.swing.JButton reativarCadastroButton;
    private javax.swing.JLabel senhaAntigaLabel;
    private javax.swing.JPasswordField senhaAntigaPasswordField;
    private javax.swing.JLabel senhaNovaLabel;
    private javax.swing.JPasswordField senhaNovaPasswordField;
    private javax.swing.JComboBox<String> sexoComboBox;
    private javax.swing.JLabel sexoLabel;
    private RW.components.StatusForcaSenha statusForcaSenha;
    private javax.swing.JLabel statusLabel;
    private javax.swing.JLabel statusTxtLabel;
    private javax.swing.JComboBox<String> tipoCartaoComboBox;
    private javax.swing.JLabel tipoCartaoLabel;
    private javax.swing.JLabel titularCartaoLabel;
    private javax.swing.JTextField titularCartaoTextField;
    private javax.swing.JButton tornarAdminButton;
    private javax.swing.JLabel validadeCartaoLabel;
    private javax.swing.JTextField validadeCartaoTextField;
    // End of variables declaration//GEN-END:variables

}
