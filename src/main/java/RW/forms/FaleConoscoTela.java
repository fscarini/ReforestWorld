package RW.forms;

import RW.Tabbed.TabbedForm;
import RW.controller_dao.ConexaoController;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class FaleConoscoTela extends TabbedForm {

    private String codUsuario;

    public FaleConoscoTela(String codUsuario) {
        initComponents();
        this.codUsuario = codUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        mensagemTextArea = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        assuntoComboBox = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        FaleConosco = new javax.swing.JLabel();
        cadastrarButton = new javax.swing.JButton();
        limparButton = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(1024, 768));

        jPanel1.setBackground(new java.awt.Color(125, 233, 81));
        jPanel1.setForeground(new java.awt.Color(102, 255, 102));
        jPanel1.setRequestFocusEnabled(false);
        jPanel1.setVerifyInputWhenFocusTarget(false);
        jPanel1.setLayout(null);

        mensagemTextArea.setColumns(20);
        mensagemTextArea.setRows(5);
        jScrollPane1.setViewportView(mensagemTextArea);

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(170, 350, 830, 170);

        jLabel1.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        jLabel1.setText("Qual o assunto do contato?");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(6, 263, 240, 25);

        jLabel4.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        jLabel4.setText("Digite sua mensagem:");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(6, 364, 160, 20);

        assuntoComboBox.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        assuntoComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " ", "Dúvidas sobre pagamento", "Dúvidas sobre doações", "Dúvidas sobre alteração da senha ", "Dúvidas sobre seu perfil", "Dúvidas sobre o site", "Relatar um problema", " " }));
        jPanel1.add(assuntoComboBox);
        assuntoComboBox.setBounds(247, 254, 261, 43);

        jTextArea1.setColumns(20);
        jTextArea1.setRows(5);
        jTextArea1.setText("As mensagens enviadas serão revisadas por nossa equipe para melhor compreensão da dúvida ou problma relatado, desta forma, pedimos que a descrição da solicitação seja clara e com  \ne com o maior número de detalhes possível.\nNossa equipe retornará contato no prazo de até 3 dias úteis a partir do momento do envio da solicitação, através do e-mail utilizado no cadastro da conta que enviou o pedido.\n\nAtt. equipe Reforest World");
        jScrollPane2.setViewportView(jTextArea1);

        jPanel1.add(jScrollPane2);
        jScrollPane2.setBounds(0, 600, 1010, 86);

        FaleConosco.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagens/FALE (5).png"))); // NOI18N
        jPanel1.add(FaleConosco);
        FaleConosco.setBounds(-200, 0, 1250, 180);
        FaleConosco.getAccessibleContext().setAccessibleName("FaleConosco");

        cadastrarButton.setText("Cadastrar\n");
        cadastrarButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarButtonActionPerformed(evt);
            }
        });
        jPanel1.add(cadastrarButton);
        cadastrarButton.setBounds(920, 540, 80, 23);

        limparButton.setText("Limpar");
        limparButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparButtonActionPerformed(evt);
            }
        });
        jPanel1.add(limparButton);
        limparButton.setBounds(830, 540, 75, 23);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 1024, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 768, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarButtonActionPerformed
        enviarMensagem();
        limparMensagem();
    }//GEN-LAST:event_cadastrarButtonActionPerformed

    private void limparButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_limparButtonActionPerformed
        limparMensagem();
    }//GEN-LAST:event_limparButtonActionPerformed

    public String getCodUsuario() {
        return codUsuario;
    }

    public String getAssuntoComboBox() {
        String assunto = (String) assuntoComboBox.getSelectedItem();
        return assunto;
    }

    public String getMensagemTextArea() {
        String mensagem = mensagemTextArea.getText();
        return mensagem;
    }

    public void enviarMensagem() {
        ConexaoController enviar = new ConexaoController();
        try {
            int retorno = enviar.cadastroMensagem(this);
            if (retorno > 0) {
                JOptionPane.showMessageDialog(null, "Mensagem enviada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Não foi possível enviar sua mensagem.");
            };

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Ocorreu algum erro. Por favor, tente novamente em alguns instantes.\n Caso o erro persista acione o suporte.");
            Logger.getLogger(FaleConoscoTela.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void limparMensagem(){
        assuntoComboBox.setSelectedItem(null);
        mensagemTextArea.setText(null);
    }

    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel FaleConosco;
    private javax.swing.JComboBox<String> assuntoComboBox;
    private javax.swing.JButton cadastrarButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton limparButton;
    private javax.swing.JTextArea mensagemTextArea;
    // End of variables declaration//GEN-END:variables
}
