
package RW.forms;

import RW.controller_dao.ConexaoDAO;
import RW.controller_dao.LoginController;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;

public class LoginTela extends JPanel {
    private InicioTela inicioTela; 
    public void setInicioTela(InicioTela inicioTela) {
        this.inicioTela = inicioTela;
    }

    public LoginTela() {
        init();
    }

    private void init() {
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
        });
        setLayout(new MigLayout("wrap,fillx,insets 45 45 50 45", "[fill]"));
        JLabel title = new JLabel("Acesse a sua conta", SwingConstants.CENTER);
        JTextField emailTextField = new JTextField();
        JPasswordField senhaPasswordField = new JPasswordField();
        JCheckBox chRememberMe = new JCheckBox("Lembrar");
        JButton loginButton = new JButton("Entrar");
        title.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:montserrat +10");
        emailTextField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        senhaPasswordField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
        loginButton.putClientProperty(FlatClientProperties.STYLE, "" +
                "background:$Component.accentColor;" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        emailTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite seu e-mail");
        senhaPasswordField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite sua senha");
        
        loginButton.addActionListener(e -> {
            try {
                var login = emailTextField.getText();
                var senha = new String(senhaPasswordField.getPassword());
                if (login.isEmpty() || senha.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Por favor, preencha todos os campos.");
                    return;
                }
                var usuario = new LoginController(login, senha);
                var dao = new ConexaoDAO();
                if(dao.existeVerificado(usuario)){
                    inicioTela.dispose();
                    SwingUtilities.getWindowAncestor(this).dispose();
                    java.awt.EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            new RW.forms.LoginLoadTela(null, true).setVisible(true);
                            TelaHome telaHome = new TelaHome();
                            telaHome.setVisible(true);
                        }
                    });
                }else if(dao.existeNaoVerificado(usuario)){
                    inicioTela.dispose();
                    SwingUtilities.getWindowAncestor(this).dispose();
                    JFrame frame = new JFrame("Confirmação de Usuário");
                    ConfirmaUsuarioTela confirmaUsuarioTela = new ConfirmaUsuarioTela(emailTextField.getText());
                    frame.getContentPane().add(confirmaUsuarioTela);
                    frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                    frame.pack();
                    frame.setLocationRelativeTo(null);
                    frame.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Usuário/senha inválido. Verifique e tente novamente.");}
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro. Por favor, tente novamente em alguns instantes.\n Caso o erro persista acione o suporte.");
            }
        });

        add(title);
        add(new JLabel("E-mail"), "gapy 20");
        add(emailTextField);
        add(new JLabel("Senha"), "gapy 10");
        add(senhaPasswordField);
        //add(chRememberMe);
        add(loginButton, "gapy 30");
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

    public JTextField getEmailTextField() {
        return emailTextField;
    }

    public void setEmailTextField(JTextField emailTextField) {
        this.emailTextField = emailTextField;
    }

    public JPasswordField getSenhaPasswordField() {
        return senhaPasswordField;
    }

    //declaração dos objetos
    public void setSenhaPasswordField(JPasswordField senhaPasswordField) {
        this.senhaPasswordField = senhaPasswordField;
    }
    private JTextField emailTextField;
    private JPasswordField senhaPasswordField;
    
}
