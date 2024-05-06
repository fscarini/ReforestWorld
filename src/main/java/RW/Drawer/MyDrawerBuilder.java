
package RW.Drawer;

import RW.Tabbed.WindowsTabbed;
import RW.forms.CadastroEventosTela;
import RW.forms.TelaHome;
import RW.forms.Teste;
import RW.forms.Teste1;
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
            {"Cadastro de Mudas"},
            {"Doações Livres"},
            {"Eventos", "Cadastro de Eventos", "Consulta de Eventos"},
            {"Minhas Contribuições"},
            {"~CONFIGURAÇÕES~"},
            {"Ajuda", "Fale conosco", "Sobre nos", "Ajuda"},
            {"Configurações"},
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
            "logout.svg"};
            
        return new SimpleMenuOption()
               .setMenus(menus)
               .setIcons(icons)
               .setBaseIconPath("RW/Drawer/icon")
               .setIconScale(0.45f)
               .addMenuEvent(new MenuEvent() {
                    public void selected(MenuAction action, int index, int subIndex) {
                        if (index == 0) {
                        WindowsTabbed.getInstance().addTab("Test", new Teste());
                        }
                        if (index == 2) {
                        WindowsTabbed.getInstance().addTab("Test1", new Teste1());
                        }
                        if(index == 5 && subIndex == 1){
                            WindowsTabbed.getInstance().addTab("Criar Evento", new CadastroEventosTela());
                        }
                        if (index == 9) {
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
