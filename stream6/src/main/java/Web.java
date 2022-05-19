import java.net.URL;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Web {
	
	public static String getRange()
	{
		try {
			PDDocument document = PDDocument.load(new URL("https://cfpub.epa.gov/roe/indicator_pdf.cfm?i=31#:~:text=Naturally%20occurring%20levels%20of%20nitrate,L)%20may%20still%20exceed%20recommended").openStream());
			// Instantiate PDFTextStripper class
			PDFTextStripper pdfStripper = new PDFTextStripper();
			// Retrieving text from PDF document
			String text = pdfStripper.getText(document);
			document.close();
			
			// elliot does magic here
			
			
			return "to be implemented";
		} catch(Exception e) {
			e.printStackTrace();
			return "An error occured web scraping";
		}
	}
}
