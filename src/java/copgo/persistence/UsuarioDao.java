
package copgo.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import copgo.bean.Usuario;
import copgo.connection.ConnectionFactory;

public class UsuarioDao {

    private String sql;

    public boolean incluir(Usuario usuario) {
        boolean isOk = false;
        PreparedStatement ps = null;
        Connection conn = ConnectionFactory.getConnection();

        if (conn == null) {
            return isOk;
        }

        sql = "INSERT INTO usuario(nome, email, senha) "
                + "VALUES(?,?,?);";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.executeUpdate();
            isOk = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOk;
    }

    public boolean alterar(Usuario usuario) {
        boolean isOk = false;
        PreparedStatement ps = null;
        Connection conn = ConnectionFactory.getConnection();

        if (conn == null) {
            return isOk;
        }

        sql = "UPDATE usuario SET nome=?, email=?, senha=?"
                + "WHERE id=?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, usuario.getNome());
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.setInt(4, usuario.getId());
            ps.executeUpdate();
            isOk = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOk;
    }

    public boolean excluir(int id) {
        boolean isOk = false;
        PreparedStatement ps = null;
        Connection conn = ConnectionFactory.getConnection();

        if (conn == null) {
            return isOk;
        }

        sql = "DELETE FROM usuario WHERE id=?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            isOk = true;
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOk;
    }

    public Usuario getUsuario(int id) {
        Usuario usuario = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conn = ConnectionFactory.getConnection();

        if (conn == null) {
            return usuario;
        }

        sql = "SELECT * FROM usuario WHERE id=?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

        return usuario;
    }

    public List<Usuario> getUsuarios() {
        List<Usuario> lstUsuarios = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conn = ConnectionFactory.getConnection();

        if (conn == null) {
            return lstUsuarios;
        }

        sql = "SELECT * FROM usuario ORDER BY nome;";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            lstUsuarios = new ArrayList<>();

            while (rs.next()) {
                Usuario usuario = new Usuario();
                usuario.setId(rs.getInt("id"));
                usuario.setNome(rs.getString("nome"));
                usuario.setEmail(rs.getString("email"));
                usuario.setSenha(rs.getString("senha"));
                lstUsuarios.add(usuario);
            }

        } catch (SQLException ex) {
            Logger.getLogger(UsuarioDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

        return lstUsuarios;
    }

}
