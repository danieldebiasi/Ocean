/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import javax.swing.DefaultListModel;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Grupo Gambiarra
 */
public class Xml {

    DefaultListModel<String> MODEL = new DefaultListModel<>();

    public List<PrevisaoTempo> getUpdatedPrevisaoTempo(int codCidade) throws Exception {
        List<PrevisaoTempo> previsoes = new ArrayList<>();
        PrevisaoTempo previsao = new PrevisaoTempo();
        previsao.setCodCidade(codCidade);
        
        URL url = new URL("http://servicos.cptec.inpe.br/XML/cidade/7dias/"+codCidade+"/previsao.xml");
        URLConnection connection = url.openConnection();

        Document doc = parseXML(connection.getInputStream());
        NodeList cidades = doc.getElementsByTagName("cidade");

        NodeList nodes = cidades.item(0).getChildNodes();
        
        for(int i = 0; i < nodes.getLength(); i++){
            Node n = nodes.item(i);
            if(n.getNodeName().equals("previsao")){
                NodeList nl = n.getChildNodes();
                for(int k = 0; k < nl.getLength(); k++){
                    Node kn = nl.item(k);
                    if(kn.getNodeName().equals("dia")){
                        previsao.setDia(kn.getTextContent());
                    }
                    if(kn.getNodeName().equals("tempo")){
                        previsao.setTempo(kn.getTextContent());
                    }
                    if(kn.getNodeName().equals("maxima")){
                        previsao.setMaxima(Integer.parseInt(kn.getTextContent()));
                    }
                    if(kn.getNodeName().equals("minima")){
                        previsao.setMinima(Integer.parseInt(kn.getTextContent()));
                    }
                }
                previsoes.add(previsao);
            }
        }
        
        return previsoes;
    }
    
    public List<PrevisaoOndas> getUpdatedPrevisaoOndas(int codCidade) throws Exception {
        List<PrevisaoOndas> previsoes = new ArrayList<>();
        PrevisaoOndas previsao = new PrevisaoOndas();
        previsao.setCodCidade(codCidade);
        
        URL url = new URL("http://servicos.cptec.inpe.br/XML/cidade/"+codCidade+"/todos/tempos/ondas.xml");
        URLConnection connection = url.openConnection();

        Document doc = parseXML(connection.getInputStream());
        NodeList cidades = doc.getElementsByTagName("cidade");

        NodeList nodes = cidades.item(0).getChildNodes();
        
        for(int i = 0; i < nodes.getLength(); i++){
            Node n = nodes.item(i);
            if(n.getNodeName().equals("previsao")){
                NodeList nl = n.getChildNodes();
                for(int k = 0; k < nl.getLength(); k++){
                    Node kn = nl.item(k);
                    if(kn.getNodeName().equals("dia")){
                        previsao.setDia(kn.getTextContent());
                    }
                    if(kn.getNodeName().equals("agitacao")){
                        previsao.setAgitacao(kn.getTextContent());
                    }
                    if(kn.getNodeName().equals("vento")){
                        previsao.setVentoVel(Integer.parseInt(kn.getTextContent()));
                    }
                    if(kn.getNodeName().equals("vento_dir")){
                        previsao.setVentoDir(kn.getTextContent());
                    }
                }
                previsoes.add(previsao);
            }
        }
        
        return previsoes;
    }
    
    private Document parseXML(InputStream stream) throws Exception {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        } catch (Exception ex) {
            throw ex;
        }

        return doc;
    }    
}
