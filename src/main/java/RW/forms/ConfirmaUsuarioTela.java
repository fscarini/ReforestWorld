package RW.forms;

import RW.controller_dao.ConexaoDAO;
import RW.main.Main;
import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.UIScale;
import com.sun.jna.NativeLibrary;
import net.miginfocom.swing.MigLayout;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.geom.RoundRectangle2D;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil;

public class ConfirmaUsuarioTela extends JPanel {
    
    private JTextField codeTextField;
    private String email;

    public ConfirmaUsuarioTela(String email) {
        this.email = email;
        init();
    }

    private void init() {
        setOpaque(false);
        addMouseListener(new MouseAdapter() {
        });
        setLayout(new MigLayout("wrap,fillx,insets 45 45 50 45", "[fill]"));
        JLabel title = new JLabel("Confirme sua conta!", SwingConstants.CENTER);
        codeTextField = new JTextField();
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
            var dao = new ConexaoDAO();
            try {
                System.out.println(email);
                System.out.println(codeTextField.getText());
                if(dao.verificacaoUsuarioCodigo(email,codeTextField.getText())){
                    dao.verificacaoUsuarioOk(email);
                    JOptionPane.showMessageDialog(null, "Usuário verificado com sucesso!");
                    JFrame confirmaUsuarioTela = (JFrame) SwingUtilities.getWindowAncestor(this);
                    confirmaUsuarioTela.dispose();
                    String userDir = System.getProperty("user.dir");
                    NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir +"/src/vlc-3.0.16");
                    NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir +"/src/vlc-3.0.16/vlc-3.0.16");
                    Main main = new Main();
                    main.setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null, "Código de verificação incorreto. Verifique e tente novamente.");
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Ocorreu algum erro. Por favor, tente novamente em alguns instantes.\n Caso o erro persista acione o suporte.");
                Logger.getLogger(ConfirmaUsuarioTela.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        cancelarButton.addActionListener(e -> {
            JFrame confirmaUsuarioTela = (JFrame) SwingUtilities.getWindowAncestor(this);
            confirmaUsuarioTela.dispose();
            String userDir = System.getProperty("user.dir");
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir +"/src/vlc-3.0.16");
            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir +"/src/vlc-3.0.16/vlc-3.0.16");
            Main main = new Main();
            main.setVisible(true);
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
}
