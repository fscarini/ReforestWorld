package RW.forms;

import RW.Tabbed.TabbedForm;
import RW.controller_dao.ConexaoController;
import java.awt.Image;
import java.sql.SQLException;
import javax.swing.text.MaskFormatter;
import javax.swing.JOptionPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CadastroEventosTela extends TabbedForm {

    private FileInputStream fis;
    private int tamanho;
    private boolean fotoCarregada = false;
    private String codUsuario;
    private int resultadoSlider;
    private int resultadoSliderClick;

    public CadastroEventosTela(String codUsuario) {
        this.codUsuario = codUsuario;
        initComponents();
        cidadeTextField.setEnabled(false);
        estadoComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (estadoComboBox.getSelectedIndex() != 0) {
                    cidadeTextField.setEnabled(true);
                } else {
                    cidadeTextField.setEnabled(false);
                }
            }
        });
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        ImagemPanel = new javax.swing.JPanel();
        ImagemEventoLabel = new javax.swing.JLabel();
        ImagemLabel = new javax.swing.JLabel();
        CarregarImagemButton = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        nomeEventoTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        estadoComboBox = new javax.swing.JComboBox<>();
        cidadeTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        terminoTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        doacoesSlider = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        descricaoTextArea = new javax.swing.JTextArea();
        jLabel5 = new javax.swing.JLabel();
        limparButton = new javax.swing.JButton();
        cadastrarEventoButton = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        inicioTextField = new javax.swing.JTextField();

        ImagemEventoLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagemEventoLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/camera (1).png"))); // NOI18N
        ImagemEventoLabel.setAlignmentY(0.0F);

        ImagemLabel.setText("Imagem do Evento");

        CarregarImagemButton.setText("Anexar Imagem");
        CarregarImagemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarregarImagemButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ImagemPanelLayout = new javax.swing.GroupLayout(ImagemPanel);
        ImagemPanel.setLayout(ImagemPanelLayout);
        ImagemPanelLayout.setHorizontalGroup(
            ImagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagemPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ImagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(ImagemEventoLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagemPanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(ImagemLabel)
                        .addGap(121, 121, 121))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ImagemPanelLayout.createSequentialGroup()
                .addContainerGap(102, Short.MAX_VALUE)
                .addComponent(CarregarImagemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(96, 96, 96))
        );
        ImagemPanelLayout.setVerticalGroup(
            ImagemPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ImagemPanelLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(ImagemLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImagemEventoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CarregarImagemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jLabel1.setText("Nome do evento");

        jLabel2.setText("Estado");

        estadoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "AC", "AL", "AP", "AM", "BA", "CE", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jLabel3.setText("Início");

        jLabel6.setText("Meta de doações");

        doacoesSlider.setMaximum(5000);
        doacoesSlider.setToolTipText("");
        doacoesSlider.setBorder(javax.swing.BorderFactory.createTitledBorder("R$ 0,00"));
        doacoesSlider.addMouseMotionListener(new java.awt.event.MouseMotionAdapter() {
            public void mouseDragged(java.awt.event.MouseEvent evt) {
                doacoesSliderMouseDragged(evt);
            }
        });
        doacoesSlider.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                doacoesSliderMouseClicked(evt);
            }
        });

        jLabel4.setText("Descrição do evento");

        descricaoTextArea.setColumns(20);
        descricaoTextArea.setRows(5);
        jScrollPane1.setViewportView(descricaoTextArea);

        jLabel5.setText("Cidade");

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });

        cadastrarEventoButton.setText("Cadastrar evento");
        cadastrarEventoButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarEventoButtonActionPerformed(evt);
            }
        });

        jLabel7.setText("Término");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(169, 169, 169)
                        .addComponent(limparButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cadastrarEventoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                                    .addContainerGap()
                                    .addComponent(jLabel1))
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addGap(109, 109, 109)
                                    .addComponent(jLabel2)))
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel2Layout.createSequentialGroup()
                                    .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel5)
                                    .addGap(18, 18, 18)
                                    .addComponent(cidadeTextField))
                                .addComponent(nomeEventoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(doacoesSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(inicioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(terminoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(32, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(20, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeEventoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(estadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cidadeTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(inicioTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(terminoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(doacoesSlider, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(42, 42, 42)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(limparButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cadastrarEventoButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(68, 68, 68)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ImagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(167, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(71, 71, 71)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(ImagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(193, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    public void carregarCidadesPorEstado() {
        int codigoEstado = getEstadoComboBox();
        if (codigoEstado == 1) {

        }
    }

    private void carregarFoto() {
        JFileChooser jfc = new JFileChooser();
        jfc.setDialogTitle("Selecionar arquivo");
        jfc.setFileFilter(new FileNameExtensionFilter("Arquivo de imagens (*.PNG,*.JPG,*.JPEG)", "png", "jpg", "jpeg"));
        int resultado = jfc.showOpenDialog(this);
        if (resultado == JFileChooser.APPROVE_OPTION) {
            try {
                fis = new FileInputStream(jfc.getSelectedFile());
                tamanho = (int) jfc.getSelectedFile().length();
                Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(ImagemEventoLabel.getWidth(),
                        ImagemEventoLabel.getHeight(), Image.SCALE_SMOOTH);
                ImagemEventoLabel.setIcon(new ImageIcon(foto));
                ImagemEventoLabel.updateUI();
                fotoCarregada = true;
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    // Função Cadastrar
    private void cadastrar() {
        ConexaoController cadastro = new ConexaoController();
        try {
            cadastro.cadastroEvento(this);

        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro. Por favor, tente novamente em alguns instantes.\n Caso o erro persista acione o suporte.");
        }
    }

    // Chama a ação do botão cadastrar
    private void cadastrarEventoButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarEventoButtonActionPerformed
        String mensagemErro = verificarCamposCadastro();
        if (mensagemErro.isEmpty()) {
            cadastrar();
            limparCampos();
            JOptionPane.showMessageDialog(null, "Parabéns, seu evento foi cadastrado com sucesso!");
        } else {
            JOptionPane.showMessageDialog(null, mensagemErro);
        }
    }//GEN-LAST:event_cadastrarEventoButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        limparCampos();
    }//GEN-LAST:event_limparButtonActionPerformed

    private void doacoesSliderMouseDragged(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doacoesSliderMouseDragged
        //  Insere ou remove valores exibidos enquanto deslizado
        resultadoSlider = doacoesSlider.getValue();
        doacoesSlider.setBorder(javax.swing.BorderFactory.createTitledBorder("R$ " + resultadoSlider));
    }//GEN-LAST:event_doacoesSliderMouseDragged

    private void doacoesSliderMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_doacoesSliderMouseClicked
        // Pega o valor do slider quando for dado um click
        resultadoSliderClick = doacoesSlider.getValue();
        doacoesSlider.setBorder(javax.swing.BorderFactory.createTitledBorder("R$ " + resultadoSliderClick));
    }//GEN-LAST:event_doacoesSliderMouseClicked

    private void CarregarImagemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarregarImagemButtonActionPerformed
        carregarFoto();
    }//GEN-LAST:event_CarregarImagemButtonActionPerformed

    // Validar preenchimento dos campos
    private String verificarCamposCadastro() {
        StringBuilder mensagemErro = new StringBuilder();
        if (nomeEventoTextField.getText().isEmpty()) {
            mensagemErro.append("Por favor, preencha o campo: Nome do evento. \n");
        }
        if (terminoTextField.getText().isEmpty()) {
            mensagemErro.append("Por favor, preencha o campo: Data do evento.\n");
        }
        if (estadoComboBox.getItemCount() == 0) {
            mensagemErro.append("Por favor, preencha o campo: Estado.\n");
        }
        if (cidadeTextField.getText().isEmpty()) {
            mensagemErro.append("Por favor, preencha o campo: Cidade.\n");
        }
        if (descricaoTextArea.getText().isEmpty()) {
            mensagemErro.append("Por favor, preencha o campo: Descricao do evento.\n");
        }
        if (doacoesSlider.getValue() == 0) {
            mensagemErro.append("Por favor, coloque uma meta para doações. \n");
        }
        return mensagemErro.toString();
    }

    public void limparCampos() {
        nomeEventoTextField.setText("");
        inicioTextField.setText("");
        terminoTextField.setText("");
        descricaoTextArea.setText("");
        estadoComboBox.setSelectedIndex(0);
        cidadeTextField.setText("");
        doacoesSlider.setValue(0);
        ImagemEventoLabel.setIcon(new ImageIcon(CadastroMudasTela.class.getResource("/imagens/camera (1).png")));
        doacoesSlider.setBorder(javax.swing.BorderFactory.createTitledBorder("R$ " + 0));
    }

//     Cria um formatador de máscara de data
//    private MaskFormatter createDateMaskFormatter() {
//        try {
//            return new MaskFormatter("##/##/####");
//        } catch (java.text.ParseException e) {
//            e.printStackTrace();
//            return null;
//        }
//    }
// getters
    public javax.swing.JTextField getInicioTextField() {
        return inicioTextField;
    }

    public javax.swing.JTextField getTerminoTextField() {
        return terminoTextField;
    }

    public javax.swing.JTextArea getDescricaoTextArea() {
        return descricaoTextArea;
    }

    public javax.swing.JTextField getNomeEventoTextField() {
        return nomeEventoTextField;
    }

    @SuppressWarnings("empty-statement")
    public int getEstadoComboBox() {
        int codigoEstado = 0;

        if ("AC".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 1;
        };
        if ("AL".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 2;
        };
        if ("AP".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 3;
        };
        if ("AM".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 4;
        };
        if ("BA".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 5;
        };
        if ("CE".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 6;
        };
        if ("ES".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 7;
        };
        if ("GO".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 8;
        };
        if ("MA".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 9;
        };
        if ("MT".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 10;
        };
        if ("MS".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 11;
        };
        if ("MG".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 12;
        };
        if ("PA".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 13;
        };
        if ("PB".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 14;
        };
        if ("PR".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 15;
        };
        if ("PE".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 16;
        };
        if ("PI".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 17;
        };
        if ("RJ".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 18;
        };
        if ("RN".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 19;
        };
        if ("RS".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 20;
        };
        if ("RO".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 21;
        };
        if ("RR".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 22;
        };
        if ("SC".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 23;
        };
        if ("SP".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 24;
        };
        if ("SE".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 25;
        };
        if ("TO".equals(estadoComboBox.getSelectedItem())) {
            codigoEstado = 26;
        };

        return codigoEstado;
    }

    public String getCidadeTextField() {
        return cidadeTextField.getText();
    }

    public javax.swing.JSlider getDoacoesSlider() {
        return doacoesSlider;
    }

    public FileInputStream getFis() {
        return fis;
    }

    public int getTamanho() {
        return tamanho;
    }
    
    public String getCodUsuario(){
        return codUsuario;
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CarregarImagemButton;
    private javax.swing.JLabel ImagemEventoLabel;
    private javax.swing.JLabel ImagemLabel;
    private javax.swing.JPanel ImagemPanel;
    private javax.swing.JButton cadastrarEventoButton;
    private javax.swing.JTextField cidadeTextField;
    private javax.swing.JTextArea descricaoTextArea;
    private javax.swing.JSlider doacoesSlider;
    private javax.swing.JComboBox<String> estadoComboBox;
    private javax.swing.JTextField inicioTextField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton limparButton;
    private javax.swing.JTextField nomeEventoTextField;
    private javax.swing.JTextField terminoTextField;
    // End of variables declaration//GEN-END:variables

}
