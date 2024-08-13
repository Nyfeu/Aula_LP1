package authentication.model.dao;

import authentication.db.DB;
import authentication.model.dao.implementations.UsuarioDaoJDBC;
import authentication.model.dao.interfaces.UsuarioDao;

public class DAOFactory {

    public static UsuarioDao createUsuarioDao() {
        return new UsuarioDaoJDBC(DB.getConnection());
    }

}