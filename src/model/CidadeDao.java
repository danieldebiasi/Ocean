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
public class CidadeDao extends Dao {
    
    private static CidadeDao instance;
    private static Connection myCONN;
    
    public static CidadeDao getInstance() {
        if (instance == null) {
            instance = new CidadeDao();
            myCONN = instance.connect();
        }
        return instance;
    }
    
    private Cidade buildObject(ResultSet rs) {
        Cidade cidade = null;
        try {
            cidade = new Cidade(rs.getInt("cod_cidade"), rs.getString("cidade"), rs.getString("estado"));
        } catch (SQLException e) {
        }
        return cidade;
    }
    
    public List<Cidade> retrieveGeneric(String query) {
        PreparedStatement stmt;
        List<Cidade> cidades = new ArrayList<>();
        ResultSet rs;
        try {
            stmt = myCONN.prepareStatement(query);
            rs = this.getResultSet(stmt);
            while (rs.next()) {
                cidades.add(buildObject(rs));
            }
            rs.close();
            stmt.close();
        } catch (SQLException ex) {
        }
        return cidades;
    }

    public List<Cidade> retrieveAll() {
        return this.retrieveGeneric("SELECT * FROM cidades ORDER BY cod_cidade");
    }
    
    public List<Cidade> retrieveAllByEstado(String estado) {
        return this.retrieveGeneric("SELECT * FROM cidades WHERE estado='"+estado+"' ORDER BY cod_cidade");
    }
}
