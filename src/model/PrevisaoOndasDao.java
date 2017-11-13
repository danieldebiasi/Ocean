/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo Gambiarra
 */
public class PrevisaoOndasDao extends Dao {
    
    private static PrevisaoOndasDao instance;
    private static Connection myCONN;

    public static PrevisaoOndasDao getInstance() {
        if (instance == null) {
            instance = new PrevisaoOndasDao();
            myCONN = instance.connect();
        }
        return instance;
    }

    public void create(List<PrevisaoOndas> previsoes) {
        PreparedStatement stmt;
        String sql = "INSERT INTO ondas (cod_cidade, dia, hora, agitacao, vento_vel, vento_dir) VALUES (?,?,?,?,?,?) ON DUPLICATE KEY "
                    + "UPDATE agitacao=?, vento_vel=?, vento_dir=?";
        
        try {
            stmt = myCONN.prepareStatement(sql);
            myCONN.setAutoCommit(false);
            
            for(PrevisaoOndas previsao : previsoes){
                stmt.setInt(1, previsao.getCodCidade());
                stmt.setString(2, previsao.getDia());
                stmt.setString(3, previsao.getHora());
                stmt.setString(4, previsao.getAgitacao());
                stmt.setFloat(5, previsao.getVentoVel());
                stmt.setString(6, previsao.getVentoDir());
                stmt.setString(7, previsao.getAgitacao());
                stmt.setFloat(8, previsao.getVentoVel());
                stmt.setString(9, previsao.getVentoDir());
                stmt.addBatch();
                stmt.clearParameters();
            }         
            
            stmt.executeBatch();
            myCONN.commit();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrevisaoOndasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private PrevisaoOndas buildObject(ResultSet rs) {
        PrevisaoOndas previsao = null;
        try {
            previsao = new PrevisaoOndas(rs.getInt("cod_cidade"), rs.getString("dia"), rs.getString("hora"),
                    rs.getString("agitacao"), rs.getInt("vento_vel"), rs.getString("vento_dir"));
        } catch (SQLException e) {
            Logger.getLogger(PrevisaoOndasDao.class.getName()).log(Level.SEVERE, null, e);
        }
        return previsao;
    }
    
    public List<PrevisaoOndas> retrieveGeneric(String query) {
        PreparedStatement stmt;
        List<PrevisaoOndas> previsoes = new ArrayList<>();
        ResultSet rs;
        try {
            stmt = myCONN.prepareStatement(query);
            rs = this.getResultSet(stmt);
            while (rs.next()) {
                previsoes.add(buildObject(rs));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(PrevisaoOndasDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return previsoes;
    }

    public List<PrevisaoOndas> retrieveAll() {
        return this.retrieveGeneric("SELECT * FROM ondas ORDER BY dia");
    }
    
    public List<PrevisaoOndas> retrievePrevisoes(int cidade, String data){
        List<PrevisaoOndas> previsoes = this.retrieveGeneric("SELECT * FROM ondas WHERE cod_cidade="+cidade+" AND dia>='"+data+"'");
        return previsoes;
    }
    
    public List<PrevisaoOndas> retrieveByData(int cidade, String data) {        
        return this.retrieveGeneric("SELECT * FROM ondas WHERE cod_cidade="+cidade+" AND data='"+data+"'");
     }

}
