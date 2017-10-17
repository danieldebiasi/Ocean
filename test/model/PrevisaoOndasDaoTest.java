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
public class PrevisaoOndasDaoTest {
    
    PrevisaoOndas previsao = new PrevisaoOndas(225, "2017-10-2017", "Fraco", (float) 5.8, "N");
    
    public PrevisaoOndasDaoTest() {
    }

    @Test
    public void testSomeMethod() {
        PrevisaoOndasDao.getInstance().create(previsao);
    }
    
}
