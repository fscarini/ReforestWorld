package RW.forms;

import RW.Tabbed.TabbedForm;
import RW.controller_dao.ConexaoController;
import java.awt.Image;
import java.io.FileInputStream;
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
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }

    @SuppressWarnings("empty-statement")
    private int cadastrar() {
        ConexaoController cadastro = new ConexaoController();
        try {
            int retorno = cadastro.cadastroMuda(this);
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível realizar o cadastro.");
            };

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro. Por favor, tente novamente em alguns instantes.\n Caso o erro persista acione o suporte.");
            Logger.getLogger(CadastroMudasTela.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
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

    private void atualizar() {
        ConexaoController cadastro = new ConexaoController();
        try {
            cadastro.atualizaMuda(this);

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro. Por favor, tente novamente em alguns instantes.\n Caso o erro persista acione o suporte.");
            Logger.getLogger(CadastroMudasTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void reset() {
        BuscarTextField.setText(null);
        CaracteristicasTextArea.setText(null);
        EstadoComboBox.setSelectedItem(null);
        ImagemMudaLabel.setIcon(new ImageIcon(CadastroMudasTela.class.getResource("/imagens/camera (1).png")));
        NomeCientificoTextField.setText(null);
        NomeComercialTextField.setText(null);
        StatusComboBox.setSelectedItem(null);
        UsosTextArea.setText(null);
        ValorTextField.setText(null);
        BuscarTextField.requestFocus();
        codigoLabel.setText(null);
    }

    private void resetBuscar() {
        CaracteristicasTextArea.setText(null);
        EstadoComboBox.setSelectedItem(null);
        ImagemMudaLabel.setIcon(new ImageIcon(CadastroMudasTela.class.getResource("/imagens/camera (1).png")));
        NomeCientificoTextField.setText(null);
        NomeComercialTextField.setText(null);
        StatusComboBox.setSelectedItem(null);
        UsosTextArea.setText(null);
        ValorTextField.setText(null);
        BuscarTextField.requestFocus();
        codigoLabel.setText(null);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPrincipalPanel = new javax.swing.JPanel();
        ImagemPanel = new javax.swing.JPanel();
        ImagemMudaLabel = new javax.swing.JLabel();
        ImagemLabel = new javax.swing.JLabel();
        CarregarImagemButton = new javax.swing.JButton();
        BuscaPanel = new javax.swing.JPanel();
        BuscarTextField = new javax.swing.JTextField();
        BuscaLabel = new javax.swing.JLabel();
        BuscarButton = new javax.swing.JButton();
        DadosPanel = new javax.swing.JPanel();
        CaracteristicasLabel = new javax.swing.JLabel();
        ValorTextField = new javax.swing.JTextField();
        EstadoLabel = new javax.swing.JLabel();
        NomeCientificoLabel = new javax.swing.JLabel();
        EstadoComboBox = new javax.swing.JComboBox<>();
        UsosComunsLabel = new javax.swing.JLabel();
        NomeComercialTextField = new javax.swing.JTextField();
        NomeComercialLabel = new javax.swing.JLabel();
        StatusComboBox = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        CaracteristicasTextArea = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        UsosTextArea = new javax.swing.JTextArea();
        ValorLabel = new javax.swing.JLabel();
        NomeCientificoTextField = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        codigoTxtLabel = new javax.swing.JLabel();
        codigoLabel = new javax.swing.JLabel();
        BotoesPanel = new javax.swing.JPanel();
        CadastrarMudaButton = new javax.swing.JButton();
        AtualizarMudaButton = new javax.swing.JButton();
        LimparButton = new javax.swing.JButton();

        setMaximumSize(new java.awt.Dimension(1024, 768));
        setMinimumSize(new java.awt.Dimension(1024, 768));
        setPreferredSize(new java.awt.Dimension(1024, 768));

        painelPrincipalPanel.setMaximumSize(new java.awt.Dimension(1024, 768));
        painelPrincipalPanel.setMinimumSize(new java.awt.Dimension(1024, 768));
        painelPrincipalPanel.setPreferredSize(new java.awt.Dimension(1024, 768));

        ImagemMudaLabel.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ImagemMudaLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/camera (1).png"))); // NOI18N
        ImagemMudaLabel.setAlignmentY(0.0F);

        ImagemLabel.setText("Imagem da espécie");

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
                    .addComponent(ImagemMudaLabel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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
                .addComponent(ImagemMudaLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CarregarImagemButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        BuscaLabel.setText("Buscar por nome científico");

        BuscarButton.setText("Buscar");
        BuscarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BuscarButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BuscaPanelLayout = new javax.swing.GroupLayout(BuscaPanel);
        BuscaPanel.setLayout(BuscaPanelLayout);
        BuscaPanelLayout.setHorizontalGroup(
            BuscaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(BuscaLabel)
                .addGap(18, 18, 18)
                .addComponent(BuscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BuscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BuscaPanelLayout.setVerticalGroup(
            BuscaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BuscaPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BuscaPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BuscaLabel)
                    .addComponent(BuscarTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BuscarButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        CaracteristicasLabel.setText("Caracteristicas Gerais");

        EstadoLabel.setText("Estado");

        NomeCientificoLabel.setText("Nome Científico");

        EstadoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe", "Tocantins" }));

        UsosComunsLabel.setText("Usos Comuns");

        NomeComercialLabel.setText("Nome Comercial");

        StatusComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Ativa", "Inativa" }));

        CaracteristicasTextArea.setColumns(20);
        CaracteristicasTextArea.setRows(5);
        jScrollPane1.setViewportView(CaracteristicasTextArea);

        UsosTextArea.setColumns(20);
        UsosTextArea.setRows(5);
        jScrollPane2.setViewportView(UsosTextArea);

        ValorLabel.setText("Valor");

        jLabel6.setText("Status");

        codigoTxtLabel.setText("Código");

        javax.swing.GroupLayout DadosPanelLayout = new javax.swing.GroupLayout(DadosPanel);
        DadosPanel.setLayout(DadosPanelLayout);
        DadosPanelLayout.setHorizontalGroup(
            DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DadosPanelLayout.createSequentialGroup()
                .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(DadosPanelLayout.createSequentialGroup()
                        .addGap(12, 12, 12)
                        .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(DadosPanelLayout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DadosPanelLayout.createSequentialGroup()
                                .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(UsosComunsLabel)
                                    .addComponent(NomeComercialLabel))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(NomeComercialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(DadosPanelLayout.createSequentialGroup()
                                .addComponent(NomeCientificoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(NomeCientificoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DadosPanelLayout.createSequentialGroup()
                                .addComponent(EstadoLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(EstadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DadosPanelLayout.createSequentialGroup()
                                .addComponent(ValorLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(ValorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(DadosPanelLayout.createSequentialGroup()
                                .addComponent(CaracteristicasLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(DadosPanelLayout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(codigoTxtLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(codigoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(16, Short.MAX_VALUE))
        );
        DadosPanelLayout.setVerticalGroup(
            DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(DadosPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(codigoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(codigoTxtLabel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeComercialTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeComercialLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NomeCientificoTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(NomeCientificoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(EstadoComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(EstadoLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CaracteristicasLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(UsosComunsLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ValorTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ValorLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(DadosPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(StatusComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        CadastrarMudaButton.setText("Cadastrar");
        CadastrarMudaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CadastrarMudaButtonActionPerformed(evt);
            }
        });

        AtualizarMudaButton.setText("Atualizar");
        AtualizarMudaButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AtualizarMudaButtonActionPerformed(evt);
            }
        });

        LimparButton.setText("Limpar");
        LimparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LimparButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout BotoesPanelLayout = new javax.swing.GroupLayout(BotoesPanel);
        BotoesPanel.setLayout(BotoesPanelLayout);
        BotoesPanelLayout.setHorizontalGroup(
            BotoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(LimparButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(CadastrarMudaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(AtualizarMudaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        BotoesPanelLayout.setVerticalGroup(
            BotoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(BotoesPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(BotoesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(LimparButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CadastrarMudaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(AtualizarMudaButton, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout painelPrincipalPanelLayout = new javax.swing.GroupLayout(painelPrincipalPanel);
        painelPrincipalPanel.setLayout(painelPrincipalPanelLayout);
        painelPrincipalPanelLayout.setHorizontalGroup(
            painelPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPrincipalPanelLayout.createSequentialGroup()
                .addContainerGap(59, Short.MAX_VALUE)
                .addGroup(painelPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(painelPrincipalPanelLayout.createSequentialGroup()
                        .addComponent(DadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(painelPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ImagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(painelPrincipalPanelLayout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(BotoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(28, 28, 28))
                    .addComponent(BuscaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(75, 75, 75))
        );
        painelPrincipalPanelLayout.setVerticalGroup(
            painelPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, painelPrincipalPanelLayout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(BuscaPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(painelPrincipalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(painelPrincipalPanelLayout.createSequentialGroup()
                        .addComponent(ImagemPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(87, 87, 87)
                        .addComponent(BotoesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DadosPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(122, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPrincipalPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
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
        atualizar();
        resetBuscar();
        buscar();
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

    public JTextArea getCaracteristicasTextArea() {
        return CaracteristicasTextArea;
    }

    public void setCaracteristicasTextArea(String caracteristicas) {
        CaracteristicasTextArea.setText(caracteristicas);
    }

    @SuppressWarnings("empty-statement")
    public int getEstadoComboBox() {
        int codigoEstado = 0;

        if ("Acre".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 1;
        };
        if ("Alagoas".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 2;
        };
        if ("Amapá".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 3;
        };
        if ("Amazonas".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 4;
        };
        if ("Bahia".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 5;
        };
        if ("Ceará".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 6;
        };
        if ("Espírito Santo".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 7;
        };
        if ("Goiás".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 8;
        };
        if ("Maranhão".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 9;
        };
        if ("Mato Grosso".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 10;
        };
        if ("Mato Grosso do Sul".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 11;
        };
        if ("Minas Gerais".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 12;
        };
        if ("Pará".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 13;
        };
        if ("Paraíba".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 14;
        };
        if ("Paraná".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 15;
        };
        if ("Pernambuco".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 16;
        };
        if ("Piauí".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 17;
        };
        if ("Rio de Janeiro".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 18;
        };
        if ("Rio Grande do Norte".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 19;
        };
        if ("Rio Grande do Sul".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 20;
        };
        if ("Rondônia".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 21;
        };
        if ("Roraima".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 22;
        };
        if ("Santa Catarina".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 23;
        };
        if ("São Paulo".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 24;
        };
        if ("Sergipe".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 25;
        };
        if ("Tocantins".equals(EstadoComboBox.getSelectedItem())) {
            codigoEstado = 26;
        };

        return codigoEstado;
    }

    public void setEstadoComboBox(int estado) {
        EstadoComboBox.setSelectedIndex(estado);
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

    public int getStatusComboBox() {
        int codigoStatus = 0;
        if ("Ativa".equals(StatusComboBox.getSelectedItem())) {
            codigoStatus = 1;
        }
        if ("Inativa".equals(StatusComboBox.getSelectedItem())) {
            codigoStatus = 2;
        }
        return codigoStatus;
    }

    public void setStatusComboBox(int status) {
        StatusComboBox.setSelectedIndex(status);
    }

    public JTextArea getUsosTextArea() {
        return UsosTextArea;
    }

    public void setUsosTextArea(String usos) {
        UsosTextArea.setText(usos);
    }

    public JTextField getValorTextField() {
        return ValorTextField;
    }

    public void setValorTextField(String valorMuda) {
        ValorTextField.setText(valorMuda);
    }

    public JLabel getImagemMudaLabel() {
        return ImagemMudaLabel;
    }

    public void setImagemMudaLabel(ImageIcon icon) {
        ImagemMudaLabel.setIcon(icon);
    }

    public int getCodigoLabel() {
        int codigo = Integer.parseInt(codigoLabel.getText());
        return codigo;
    }

    public void setCodigoLabel(String codigo) {
        codigoLabel.setText(codigo);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AtualizarMudaButton;
    private javax.swing.JPanel BotoesPanel;
    private javax.swing.JLabel BuscaLabel;
    private javax.swing.JPanel BuscaPanel;
    private javax.swing.JButton BuscarButton;
    private javax.swing.JTextField BuscarTextField;
    private javax.swing.JButton CadastrarMudaButton;
    private javax.swing.JLabel CaracteristicasLabel;
    private javax.swing.JTextArea CaracteristicasTextArea;
    private javax.swing.JButton CarregarImagemButton;
    private javax.swing.JPanel DadosPanel;
    private javax.swing.JComboBox<String> EstadoComboBox;
    private javax.swing.JLabel EstadoLabel;
    private javax.swing.JLabel ImagemLabel;
    private javax.swing.JLabel ImagemMudaLabel;
    private javax.swing.JPanel ImagemPanel;
    private javax.swing.JButton LimparButton;
    private javax.swing.JLabel NomeCientificoLabel;
    private javax.swing.JTextField NomeCientificoTextField;
    private javax.swing.JLabel NomeComercialLabel;
    private javax.swing.JTextField NomeComercialTextField;
    private javax.swing.JComboBox<String> StatusComboBox;
    private javax.swing.JLabel UsosComunsLabel;
    private javax.swing.JTextArea UsosTextArea;
    private javax.swing.JLabel ValorLabel;
    private javax.swing.JTextField ValorTextField;
    private javax.swing.JLabel codigoLabel;
    private javax.swing.JLabel codigoTxtLabel;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelPrincipalPanel;
    // End of variables declaration//GEN-END:variables

}
