package RW.forms;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;

public class ConfirmaUsuarioTela extends JPanel {
    
    private JTextField codeTextField;

    public ConfirmaUsuarioTela() {
        init();
    }

    private void init() {
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
        });
        setLayout(new MigLayout("wrap,fillx,insets 45 45 50 45", "[fill]"));
        JLabel title = new JLabel("Confirme sua conta!", SwingConstants.CENTER);
        JTextField codeTextField = new JTextField();
        JButton confirmarButton = new JButton("Confirmar");
        JButton cancelarButton = new JButton("Cancelar");
        title.putClientProperty(FlatClientProperties.STYLE, "" +
                "font:montserrat +10");
        codeTextField.putClientProperty(FlatClientProperties.STYLE, "" +
                "margin:5,10,5,10;" +
                "focusWidth:1;" +
                "innerFocusWidth:0");
        confirmarButton.putClientProperty(FlatClientProperties.STYLE, "" +
                "background:$Component.accentColor;" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        cancelarButton.putClientProperty(FlatClientProperties.STYLE, "" +
                "background:$Component.accentColor;" +
                "borderWidth:0;" +
                "focusWidth:0;" +
                "innerFocusWidth:0");
        codeTextField.putClientProperty(FlatClientProperties.PLACEHOLDER_TEXT, "Digite o código aqui");
        
        confirmarButton.addActionListener(e -> {
            
        });
        cancelarButton.addActionListener(e -> {
            JFrame confirmaUsuarioTela = (JFrame) SwingUtilities.getWindowAncestor(this);
            confirmaUsuarioTela.dispose();
        });

        add(title);
        add(new JLabel("Digite o código enviado para o seu e-mail."), "gapy 20");
        add(new JLabel(""));
        add(codeTextField);
        add(confirmarButton, "gapy 30");
        add(cancelarButton, "gapy 20");
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

    public JTextField getCodeTextField() {
        return codeTextField;
    }
}
