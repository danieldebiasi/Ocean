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
public class PrevisaoOndasDAO extends DAO {
    
    private static PrevisaoOndasDAO instance;
    private static Connection myCONN;
    
    private PrevisaoOndasDAO() {
    }

    public static PrevisaoOndasDAO getInstance() {
        if (instance == null) {
            instance = new PrevisaoOndasDAO();
            myCONN = instance.connect();
        }
        return instance;
    }

    public void create(int cidade, String dia, String agitacao, int ventoVel, String ventoDir) {
        PreparedStatement stmt;
        try {
            stmt = myCONN.prepareStatement("INSERT INTO ondas (cod_cidade, dia, agitacao, vento_vel, vento_dir) VALUES (?,?,?,?,?)");
            stmt.setInt(1, cidade);
            stmt.setString(2, dia);
            stmt.setString(3, agitacao);
            stmt.setInt(4, ventoVel);
            stmt.setString(5, ventoDir);
            this.executeUpdate(stmt);
            stmt.close();
        } catch (SQLException ex) {
        }
    }

    private PrevisaoOndas buildObject(ResultSet rs) {
        PrevisaoOndas previsao = null;
        try {
            previsao = new PrevisaoOndas(rs.getInt("cod_cidade"), rs.getString("dia"), rs.getString("agitacao"), rs.getInt("vento_vel"), rs.getString("vento_dir"));
        } catch (SQLException e) {
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
        }
        return previsoes;
    }

    public List<PrevisaoOndas> retrieveAll() {
        return this.retrieveGeneric("SELECT * FROM ondas ORDER BY dia");
    }
    
    public List<PrevisaoOndas> retrievePrevisoes(int cidade, String data){
        List<PrevisaoOndas> previsoes = this.retrieveGeneric("SELECT * FROM ondas WHERE cod_cidade="+cidade+" AND data='"+data+"'");
        return previsoes;
    }
    
    public PrevisaoOndas retrieveByData(int cidade, String data) {
        PrevisaoOndas previsao = null;
        List<PrevisaoOndas> previsoes = this.retrieveGeneric("SELECT * FROM ondas WHERE cod_cidade="+cidade+" AND data='"+data+"'");
        if(!previsoes.isEmpty()){
            previsao = previsoes.get(0);
        }
        return previsao;
    }

}
