
package RW.Drawer;

import RW.Tabbed.WindowsTabbed;
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
            {"~MAIN~"},
            {"Dashboard"},
            {"~WEB APP~"},
            {"Email", "Inbox", "Read", "Compost"},
            {"Chat"},
            {"Calendar"},
            {"~COMPONENT~"},
            {"Advanced UI", "Cropper", "Owl Carousel", "Sweet Alert"},
            {"Forms", "Basic Elements", "Advanced Elements", "SEditors", "Wizard"},
            {"~OTHER~"},
            {"Charts", "Apex", "Flot", "Sparkline"},
            {"Icons", "Feather Icons", "Flag Icons", "Mdi Icons"},
            {"Special Pages", "Blank page", "Faq", "Invoice", "Profile", "Pricing", "Timeline"},
            {"Logout"}
        };
        
        String icons[] = {
            "dashboard.svg",
            "email.svg",
            "chat.svg",
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
                        if (index == 9) {
                            String userDir = System.getProperty("user.dir");
                            NativeLibrary.addSearchPath(RuntimeUtil.getLibVlcLibraryName(), userDir +"/src/vlc-3.0.16");
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
               if (index==0){
               return false;
               }else if (index==3){
                return false;
               }
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
