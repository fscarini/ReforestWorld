import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TelaLogin extends JFrame implements ActionListener{

    // imagens
    ImageIcon i1 = new ImageIcon(getClass().getResource("Group14.jpg"));

    // botões
    JButton b1 =  new JButton("Criar usuario");    
    JButton b2 =  new JButton("LOGIN");
    JButton showPasswordButton = new JButton("Mostrar Senha");

    // caixa de texto
    JTextField caixa1 = new JTextField("Usuario", 30);
    JPasswordField caixa2 = new JPasswordField(30);

    //configuração da ação do botão
    public void actionPerformed (ActionEvent e) {

        if (e.getSource()==b1) {
            TelaCadastro telaCadastro = new TelaCadastro();
            telaCadastro.setVisible(true);
            // Fecha a tela de login após abrir a tela de cadastro
            dispose();
        }
        if (e.getSource()==b2) {
            JOptionPane.showMessageDialog(null, "Usuario não encontrado");
        }
        if (e.getSource() == showPasswordButton) {
            if (caixa2.getEchoChar() == (char) 0) {
                caixa2.setEchoChar('*');
                showPasswordButton.setText("mostrar");
            } else {
                caixa2.setEchoChar((char) 0);
                showPasswordButton.setText("ocultar");
            }
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

    public TelaLogin() {
        setLayout(new FlowLayout());

        // criar o painel com a imagem de fundo
        ImagePanel imagePanel = new ImagePanel(i1.getImage());

        // adicionar botões e caixas de texto no painel da imagem
        imagePanel.add(b1);
        imagePanel.add(b2);
        imagePanel.add(caixa1);
        imagePanel.add(caixa2);
        imagePanel.add(showPasswordButton);

        b1.addActionListener(this);
        b2.addActionListener(this);
        showPasswordButton.addActionListener(this);

        // adicionar o painel com a imagem de fundo ao JFrame
        add(imagePanel);

        // tela
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack(); // redimensiona o JFrame para caber os componentes
        setLocationRelativeTo(null);
        setVisible(true);

        //configuraçoes dos botoes
        b1.setOpaque(false); // torna o botão transparente
        b1.setContentAreaFilled(false); // torna a área de conteúdo do botão transparente
        b1.setBorderPainted(false); // remove a pintura da borda do botão
        b1.setForeground(Color.WHITE); // define a cor do texto como branco

        b1.setBounds(0, 0, 200, 30);
        setLayout(null);
        b1.setLocation(290, 310);

        b2.setBounds(0, 0, 213, 40);
        setLayout(null);
        b2.setLocation(200, 270);

        //caixa de texto
        caixa1.setText("Usuario");
        caixa1.setOpaque(false); // torna a caixa de texto transparente
        caixa1.setForeground(Color.WHITE); // define a cor do texto como branco
        caixa1.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa1.setLocation(193, 160);

        // Configuração inicial para caixa2 (senha)
        caixa2.setEchoChar((char) 0); // Mostra o texto padrão
        caixa2.setText("Senha");
        caixa2.setForeground(Color.WHITE);
        caixa2.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                caixa2.setEchoChar('*'); // Quando o campo ganha foco, exibe asteriscos
                if (new String(caixa2.getPassword()).equals("Senha")) {
                    caixa2.setText("");
                }
            }

            public void focusLost(FocusEvent e) {
                if (caixa2.getPassword().length == 0) { // Se nada foi digitado
                    caixa2.setEchoChar((char) 0); // Mostra o texto padrão
                    caixa2.setText("Senha");
                }
            }
        });

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

        caixa2.setOpaque(false); // torna a caixa de texto transparente
        caixa2.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa2.setLocation(193, 220);

        // Botão para mostrar/esconder senha
        showPasswordButton.setOpaque(false); // torna o botão transparente
        showPasswordButton.setContentAreaFilled(false); // torna a área de conteúdo do botão transparente
        showPasswordButton.setBorderPainted(false); // remove a pintura da borda do botão
        showPasswordButton.setForeground(Color.WHITE); // define a cor do texto como branco
        showPasswordButton.setBounds(0, 0, 90, 30);
        setLayout(null);
        showPasswordButton.setLocation(410, 220);
    }

    public static void main(String[] args) {
        new TelaLogin();
    }
}
