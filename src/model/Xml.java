/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 * Classe para processamento do XML de previsões utilizando o parser SAX.
 * @author Daniel
 */
public abstract class Xml extends DefaultHandler {
    
    private String tagAtual;
    private int codCidadeAtual;
    
    public Xml() {
        super();
    }
    
    public String getTagAtual() {
        return this.tagAtual;
    }
    
    public void setTagAtual(String tagAtual) {
        this.tagAtual = tagAtual;
    }
    
    public int getCodCidadeAtual() {
        return this.codCidadeAtual;
    }
    
    public void setCodCidadeAtual(int codCidadeAtual) {
        this.codCidadeAtual = codCidadeAtual;
    }
    
    /**
     * Obter arquivo XML a partir do link fornecido.
     * @param link
     * @return
     * @throws Exception 
     */
    private InputStream obterArquivo(String link) throws Exception  {
        URL url = new URL(link);
        URLConnection connection = url.openConnection();
        
        return connection.getInputStream();
    }
   
    @Override
    public void startDocument() {
        //System.out.println("Iniciando processamento do XML...");
    }
    
    @Override
    public void endDocument() {
        //System.out.println("Processamento concluído.");
    }
    
    @Override
    public void startElement(String uri, String localName, String qname, Attributes attributes) {
        this.tagAtual = qname;
        
        System.out.println(qname);
    }
    
    @Override
    public void endElement(String uri, String localName, String qname) {
        setTagAtual("");
    }
    
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        String valor = new String(ch, start, length);
        
        System.out.println("VALOR: " + valor);
    }
    
}
