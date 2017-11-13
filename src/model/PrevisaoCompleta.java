/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.util.List;

/**
 *
 * @author Grupo Gambiarra
 */
public class PrevisaoCompleta {

    private PrevisaoTempo previsaoTempo;
    private List<PrevisaoOndas> previsaoOndas;
    
    public PrevisaoCompleta(PrevisaoTempo previsaoTempo, List<PrevisaoOndas> previsaoOndas){
        this.previsaoTempo = previsaoTempo;
        this.previsaoOndas = previsaoOndas;
    }
    
    /**
     * @return the previsaoTempo
     */
    public PrevisaoTempo getPrevisaoTempo() {
        return previsaoTempo;
    }

    /**
     * @return the previsaoOndas
     */
    public List<PrevisaoOndas> getPrevisaoOndas() {
        return previsaoOndas;
    }

    /**
     * @param previsaoTempo the previsaoTempo to set
     */
    public void setPrevisaoTempo(PrevisaoTempo previsaoTempo) {
        this.previsaoTempo = previsaoTempo;
    }

    /**
     * @param previsaoOndas the previsaoOndas to set
     */
    public void setPrevisaoOndas(List<PrevisaoOndas> previsaoOndas) {
        this.previsaoOndas = previsaoOndas;
    }

}
