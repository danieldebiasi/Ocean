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
public class PrevisaoTempo extends Previsao {

    private String tempo;
    private int minima;
    private int maxima;
    
    public PrevisaoTempo(int codCidade, String dia, String tempo, int minima, int maxima){
        this.codCidade = codCidade;
        this.dia = dia;
        this.tempo = tempo;
        this.minima = minima;
        this.maxima = maxima;
    }
    
    /**
     * @return the tempo
     */
    public String getTempo() {
        return tempo;
    }

    /**
     * @return the minima
     */
    public int getMinima() {
        return minima;
    }

    /**
     * @return the maxima
     */
    public int getMaxima() {
        return maxima;
    }

    /**
     * @param tempo the tempo to set
     */
    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    /**
     * @param minima the minima to set
     */
    public void setMinima(int minima) {
        this.minima = minima;
    }

    /**
     * @param maxima the maxima to set
     */
    public void setMaxima(int maxima) {
        this.maxima = maxima;
    }
    
}
