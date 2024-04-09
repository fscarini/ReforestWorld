import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaInicio extends JFrame implements ActionListener{

    // imagens
    ImageIcon i1 = new ImageIcon(getClass().getResource("Group18.jpg"));

    // botões
    JButton b1 =  new JButton("CRIAR USUARIO");    
    JButton b2 =  new JButton("ENTRAR");

        //configuração da ação do botão
    public void actionPerformed (ActionEvent e) {

        if (e.getSource()==b1) {
            TelaCadastro telaCadastro = new TelaCadastro();
            telaCadastro.setVisible(true);
            // Fecha a tela anterior
            dispose();
        }
        if (e.getSource()==b2) {
            TelaLogin TelaLogin = new TelaLogin();
            TelaLogin.setVisible(true);
            // Fecha a tela anterior
            dispose();
        }
        
    }

    // painel para a imagem de fundo
    private class ImagePanel extends JPanel {
        private Image image;

        public ImagePanel(Image image) {
            this.image = image;
            Dimension size = new Dimension(image.getWidth(null), image.getHeight(null));
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
        }

        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawImage(image, 0, 0, null);
        }
    }

    public TelaInicio() {
        setLayout(new FlowLayout());

        // criar o painel com a imagem de fundo
        ImagePanel imagePanel = new ImagePanel(i1.getImage());

        // adicionar botões e caixas de texto no painel da imagem
        imagePanel.add(b1);
        imagePanel.add(b2);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        // adicionar o painel com a imagem de fundo ao JFrame
        add(imagePanel);

        // tela
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack(); // redimensiona o JFrame para caber os componentes
        setLocationRelativeTo(null);
        setVisible(true);

        //configuraçoes dos botoes
        b1.setBounds(0, 0, 213, 40);
        setLayout(null);
        b1.setLocation(390, 355);

        b2.setBounds(0, 0, 213, 40);
        setLayout(null);
        b2.setLocation(670, 355);

                
    }

    public static void main(String[] args) {
        new TelaInicio();
    }
}
