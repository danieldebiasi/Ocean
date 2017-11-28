/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */
package testes;

import control.Controle;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.Alerta;
import model.PrevisaoCompleta;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Grupo Gambiarra
 */
public class AlertaTest {
    
    public AlertaTest() {
    }

    @Test
    public void testSomeMethod() {
        Controle controle = new Controle();
        LocalDateTime localDate = LocalDateTime.now();
        String dia = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate);
        List<PrevisaoCompleta> previsoes = controle.obterPrevisoes(241, dia);
        
        List<Alerta> alertas = new ArrayList<>();
        
        for (PrevisaoCompleta previsao : previsoes) {
            Alerta alerta = new Alerta(previsao);
            if(alerta.getNivel() > 0){
                alertas.add(alerta);
            }
        }
        
        if(!alertas.isEmpty()){
            for(Alerta a : alertas){
                System.out.println(a.getDia());
                System.out.println(a.getNivel());
            }
        }
        
    }
    
}
