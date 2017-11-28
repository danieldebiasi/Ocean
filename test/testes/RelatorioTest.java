/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */
package testes;

import control.Controle;
import java.awt.Desktop;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Cidade;
import model.CidadeDao;
import model.PrevisaoCompleta;
import model.Relatorio;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Grupo Gambiarra
 */
public class RelatorioTest {
    
    public RelatorioTest() {
    }

    @Test
    public void testSomeMethod() {
        int codCidade = 241;
        LocalDateTime localDate = LocalDateTime.now();
        String dia = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate);
        
        List<PrevisaoCompleta> previsoes = new Controle().obterPrevisoes(codCidade, dia);
        CidadeDao cidadeDao = CidadeDao.getInstance();
        LocalDateTime localDate1 = LocalDateTime.now();
        String data = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(localDate1);
        Relatorio relatorio = new Relatorio(previsoes, data);
        
        Cidade cidade = cidadeDao.retrieveCidade(codCidade);
        
        Desktop desktop = Desktop.getDesktop();
        try {
            desktop.open(relatorio.gerar(cidade.getCodCidade(), cidade.getEstado(), cidade.getCidade()));
        } catch (IOException ex) {
            Logger.getLogger(RelatorioTest.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
}
