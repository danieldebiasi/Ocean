/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */
package model;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Grupo Gambiarra
 */
public class PrevisaoTempoDaoTest {
    
    public PrevisaoTempoDaoTest() {
    }

    @Test
    public void testSomeMethod() {
        List<PrevisaoTempo> previsoes = new ArrayList<>();
        PrevisaoTempoDao pteste = PrevisaoTempoDao.getInstance();
        Xml xml = new Xml();
        
        try {
            previsoes = xml.getUpdatedPrevisaoTempo(241);
        } catch (Exception ex) {
            Logger.getLogger(PrevisaoTempoDaoTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for(int i = 0; i < previsoes.size(); i++){
            pteste.create(previsoes.get(i));
        }
    }
    
}
