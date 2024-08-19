package authentication.model.dao.implementations;

import authentication.model.dao.interfaces.UsuarioDao;
import authentication.db.DB;
import authentication.db.DBException;
import authentication.model.entities.Usuario;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UsuarioDaoJDBC implements UsuarioDao {

    private Connection conn;

    public UsuarioDaoJDBC(Connection conn) {
        this.conn = conn;
    }


    @Override
    public void create(Usuario usuario) {

        String sqlInsert = "INSERT INTO usuario(nome, email, senha_hash) VALUES(?,?,?)";
        PreparedStatement stm = null;

        try{

            stm = conn.prepareStatement(sqlInsert);
            stm.setString(1, usuario.getNome());
            stm.setString(2, usuario.getEmail());
            stm.setString(3, usuario.getSenha());
            stm.execute();


        } catch (SQLException e) {

            throw new DBException(e.getMessage());

        } finally {

            DB.closeStatement(stm);

        }

    }

    @Override
    public Usuario read(String email) {

        String sqlSelect = "SELECT nome, email, senha_hash FROM usuario WHERE email = ?";
        PreparedStatement stm = null;
        ResultSet rs = null;

        try{

            stm = conn.prepareStatement(sqlSelect);
            stm.setString(1, email);
            rs = stm.executeQuery();

            Usuario usuario = null;

            if (rs.next()) {
                usuario = instantiateUsuario(rs);
                usuario.setNotas(readNotas(email));
                usuario.setFaltas(readFaltas(email));
            }

            return usuario;

        } catch (SQLException e) {

            throw new DBException(e.getMessage());

        } finally {

            DB.closeStatement(stm);
            DB.closeResultSet(rs);

        }

    }

    private ArrayList<Float> readNotas(String email) {

        String sqlSelect = "SELECT nota FROM notas WHERE email = ?";

        PreparedStatement stm = null;
        ResultSet rs = null;

        try{

            stm = conn.prepareStatement(sqlSelect);
            stm.setString(1, email);
            rs = stm.executeQuery();

            ArrayList<Float> notasLidas = new ArrayList<>();

            while (rs.next()) notasLidas.add(rs.getFloat("nota"));

            return notasLidas;

        } catch (SQLException e) {

            throw new DBException(e.getMessage());

        } finally {

            DB.closeStatement(stm);
            DB.closeResultSet(rs);

        }

    }

    private Integer readFaltas(String email) {

        String sqlSelect = "SELECT quantidade FROM faltas WHERE email = ?";

        PreparedStatement stm = null;
        ResultSet rs = null;

        try{

            stm = conn.prepareStatement(sqlSelect);
            stm.setString(1, email);
            rs = stm.executeQuery();

            Integer faltasLidas = null;

            if (rs.next()) faltasLidas = rs.getInt("quantidade");

            return faltasLidas;

        } catch (SQLException e) {

            throw new DBException(e.getMessage());

        } finally {

            DB.closeStatement(stm);
            DB.closeResultSet(rs);

        }

    }

    private Usuario instantiateUsuario(ResultSet rs) throws SQLException {

        Usuario usuario = new Usuario();
        usuario.setNome(rs.getString("nome"));
        usuario.setEmail(rs.getString("email"));
        usuario.setSenha(rs.getString("senha_hash"));
        return usuario;

    }

    @Override
    public void update(Usuario usuario) {

        deleteFaltas(usuario.getEmail());
        createFaltas(usuario);

        deleteNotas(usuario.getEmail());
        createNotas(usuario);

    }

    private void createFaltas(Usuario usuario) {

        String sqlInsert = "INSERT INTO faltas(email, quantidade) VALUES(?,?)";
        PreparedStatement stm = null;
        String email = usuario.getEmail();

        try{

            stm = conn.prepareStatement(sqlInsert);
            stm.setString(1, email);
            stm.setInt(2, usuario.getFaltas());
            stm.execute();

        } catch (SQLException e) {

            throw new DBException(e.getMessage());

        } finally {

            DB.closeStatement(stm);

        }


    }

    private void createNotas(Usuario usuario) {

        String sqlInsert = "INSERT INTO notas(email, nota) VALUES(?,?)";
        PreparedStatement stm = null;
        String email = usuario.getEmail();

        try{

            for (float nota : usuario.getNotas()) {

                stm = conn.prepareStatement(sqlInsert);
                stm.setString(1, email);
                stm.setFloat(2, nota);
                stm.execute();

            }

        } catch (SQLException e) {

            throw new DBException(e.getMessage());

        } finally {

            DB.closeStatement(stm);

        }


    }

    private void deleteFaltas(String email) {

        String sqlExcluir = "DELETE FROM faltas WHERE email = ?";
        PreparedStatement stm = null;

        try{

            stm = conn.prepareStatement(sqlExcluir);
            stm.setString(1, email);
            stm.execute();

        } catch (SQLException e) {

            throw new DBException(e.getMessage());

        } finally {

            DB.closeStatement(stm);

        }

    }

    private void deleteNotas(String email) {

        String sqlExcluir = "DELETE FROM notas WHERE email = ?";
        PreparedStatement stm = null;

        try{

            stm = conn.prepareStatement(sqlExcluir);
            stm.setString(1, email);
            stm.execute();

        } catch (SQLException e) {

            throw new DBException(e.getMessage());

        } finally {

            DB.closeStatement(stm);

        }

    }

    @Override
    public void delete(String email) {

        String sqlExcluir = "DELETE FROM usuario WHERE email = ?";
        PreparedStatement stm = null;

        try{

            stm = conn.prepareStatement(sqlExcluir);
            stm.setString(1, email);
            stm.execute();

        } catch (SQLException e) {

            throw new DBException(e.getMessage());

        } finally {

            DB.closeStatement(stm);

        }

    }

    @Override
    public List<Usuario> readAll() {

        PreparedStatement st = null;
        ResultSet rs = null;

        try {

            st = conn.prepareStatement("SELECT email FROM usuario");

            rs = st.executeQuery();
            List<Usuario> usuarioList = new ArrayList<>();

            while(rs.next()) {
                usuarioList.add(read(rs.getString("email")));
            }

            return usuarioList;

        } catch (SQLException e) {

            throw new DBException(e.getMessage());

        } finally {

            DB.closeStatement(st);
            DB.closeResultSet(rs);

        }

    }
}