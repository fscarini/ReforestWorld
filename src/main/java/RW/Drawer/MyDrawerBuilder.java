package RW.Drawer;

import raven.drawer.component.SimpleDrawerBuilder;

public abstract class MyDrawerBuilder extends SimpleDrawerBuilder {

    private String nome;
    private String email;
    private String codPerfil;

    public MyDrawerBuilder(String nome, String email, String codPerfil) {
        this.nome = nome;
        this.email = email;
        this.codPerfil = codPerfil;
//        System.out.println("MyDrawerBuilder - Nome: " + nome);
//        System.out.println("MyDrawerBuilder - Email: " + email);
//        System.out.println("MyDrawerBuilder - CodPerfil: " + codPerfil);
    }
}
