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
public class ConsultarPrevisaoTest {
    
    public ConsultarPrevisaoTest() {
    }

    @Test
    public void testSomeMethod() {
        int codCidade = 241;
        LocalDateTime localDate = LocalDateTime.now();
        String dia = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate);
        
        PrevisaoTempoDao ptempoDao = PrevisaoTempoDao.getInstance();
        PrevisaoOndasDao pondasDao = PrevisaoOndasDao.getInstance();
        List<PrevisaoTempo> ptempo = ptempoDao.retrievePrevisoes(codCidade, dia);
        List<PrevisaoOndas> pondas = pondasDao.retrievePrevisoes(codCidade, dia);        
        List<PrevisaoCompleta> previsoes = new ArrayList<>();
        
        for(int i = 0; i < 6; i++){
            List<PrevisaoOndas> pondasData = new ArrayList<>();
            for(int j = 0; j < 8; j++){
                try{
                    pondasData.add(pondas.get((i*8)+j));
                }catch (IndexOutOfBoundsException ex){
                    pondasData.add(new PrevisaoOndas(codCidade, "Indisponível", "--", "Indisponível", -1, "Indisponível"));
                }
            }
            PrevisaoCompleta completa = new PrevisaoCompleta(ptempo.get(i), pondasData);
            previsoes.add(completa);
        }
        
        for(int i = 0; i < 6; i++){
            System.out.println(previsoes.get(i).getPrevisaoTempo().getDia());
            System.out.println(previsoes.get(i).getPrevisaoTempo().getTempo());
            System.out.println(previsoes.get(i).getPrevisaoTempo().getMinima());
            System.out.println(previsoes.get(i).getPrevisaoTempo().getMaxima());
            for(int j = 0; j < 8; j++){
                System.out.println(previsoes.get(i).getPrevisaoOndas().get(j).getHora());
                System.out.println(previsoes.get(i).getPrevisaoOndas().get(j).getAgitacao());
                System.out.println(previsoes.get(i).getPrevisaoOndas().get(j).getVentoVel());
                System.out.println(previsoes.get(i).getPrevisaoOndas().get(j).getVentoDir());
            }
        }
    }
    
}
