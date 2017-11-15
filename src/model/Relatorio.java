/*
 * Projeto Ocean - Previsao de Tempo e Mares
 * Engenharia de Software III
 * Faculdade de Tecnologia - UNICAMP
 */

package model;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.Phrase;
import com.itextpdf.text.pdf.PdfWriter;
import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Grupo Gambiarra
 */
public class Relatorio {

    private List<PrevisaoCompleta> previsoes;
    private String data;
    
    public Relatorio(List<PrevisaoCompleta> previsoes, String data){
        this.previsoes = previsoes;
        this.data = data;
    }
    
    /**
     * @return the previsoes
     */
    public List<PrevisaoCompleta> getPrevisoes() {
        return previsoes;
    }

    /**
     * @return the data
     */
    public String getData() {
        return data;
    }

    /**
     * @param previsoes the previsoes to set
     */
    public void setPrevisoes(List<PrevisaoCompleta> previsoes) {
        this.previsoes = previsoes;
    }

    /**
     * @param data the data to set
     */
    public void setData(String data) {
        this.data = data;
    }
    
    public File gerar(int codCidade, String estado, String cidade){
        File file = null;
        Document document = new Document();
        String[] split = this.data.split(" ");
        String dia[] = split[0].split("/");
        String hora[] = split[1].split(":");
        
        try {
            file = new File("Relatorios");
            if(!file.exists()){
                file.mkdir();
            }
            
            PdfWriter.getInstance(document, new FileOutputStream("Relatorios/relatorio"+codCidade+"_"+dia[0]+dia[1]+dia[2]+"_"+hora[0]+hora[1]+hora[2]+".pdf"));
            
            document.open();
            Phrase phr = new Phrase("Relatório de Previsão de Tempo", FontFactory.getFont(FontFactory.HELVETICA_BOLD, 18));
            Paragraph par = new Paragraph(phr);
            Paragraph br = new Paragraph("\n");
            par.setAlignment(Element.ALIGN_CENTER);
            document.add(par);
            document.add(br);
            
            phr = new Phrase("Relatório gerado em: "+split[0]+" às "+split[1], FontFactory.getFont(FontFactory.HELVETICA, 12));
            par = new Paragraph(phr);
            document.add(par);
            document.add(br);
            phr = new Phrase("Cidade "+codCidade+": "+cidade+" - "+estado, FontFactory.getFont(FontFactory.HELVETICA, 12));
            par = new Paragraph(phr);
            document.add(par);
            document.add(br);
            
            for(int i = 0; i < previsoes.size(); i++){
                phr = new Phrase("DIA: "+previsoes.get(i).getPrevisaoTempo().getDia(), FontFactory.getFont(FontFactory.HELVETICA, 10));
                par = new Paragraph(phr);
                document.add(par);
                document.add(br);
                phr = new Phrase("TEMPO", FontFactory.getFont(FontFactory.HELVETICA, 10));
                par = new Paragraph(phr);
                document.add(par);
                phr = new Phrase("CONDIÇÃO: "+previsoes.get(i).getPrevisaoTempo().legendaTempo(), FontFactory.getFont(FontFactory.HELVETICA, 10));
                par = new Paragraph(phr);
                document.add(par);
                phr = new Phrase("MÍNIMA: "+previsoes.get(i).getPrevisaoTempo().getMinima()+"°C", FontFactory.getFont(FontFactory.HELVETICA, 10));
                phr.add(Chunk.TABBING);
                phr.add("MÁXIMA: "+previsoes.get(i).getPrevisaoTempo().getMaxima()+"°C");
                par = new Paragraph(phr);
                document.add(par);
                document.add(br);
                phr = new Phrase("ONDAS", FontFactory.getFont(FontFactory.HELVETICA, 10));
                par = new Paragraph(phr);
                document.add(par);
                for(int j = 0; j < previsoes.get(i).getPrevisaoOndas().size(); j++){
                    phr = new Phrase(previsoes.get(i).getPrevisaoOndas().get(j).getHora(), FontFactory.getFont(FontFactory.HELVETICA, 10));
                    phr.add(Chunk.TABBING);
                    phr.add("AGITAÇÃO: "+previsoes.get(i).getPrevisaoOndas().get(j).getAgitacao());
                    phr.add(Chunk.TABBING);
                    phr.add("VELOCIDADE: ");
                    if(!Float.toString(previsoes.get(i).getPrevisaoOndas().get(j).getVentoVel()).equals("-1.0")){
                        phr.add(previsoes.get(i).getPrevisaoOndas().get(j).getVentoVel()+" km/h");
                    }else{
                        phr.add("Indisponível");
                    }
                    phr.add(Chunk.TABBING);
                    phr.add("DIREÇÃO: "+previsoes.get(i).getPrevisaoOndas().get(j).getVentoDir());
                    par = new Paragraph(phr);
                    document.add(par);
                }
                document.add(br);document.add(br);
            }
            
            file = new File("Relatorios/relatorio"+dia[0]+dia[1]+dia[2]+"_"+hora[0]+hora[1]+hora[2]+".pdf");
            
        } catch (FileNotFoundException | DocumentException ex) {
            Logger.getLogger(Relatorio.class.getName()).log(Level.SEVERE, null, ex);
        } finally{
            document.close();
        }
        
        return file;
    }
}
