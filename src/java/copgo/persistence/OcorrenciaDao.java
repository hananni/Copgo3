
package copgo.persistence;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import copgo.bean.Ocorrencia;
import copgo.connection.ConnectionFactory;

public class OcorrenciaDao {

    private String sql;

    public boolean incluir(Ocorrencia ocorrencia) {
        boolean isOk = false;
        PreparedStatement ps = null;
        Connection conn = ConnectionFactory.getConnection();

        if (conn == null) {
            return isOk;
        }

        sql = "INSERT INTO ocorrencia(descricao, data, tipoocorrencia, localizacao) "
                + "VALUES(?,?,?,?);";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ocorrencia.getDescricao());
            ps.setString(2, ocorrencia.getData());
            ps.setString(3, ocorrencia.getTipoocorrencia());
            ps.setString(4, ocorrencia.getLocalizacao());
            ps.executeUpdate();
            isOk = true;
        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOk;
    }

    public boolean alterar(Ocorrencia ocorrencia) {
        boolean isOk = false;
        PreparedStatement ps = null;
        Connection conn = ConnectionFactory.getConnection();

        if (conn == null) {
            return isOk;
        }

        sql = "UPDATE ocorrencia SET descricao=?, data=?, tipoocorrencia=?, localizacao=?"
                + "WHERE id=?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setString(1, ocorrencia.getDescricao());
            ps.setString(2, ocorrencia.getData());
            ps.setString(3, ocorrencia.getTipoocorrencia());
            ps.setString(4, ocorrencia.getLocalizacao());
            ps.setInt(5, ocorrencia.getId());
            ps.executeUpdate();
            isOk = true;
        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaDao.class.getName()).log(Level.SEVERE, null, ex);
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

        sql = "DELETE FROM ocorrencia WHERE id=?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            ps.executeUpdate();
            isOk = true;
        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps);
        }

        return isOk;
    }

    public Ocorrencia getOcorrencia(int id) {
        Ocorrencia ocorrencia = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conn = ConnectionFactory.getConnection();

        if (conn == null) {
            return ocorrencia;
        }

        sql = "SELECT * FROM ocorrencia WHERE id=?;";

        try {
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                ocorrencia = new Ocorrencia();
                ocorrencia.setId(rs.getInt("id"));
                ocorrencia.setDescricao(rs.getString("descricao"));
                ocorrencia.setData(rs.getString("data"));
                ocorrencia.setTipoocorrencia(rs.getString("tipoocorrencia"));
                ocorrencia.setLocalizacao(rs.getString("localizacao"));
            }

        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

        return ocorrencia;
    }

    public List<Ocorrencia> getOcorrencias() {
        List<Ocorrencia> lstOcorrencias = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        Connection conn = ConnectionFactory.getConnection();

        if (conn == null) {
            return lstOcorrencias;
        }

        sql = "SELECT * FROM ocorrencia ORDER BY nome;";

        try {
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            lstOcorrencias = new ArrayList<>();

            while (rs.next()) {
                Ocorrencia ocorrencia = new Ocorrencia();
                ocorrencia.setId(rs.getInt("id"));
                ocorrencia.setDescricao(rs.getString("descricao"));
                ocorrencia.setData(rs.getString("data"));
                ocorrencia.setTipoocorrencia(rs.getString("tipoocorrencia"));
                ocorrencia.setLocalizacao(rs.getString("localizacao"));
                lstOcorrencias.add(ocorrencia);
            }

        } catch (SQLException ex) {
            Logger.getLogger(OcorrenciaDao.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(conn, ps, rs);
        }

        return lstOcorrencias;
    }

}
