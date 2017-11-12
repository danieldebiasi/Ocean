/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package control;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import model.Cidade;
import model.CidadeDao;
import model.PrevisaoOndas;
import model.PrevisaoOndasDao;
import model.PrevisaoTempo;
import model.PrevisaoTempoDao;
import model.Xml;

/**
 *
 * @author Grupo Gambiarra
 */
public class Controle {
    
    public static void inicializar(){
        PrevisaoTempoDao ptempo = PrevisaoTempoDao.getInstance();
        PrevisaoOndasDao pondas = PrevisaoOndasDao.getInstance();
        CidadeDao cidadeDao = CidadeDao.getInstance();
        List<PrevisaoTempo> listptempo = new ArrayList<>();
        List<PrevisaoOndas> listpondas = new ArrayList<>();
        List<Cidade> cidades = new ArrayList<>();        
        Xml xml = new Xml();
        
        cidades = cidadeDao.retrieveAll();
        
        for(int i = 0; i < cidades.size(); i++){
            try {
                listptempo = xml.getUpdatedPrevisaoTempo(cidades.get(i).getCodCidade());
                listpondas = xml.getUpdatedPrevisaoOndas(cidades.get(i).getCodCidade());
                                
                ptempo.create(listptempo);                
               
                pondas.create(listpondas);               
                
            } catch (Exception ex) {
                Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    public DefaultComboBoxModel getCidades(Object estado){
        CidadeDao cidadeDao = CidadeDao.getInstance();
        List<Cidade> cidades = cidadeDao.retrieveAllByEstado(estado.toString());
        DefaultComboBoxModel MODEL = new DefaultComboBoxModel();
        
        MODEL.removeAllElements();
        
        for(int i = 0; i < cidades.size(); i++){
            MODEL.addElement(cidades.get(i).getCidade());
        }
        
        return MODEL;
    }
    
}
