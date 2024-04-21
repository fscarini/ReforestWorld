package RW.forms;

import RW.components.StatusForcaSenha;
import RW.controller.CadastroController;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.text.MaskFormatter;

public class CadastroTela extends JPanel {

    public CadastroTela() {
        init();
    }

    private void init() {
        
        //configura o painel
        setOpaque(false);
        addMouseListener(new MouseAdapter() {});
        setLayout(new MigLayout("wrap,fillx,insets 45 45 50 45", "[fill]"));
        
        //cria botões e campos
        JLabel title = new JLabel("Crie sua conta", SwingConstants.CENTER);
        nomeUsuarioTextField = new JTextField();
        dtNascimentoTextField = new JFormattedTextField(createDateMaskFormatter()); // Usa a máscara de data
        emailTextField = new JTextField();
        cpfTextField = new JTextField();
        senhaPasswordField = new JPasswordField();
        confirmaSenhaPasswordField = new JPasswordField();
        JButton cadastrarButton = new JButton("Cadastrar");
        StatusForcaSenha = new StatusForcaSenha();
        String[] itens = {"","M","F"};
        sexoComboBox = new JComboBox<>(itens);

        // Adiciona formatação automática para o CPF
        cpfTextField.addKeyListener(new java.awt.event.KeyAdapter() {
            @Override
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formatarCPF(cpfTextField);
            }
        });
        
        //personaliza os campos
        title.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:bold +10");
        nomeUsuarioTextField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        senhaPasswordField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
        confirmaSenhaPasswordField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
        cadastrarButton.putClientProperty(FlatClientProperties.STYLE, "" +
                "background:$Component.accentColor;" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        dtNascimentoTextField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        sexoComboBox.setOpaque(false);
        sexoComboBox.setForeground(Color.WHITE);
        sexoComboBox.setBackground(UIManager.getColor("TextField.background"));
        emailTextField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        cpfTextField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        nomeUsuarioTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira seu nome");
        senhaPasswordField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira sua senha");
        confirmaSenhaPasswordField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Confirme sua senha");
        dtNascimentoTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira sua data de nascimento");
        sexoComboBox.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Selecione seu sexo");
        emailTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira seu e-mail");
        cpfTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira seu CPF");
        
        //chama a ação do botão cadastrar
        cadastrarButton.addActionListener(e -> {
            String mensagemErro = verificarCamposCadastro();
            if (mensagemErro.isEmpty()) {
                cadastrar();
                
            } else {
                JOptionPane.showMessageDialog(null,mensagemErro);
            }
        });
        
        //chama o validador da senha
        StatusForcaSenha.initPasswordField(senhaPasswordField);
        
        //adiciona os botões e campos ao painel
        add(title);
        add(new JLabel("Data de Nascimento"), "gapy 20");
        add(dtNascimentoTextField);
        add(new JLabel("Sexo"), "gapy 10");
        add(sexoComboBox);
        add(new JLabel("E-mail"), "gapy 10");
        add(emailTextField);
        add(new JLabel("CPF"), "gapy 10");
        add(cpfTextField);
        add(new JLabel("Nome"), "gapy 10");
        add(nomeUsuarioTextField);
        add(new JLabel("Senha"), "gapy 10");
        add(senhaPasswordField);
        add(StatusForcaSenha, "gapy 0");
        add(new JLabel("Confirmação da Senha"), "gapy 10");
        add(confirmaSenhaPasswordField);
        add(cadastrarButton, "gapy 30");
    }
    
    
    //tratativa na tela para criar efeito no painel
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        int arc = UIScale.scale(20);
        g2.setColor(getBackground());
        g2.setComposite(AlphaComposite.SrcOver.derive(0.6f));
        g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc));
        g2.dispose();
        super.paintComponent(g);
    }
        
    //função cadastrar
    private void cadastrar() {
        CadastroController cadastro = new CadastroController();
        try {
            cadastro.cadastroUsuario(this);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro. Por favor, tente novamente em alguns instantes.\n Caso o erro persista acione o suporte.");
        }
    } 
        
    //Validar preenchimento dos campos do cadastro
    private String verificarCamposCadastro() {
        StringBuilder mensagemErro = new StringBuilder();
        if (nomeUsuarioTextField.getText().isEmpty()) {
            mensagemErro.append("Por favor, preencha o campo Nome.\n");
        }
        if (dtNascimentoTextField.getText().isEmpty()) {
            mensagemErro.append("Por favor, preencha o campo Data de Nascimento.\n");
        }
        if (sexoComboBox.getItemCount() == 0) {
            mensagemErro.append("Por favor, preencha o campo Sexo.\n");
        }
        if (emailTextField.getText().isEmpty()) {
            mensagemErro.append("Por favor, preencha o campo E-mail.\n");
        }
        if (cpfTextField.getText().isEmpty()) {
            mensagemErro.append("Por favor, preencha o campo CPF.\n");
        }
        if (senhaPasswordField.getPassword().length == 0) {
            mensagemErro.append("Por favor, preencha o campo Senha.\n");
        }
        if (confirmaSenhaPasswordField.getPassword().length == 0) {
            mensagemErro.append("Por favor, preencha o campo Confirmação da Senha.\n");
        }
        //String contraSenha = String.valueOf(confirmaSenhaPasswordField.getPassword());
        //String senha = String.valueOf(senhaPasswordField.getPassword());
        //if ( senha != contraSenha){
        //    mensagemErro.append("As senhas fornecidas não coincidem. Por favor, verifique e tente novamente.\n");
        //}
        return mensagemErro.toString();
    }
        
    // Função para formatar automaticamente o CPF
    private void formatarCPF(JTextField campo) {
        String cpf = campo.getText().replaceAll("[^0-9]", "");
        if (cpf.length() > 11) {
            cpf = cpf.substring(0, 11);
        }
        StringBuilder cpfFormatado = new StringBuilder();
        for (int i = 0; i < cpf.length(); i++) {
            cpfFormatado.append(cpf.charAt(i));
            if ((i + 1) % 3 == 0 && i < 8) {
                cpfFormatado.append('.');
            } else if (i == 8) {
                cpfFormatado.append('-');
            }
        }
        campo.setText(cpfFormatado.toString());
    }
    
        // Cria um formatador de máscara de data
    private MaskFormatter createDateMaskFormatter() {
        try {
            return new MaskFormatter("##/##/####");
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    
    //geters e seters
    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JTextField getCpfTextField() {
        return cpfTextField;
    }

    public void setCpfTextField(JTextField cpfTextField) {
        this.cpfTextField = cpfTextField;
    }

    public JTextField getNomeUsuarioTextField() {
        return nomeUsuarioTextField;
    }

    public void setNomeUsuarioTextField(JTextField nomeUsuarioTextField) {
        this.nomeUsuarioTextField = nomeUsuarioTextField;
    }

    public JPasswordField getSenhaPasswordField() {
        return senhaPasswordField;
    }

    public void setSenhaPasswordField(JPasswordField senhaPasswordField) {
        this.senhaPasswordField = senhaPasswordField;
    }

    public JTextField getIdadeTextField() {
        return dtNascimentoTextField;
    }

    public void setIdadeTextField(JTextField dtNascimentoTextField) {
        this.dtNascimentoTextField = dtNascimentoTextField;
    }
    public JPasswordField getConfirmaSenhaPasswordField() {
        return confirmaSenhaPasswordField;
    }

    public void setConfirmaSenhaPasswordField(JPasswordField confirmaSenhaPasswordField) {
        this.confirmaSenhaPasswordField = confirmaSenhaPasswordField;
    }
    public JComboBox getSexoComboBox() {
        return sexoComboBox;
    }

    public void setSexoComboBox(JComboBox sexoComboBox) {
        this.sexoComboBox = sexoComboBox;
    }
    
    //declaração dos objetos
    private JTextField dtNascimentoTextField;
    private JComboBox sexoComboBox;
    private JTextField emailTextField;
    private JTextField cpfTextField;
    private JTextField nomeUsuarioTextField;
    private JPasswordField senhaPasswordField;
    private JPasswordField confirmaSenhaPasswordField;
    private StatusForcaSenha StatusForcaSenha;

};