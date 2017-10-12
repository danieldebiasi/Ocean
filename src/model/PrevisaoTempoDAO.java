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

/**
 *
 * @author Grupo Gambiarra
 */
public class PrevisaoTempoDAO extends DAO {
    
    private static PrevisaoTempoDAO instance;
    private static Connection myCONN;
    
    private PrevisaoTempoDAO() {
    }

    public static PrevisaoTempoDAO getInstance() {
        if (instance == null) {
            instance = new PrevisaoTempoDAO();
            myCONN = instance.connect();
        }
        return instance;
    }

    public void create(int cidade, String dia, String tempo, int minima, int maxima) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("INSERT INTO tempo (cod_cidade, dia, cod_tempo, minima, maxima) VALUES (?,?,?,?,?)");
            stmt.setInt(1, cidade);
            stmt.setString(2, dia);
            stmt.setString(3, tempo);
            stmt.setInt(4, minima);
            stmt.setInt(5, maxima);
            this.executeUpdate(stmt);
            stmt.close();
        } catch (SQLException ex) {
        }
    }

    private PrevisaoTempo buildObject(ResultSet rs) {
        PrevisaoTempo previsao = null;
        try {
            previsao = new PrevisaoTempo(rs.getInt("cod_cidade"), rs.getString("dia"), rs.getString("tempo"), rs.getInt("minima"), rs.getInt("maxima"));
        } catch (SQLException e) {
        }
        return previsao;
    }
    
    public List<PrevisaoTempo> retrieveGeneric(String query) {
        PreparedStatement stmt;
        List<PrevisaoTempo> previsoes = new ArrayList<>();
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
        }
        return previsoes;
    }

    public List<PrevisaoTempo> retrieveAll() {
        return this.retrieveGeneric("SELECT * FROM tempo ORDER BY dia");
    }
    
    public List<PrevisaoTempo> retrievePrevisoes(int cidade, String data){
        List<PrevisaoTempo> previsoes = this.retrieveGeneric("SELECT * FROM tempo WHERE cod_cidade="+cidade+" AND data='"+data+"'");
        return previsoes;
    }
    
    public PrevisaoTempo retrieveByData(int cidade, String data) {
        PrevisaoTempo previsao = null;
        List<PrevisaoTempo> previsoes = this.retrieveGeneric("SELECT * FROM tempo WHERE cod_cidade="+cidade+" AND data='"+data+"'");
        if(!previsoes.isEmpty()){
            previsao = previsoes.get(0);
        }
        return previsao;
    }

}
