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
public class Cidade {

    private int codCidade;
    private String cidade;
    private String estado;
    
    public Cidade(int codCidade, String cidade, String estado){
        this.codCidade = codCidade;
        this.cidade = cidade;
        this.estado = estado;
    }
    
    /**
     * @return the codCidade
     */
    public int getCodCidade() {
        return codCidade;
    }

    /**
     * @return the cidade
     */
    public String getCidade() {
        return cidade;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param codCidade the codCidade to set
     */
    public void setCodCidade(int codCidade) {
        this.codCidade = codCidade;
    }

    /**
     * @param cidade the cidade to set
     */
    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }    
    
}
