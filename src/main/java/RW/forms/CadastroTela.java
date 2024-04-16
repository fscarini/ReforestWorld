/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package RW.forms;

/**
 *
 * @author Guilherme Quiller
 */
import RW.controller.LoginController;
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

public class CadastroTela extends JPanel {

  
    public CadastroTela() {
        init();

    }

    private void init() {
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
        });
        setLayout(new MigLayout("wrap,fillx,insets 45 45 50 45", "[fill]"));
        JLabel title = new JLabel("Crie sua conta", SwingConstants.CENTER);
        JTextField NomeUsuarioTextField = new JTextField();
        JTextField idadeTextField = new JTextField();
        JTextField sexoTextField = new JTextField();
        JTextField emaiTextField = new JTextField();
        JTextField cpfTextField = new JTextField();
        JPasswordField senhaPasswordField = new JPasswordField();
        JPasswordField confirmaSenhaPasswordField = new JPasswordField();
        JCheckBox lembrarCheckBox = new JCheckBox("Lembrar");
        JButton CadastrarButton = new JButton("Cadastrar");
        title.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:bold +10");
        NomeUsuarioTextField.putClientProperty(FlatClientProperties.STYLE, "" +
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
        CadastrarButton.putClientProperty(FlatClientProperties.STYLE, "" +
                "background:$Component.accentColor;" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        idadeTextField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        sexoTextField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        emaiTextField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        cpfTextField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        NomeUsuarioTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira seu nome");
        senhaPasswordField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira sua senha");
        confirmaSenhaPasswordField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira sua senha");
        idadeTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira sua data de nascimento");
        sexoTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Selecione seu sexo");
        emaiTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira seu e-mail");
        cpfTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira seu CPF");
        CadastrarButton.addActionListener(e -> {
                cadastrar();
            });

        add(title);
        add(new JLabel("Data de Nascimento"), "gapy 20");
        add(idadeTextField);
        add(new JLabel("Sexo"), "gapy 10");
        add(sexoTextField);
        add(new JLabel("E-mail"), "gapy 10");
        add(emaiTextField);
        add(new JLabel("CPF"), "gapy 10");
        add(cpfTextField);
        add(new JLabel("Nome"), "gapy 10");
        add(NomeUsuarioTextField);
        add(new JLabel("Senha"), "gapy 10");
        add(senhaPasswordField);
        add(new JLabel("Confirmação da Senha"), "gapy 10");
        add(confirmaSenhaPasswordField);
        add(CadastrarButton, "gapy 30");
        
    }
    

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
    
    public JTextField getSexoTextField() {
        return sexoTextField;
    }

    public void setSexoTextField(JTextField sexoTextField) {
        this.sexoTextField = sexoTextField;
    }

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
        return idadeTextField;
    }

    public void setIdadeTextField(JTextField idadeTextField) {
        this.idadeTextField = idadeTextField;
    }
    
    private JTextField idadeTextField;
    private JTextField sexoTextField;
    private JTextField emailTextField;
    private JTextField cpfTextField;
    private JTextField nomeUsuarioTextField;
    private JPasswordField senhaPasswordField;

    private void cadastrar() {
        try {
            LoginController cadastro = new LoginController();
            cadastro.cadastroUsuario(this);
        } catch (SQLException sql) {
            Logger.getLogger(CadastroTela.class.getName()).log(Level.SEVERE, null, sql);
        }
        
        
    }       
}


