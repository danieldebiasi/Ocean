/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;

/**
 * Classe de processamento do XML de previsão do tempo.
 * @author Daniel
 */
public class XmlPrevisaoTempo extends Xml {
    
    private PrevisaoTempo previsao;
    private List<PrevisaoTempo> previsoes = new ArrayList<>();
    
    public XmlPrevisaoTempo() {
        super();
    }
    
    public InputStream montarUrl(int codCidade) throws IOException {
        setCodCidadeAtual(codCidade);
        URL url = new URL("http://servicos.cptec.inpe.br/XML/cidade/7dias/"+codCidade+"/previsao.xml");
        URLConnection connection = url.openConnection();
        
        return connection.getInputStream();
    }
    
    /**
     * Processar XML obtido.
     * @param inputStream
     * @return  
     */
    public List<PrevisaoTempo> processar(InputStream inputStream) {
        SAXParserFactory factory = SAXParserFactory.newInstance();
        SAXParser parser;
        
        try {
            parser = factory.newSAXParser();
            parser.parse(inputStream, this);
            
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(Xml.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return this.previsoes;
    }
    
    @Override
    public void startElement(String uri, String localName, String qname, Attributes attributes) {
        if(qname.equals("previsao")) {
            this.previsao = new PrevisaoTempo();
            this.previsao.setCodCidade(this.getCodCidadeAtual());
        }
        
        setTagAtual(qname);
    }
    
    @Override
    public void endElement(String uri, String localName, String qname) {
        if(qname.equals("previsao")) {
            this.previsoes.add(this.previsao);
            this.previsao = null;
        }
        
        setTagAtual("");
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String valor = new String(ch, start, length);
        
        if(getTagAtual().equals("dia")) {
            String[] split = valor.split("-");
            String dia = split[0]+"/"+split[1]+"/"+split[2];
            previsao.setDia(dia);
        } else {
        
        if(getTagAtual().equals("tempo")) {
            previsao.setTempo(valor);
        } else {
        
        if(getTagAtual().equals("minima")) {
            previsao.setMinima(Integer.parseInt(valor));
        } else {
        
        if(getTagAtual().equals("maxima")) {
            previsao.setMaxima(Integer.parseInt(valor));
        }}}}
    
    }
    
}
