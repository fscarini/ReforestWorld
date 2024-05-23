package RW.forms;

import com.formdev.flatlaf.FlatClientProperties;
import com.formdev.flatlaf.util.Animator;
import com.formdev.flatlaf.util.CubicBezierEasing;
import net.miginfocom.swing.MigLayout;
import RW.components.EventHomeOverlay;
import RW.components.HeaderButton;
import RW.components.LoadingPanel;
import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.util.List;

public class InicioOverlay extends JWindow {

    private JFrame mainWindow;
    private InicioTela inicioTela;
    private LoadingPanel loadingPanel;
    private PanelOverlay overlay;
    private List<VideosOverlay> videosOverlay;

    public enum AnimationType {
        CLOSE_VIDEO, SHOW_VIDEO, NONE
    }

    public PanelOverlay getOverlay() {
        return overlay;
    }

    public InicioOverlay(JFrame frame, InicioTela inicioTela, List<VideosOverlay> locations) {
        super(frame);
        this.mainWindow = frame;
        this.inicioTela = inicioTela;
        this.videosOverlay = locations;
        init();
    }

    public void closeMainWindow() {
        mainWindow.dispose();
    }

    private void init() {
        loadingPanel = new LoadingPanel();
        add(loadingPanel, BorderLayout.CENTER);
        loadingPanel.setVisible(false); // Começa invisível
        setBackground(new Color(35, 96, 135, 10));
        setLayout(new BorderLayout());
        overlay = new PanelOverlay();
        overlay.setInicioTela(inicioTela);
        add(overlay);
    }

    class PanelOverlay extends JPanel {

        private MigLayout migLayout;
        private EventHomeOverlay eventHomeOverlay;
        private AnimationType animationType = AnimationType.NONE;
        private Animator animator;
        private Animator loginAnimator;
        private Animator cadastroAnimator;
        private Animator recuperarSenhaAnimator;
        private float animate;
        private int index;
        private boolean showLogin;
        private boolean showCadastro;
        private boolean showRecuperarSenha;
        private InicioTela inicioTela;
        private JPanel header;
        private JTextPane textTitle;
        private JTextPane textDescription;
        private JButton sobreNosJButton;
        private LoginTela panelLogin;
        private CadastroTela panelCadastro;
        private RecuperaSenhaTela panelRecuperarSenha;
        private JLabel logo;

        public PanelOverlay() {
            init();
        }

        private void init() {

            setOpaque(false);
            migLayout = new MigLayout("fill,insets 10 180 10 180", "fill", "[grow 0][]");
            setLayout(migLayout);
            createHeader();
            createPageButton();
            createLogin();
            createCadastro();
            createRecuperarSenha();
            JPanel panel = new JPanel(new MigLayout("wrap", "", "[]30[]"));
            panel.setOpaque(false);
            textTitle = new JTextPane();
            textDescription = new JTextPane();
            sobreNosJButton = new JButton("Sobre nós");
            textTitle.setOpaque(false);
            textTitle.setEditable(false);
            textTitle.putClientProperty(FlatClientProperties.STYLE, ""
                    + "font:montserrat +40;"
                    + "border:0,0,0,0");
            textDescription.setOpaque(false);
            textDescription.setEditable(false);
            textDescription.putClientProperty(FlatClientProperties.STYLE, ""
                    + "font:montserrat +2;"
                    + "foreground:$Component.accentColor;"
                    + "border:0,0,0,0");
            sobreNosJButton.putClientProperty(FlatClientProperties.STYLE, ""
                    + "background:$Component.accentColor;"
                    + "borderWidth:0;"
                    + "margin:5,15,5,15;"
                    + "focusWidth:0;"
                    + "innerFocusWidth:0;"
                    + "arc:999");
            logo = new JLabel();
            logo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/Reforest World Logo.png")));
            logo.putClientProperty(FlatClientProperties.STYLE, ""
                    + "font:montserrat +10");
            //panel.add(textTitle);
            panel.add(logo);
            panel.add(textDescription);
            panel.add(sobreNosJButton);
            add(panel, "width 50%!");
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    runLoginAnimation(false);
                }
            });
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    runCadastroAnimation(false);
                }
            });
            addMouseListener(new MouseAdapter() {
                @Override
                public void mouseReleased(MouseEvent e) {
                    runRecuperarSenhaAnimation(false);
                }
            });
            animator = new Animator(500, new Animator.TimingTarget() {
                @Override
                public void timingEvent(float v) {
                    animate = v;
                    repaint();
                }

                @Override
                public void end() {
                    if (animationType == AnimationType.CLOSE_VIDEO) {
                        eventHomeOverlay.onChanged(index);
                        SwingUtilities.invokeLater(() -> {
                            sleep(500);
                            runAnimation(index, AnimationType.SHOW_VIDEO);
                        });
                    } else {
                        animationType = AnimationType.NONE;
                    }
                }
            });
            loginAnimator = new Animator(500, new Animator.TimingTarget() {
                @Override
                public void timingEvent(float v) {
                    float f = showLogin ? v : 1f - v;
                    int x = (int) ((350 + 180) * f);
                    migLayout.setComponentConstraints(panelLogin, "pos 100%-" + x + " 0.5al, w 350");
                    revalidate();
                }
            });
            cadastroAnimator = new Animator(500, new Animator.TimingTarget() {
                @Override
                public void timingEvent(float v) {
                    float f = showCadastro ? v : 1f - v;
                    int x = (int) ((350 + 180) * f);
                    migLayout.setComponentConstraints(panelCadastro, "pos 100%-" + x + " 0.5al, w 350");
                    revalidate();
                }
            });
            recuperarSenhaAnimator = new Animator(500, new Animator.TimingTarget() {
                @Override
                public void timingEvent(float v) {
                    float f = showRecuperarSenha ? v : 1f - v;
                    int x = (int) ((350 + 180) * f);
                    migLayout.setComponentConstraints(panelRecuperarSenha, "pos 100%-" + x + " 0.5al, w 350");
                    revalidate();
                }
            });
            animator.setInterpolator(CubicBezierEasing.EASE_IN);
            loginAnimator.setInterpolator(CubicBezierEasing.EASE);
            cadastroAnimator.setInterpolator(CubicBezierEasing.EASE);
            recuperarSenhaAnimator.setInterpolator(CubicBezierEasing.EASE);

        }

        public void setInicioTela(InicioTela inicioTela) {
            this.inicioTela = inicioTela;
        }

        public void setEventHomeOverlay(EventHomeOverlay eventHomeOverlay) {
            this.eventHomeOverlay = eventHomeOverlay;
        }

        public void setIndex(int index) {
            this.index = index;
            VideosOverlay location = videosOverlay.get(index);
            textTitle.setText(location.getTitle());
            textDescription.setText(location.getDescription());
        }

        private void sleep(long l) {
            try {
                Thread.sleep(l);
            } catch (Exception e) {
                System.err.println(e);
            }
        }

        private void createHeader() {
            header = new JPanel(new MigLayout("fill", "[]push[][]"));
            header.setOpaque(false);
            JLabel title = new JLabel();
            title.setIcon(new javax.swing.ImageIcon(getClass().getResource("")));
            title.putClientProperty(FlatClientProperties.STYLE, ""
                    + "font:montserrat +10");
            HeaderButton sairHeaderButton = new HeaderButton("Sair");
            HeaderButton recuperarSenhaHeaderButton = new HeaderButton("Recuperar Senha");
            HeaderButton cadastrarHeaderButton = new HeaderButton("Cadastrar-se");
            HeaderButton entrarHeaderButton = new HeaderButton("Entrar");
            //icones dos botoes
            recuperarSenhaHeaderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/senha-incorreta.png")));
            cadastrarHeaderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/cadastro.png")));
            entrarHeaderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/escudo-de-seguranca.png")));
            sairHeaderButton.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagens/poder.png")));
            //cor da fonte
            recuperarSenhaHeaderButton.setForeground(new Color(0, 128, 128));
            cadastrarHeaderButton.setForeground(new Color(0, 128, 128));
            entrarHeaderButton.setForeground(new Color(0, 128, 128));
            sairHeaderButton.setForeground(new Color(0, 128, 128));

            entrarHeaderButton.addActionListener(e -> {
                loginAction();
            });
            cadastrarHeaderButton.addActionListener(e -> {
                panelCadastro.setInicioTela(inicioTela);
                runCadastroAnimation(true);
                runLoginAnimation(false);
                runRecuperarSenhaAnimation(false);
            });
            recuperarSenhaHeaderButton.addActionListener(e -> {
                runRecuperarSenhaAnimation(true);
                runCadastroAnimation(false);
                runLoginAnimation(false);

            });
            sairHeaderButton.addActionListener(e -> {
                //System.exit(0);
                inicioTela.dispose();
            });

            header.add(title);
            header.add(sairHeaderButton);
            header.add(recuperarSenhaHeaderButton);
            header.add(cadastrarHeaderButton);
            header.add(entrarHeaderButton);
            add(header, "wrap");
        }

        public void loginAction() {
            panelLogin.setInicioTela(inicioTela);
            runLoginAnimation(true);
            runCadastroAnimation(false);
            runRecuperarSenhaAnimation(false);
        }

        private void createLogin() {
            panelLogin = new LoginTela();
            panelLogin.setInicioTela(inicioTela);
            add(panelLogin, "pos 100% 0.5al,w 350");
        }

        private void createCadastro() {
            panelCadastro = new CadastroTela();
            add(panelCadastro, "pos 100% 0.5al,w 350");
        }

        private void createRecuperarSenha() {
            panelRecuperarSenha = new RecuperaSenhaTela();
            add(panelRecuperarSenha, "pos 100% 0.5al,w 350");
        }

        private void createPageButton() {
            JPanel panel = new JPanel(new MigLayout("gapx 20"));
            panel.setOpaque(false);
            for (int i = 0; i < videosOverlay.size(); i++) {
                JButton cmd = new JButton("");
                cmd.putClientProperty(FlatClientProperties.STYLE, ""
                        + "margin:5,5,5,5;"
                        + "arc:999;"
                        + "borderWidth:0;"
                        + "focusWidth:0;"
                        + "innerFocusWidth:0;" +
                "selectedBackground:$Component.accentColor"
                );

                cmd.setCursor(new Cursor(Cursor.HAND_CURSOR));
                final int index = i;
                cmd.addActionListener(e -> {
                    if (this.index != index) {
                        boolean act = runAnimation(index, AnimationType.CLOSE_VIDEO);
                        if (act) {
                            setSelectedButton(panel, index);
                        }
                    }
                });
                panel.add(cmd);
            }
            add(panel, "pos 0.5al 80%");
            setSelectedButton(panel, index);
        }

        private void setSelectedButton(JPanel panel, int index) {
            int count = panel.getComponentCount();
            for (int i = 0; i < count; i++) {
                JButton cmd = (JButton) panel.getComponent(i);
                if (i == index) {
                    cmd.setSelected(true);
                } else {
                    cmd.setSelected(false);
                }
            }
        }

        private boolean runAnimation(int index, AnimationType animationType) {
            if (!animator.isRunning()) {
                this.animate = 0;
                this.animationType = animationType;
                this.index = index;
                animator.start();
                return true;
            } else {
                return false;
            }
        }

        private void runLoginAnimation(boolean show) {
            if (showLogin != show) {
                if (!loginAnimator.isRunning()) {
                    showLogin = show;
                    loginAnimator.start();
                }
            }
        }

        public void runCadastroAnimation(boolean show) {
            if (showCadastro != show) {
                if (!cadastroAnimator.isRunning()) {
                    showCadastro = show;
                    cadastroAnimator.start();
                }
            }
        }

        private void runRecuperarSenhaAnimation(boolean show) {
            if (showRecuperarSenha != show) {
                if (!recuperarSenhaAnimator.isRunning()) {
                    showRecuperarSenha = show;
                    recuperarSenhaAnimator.start();
                }
            }
        }

        @Override
        protected void paintComponent(Graphics g) {
            if (animationType != AnimationType.NONE) {
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                int width = getWidth();
                int height = getHeight();
                //troca cor da transição
                g2.setColor(new Color(149, 175, 66));
                Rectangle rec = new Rectangle(0, 0, width, height);
                if (animationType == AnimationType.CLOSE_VIDEO) {
                    g2.setComposite(AlphaComposite.SrcOver.derive(animate));
                    g2.fill(rec);
                } else {
                    Area area = new Area(rec);
                    area.subtract(new Area(createRec(rec)));
                    g2.fill(area);
                }
                g2.dispose();
            }
            super.paintComponent(g);
        }

        private Shape createRec(Rectangle rec) {
            int maxSize = Math.max(rec.width, rec.height);
            float size = maxSize * animate;
            float x = (rec.width - size) / 2;
            float y = (rec.height - size) / 2;
            Ellipse2D ell = new Ellipse2D.Double(x, y, size, size);
            return ell;
        }
    }
}
