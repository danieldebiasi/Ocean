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
    
    public String legendaTempo(){
        String legTempo = null;
        String s = this.getTempo();
        
        if(s.equals("ec"))      legTempo = "Encoberto com Chuvas Isoladas"; //0
        if(s.equals("ci"))      legTempo = "Chuvas Isoladas";//1
        if(s.equals("c"))       legTempo = "Chuvas Periódicas";//0
        if(s.equals("in"))      legTempo = "Instável";//1
        if(s.equals("pp"))      legTempo = "Possibilidade de Pancadas de Chuva";//1
        if(s.equals("cm"))      legTempo = "Chuva pela Manhã";//1
        if(s.equals("cn"))      legTempo = "Chuva a noite";//1
        if(s.equals("pt"))      legTempo = "Pancadas de Chuva a Tarde";//1
        if(s.equals("pm"))      legTempo = "Pancadas de Chuva pela Manhã";//1
        if(s.equals("np"))      legTempo = "Nublado e Pancadas de Chuva";//1
        if(s.equals("pc"))      legTempo = "Pancadas de Chuva";//1
        if(s.equals("pn"))      legTempo = "Parcialmente Nublado";//0
        if(s.equals("cv"))      legTempo = "Chuvisco";//0
        if(s.equals("ch"))      legTempo = "Chuvoso";//1
        if(s.equals("t"))       legTempo = "Tempestade";//2
        if(s.equals("ps"))      legTempo = "Predomínio de Sol";//0
        if(s.equals("e"))       legTempo = "Encoberto";//0
        if(s.equals("n"))       legTempo = "Nublado";//0
        if(s.equals("nv"))      legTempo = "Nevoeiro";//1
        if(s.equals("g"))       legTempo = "Geada";//2
        if(s.equals("ne"))      legTempo = "Neve";//2
        if(s.equals("nd"))      legTempo = "Não definido";//0
        if(s.equals("pnt"))     legTempo = "Pancadas de Chuva a Noite";//1
        if(s.equals("psc"))     legTempo = "Possibilidade de Chuva";//0
        if(s.equals("pcm"))     legTempo = "Possibilidade de Chuva pela Manhã";//0
        if(s.equals("pct"))     legTempo = "Possibilidade de Chuva a Tarde";//0
        if(s.equals("pcn"))     legTempo = "Possibilidade de Chuva a Noite";//0
        if(s.equals("npt"))     legTempo = "Nublado com Pancadas a Tarde";//0
        if(s.equals("npn"))     legTempo = "Nublado com Pancadas a Noite";//0
        if(s.equals("ncn"))     legTempo = "Nublado com Possibilidade de Chuva a Noite";//0
        if(s.equals("nct"))     legTempo = "Nublado com Possibilidade de Chuva a Tarde";//0
        if(s.equals("ncm"))     legTempo = "Nublado com Possibilidade de Chuva pela Manhã";//0
        if(s.equals("npm"))     legTempo = "Nublado com Pancadas pela Manhã";//0
        if(s.equals("npp"))     legTempo = "Nublado com Possibilidade de Chuva";//0
        if(s.equals("vn"))      legTempo = "Variação de Nebulosidade";//0
        if(s.equals("ct"))      legTempo = "Chuva a Tarde";//1
        if(s.equals("ppn"))     legTempo = "Possibilidade de Pancada de Chuva a Noite";//0
        if(s.equals("ppt"))     legTempo = "Possibilidade de Pancada de Chuva a Tarde";//0
        if(s.equals("ppm"))     legTempo = "Possibilidade de Pancada de Chuva pela Manhã";//0
        if(s.equals("nppc"))    legTempo = "Nublado com Possibilidade de Pancadas de Chuva";//0
        if(s.equals("nppcm"))   legTempo = "Nublado com Possibilidade de Pancadas de Chuva de Manhã";//0
        if(s.equals("nppct"))   legTempo = "Nublado com Possibilidade de Pancadas de Chuva a Tarde";//0
        if(s.equals("nppcn"))   legTempo = "Nublado com Possibilidade de Pancadas de Chuva a Noite";//0     
        
        return legTempo;
    }
    
}
