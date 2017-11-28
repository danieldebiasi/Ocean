/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */
package testes;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import model.PrevisaoCompleta;
import model.PrevisaoOndas;
import model.PrevisaoOndasDao;
import model.PrevisaoTempo;
import model.PrevisaoTempoDao;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Grupo Gambiarra
 */
public class ConsultaPrevisaoAnteriorTest {
    
    public ConsultaPrevisaoAnteriorTest() {
    }

    @Test
    public void testSomeMethod() {
        int codCidade = 241;
        String dia = "2017/11/20";
        
        PrevisaoTempoDao ptempoDao = PrevisaoTempoDao.getInstance();
        PrevisaoOndasDao pondasDao = PrevisaoOndasDao.getInstance();
        PrevisaoTempo ptempo = ptempoDao.retrieveByData(codCidade, dia);
        List<PrevisaoOndas> pondas = pondasDao.retrievePrevisoes(codCidade, dia);        
        List<PrevisaoCompleta> previsoes = new ArrayList<>();
        List<PrevisaoOndas> pondasData = new ArrayList<>();
        
        if(ptempo!=null){
            for(int i = 0; i < 8; i++){
                    try{
                        pondasData.add(pondas.get(i));
                    }catch (IndexOutOfBoundsException ex){
                        pondasData.add(new PrevisaoOndas(codCidade, "Indisponível", "--", "Indisponível", -1, "Indisponível"));
                    }
            }
            PrevisaoCompleta completa = new PrevisaoCompleta(ptempo, pondasData);
            previsoes.add(completa);
        }
        
        
        System.out.println(previsoes.get(0).getPrevisaoTempo().getDia());
        System.out.println(previsoes.get(0).getPrevisaoTempo().getTempo());
        System.out.println(previsoes.get(0).getPrevisaoTempo().getMinima());
        System.out.println(previsoes.get(0).getPrevisaoTempo().getMaxima());
        for(int j = 0; j < 8; j++){
            System.out.println(previsoes.get(0).getPrevisaoOndas().get(j).getHora());
            System.out.println(previsoes.get(0).getPrevisaoOndas().get(j).getAgitacao());
            System.out.println(previsoes.get(0).getPrevisaoOndas().get(j).getVentoVel());
            System.out.println(previsoes.get(0).getPrevisaoOndas().get(j).getVentoDir());
        }
        
    }
    
}
