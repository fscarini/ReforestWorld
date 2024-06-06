package RW.forms;

import RW.cell.TableActionCellRender;
import RW.cell.TableActionCellEditor;
import RW.Tabbed.TabbedForm;
import RW.Tabbed.WindowsTabbed;
import RW.cell.TableActionEvent;
import RW.controller_dao.ConexaoController;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.RowFilter;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;

public class ConsultaEventosTela extends TabbedForm {
        private String codUsuario;
        private String codPerfil;

    public ConsultaEventosTela(String codPerfil) {
        this.codPerfil = codPerfil;
        initComponents();

        // Configura a tabela (renderização de células, edição e eventos)
        TableActionEvent event = new TableActionEvent() {
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                codUsuario = Tabela.getValueAt(row, 0).toString();
                WindowsTabbed.getInstance().addTab("Meu Perfil", new MeuPerfilTela(codPerfil, codUsuario));
            }

            public void onDelete(int row) {
                if (Tabela.isEditing()) {
                    Tabela.getCellEditor().stopCellEditing();
                }
                DefaultTableModel model = (DefaultTableModel) Tabela.getModel();
                model.removeRow(row);
            }

            public void onView(int row) {
                System.out.println("View row : " + row);
            }
        };

        Tabela.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null},
                    {null, null, null, null, null, null}
                },
                new String[]{
                    "Nome do Evento", "Data de início", "Data de termino", "Localização", "Meta Doação", "Ação"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, false, true // Ajustado para coluna 5
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        // Define o renderizador e editor para a coluna de ação
        Tabela.getColumnModel().getColumn(5).setCellRenderer(new TableActionCellRender());
        Tabela.getColumnModel().getColumn(5).setCellEditor(new TableActionCellEditor(event));

        // Define o alinhamento para a coluna ID (alinhamento à direita)
        Tabela.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });
        
          carregarDadosTabela();

    }
    
    
    private void exibirTodosOsEventos() {
        
    }
   

    private void carregarDadosTabela() {
        try {
            ConexaoController controller = new ConexaoController();
            controller.buscaEventos(this); // Chama o método para listar eventos
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JTable getTabela() {
        return Tabela;
    }
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        painelPai = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        exibirTodosOsEventosRadio = new javax.swing.JRadioButton();

        Tabela.setAutoCreateRowSorter(true);
        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "Nome do Evento", "Data de início", "Data de termino", "Localização", "Meta de doação", " "
            }
        ));
        Tabela.setRowHeight(40);
        jScrollPane2.setViewportView(Tabela);

        exibirTodosOsEventosRadio.setText("Exibir eventos expirados");
        exibirTodosOsEventosRadio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exibirTodosOsEventosRadioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout painelPaiLayout = new javax.swing.GroupLayout(painelPai);
        painelPai.setLayout(painelPaiLayout);
        painelPaiLayout.setHorizontalGroup(
            painelPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(painelPaiLayout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(exibirTodosOsEventosRadio)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 829, Short.MAX_VALUE))
        );
        painelPaiLayout.setVerticalGroup(
            painelPaiLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 710, Short.MAX_VALUE)
            .addGroup(painelPaiLayout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(exibirTodosOsEventosRadio)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(painelPai, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents

    private void exibirTodosOsEventosRadioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exibirTodosOsEventosRadioActionPerformed
        
    }//GEN-LAST:event_exibirTodosOsEventosRadioActionPerformed
    


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Tabela;
    private javax.swing.JRadioButton exibirTodosOsEventosRadio;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel painelPai;
    // End of variables declaration//GEN-END:variables
}
