package RW.forms;

import RW.Drawer.MyDrawerBuilder;
import RW.Tabbed.WindowsTabbed;
import RW.main.Main;
import com.formdev.flatlaf.FlatLaf;
import com.formdev.flatlaf.extras.FlatAnimatedLafChange;
import com.formdev.flatlaf.themes.FlatMacDarkLaf;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.sun.jna.NativeLibrary;
import java.awt.EventQueue;
import java.awt.Frame;
import raven.drawer.Drawer;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.popup.GlassPanePopup;
import raven.swing.AvatarIcon;
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil;

public class TelaHome extends javax.swing.JFrame {

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public String getCodPerfil() {
        return codPerfil;
    }
    public String getCodUsuario() {
        return codUsuario;
    }
    private String nome;
    private String codUsuario;
    private String email;
    private String codPerfil;

    public TelaHome(String nome, String email, String codPerfil, String codUsuario) {
        this.nome = nome;
        this.email = email;
        this.codPerfil = codPerfil;
        this.codUsuario = codUsuario;
        GlassPanePopup.install(this);
        MyDrawerBuilder myDrawerbuilder = new MyDrawerBuilder(nome, email, codPerfil, codUsuario) {
            private void changeMode(boolean dark) {
                if (FlatLaf.isLafDark() != dark) {
                    if (dark) {
                        EventQueue.invokeLater(() -> {
                            FlatAnimatedLafChange.showSnapshot();
                            FlatMacDarkLaf.setup();
                            FlatLaf.updateUI();
                            FlatAnimatedLafChange.hideSnapshotWithAnimation();
                        });
                    } else {
                        EventQueue.invokeLater(() -> {
                            FlatAnimatedLafChange.showSnapshot();
                            FlatMacLightLaf.setup();
                            FlatLaf.updateUI();
                            FlatAnimatedLafChange.hideSnapshotWithAnimation();
                        });
                    }
                }
            }

            @Override
            public SimpleHeaderData getSimpleHeaderData() {
                return new SimpleHeaderData()
                        //adicionar a foto para mudar de acordo o o usurio
                        .setIcon(new AvatarIcon(getClass().getResource("/imagens/Reforest World Logo.png"), 60, 60, 999))
                        //adicionar o nome da pessoa conforme ela logar, puxando do banco de dados
                        .setTitle(nome)
                        //adicionar o e-mail da pessoa que entrar
                        .setDescription(email);
            }

            @Override
            public SimpleMenuOption getSimpleMenuOption() {
                String[][] menus;
                if ("1".equals(codPerfil)) { // Perfil de administrador
                    menus = new String[][]{
                        {"~ÁREA DO USUÁRIO~"},
                        {"Meu Perfil"},
                        {"~COMUNIDADE~"},
                        {"Chat"},
                        {"Forum"},
                        {"~DOAÇÕES~"},
                        {"Gestão de Mudas"},
                        {"Doações Livres"},
                        {"Eventos", "Cadastro de Eventos", "Consulta de Eventos"},
                        {"Minhas Contribuições"},
                        {"~CONFIGURAÇÕES~"},
                        {"Ajuda", "Fale conosco", "Sobre nós", "Ajuda"},
                        {"Configurações", "Dark Theme", "Light Theme"},
                        {"Gestão de Usuários"},
                        {"Logout"}
                    };
                } else {
                    menus = new String[][]{
                        {"~ÁREA DO USUÁRIO~"},
                        {"Meu Perfil"},
                        {"~COMUNIDADE~"},
                        {"Chat"},
                        {"Forum"},
                        {"~DOAÇÕES~"},
                        {"Doações Livres"},
                        {"Eventos", "Consulta de Eventos"},
                        {"Minhas Contribuições"},
                        {"~CONFIGURAÇÕES~"},
                        {"Ajuda", "Fale conosco", "Sobre nós", "Ajuda"},
                        {"Configurações", "Dark Theme", "Light Theme"},
                        {"Logout"}
                    };
                };

                String icons[] = {
                    "dashboard.svg",
                    "chat.svg",
                    "email.svg",
                    "calendar.svg",
                    "ui.svg",
                    "forms.svg",
                    "chart.svg",
                    "icon.svg",
                    "page.svg",
                    "page.svg",
                    "logout.svg"};

                return new SimpleMenuOption()
                        .setMenus(menus)
                        .setIcons(icons)
                        .setBaseIconPath("RW/Drawer/icon")
                        .setIconScale(0.45f)
                        .addMenuEvent(new MenuEvent() {
                            public void selected(MenuAction action, int index, int subIndex) {

                                if (index == 0) {
                                    WindowsTabbed.getInstance().addTab("Meu Perfil", new MeuPerfilTela(codPerfil, codUsuario));
                                }
                                if (index == 1) {
                                    WindowsTabbed.getInstance().addTab("Chat", new ChatTela());
                                }
                                if (index == 2) {
                                    WindowsTabbed.getInstance().addTab("Forum", new ForumTela());
                                }
                                if (index == 3) {
                                    if ("1".equals(codPerfil)) {
                                        WindowsTabbed.getInstance().addTab("Gestão de Mudas", new CadastroMudasTela());
                                    } else {
                                        WindowsTabbed.getInstance().addTab("Doações Livres", new DoacaoLivreTela());
                                    }
                                }
                                if (index == 4) {
                                    if ("1".equals(codPerfil)) {
                                        WindowsTabbed.getInstance().addTab("Doações Livres", new DoacaoLivreTela());
                                    }
                                }

                                if (index == 4 && subIndex == 1) {
                                    WindowsTabbed.getInstance().addTab("Consultar Eventos", new ConsultaEventosTela());
                                }
                                if (index == 5) {
                                    if ("2".equals(codPerfil)) {
                                        WindowsTabbed.getInstance().addTab("Minhas Contribuições", new MinhasContribuicoesTela());
                                    }
                                }
                                if (index == 5 && subIndex == 1) {
                                    WindowsTabbed.getInstance().addTab("Criar Evento", new CadastroEventosTela());
                                }
                                if (index == 5 && subIndex == 2) {
                                    WindowsTabbed.getInstance().addTab("Consultar Eventos", new ConsultaEventosTela());
                                }
                                if (index == 6) {
                                    if ("1".equals(codPerfil)) {
                                        WindowsTabbed.getInstance().addTab("Minhas Contribuições", new MinhasContribuicoesTela());
                                    }
                                }
                                if (index == 6 && subIndex == 1) {
                                    if ("2".equals(codPerfil)) {
                                        WindowsTabbed.getInstance().addTab("Fale conosco", new FaleConoscoTela(codUsuario));
                                    }
                                }
                                if (index == 6 && subIndex == 2) {
                                    if ("2".equals(codPerfil)) {
                                        WindowsTabbed.getInstance().addTab("Sobre nós", new SobreNosTela());
                                    }
                                }
                                if (index == 6 && subIndex == 3) {
                                    if ("2".equals(codPerfil)) {
                                        WindowsTabbed.getInstance().addTab("Ajuda", new AjudaTela());
                                    }
                                }
                                if (index == 7 && subIndex == 1) {
                                    if ("1".equals(codPerfil)) {
                                        WindowsTabbed.getInstance().addTab("Fale conosco", new FaleConoscoTela(codUsuario));
                                    } else {
                                        changeMode(true);
                                    }
                                }
                                if (index == 7 && subIndex == 2) {
                                    if ("1".equals(codPerfil)) {
                                        WindowsTabbed.getInstance().addTab("Sobre nós", new SobreNosTela());
                                    } else {
                                        changeMode(false);
                                    }
                                }
                                if (index == 7 && subIndex == 3) {
                                    WindowsTabbed.getInstance().addTab("Ajuda", new AjudaTela());
                                }
                                if (index == 8) {
                                    if ("2".equals(codPerfil)) {
                                        String userDir = System.getProperty("user.dir");
                                        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir + "/src/vlc-3.0.16");
                                        NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir + "/src/vlc-3.0.16/vlc-3.0.16");
                                        Main main = new Main();
                                        main.setVisible(true);
                                        dispose();
                                    }
                                }
                                if (index == 9) {
                                    WindowsTabbed.getInstance().addTab("Gestão de Usuários", new GestaoUsuariosTela());
                                }
                                if (index == 8 && subIndex == 1) {
                                    changeMode(true);
                                }
                                if (index == 8 && subIndex == 2) {
                                    changeMode(false);
                                }
                                if (index == 10) {

                                    String userDir = System.getProperty("user.dir");
                                    NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir + "/src/vlc-3.0.16");
                                    NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir + "/src/vlc-3.0.16/vlc-3.0.16");
                                    Main main = new Main();
                                    main.setVisible(true);
                                    dispose();
                                }
                                System.err.println("Menu selected " + index + " " + subIndex);
                            }
                        })
                        .setMenuValidation(new MenuValidation() {
                            @Override
                            public boolean menuValidation(int index, int subIndex) {
                                return true;
                            }

                        });
            }

            @Override

            public SimpleFooterData getSimpleFooterData() {
                return new SimpleFooterData()
                        .setTitle("Reforest World")
                        .setDescription("Versão 2024");
            }

        };
        Drawer.getInstance().setDrawerBuilder(myDrawerbuilder);
        initComponents();
        WindowsTabbed.getInstance().install(this, body);
        this.setExtendedState(Frame.MAXIMIZED_BOTH);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        body = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));

        body.setMaximumSize(new java.awt.Dimension(1024, 768));
        body.setMinimumSize(new java.awt.Dimension(1024, 768));
        body.setPreferredSize(new java.awt.Dimension(1024, 768));
        body.setLayout(new java.awt.BorderLayout());

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(body, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel body;
    // End of variables declaration//GEN-END:variables
}
