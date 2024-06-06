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

public class GestaoUsuariosTela extends TabbedForm {

    private String codUsuario;
    private String codPerfil;

    public GestaoUsuariosTela(String codPerfil) {

        this.codPerfil = codPerfil;
        initComponents();

        // Configura a tabela (renderização de células, edição e eventos)
        TableActionEvent event = new TableActionEvent() {
            public void onEdit(int row) {
                System.out.println("Edit row : " + row);
                codUsuario = Tabela.getValueAt(row, 0).toString();
                WindowsTabbed.getInstance().addTab("Meu Perfil", new MeuPerfilTela(codPerfil, codUsuario, "2"));
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
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null},
                    {null, null, null, null, null}
                },
                new String[]{
                    "ID", "Nome", "Email", "CPF", "Ação"
                }
        ) {
            boolean[] canEdit = new boolean[]{
                false, false, false, false, true // Ajustado para coluna 4
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit[columnIndex];
            }
        });

        // Define o renderizador e editor para a coluna de ação
        Tabela.getColumnModel().getColumn(4).setCellRenderer(new TableActionCellRender());
        Tabela.getColumnModel().getColumn(4).setCellEditor(new TableActionCellEditor(event));

        // Define o alinhamento para a coluna ID (alinhamento à direita)
        Tabela.getColumnModel().getColumn(0).setCellRenderer(new DefaultTableCellRenderer() {
            @Override
            public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
                setHorizontalAlignment(SwingConstants.RIGHT);
                return super.getTableCellRendererComponent(jtable, o, bln, bln1, i, i1);
            }
        });

        // Chama o método para buscar os dados do banco de dados
        carregarDadosTabela();

        // Adiciona um ActionListener para cada campo de texto
        IDjTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisar();
            }
        });

        NomejTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisar();
            }
        });

        EmailjTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisar();
            }
        });

        CPFjTextField.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                pesquisar();
            }
        });
    }

    private void pesquisar() {
        PesquisarjButton.doClick(); // Simula o clique no botão "Pesquisar"
    }

    private void carregarDadosTabela() {
        try {
            ConexaoController controller = new ConexaoController();
            controller.buscaUsuarios(this); // Chama o método para buscar os usuários
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, "Erro ao carregar dados: " + e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public JTable getTabela() {
        return Tabela;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        Tabela = new javax.swing.JTable();
        filtrojLabel = new javax.swing.JLabel();
        PesquisarjButton = new javax.swing.JButton();
        IDjTextField = new javax.swing.JTextField();
        jLabel = new javax.swing.JLabel();
        NomejTextField = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        EmailjTextField = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        CPFjTextField = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();

        Tabela.setAutoCreateRowSorter(true);
        Tabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Nome", "Email", "CPF", "Ação"
            }
        ));
        Tabela.setRowHeight(40);
        jScrollPane2.setViewportView(Tabela);

        filtrojLabel.setText("FILTRO PERSONALIZADO");

        PesquisarjButton.setText("PESQUISAR");
        PesquisarjButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                PesquisarjButtonActionPerformed(evt);
            }
        });

        jLabel.setText("ID");

        jLabel1.setText("Nome");

        jLabel2.setText("E-mail");

        jLabel3.setText("CPF");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(IDjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel)
                                .addComponent(filtrojLabel, javax.swing.GroupLayout.Alignment.TRAILING)))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(NomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel1))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(EmailjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(CPFjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 147, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addComponent(PesquisarjButton)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 840, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 713, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(filtrojLabel)
                .addGap(49, 49, 49)
                .addComponent(jLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(IDjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(NomejTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EmailjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(CPFjTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120)
                .addComponent(PesquisarjButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void PesquisarjButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_PesquisarjButtonActionPerformed
        DefaultTableModel model = (DefaultTableModel) Tabela.getModel();
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<>(model);
        Tabela.setRowSorter(sorter);

        List<RowFilter<Object, Object>> filters = new ArrayList<>();

        // Adiciona filtro para cada campo de texto preenchido
        if (!IDjTextField.getText().isEmpty()) {
            filters.add(RowFilter.regexFilter(IDjTextField.getText(), 0)); // 0 é o índice da coluna ID
        }
        if (!NomejTextField.getText().isEmpty()) {
            String nomeFilter = "(?i)" + Pattern.quote(NomejTextField.getText()); // Ignora o caso
            filters.add(RowFilter.regexFilter(nomeFilter, 1)); // 1 é o índice da coluna Nome
        }
        if (!EmailjTextField.getText().isEmpty()) {
            filters.add(RowFilter.regexFilter(EmailjTextField.getText(), 2)); // 2 é o índice da coluna Email
        }
        if (!CPFjTextField.getText().isEmpty()) {
            filters.add(RowFilter.regexFilter(CPFjTextField.getText(), 3)); // 3 é o índice da coluna CPF
        }

        // Combina os filtros com um operador AND
        RowFilter<Object, Object> combinedFilter = RowFilter.andFilter(filters);

        // Aplica o filtro à tabela
        sorter.setRowFilter(combinedFilter);
    }//GEN-LAST:event_PesquisarjButtonActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField CPFjTextField;
    private javax.swing.JTextField EmailjTextField;
    private javax.swing.JTextField IDjTextField;
    private javax.swing.JTextField NomejTextField;
    private javax.swing.JButton PesquisarjButton;
    private javax.swing.JTable Tabela;
    private javax.swing.JLabel filtrojLabel;
    private javax.swing.JLabel jLabel;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    // End of variables declaration//GEN-END:variables
}
