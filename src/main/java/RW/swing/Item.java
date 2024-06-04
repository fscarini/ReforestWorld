package RW.swing;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.text.DecimalFormat;

public class Item extends javax.swing.JPanel {
    private boolean selected;
    
    public boolean isSelected(){
        return selected;
    }
    
    public void setSelected(boolean selected){
        this.selected = selected;
        repaint();
    }
    
    public Item() {
        initComponents();
        setOpaque(false);
        setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    private ItemModel data;
    
    public ItemModel getData() {
        return data;
    }
    
    public void setData(ItemModel data){
        this.data = data;
        imagem.setImage(data.getImage());
        ibNomeDoEvento.setText(data.getNomeDoEvento());
        ibData.setText(data.getDataEvento());
        DecimalFormat df = new DecimalFormat("R$#,##0.00");
        ibMeta.setText(df.format(data.getMetaDoacao()));
        
        
    }
    @Override
    public void paint(Graphics grphcs){
        Graphics2D g2 = (Graphics2D) grphcs.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(new Color(242, 242, 242));
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20);
        if(selected){
            g2.setColor(new Color(94,156,255));
            g2.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        g2.dispose();
        super.paint(grphcs);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        ibNomeDoEvento = new javax.swing.JLabel();
        ibData = new javax.swing.JLabel();
        imagem = new RW.swing.PictureBox();
        ibMeta = new javax.swing.JLabel();
        ibDescricao = new javax.swing.JLabel();

        ibNomeDoEvento.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ibNomeDoEvento.setForeground(new java.awt.Color(0, 0, 0));
        ibNomeDoEvento.setText("Nome do evento");

        ibData.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ibData.setForeground(new java.awt.Color(0, 0, 0));
        ibData.setText("Data");

        imagem.setImage(new javax.swing.ImageIcon(getClass().getResource("/RW/Drawer/icon/3x4.png"))); // NOI18N

        ibMeta.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        ibMeta.setForeground(new java.awt.Color(0, 0, 0));
        ibMeta.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        ibMeta.setText("Meta");

        ibDescricao.setFont(new java.awt.Font("Dialog", 1, 14)); // NOI18N
        ibDescricao.setForeground(new java.awt.Color(0, 0, 0));
        ibDescricao.setText("Descricao");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(ibNomeDoEvento, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                        .addGap(10, 10, 10))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(imagem, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ibData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addComponent(ibMeta, javax.swing.GroupLayout.PREFERRED_SIZE, 108, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(ibDescricao, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(ibNomeDoEvento)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ibData)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(imagem, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(ibMeta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(ibDescricao)
                .addContainerGap(69, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel ibData;
    private javax.swing.JLabel ibDescricao;
    private javax.swing.JLabel ibMeta;
    private javax.swing.JLabel ibNomeDoEvento;
    private RW.swing.PictureBox imagem;
    // End of variables declaration//GEN-END:variables
}
