
package RW.Drawer;

import RW.Tabbed.WindowsTabbed;
import RW.forms.AjudaTela;
import RW.forms.CadastroEventosTela;
import RW.forms.CadastroMudasTela;
import RW.forms.ChatTela;
import RW.forms.ConfiguracoesTela;
import RW.forms.ConsultaEventosTela;
import RW.forms.DoacaoLivreTela;
import RW.forms.FaleConoscoTela;
import RW.forms.ForumTela;
import RW.forms.GestaoUsuariosTela;
import RW.forms.MeuPerfilTela;
import RW.forms.MinhasContribuicoesTela;
import RW.forms.SobreNosTela;
import RW.forms.TelaHome;
import RW.main.Main;
import com.sun.jna.NativeLibrary;
import java.util.HashSet;
import java.util.Set;
import raven.drawer.component.SimpleDrawerBuilder;
import raven.drawer.component.footer.SimpleFooterData;
import raven.drawer.component.header.SimpleHeaderData;
import raven.drawer.component.menu.MenuAction;
import raven.drawer.component.menu.MenuEvent;
import raven.drawer.component.menu.MenuValidation;
import raven.drawer.component.menu.SimpleMenuOption;
import raven.swing.AvatarIcon;
import javax.swing.JMenu;
import uk.co.caprica.vlcj.binding.support.runtime.RuntimeUtil;


/**
 *
 * @author Guilherme Quiller
 */
public class MyDrawerBuilder extends SimpleDrawerBuilder{

    @Override
    public SimpleHeaderData getSimpleHeaderData() {
        return new SimpleHeaderData()
                //adicionar a foto para mudar de acordo o o usurio
                .setIcon(new AvatarIcon(getClass().getResource("/imagens/Reforest World Logo.png"),60,60, 999))
                //adicionar o nome da pessoa conforme ela logar, puxando do banco de dados
                .setTitle("nome do usuario")
                //adicionar o e-mail da pessoa que entrar
                .setDescription("o e-mail da pessoa");
        
        
    }

    @Override
    public SimpleMenuOption getSimpleMenuOption() {
        String menus[][] = {

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
            {"Configurações"},
            {"Gestão de Usuários"},
            {"Logout"}
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
                        WindowsTabbed.getInstance().addTab("Meu Perfil", new MeuPerfilTela());
                        }
                        if (index == 1) {
                        WindowsTabbed.getInstance().addTab("Chat", new ChatTela());
                        }
                        if (index == 2) {
                        WindowsTabbed.getInstance().addTab("Forum", new ForumTela());
                        }
                        if (index == 3) {
                        WindowsTabbed.getInstance().addTab("Gestão de Mudas", new CadastroMudasTela());
                        }
                        if (index == 4) {
                        WindowsTabbed.getInstance().addTab("Doações Livres", new DoacaoLivreTela());
                        }
                        if(index == 5 && subIndex == 1){
                            WindowsTabbed.getInstance().addTab("Criar Evento", new CadastroEventosTela());
                        }
                        if(index == 5 && subIndex == 2){
                            WindowsTabbed.getInstance().addTab("Consultar Eventos", new ConsultaEventosTela());
                        }
                        if (index == 6) {
                        WindowsTabbed.getInstance().addTab("Minhas Contribuições", new MinhasContribuicoesTela());
                        }
                        if (index == 7 && subIndex == 1) {
                        WindowsTabbed.getInstance().addTab("Fale conosco", new FaleConoscoTela());
                        }
                        if (index == 7 && subIndex == 2) {
                        WindowsTabbed.getInstance().addTab("Sobre nós", new SobreNosTela());
                        }
                        if (index == 7 && subIndex == 3) {
                        WindowsTabbed.getInstance().addTab("Ajuda", new AjudaTela());
                        }
                        if (index == 8) {
                        WindowsTabbed.getInstance().addTab("Configurações", new ConfiguracoesTela());
                        }
                        if (index == 9) {
                        WindowsTabbed.getInstance().addTab("Gestão de Usuários", new GestaoUsuariosTela());
                        }
                        if (index == 10) {

                            String userDir = System.getProperty("user.dir");
                            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir +"/src/vlc-3.0.16");
                            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir +"/src/vlc-3.0.16/vlc-3.0.16");
                            Main main = new Main();
                            main.setVisible(true);
//                            TelaHome.dispose();
                        } 
                        System.err.println("Menu selected "+index+" "+subIndex);
                    }
               })                
                .setMenuValidation(new  MenuValidation(){
            @Override
            public boolean menuValidation(int index, int subIndex) {
//               if (index==0){
//               return false;
//               }else if (index==3){
//                return false;
//               }
                return true;
            }
                    
                }) ;
    }

    @Override
    public SimpleFooterData getSimpleFooterData() {
        return new SimpleFooterData()
                .setTitle("Reforest World")
                .setDescription("Versão 2024");
        
    }
    
}
