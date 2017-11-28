/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package control;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import model.Alerta;
import model.AlertaDao;
import model.Cidade;
import model.CidadeDao;
import model.PrevisaoCompleta;
import model.PrevisaoOndas;
import model.PrevisaoOndasDao;
import model.PrevisaoTempo;
import model.PrevisaoTempoDao;
import model.Relatorio;
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
        long start = System.currentTimeMillis();
        for(int i = 0; i < cidades.size(); i++){
            try {
                listptempo.addAll(xml.getUpdatedPrevisaoTempo(cidades.get(i).getCodCidade()));
                listpondas.addAll(xml.getUpdatedPrevisaoOndas(cidades.get(i).getCodCidade()));
            } catch (Exception ex) {
                Logger.getLogger(Controle.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        ptempo.create(listptempo);
        pondas.create(listpondas);
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
    
    public int getCodCidade(String estado, String cidade){
       CidadeDao cidadeDao = CidadeDao.getInstance();
       return cidadeDao.retriveCodCidade(estado, cidade).get(0).getCodCidade();
    }
    
    public List<PrevisaoCompleta> obterPrevisoes(int codCidade, String dia){
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
        
        return previsoes;
    }
    
    public List<PrevisaoCompleta> obterPrevisao(int codCidade, String dia){
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
        
        return previsoes;
    }
    
    public File gerarRelatorio(int codCidade, String dia){
        List<PrevisaoCompleta> previsoes = obterPrevisoes(codCidade, dia);
        CidadeDao cidadeDao = CidadeDao.getInstance();
        LocalDateTime localDate = LocalDateTime.now();
        String data = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss").format(localDate);
        Relatorio relatorio = new Relatorio(previsoes, data);
        
        Cidade cidade = cidadeDao.retrieveCidade(codCidade);
        
        return relatorio.gerar(cidade.getCodCidade(), cidade.getEstado(), cidade.getCidade());
    }
    
    public List<Alerta> verificarAlertas(List<PrevisaoCompleta> previsoes){
        List<Alerta> alertas = new ArrayList<>();
        AlertaDao alertaDao = AlertaDao.getInstance();
        
        for (PrevisaoCompleta previsao : previsoes) {
            Alerta alerta = new Alerta(previsao);
            if(alerta.getNivel() > 0){
                alertas.add(alerta);
            }
        }
        
        alertaDao.create(alertas);
        
        return alertas;
    }
    
    public static DefaultTableModel updateAlertas(){
        DefaultTableModel model = new DefaultTableModel(new String[]{"Nível", "Dia", "Cidade", "Estado"}, 0){
            @Override
            public boolean isCellEditable(int row, int column){
                return false;
            }
        };
        
        AlertaDao alertaDao = AlertaDao.getInstance();
        CidadeDao cidadeDao = CidadeDao.getInstance();
        
        LocalDateTime localDate = LocalDateTime.now();
        String data = DateTimeFormatter.ofPattern("yyyy/MM/dd").format(localDate);
        alertaDao.delete(data);
        List<Alerta> alertas = alertaDao.retrieveAll();
        
        for(int i = 0; i < alertas.size(); i++){
            String condicao = Integer.toString(alertas.get(i).getNivel());
            Cidade c = cidadeDao.retrieveCidade(alertas.get(i).getCodCidade());
            String cidade = c.getCidade();
            String estado = c.getEstado();
            String dia = alertas.get(i).getDia();
            
            Object[] linha = {condicao, dia, cidade, estado};
            
            model.addRow(linha);
        } 
        
        return model;
    }
    
    public void limparAlertas(){
        AlertaDao alertaDao = AlertaDao.getInstance();
        alertaDao.deleteAll();
    }
    
    public String[] obterAlerta(String dia, String codCidade){
        AlertaDao alertaDao = AlertaDao.getInstance();
        List<Alerta> alerta = alertaDao.retrieveAlerta(dia, codCidade);
        
        String[] ret = new String[3];
        
        ret[0] = alerta.get(0).getCondicao();
        ret[1] = alerta.get(0).getAgitacao();
        ret[2] = Float.toString(alerta.get(0).getVento());
        
        return ret;
    }
    
}
