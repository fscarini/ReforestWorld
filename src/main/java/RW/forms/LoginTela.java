
package RW.forms;

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
        this.inicioTela = inicioTela; // Implemente este método para definir a referência inicioTela
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
        JTextField txtUsername = new JTextField();
        JPasswordField txtPassword = new JPasswordField();
        JCheckBox chRememberMe = new JCheckBox("Lembrar");
        JButton loginButton = new JButton("Entrar");
        title.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:montserrat +10");
        txtUsername.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        txtPassword.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0;" +
                "showRevealButton:true");
        loginButton.putClientProperty(FlatClientProperties.STYLE, "" +
                "background:$Component.accentColor;" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        txtUsername.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite seu usuário");
        txtPassword.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite sua senha");
        loginButton.addActionListener(e -> {
            inicioTela.dispose();
            SwingUtilities.getWindowAncestor(this).dispose();
            HomeTela homeTela = new HomeTela();
            homeTela.setVisible(true);
        });

        add(title);
        add(new JLabel("Usuário"), "gapy 20");
        add(txtUsername);
        add(new JLabel("Senha"), "gapy 10");
        add(txtPassword);
        add(chRememberMe);
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
}
