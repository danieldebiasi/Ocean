/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */
package model;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Grupo Gambiarra
 */
public class XmlTest {
    
    Xml xteste = new Xml();
    
    public XmlTest() {
    }

    @Test
    public void testSomeMethod() {
        
        List<PrevisaoTempo> lteste;
        
        try {
            lteste = xteste.getUpdatedPrevisaoTempo(241);
            for(int i = 0; i < lteste.size(); i++){
                System.out.println(lteste.get(i).getDia());
            }
        } catch (Exception ex) {
            Logger.getLogger(XmlTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
}
