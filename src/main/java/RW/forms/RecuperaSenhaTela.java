package RW.forms;

import RW.controller_dao.LoginController;
import RW.controller_dao.ConexaoDAO;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.util.UIScale;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;


public class RecuperaSenhaTela extends JPanel {
    private InicioTela inicioTela; 
    public void setInicioTela(InicioTela inicioTela) {
        this.inicioTela = inicioTela;
    }

    public RecuperaSenhaTela() {
        init();
    }

    private void init() {
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
        });
        setLayout(new MigLayout("wrap,fillx,insets 45 45 50 45", "[fill]"));
        JLabel title = new JLabel("Recupere sua senha", SwingConstants.CENTER);
        JTextField emaiJTextField = new JTextField();
        JButton cmdLogin = new JButton("Enviar");
        title.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:bold +10");
        cmdLogin.putClientProperty(FlatClientProperties.STYLE, "" +
                "background:$Component.accentColor;" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        emaiJTextField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        emaiJTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Insira seu E-mail");

        cmdLogin.addActionListener(e -> {
            // Criar um JFrame para exibir o ConfirmaUsuarioTela
            JFrame frame = new JFrame("Confirmação de Usuário");

            // Adicionar o ConfirmaUsuarioTela ao JFrame
            ConfirmaUsuarioTela confirmaUsuarioTela = new ConfirmaUsuarioTela();
            frame.getContentPane().add(confirmaUsuarioTela);

            // Configurar o JFrame
            frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Fechar apenas a janela ao sair
            frame.pack(); // Ajustar o tamanho do JFrame com base no conteúdo
            frame.setLocationRelativeTo(null); // Centralizar o JFrame na tela
            frame.setVisible(true); // Exibir o JFrame
                //loginAction();
        });
        
        add(title);
        add(new JLabel("Para recuperar seu acesso digite seu e-mail e"), "gapy 20");
        add(new JLabel("siga as orientações que encaminhamos para"), "gapy 1");
        add(new JLabel("sua caixa de entrada."), "gapy 1");
        add(new JLabel("E-mail"), "gapy 20");
        add(emaiJTextField);
        add(cmdLogin, "gapy 30");
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
