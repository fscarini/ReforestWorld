package RW.controller_dao;

public class CadastroEvento {
    public CadastroEvento(String nome, String data, String local, String descricao){
        this.nome = nome;
        this.data = data;
        this.local = local;
        this.descricao = descricao;
    }
    
    private String nome, data, local, descricao;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getData() {
        return data;
    }

    public void setData_evento(String data) {
        this.data = data;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
}
