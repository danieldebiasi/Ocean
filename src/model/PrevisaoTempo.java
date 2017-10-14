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
    
    public PrevisaoTempo(){
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
    
    public String legendaTempo(String s){
        String legTempo = null;
        
        if(s.equals("ec"))      legTempo = "Encoberto com Chuvas Isoladas";
        if(s.equals("ci"))      legTempo = "Chuvas Isoladas";
        if(s.equals("c"))       legTempo = "Chuvas Periódicas";
        if(s.equals("in"))      legTempo = "Instável";
        if(s.equals("pp"))      legTempo = "Possibilidade de Pancadas de Chuva";
        if(s.equals("cm"))      legTempo = "Chuva pela Manhã";
        if(s.equals("cn"))      legTempo = "Chuva a noite";
        if(s.equals("pt"))      legTempo = "Pancadas de Chuva a Tarde";
        if(s.equals("pm"))      legTempo = "Pancadas de Chuva pela Manhã";
        if(s.equals("np"))      legTempo = "Nublado e Pancadas de Chuva";
        if(s.equals("pc"))      legTempo = "Pancadas de Chuva";
        if(s.equals("pn"))      legTempo = "Parcialmente Nublado";
        if(s.equals("cv"))      legTempo = "Chuvisco";
        if(s.equals("ch"))      legTempo = "Chuvoso";
        if(s.equals("t"))       legTempo = "Tempestade";
        if(s.equals("ps"))      legTempo = "Predomínio de Sol";
        if(s.equals("e"))       legTempo = "Encoberto";
        if(s.equals("n"))       legTempo = "Nublado";
        if(s.equals("nv"))      legTempo = "Nevoeiro";
        if(s.equals("g"))       legTempo = "Geada";
        if(s.equals("ne"))      legTempo = "Neve";
        if(s.equals("nd"))      legTempo = "Não definido";
        if(s.equals("pnt"))     legTempo = "Pancadas de Chuva a Noite";
        if(s.equals("psc"))     legTempo = "Possibilidade de Chuva";
        if(s.equals("pcm"))     legTempo = "Possibilidade de Chuva pela Manhã";
        if(s.equals("pct"))     legTempo = "Possibilidade de Chuva a Tarde";
        if(s.equals("pcn"))     legTempo = "Possibilidade de Chuva a Noite";
        if(s.equals("npt"))     legTempo = "Nublado com Pancadas a Tarde";
        if(s.equals("npn"))     legTempo = "Nublado com Pancadas a Noite";
        if(s.equals("ncn"))     legTempo = "Nublado com Possibilidade de Chuva a Noite";
        if(s.equals("nct"))     legTempo = "Nublado com Possibilidade de Chuva a Tarde";
        if(s.equals("ncm"))     legTempo = "Nublado com Possibilidade de Chuva pela Manhã";
        if(s.equals("npm"))     legTempo = "Nublado com Pancadas pela Manhã";
        if(s.equals("npp"))     legTempo = "Nublado com Possibilidade de Chuva";
        if(s.equals("vn"))      legTempo = "Variação de Nebulosidade";
        if(s.equals("ct"))      legTempo = "Chuva a Tarde";
        if(s.equals("ppn"))     legTempo = "Possibilidade de Pancada de Chuva a Noite";
        if(s.equals("ppt"))     legTempo = "Possibilidade de Pancada de Chuva a Tarde";
        if(s.equals("ppm"))     legTempo = "Possibilidade de Pancada de Chuva pela Manhã";
        if(s.equals("nppc"))    legTempo = "Nublado com Possibilidade de Pancadas de Chuva";
        if(s.equals("nppcm"))   legTempo = "Nublado com Possibilidade de Pancadas de Chuva de Manhã";
        if(s.equals("nppct"))   legTempo = "Nublado com Possibilidade de Pancadas de Chuva a Tarde";
        if(s.equals("nppcn"))   legTempo = "Nublado com Possibilidade de Pancadas de Chuva a Noite";        
        
        return legTempo;
    }
    
}
