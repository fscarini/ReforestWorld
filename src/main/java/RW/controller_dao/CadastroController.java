package RW.controller_dao;

import RW.forms.CadastroTela;
import RW.controller_dao.CadastroDAO;
import java.sql.SQLException;

public class CadastroController {

    public void cadastroUsuario(CadastroTela view) throws SQLException {

        CadastroDAO cadastro = new CadastroDAO();
        cadastro.cadastrarUsuario(
            view.getNomeUsuarioTextField().getText(),
            view.getEmailTextField().getText(),
            String.valueOf(view.getSenhaPasswordField().getPassword()),
            view.getIdadeTextField().getText(),
            (String) view.getSexoComboBox().getSelectedItem(),
            view.getCpfTextField().getText());

    }
}

