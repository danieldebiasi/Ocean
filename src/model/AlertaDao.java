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
public class AlertaDao extends Dao {
    private static AlertaDao instance;
    private static Connection myCONN;
    
    public static AlertaDao getInstance() {
        if (instance == null) {
            instance = new AlertaDao();
            myCONN = instance.connect();
        }
        return instance;
    }
    
    private Alerta buildObject(ResultSet rs) {
        Alerta alerta = null;
        try {
            alerta = new Alerta(rs.getInt("cod_cidade"), rs.getString("dia"), rs.getInt("nivel"), 
                                rs.getString("cod_tempo"), rs.getString("agitacao"), rs.getFloat("vento_vel"));
        } catch (SQLException e) {
        }
        return alerta;
    }
    
    public void create(List<Alerta> alertas) {
        PreparedStatement stmt;
        String sql = "INSERT INTO alertas(cod_cidade, dia, nivel, cod_tempo, agitacao, vento_vel) VALUES"
                + " (?,?,?,?,?,?) ON DUPLICATE KEY UPDATE nivel=?";
        
        try {
            stmt = myCONN.prepareStatement(sql);
            myCONN.setAutoCommit(false);
            
            for(Alerta alerta : alertas){
                stmt.setInt(1, alerta.getCodCidade());
                stmt.setString(2, alerta.getDia());
                stmt.setInt(3, alerta.getNivel());
                stmt.setString(4, alerta.getCondicao());
                stmt.setString(5, alerta.getAgitacao());
                stmt.setFloat(6, alerta.getVento());
                stmt.setInt(7, alerta.getNivel());
                stmt.addBatch();
                stmt.clearParameters();
            }         
            
            stmt.executeBatch();
            myCONN.commit();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Alerta> retrieveGeneric(String query) {
        PreparedStatement stmt;
        List<Alerta> alertas = new ArrayList<>();
        ResultSet rs;
        try {
            stmt = myCONN.prepareStatement(query);
            rs = this.getResultSet(stmt);
            while (rs.next()) {
                alertas.add(buildObject(rs));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
        return alertas;
    }

    public List<Alerta> retrieveAll() {
        return this.retrieveGeneric("SELECT * FROM alertas ORDER BY cod_cidade, dia");
    }
    
    public List<Alerta> retrieveAlerta(String dia, String cidade){
        return this.retrieveGeneric("SELECT * FROM alertas WHERE dia='"+dia+"' AND cod_cidade='"+cidade+"'");
    }
    
    public void delete(String dia){
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("DELETE FROM alertas WHERE dia < ?");
            stmt.setString(1, dia);
            this.executeUpdate(stmt);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void deleteAll(){
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("DELETE FROM alertas");
            this.executeUpdate(stmt);
            stmt.close();
        } catch (SQLException ex) {
            Logger.getLogger(AlertaDao.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
