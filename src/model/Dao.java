/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Grupo Gambiarra
 */
abstract class Dao {
    private static Connection con;
    private static final String DBURL = "jdbc:mysql:///ocean";
    private static final String username = "root";
    private static final String password = "root";
    
    protected Connection connect() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(DBURL, username, password);
            } catch (SQLException e) {
                throw new IllegalStateException("Erro na conexão com o Banco de Dados.", e);
            }
        }
        return con;
    }
    
    protected ResultSet getResultSet(PreparedStatement queryStatement) throws SQLException {
        ResultSet rs;
        rs = queryStatement.executeQuery();
        return rs;
    }
    
    protected int executeUpdate(PreparedStatement queryStatement) throws SQLException {
        int update;
        update = queryStatement.executeUpdate();
        return update;
    }
    
    protected void disconnect() {
        try {
            this.con.close();
        } catch (SQLException e) {
        }
    }
}
