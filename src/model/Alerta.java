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
public class Alerta {

    private String tempo;
    private String agitacao;
    private String ventoVel;
    
    /**
     * @return the tempo
     */
    public String getTempo() {
        return tempo;
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
    public String getVentoVel() {
        return ventoVel;
    }

    /**
     * @param tempo the tempo to set
     */
    public void setTempo(String tempo) {
        this.tempo = tempo;
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
    public void setVentoVel(String ventoVel) {
        this.ventoVel = ventoVel;
    }
    
}
