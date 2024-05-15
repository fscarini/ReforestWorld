package RW.forms;

import RW.Tabbed.TabbedForm;
import RW.controller_dao.ConexaoController;
import java.awt.Image;
import java.io.FileInputStream;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.filechooser.FileNameExtensionFilter;

public class CadastroMudasTela extends TabbedForm {

    private FileInputStream fis;
    private int tamanho;
    private boolean fotoCarregada = false;

    public CadastroMudasTela() {
        initComponents();
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
                Image foto = ImageIO.read(jfc.getSelectedFile()).getScaledInstance(ImagemMudaLabel.getWidth(),
                        ImagemMudaLabel.getHeight(), Image.SCALE_SMOOTH);
                ImagemMudaLabel.setIcon(new ImageIcon(foto));
                ImagemMudaLabel.updateUI();
                fotoCarregada = true;
            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }
    // Função Cadastrar

    private void cadastrar() {
        ConexaoController cadastro = new ConexaoController();
        try {
            cadastro.cadastroMuda(this);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro. Por favor, tente novamente em alguns instantes.\n Caso o erro persista acione o suporte.");
            Logger.getLogger(CadastroMudasTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void buscar() {
        ConexaoController cadastro = new ConexaoController();
        try {
            cadastro.buscaCadastroMuda(this);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro. Por favor, tente novamente em alguns instantes.\n Caso o erro persista acione o suporte.");
            Logger.getLogger(CadastroMudasTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void reset() {
        BuscarTextField.setText(null);
        CaracteristicasTextArea.setText(null);
        EstadoTextField.setText(null);
        ImagemMudaLabel.setIcon(new ImageIcon(CadastroMudasTela.class.getResource("/imagens/camera (1).png")));
        NomeCientificoTextField.setText(null);
        NomeComercialTextField.setText(null);
        StatusTextField.setText(null);
        UsosTextArea.setText(null);
        ValorTextField.setText(null);
        BuscarTextField.requestFocus();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        NomeComercialTextField = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        CaracteristicasTextArea = new javax.swing.JTextArea();
        NomeCientificoTextField = new javax.swing.JTextField();
        ValorTextField = new javax.swing.JTextField();
        NomeCientificoLabel = new javax.swing.JLabel();
        NomeComercialLabel = new javax.swing.JLabel();
        ValorLabel = new javax.swing.JLabel();
        CaracteristicasLabel = new javax.swing.JLabel();
        CadastrarMudaButton = new javax.swing.JButton();
        LimparButton = new javax.swing.JButton();
        EstadoTextField = new javax.swing.JTextField();
        EstadoLabel = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        StatusTextField = new javax.swing.JTextField();
        jScrollPane2 = new javax.swing.JScrollPane();
        UsosTextArea = new javax.swing.JTextArea();
        UsosComunsLabel = new javax.swing.JLabel();
        AtualizarMudaButton = new javax.swing.JButton();
        ImagemMudaLabel = new javax.swing.JLabel();
        CarregarImagemButton = new javax.swing.JButton();
        ImagemLabel = new javax.swing.JLabel();
        BuscaLabel = new javax.swing.JLabel();
        BuscarTextField = new javax.swing.JTextField();
        BuscarButton = new javax.swing.JButton();

        CaracteristicasTextArea.setColumns(20);
        CaracteristicasTextArea.setRows(5);
        jScrollPane1.setViewportView(CaracteristicasTextArea);

        NomeCientificoLabel.setText("Nome Científico");

        NomeComercialLabel.setText("Nome Comercial");

        ValorLabel.setText("Valor");

        CaracteristicasLabel.setText("Caracteristicas Gerais");

        CadastrarMudaButton.setText("Cadastrar");
        CadastrarMudaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarMudaButtonActionPerformed(evt);
            }
        });

        LimparButton.setText("Limpar");
        LimparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparButtonActionPerformed(evt);
            }
        });

        EstadoLabel.setText("Estado");

        jLabel6.setText("Status");

        UsosTextArea.setColumns(20);
        UsosTextArea.setRows(5);
        jScrollPane2.setViewportView(UsosTextArea);

        UsosComunsLabel.setText("Usos Comuns");

        AtualizarMudaButton.setText("Atualizar");
        AtualizarMudaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarMudaButtonActionPerformed(evt);
            }
        });

        ImagemMudaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagemMudaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/camera (1).png"))); // NOI18N
        ImagemMudaLabel.setAlignmentY(0.0F);

        CarregarImagemButton.setText("Anexar Imagem");
        CarregarImagemButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CarregarImagemButtonActionPerformed(evt);
            }
        });

        ImagemLabel.setText("Imagem da espécie");

        BuscaLabel.setText("Buscar por nome científico");

        BuscarButton.setText("Buscar");
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BuscaLabel)
                        .addGap(18, 18, 18)
                        .addComponent(BuscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(BuscarButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(UsosComunsLabel)
                            .addComponent(NomeComercialLabel)
                            .addComponent(ValorLabel)
                            .addComponent(CaracteristicasLabel)
                            .addComponent(EstadoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2)
                            .addComponent(EstadoTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ValorTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NomeComercialTextField, javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addComponent(LimparButton)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(CadastrarMudaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(AtualizarMudaButton)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(NomeCientificoLabel)
                                    .addGap(18, 18, 18)
                                    .addComponent(NomeCientificoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel6)
                                    .addGap(18, 18, 18)
                                    .addComponent(StatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                                .addComponent(ImagemLabel)
                                .addComponent(ImagemMudaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 235, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(CarregarImagemButton)))))
                .addContainerGap(60, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(25, 25, 25)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscaLabel)
                    .addComponent(BuscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarButton))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeComercialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeComercialLabel)
                    .addComponent(NomeCientificoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeCientificoLabel))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ValorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ValorLabel)
                    .addComponent(StatusTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(EstadoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(EstadoLabel))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(28, 28, 28)
                                .addComponent(CaracteristicasLabel))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(34, 34, 34)
                                .addComponent(UsosComunsLabel)))
                        .addGap(28, 28, 28)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(LimparButton)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(AtualizarMudaButton)
                                .addComponent(CadastrarMudaButton))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(ImagemLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(ImagemMudaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(CarregarImagemButton)))
                .addGap(41, 41, 41))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
    }// </editor-fold>//GEN-END:initComponents

    // chama a ação do botão cadastrar
    private void CadastrarMudaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CadastrarMudaButtonActionPerformed
        cadastrar();
        reset();
    }//GEN-LAST:event_CadastrarMudaButtonActionPerformed

    private void LimparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LimparButtonActionPerformed
        reset();
    }//GEN-LAST:event_LimparButtonActionPerformed

    private void AtualizarMudaButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AtualizarMudaButtonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AtualizarMudaButtonActionPerformed

    private void CarregarImagemButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CarregarImagemButtonActionPerformed
        carregarFoto();
    }//GEN-LAST:event_CarregarImagemButtonActionPerformed

    private void BuscarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BuscarButtonActionPerformed
        buscar();
    }//GEN-LAST:event_BuscarButtonActionPerformed

    public FileInputStream getFis() {
        return fis;
    }

    public void setFis(FileInputStream fis) {
        this.fis = fis;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    public JTextField getBuscarTextField() {
        return BuscarTextField;
    }

    public void setBuscarTextField(JTextField BuscarTextField) {
        this.BuscarTextField = BuscarTextField;
    }

    public JTextArea getCaracteristicasTextArea() {
        return CaracteristicasTextArea;
    }

    public void setCaracteristicasTextArea(JTextArea CaracteristicasTextArea) {
        this.CaracteristicasTextArea = CaracteristicasTextArea;
    }

    public JTextField getEstadoTextField() {
        return EstadoTextField;
    }

    public void setEstadoTextField(JTextField EstadoTextField) {
        this.EstadoTextField = EstadoTextField;
    }

    public JTextField getNomeCientificoTextField() {
        return NomeCientificoTextField;
    }

    public void setNomeCientificoTextField(String nomeCientifico) {
        NomeCientificoTextField.setText(nomeCientifico);
    }

    public JTextField getNomeComercialTextField() {
        return NomeComercialTextField;
    }

    public void setNomeComercialTextField(String nomeComercial) {
        NomeComercialTextField.setText(nomeComercial);
    }

    public JTextField getStatusTextField() {
        return StatusTextField;
    }

    public void setStatusTextField(JTextField StatusTextField) {
        this.StatusTextField = StatusTextField;
    }

    public JTextArea getUsosTextArea() {
        return UsosTextArea;
    }

    public void setUsosTextArea(JTextArea UsosTextArea) {
        this.UsosTextArea = UsosTextArea;
    }

    public JTextField getValorTextField() {
        return ValorTextField;
    }

    public void setValorTextField(JTextField ValorTextField) {
        this.ValorTextField = ValorTextField;
    }

    public JLabel getImagemMudaLabel() {
        return ImagemMudaLabel;
    }

    public void setImagemMudaLabel(ImageIcon icon) {
    // Obtém a largura e a altura do JLabel
    int labelWidth = ImagemMudaLabel.getWidth();
    int labelHeight = ImagemMudaLabel.getHeight();
    
    // Carrega a imagem original do ImageIcon
    Image imagemOriginal = icon.getImage();
    
    // Redimensiona a imagem para caber no JLabel
    Image imagemRedimensionada = imagemOriginal.getScaledInstance(labelWidth, labelHeight, Image.SCALE_SMOOTH);
    
    // Cria um novo ImageIcon com a imagem redimensionada
    ImageIcon novoIcon = new ImageIcon(imagemRedimensionada);
    
    // Define o novo ImageIcon como o ícone do JLabel
    ImagemMudaLabel.setIcon(novoIcon);
    
    // Atualiza o JLabel para refletir a mudança
    ImagemMudaLabel.repaint();
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtualizarMudaButton;
    private javax.swing.JLabel BuscaLabel;
    private javax.swing.JButton BuscarButton;
    private javax.swing.JTextField BuscarTextField;
    private javax.swing.JButton CadastrarMudaButton;
    private javax.swing.JLabel CaracteristicasLabel;
    private javax.swing.JTextArea CaracteristicasTextArea;
    private javax.swing.JButton CarregarImagemButton;
    private javax.swing.JLabel EstadoLabel;
    private javax.swing.JTextField EstadoTextField;
    private javax.swing.JLabel ImagemLabel;
    private javax.swing.JLabel ImagemMudaLabel;
    private javax.swing.JButton LimparButton;
    private javax.swing.JLabel NomeCientificoLabel;
    private javax.swing.JTextField NomeCientificoTextField;
    private javax.swing.JLabel NomeComercialLabel;
    private javax.swing.JTextField NomeComercialTextField;
    private javax.swing.JTextField StatusTextField;
    private javax.swing.JLabel UsosComunsLabel;
    private javax.swing.JTextArea UsosTextArea;
    private javax.swing.JLabel ValorLabel;
    private javax.swing.JTextField ValorTextField;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables

}
