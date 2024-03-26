import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

public class TelaCadastro extends JFrame implements ActionListener{

    // imagens
    ImageIcon i1 = new ImageIcon(getClass().getResource("imagem1.jpg"));

     // caixa de texto
     JTextField caixa1 = new JTextField("Usuario", 30);
     JTextField caixa2 = new JTextField("e-mail", 30);
     JTextField caixa3 = new JTextField("senha", 30);
     JTextField caixa4 = new JTextField("confirmar senha", 30);
     JTextField caixa5 = new JTextField("CPF", 30);
     JTextField caixa6 = new JTextField("Nome Completo", 30);
     JTextField caixa7 = new JTextField("CEP", 30);
     JTextField caixa8 = new JTextField("Usuario", 30);

    //configuração da ação do botão
    public void actionPerformed (ActionEvent e) {

        

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

    public TelaCadastro() {
        setLayout(new FlowLayout());

        // criar o painel com a imagem de fundo
        ImagePanel imagePanel = new ImagePanel(i1.getImage());

        // adicionar botões e caixas de texto no painel da imagem
        imagePanel.add(caixa1);
        imagePanel.add(caixa2);
        imagePanel.add(caixa3);
        imagePanel.add(caixa4);
        imagePanel.add(caixa5);
        imagePanel.add(caixa6);
        imagePanel.add(caixa7);
        imagePanel.add(caixa8);


        // adicionar o painel com a imagem de fundo ao JFrame
        add(imagePanel);

        // tela
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack(); // redimensiona o JFrame para caber os componentes
        setLocationRelativeTo(null);
        setVisible(true);

        //caixa de texto
        caixa1.setText("Usuario");
        System.out.println(caixa1.getText());
        caixa1.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa1.setLocation(20, 40);

        caixa2.setText("E-mail");
        System.out.println(caixa1.getText());
        caixa2.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa2.setLocation(20, 120);

        caixa3.setText("Senha");
        System.out.println(caixa1.getText());
        caixa3.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa3.setLocation(20, 210);

        caixa4.setText("Confirme sua senha");
        System.out.println(caixa1.getText());
        caixa4.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa4.setLocation(20, 290);

        caixa5.setText("Nome completo");
        System.out.println(caixa1.getText());
        caixa5.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa5.setLocation(320, 40);

        caixa6.setText("CPF");
        System.out.println(caixa1.getText());
        caixa6.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa6.setLocation(320, 120);

        caixa7.setText("Data de nascimento");
        System.out.println(caixa1.getText());
        caixa7.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa7.setLocation(320, 210);

        caixa8.setText("Numero de Telefone");
        System.out.println(caixa1.getText());
        caixa8.setBounds(0, 0, 230, 30);
        setLayout(null);
        caixa8.setLocation(320, 290);

        // Configuração de auto-apagável para caixas
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

        caixa2.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixa2.getText().equals("E-mail")) {
                    caixa2.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixa2.getText().isEmpty()) {
                    caixa2.setText("E-mail");
                }
            }
        });

        caixa3.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixa3.getText().equals("Senha")) {
                    caixa3.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixa3.getText().isEmpty()) {
                    caixa3.setText("Senha");
                }
            }
        });

        caixa4.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixa4.getText().equals("Confirme sua senha")) {
                    caixa4.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixa4.getText().isEmpty()) {
                    caixa4.setText("Confirme sua senha");
                }
            }
        });

        caixa5.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixa5.getText().equals("Nome completo")) {
                    caixa5.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixa5.getText().isEmpty()) {
                    caixa5.setText("Nome completo");
                }
            }
        });

        caixa6.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixa6.getText().equals("CPF")) {
                    caixa6.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixa6.getText().isEmpty()) {
                    caixa6.setText("CPF");
                }
            }
        });

        caixa7.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixa7.getText().equals("Data de nascimento")) {
                    caixa7.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixa7.getText().isEmpty()) {
                    caixa7.setText("Data de nascimento");
                }
            }
        });

        caixa8.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixa8.getText().equals("Numero de Telefone")) {
                    caixa8.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixa8.getText().isEmpty()) {
                    caixa8.setText("Numero de Telefone");
                }
            }
        });

    }

    public static void main(String[] args) {
        new TelaCadastro();
    }
}
