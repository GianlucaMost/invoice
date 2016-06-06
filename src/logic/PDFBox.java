package logic;

import java.time.LocalDateTime;

import javax.swing.DefaultListModel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.font.PDType1Font;

import persistence.ErsatzteilDAO;
import persistence.ErsatzteilDAOImpl;

public class PDFBox implements AusgabeBeobachter {
	
    @Override
	 public void print(String[] daten, DefaultListModel<String> ausgewaehlte, DefaultListModel<String> ausgewaehltesAuto) { 
		 
		         
		         String fileName = "~"+LocalDateTime.now()+".pdf";
		         float gesamtPreis=0;
		         try{
		         
		         
		     
		         PDDocument doc = new PDDocument();
		         
		         PDPage page = new PDPage();
		         doc.addPage(page);
		         PDPageContentStream content = new PDPageContentStream(doc, page);
		         content.beginText();
		         content.setFont(PDType1Font.HELVETICA, 12);
		         content.moveTextPositionByAmount(30, 750);
		         content.drawString("An:");
		         content.newLine();
		         content.moveTextPositionByAmount(0, -30);
		         for (int i = 0; i<daten.length; i++){
		         content.drawString(daten[i]);
		         content.newLine();
		         content.moveTextPositionByAmount(0, -30);
		         }
		         content.endText();
		         
		         content.beginText();
		         content.moveTextPositionByAmount(30, 550);
		         content.drawString("Wir stellen in Rechnung:");
		         content.newLine();
		         content.moveTextPositionByAmount(0, -30);
		         content.setFont(PDType1Font.HELVETICA, 12);
		             ErsatzteilDAO ed = new ErsatzteilDAOImpl();
		         for (int i = 0; i<ausgewaehlte.size(); i++){

		             float preis = ed.findPriceFrom(ausgewaehlte.get(i));
		             content.drawString(ausgewaehlte.get(i) +"      "+ preis);

		             gesamtPreis = gesamtPreis + preis;
		             content.newLine();
		             content.moveTextPositionByAmount(0, -30);
		         }
		         
		         content.drawString("zuzahlen: "+ gesamtPreis + "€");
		         content.endText();
		         content.close();
		         doc.save(fileName); 
		         
		         doc.close();
		         
		         
		         
		         }
		         catch(Exception e){
		         System.out.println(e.getMessage());
		         }
		         

		     }
}
