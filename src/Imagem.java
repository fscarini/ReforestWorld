import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class Imagem extends JFrame {

    // imagens
    ImageIcon i1 = new ImageIcon(getClass().getResource("imagem1.jpg"));

    // botões
    JButton b1 =  new JButton("Cadastrar");
    JButton b2 =  new JButton("Entrar");

    // caixa de texto
    JTextField caixa1 = new JTextField("Usuario", 30);
    JTextField caixa2 = new JTextField("Senha", 30);

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

    public Imagem() {
        setLayout(new FlowLayout());

        // criar o painel com a imagem de fundo
        ImagePanel imagePanel = new ImagePanel(i1.getImage());

        // adicionar botões e caixas de texto no painel da imagem
        imagePanel.add(b1);
        imagePanel.add(b2);
        imagePanel.add(caixa1);
        imagePanel.add(caixa2);

        // adicionar o painel com a imagem de fundo ao JFrame
        add(imagePanel);

        // tela
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack(); // redimensiona o JFrame para caber os componentes
        setLocationRelativeTo(null);
        setVisible(true);

        b1.setBounds(0, 0, 110, 30);
        setLayout(null);
        b1.setLocation(50, 250);

        b2.setBounds(0, 0, 80, 30);
        setLayout(null);
        b2.setLocation(200, 250);

        //caixa de texto
        caixa1.setText("Usuario");
        System.out.println(caixa1.getText());
        caixa1.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa1.setLocation(50, 110);

        caixa2.setText("Senha");
        System.out.println(caixa1.getText());
        caixa2.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa2.setLocation(50, 170);

        // Configuração de auto-apagável para caixa1 (usuário)
        caixa1.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixa1.getText().equals("Usuario")) {
                    caixa1.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixa1.getText().isEmpty()) {
                    caixa1.setText("Usuario");
                }
            }
        });

        // Configuração de auto-apagável para caixa2 (senha)
        caixa2.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixa2.getText().equals("Senha")) {
                    caixa2.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixa2.getText().isEmpty()) {
                    caixa2.setText("Senha");
                }
            }
        });
    }

    public static void main(String[] args) {
        new Imagem();
    }
}
