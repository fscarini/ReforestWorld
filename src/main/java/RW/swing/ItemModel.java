package RW.swing;

import javax.swing.Icon;


public class ItemModel {
    
    int eventoID;
    String nomeDoEvento;
    String descricao;
    int metaDoacao;
    String dataEvento;
    Icon image;
    
    public ItemModel(int eventoID, String nomeDoEvento, String descricao, int metaDoacao, String dataEvento, Icon image){
        this.eventoID = eventoID;
        this.nomeDoEvento = nomeDoEvento;
        this.descricao = descricao;
        this.metaDoacao = metaDoacao;
        this.dataEvento = dataEvento;
        this.image = image;
    }

    public int getEventoID() {
        return eventoID;
    }

    public void setEventoID(int eventoID) {
        this.eventoID = eventoID;
    }

    public String getNomeDoEvento() {
        return nomeDoEvento;
    }

    public void setNomeDoEvento(String nomeDoEvento) {
        this.nomeDoEvento = nomeDoEvento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getMetaDoacao() {
        return metaDoacao;
    }

    public void setMetaDoacao(int metaDoacao) {
        this.metaDoacao = metaDoacao;
    }

    public String getDataEvento() {
        return dataEvento;
    }

    public void setDataEvento(String dataEvento) {
        this.dataEvento = dataEvento;
    }

    public Icon getImage() {
        return image;
    }

    public void setImage(Icon image) {
        this.image = image;
    }

}
