import javax.swing.ImageIcon;
import javax.swing.JButton;
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
    ImageIcon i1 = new ImageIcon(getClass().getResource("Group20.jpg"));

     // caixa de texto
     JTextField caixaPrimeiroNome = new JTextField("", 30);
     JTextField caixaSegundoNome = new JTextField("", 30);
     JTextField caixaEmail = new JTextField("", 30);
     JTextField caixaSenha = new JTextField("", 30);
     JTextField caixaConfirmaSenha = new JTextField("", 30);
     JTextField caixaCpf = new JTextField("", 30);
     JTextField caixaDataDeNascimento = new JTextField("", 30);
     JTextField caixaNumeroTelefone = new JTextField("", 30);

     JButton botaoVoltar = new JButton("Ja tenho conta");


    


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

    //configuração da ação do botão
    public void actionPerformed (ActionEvent e) {

        if (e.getSource()==botaoVoltar) {
            TelaLogin telaLogin = new TelaLogin();
            telaLogin.setVisible(true);
            // Fecha a tela anterior
            dispose();
        }
        
    }

    public TelaCadastro() {
        setLayout(new FlowLayout());

        // criar o painel com a imagem de fundo
        ImagePanel imagePanel = new ImagePanel(i1.getImage());

        // adicionar botões e caixas de texto no painel da imagem
        imagePanel.add(caixaPrimeiroNome);
        imagePanel.add(caixaSegundoNome);
        imagePanel.add(caixaEmail);
        imagePanel.add(caixaSenha);
        imagePanel.add(caixaConfirmaSenha);
        imagePanel.add(caixaCpf);
        imagePanel.add(caixaDataDeNascimento);
        imagePanel.add(caixaNumeroTelefone);
        imagePanel.add(botaoVoltar);


        // adicionar o painel com a imagem de fundo ao JFrame
        add(imagePanel);

        // tela
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        pack(); // redimensiona o JFrame para caber os componentes
        setLocationRelativeTo(null);
        setVisible(true);

        //caixa de texto
        caixaPrimeiroNome.setText("Primeiro nome");
        System.out.println(caixaPrimeiroNome.getText());
        caixaPrimeiroNome.setBounds(0, 0, 100, 30);
        setLayout(null);
        caixaPrimeiroNome.setLocation(20, 110);

        caixaSegundoNome.setText("Segundo nome");
        System.out.println(caixaPrimeiroNome.getText());
        caixaSegundoNome.setBounds(0, 0, 100, 30);
        setLayout(null);
        caixaSegundoNome.setLocation(130, 110);

        caixaEmail.setText("E-mail");
        System.out.println(caixaPrimeiroNome.getText());
        caixaEmail.setBounds(0, 0, 210, 30);
        setLayout(null);
        caixaEmail.setLocation(20, 160);

        caixaSenha.setText("Senha");
        System.out.println(caixaPrimeiroNome.getText());
        caixaSenha.setBounds(0, 0, 210, 30);
        setLayout(null);
        caixaSenha.setLocation(20, 210);

        caixaConfirmaSenha.setText("Confirme a senha");
        System.out.println(caixaPrimeiroNome.getText());
        caixaConfirmaSenha.setBounds(0, 0, 210, 30);
        setLayout(null);
        caixaConfirmaSenha.setLocation(20, 260);

        caixaCpf.setText("CPF");
        System.out.println(caixaPrimeiroNome.getText());
        caixaCpf.setBounds(0, 0, 210, 30);
        setLayout(null);
        caixaCpf.setLocation(250, 110);

        caixaDataDeNascimento.setText("Data de nascimento");
        System.out.println(caixaPrimeiroNome.getText());
        caixaDataDeNascimento.setBounds(0, 0, 210, 30);
        setLayout(null);
        caixaDataDeNascimento.setLocation(250, 160);

        caixaNumeroTelefone.setText("Numero de telefone");
        System.out.println(caixaPrimeiroNome.getText());
        caixaNumeroTelefone.setBounds(0, 0, 210, 30);
        setLayout(null);
        caixaNumeroTelefone.setLocation(250, 210);

        //configuraçoes dos botoes
        botaoVoltar.setBounds(0, 0, 160, 40);
        setLayout(null);
        botaoVoltar.setLocation(10, 13);

        // adicionar botões e caixas de texto no painel da imagem
        botaoVoltar.addActionListener(this);

        // Configuração de auto-apagável para caixas
        caixaPrimeiroNome.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixaPrimeiroNome.getText().equals("Primeiro nome")) {
                    caixaPrimeiroNome.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixaPrimeiroNome.getText().isEmpty()) {
                    caixaPrimeiroNome.setText("Primeiro nome");
                }
            }
        });

        caixaSegundoNome.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixaSegundoNome.getText().equals("Segundo nome")) {
                    caixaSegundoNome.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixaSegundoNome.getText().isEmpty()) {
                    caixaSegundoNome.setText("Segundo nome");
                }
            }
        });

        caixaEmail.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixaEmail.getText().equals("E-MAIL")) {
                    caixaEmail.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixaEmail.getText().isEmpty()) {
                    caixaEmail.setText("E-MAIL");
                }
            }
        });

        caixaSenha.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixaSenha.getText().equals("Senha")) {
                    caixaSenha.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixaSenha.getText().isEmpty()) {
                    caixaSenha.setText("Senha");
                }
            }
        });

        caixaConfirmaSenha.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixaConfirmaSenha.getText().equals("Confirme a Senha")) {
                    caixaConfirmaSenha.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixaConfirmaSenha.getText().isEmpty()) {
                    caixaConfirmaSenha.setText("Confirme a Senha");
                }
            }
        });

        caixaCpf.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixaCpf.getText().equals("CPF")) {
                    caixaCpf.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixaCpf.getText().isEmpty()) {
                    caixaCpf.setText("CPF");
                }
            }
        });

        caixaDataDeNascimento.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixaDataDeNascimento.getText().equals("Data de nascimento")) {
                    caixaDataDeNascimento.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixaDataDeNascimento.getText().isEmpty()) {
                    caixaDataDeNascimento.setText("Data de nascimento");
                }
            }
        });

        caixaNumeroTelefone.addFocusListener(new FocusListener() {
            
            public void focusGained(FocusEvent e) {
                if (caixaNumeroTelefone.getText().equals("Numero de Telefone")) {
                    caixaNumeroTelefone.setText("");
                }
            }

            
            public void focusLost(FocusEvent e) {
                if (caixaNumeroTelefone.getText().isEmpty()) {
                    caixaNumeroTelefone.setText("Numero de Telefone");
                }
            }
        });

    }

    public static void main(String[] args) {
        new TelaCadastro();
    }
}
