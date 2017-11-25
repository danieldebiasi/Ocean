/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author Grupo Gambiarra
 */
public class Alerta {

    /*
        Critério de avaliação utilizando a Escala de Beaufort
        - Para ventos abaixo de 12km/h, soma-se 0 ao nível.
        - Para ventos entre 12km/h e 28km/h soma-se 1 ao nível.
        - Para ventos acima de 28km/h soma-se 2 ao nível.
        
        0 - Condição Boa
        1 - Condição Moderada
        >=2 - Condição Ruim
    */
    
    private int codCidade;
    private String dia;
    private int nivel = 0;
    private PrevisaoCompleta previsoes;
    private String condicao;
    private String agitacao;
    private float vento;
    
    public Alerta(int codCidade, String dia, int nivel, String condicao, String agitacao, float vento){
        this.codCidade = codCidade;
        this.dia = dia;
        this.nivel = nivel;
        this.condicao = condicao;
        this.agitacao = agitacao;
        this.vento = vento;
    }
    
    public Alerta(PrevisaoCompleta previsao){
        this.previsoes = previsao;
        this.codCidade = previsao.getPrevisaoTempo().getCodCidade();
        this.dia = previsao.getPrevisaoTempo().getDia();
        this.condicao = previsao.getPrevisaoTempo().legendaTempo();
        definirNivel();
    }
    
    /**
     * @return the codCidade
     */
    public int getCodCidade() {
        return codCidade;
    }

    /**
     * @param codCidade the codCidade to set
     */
    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }
    
    /**
     * @return the dia
     */
    public String getDia() {
        return dia;
    }

    /**
     * @param dia the dia to set
     */
    public void setDia(String dia) {
        this.dia = dia;
    }
    
    /**
     * @return the nivel
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * @param nivel the nivel to set
     */
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    /**
     * @return the previsoes
     */
    public PrevisaoCompleta getPrevisoes() {
        return previsoes;
    }

    /**
     * @param previsoes the previsaoCompleta to set
     */
    public void setPrevisoes(PrevisaoCompleta previsoes) {
        this.previsoes = previsoes;
    }
    
    /**
     * @return the condicao
     */
    public String getCondicao() {
        return condicao;
    }

    /**
     * @param condicao the condicao to set
     */
    public void setCondicao(String condicao) {
        this.condicao = condicao;
    }

    /**
     * @return the agitacao
     */
    public String getAgitacao() {
        return agitacao;
    }

    /**
     * @param agitacao the agitacao to set
     */
    public void setAgitacao(String agitacao) {
        this.agitacao = agitacao;
    }
    
    /**
     * @return the vento
     */
    public float getVento() {
        return vento;
    }

    /**
     * @param vento the vento to set
     */
    public void setVento(float vento) {
        this.vento = vento;
    }
    
    /**
     * Método para definir nível de um alerta dada uma previsão.
     */
    private void definirNivel(){
        if(!this.previsoes.getPrevisaoOndas().get(0).getAgitacao().equals("Indisponível")){
            Map<String, Integer> counter = new TreeMap<String, Integer>();
            int tot = 0;
            float vent = 0;

            for (PrevisaoOndas previsao : this.previsoes.getPrevisaoOndas()) {
                String cond = previsao.getAgitacao();
                if(!cond.equals("Indisponível")){
                    counter.put(cond, counter.get(cond) == null ? 1 : counter.get(cond) + 1);
                    vent += previsao.getVentoVel();
                    tot++;
                }                
            }

            Map.Entry<String, Integer> ocorrencias = null;

            for (Map.Entry<String, Integer> entry : counter.entrySet())
            {
                if (ocorrencias == null || entry.getValue().compareTo(ocorrencias.getValue()) > 0)
                {
                    ocorrencias = entry;
                    this.agitacao = ocorrencias.getKey();
                }
            }

            this.vento = Math.round(vent/tot);

            if(this.agitacao.equals("Forte") || this.agitacao.equals("MuitoForte")){
                this.nivel += 2;
            }

            if(this.vento >= 12 && this.vento < 28){
                this.nivel += 1;
            }else if(this.vento >= 28){
                this.nivel += 2;
            }

            String prev = this.previsoes.getPrevisaoTempo().getTempo();
            if(prev.equals("ci") || prev.equals("in") || prev.equals("pp") || prev.equals("cm") ||
               prev.equals("cn") || prev.equals("pt") || prev.equals("pm") || prev.equals("np") ||
               prev.equals("pc") || prev.equals("ch") || prev.equals("nv") || prev.equals("pnt")||
               prev.equals("ct")){
                this.nivel += 1;
            }else if(prev.equals("t") || prev.equals("g") || prev.equals("ne")){
                this.nivel += 2;
            }
        }
    }
}
