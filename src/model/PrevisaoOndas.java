/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

/**
 *
 * @author Grupo Gambiarra
 */
public class PrevisaoOndas extends Previsao {

    private String agitacao;
    private int ventoVel;
    private String ventoDir;
    
    public PrevisaoOndas(int codCidade, String dia, String agitacao, int ventoVel, String ventoDir){
        this.codCidade = codCidade;
        this.dia = dia;
        this.agitacao = agitacao;
        this.ventoVel = ventoVel;
        this.ventoDir = ventoDir;
    }
    
    public PrevisaoOndas(){
    }
    
    /**
     * @return the agitacao
     */
    public String getAgitacao() {
        return agitacao;
    }

    /**
     * @return the ventoVel
     */
    public int getVentoVel() {
        return ventoVel;
    }

    /**
     * @return the ventoDir
     */
    public String getVentoDir() {
        return ventoDir;
    }

    /**
     * @param agitacao the agitacao to set
     */
    public void setAgitacao(String agitacao) {
        this.agitacao = agitacao;
    }

    /**
     * @param ventoVel the ventoVel to set
     */
    public void setVentoVel(int ventoVel) {
        this.ventoVel = ventoVel;
    }

    /**
     * @param ventoDir the ventoDir to set
     */
    public void setVentoDir(String ventoDir) {
        this.ventoDir = ventoDir;
    }
    
}
