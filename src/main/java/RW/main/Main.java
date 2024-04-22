
package RW.main;

import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.fonts.roboto.FlatRobotoFont;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.util.UIScale;
import RW.forms.InicioTela;
import com.sun.jna.NativeLibrary;
import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil;

public class Main extends JFrame {

    private InicioTela home;

    public Main() {

        init();
    }

    private void init() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setUndecorated(true);
        setSize(UIScale.scale(new Dimension(1365, 768)));
        setLocationRelativeTo(null);
        home = new InicioTela();
        setContentPane(home);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {
                home.initOverlay(Main.this);
                home.play(0);
            }

            @Override
            public void windowClosing(WindowEvent e) {
                home.stop();
            }
        });
    }

    public static void main(String[] args) {
        String userDir = System.getProperty("user.dir");
        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir +"/src/vlc-3.0.16");
        FlatRobotoFont.install();
        FlatLaf.registerCustomDefaultsSource("raven.themes");
        FlatMacDarkLaf.setup();
        UIManager.put("defaultFont", new Font(FlatRobotoFont.FAMILY, Font.PLAIN, 13));
        EventQueue.invokeLater(() -> new Main().setVisible(true));
    }
}

