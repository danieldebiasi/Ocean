/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */
package model;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Grupo Gambiarra
 */
public class PrevisaoTempoDaoTest {
    
    private PrevisaoTempo previsao = new PrevisaoTempo(220, "2017-10-16", "Tempestade", 18, 25);
    
    public PrevisaoTempoDaoTest() {
    }

    @Test
    public void testSomeMethod() {
        PrevisaoTempoDao.getInstance().create(previsao);
    }
    
}
