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
public class Relatorio {

    private PrevisaoTempo previsaoTempo;
    private PrevisaoOndas previsaoOndas;
    
    /**
     * @return the previsaoTempo
     */
    public PrevisaoTempo getPrevisaoTempo() {
        return previsaoTempo;
    }

    /**
     * @param previsaoTempo the previsaoTempo to set
     */
    public void setPrevisaoTempo(PrevisaoTempo previsaoTempo) {
        this.previsaoTempo = previsaoTempo;
    }

    /**
     * @return the previsaoOndas
     */
    public PrevisaoOndas getPrevisaoOndas() {
        return previsaoOndas;
    }

    /**
     * @param previsaoOndas the previsaoOndas to set
     */
    public void setPrevisaoOndas(PrevisaoOndas previsaoOndas) {
        this.previsaoOndas = previsaoOndas;
    }    
    
}
