package RW.controller_dao;

public class LoginController {
    int codigo;
    String login;
    String senha;
    
    //construtor padrão
    public LoginController(){}
    
    public LoginController(String login, String senha){
        this.login = login;
        this.senha = senha;
    }
}
