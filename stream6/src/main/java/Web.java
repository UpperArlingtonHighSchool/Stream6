import java.net.URL;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

public class Web {
	
	public static String getRange()
	{
		JFrame frame = new JFrame("Stream6 Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// This centers the JFrame to the screen
		frame.setSize(300, 150);
		frame.setLocationRelativeTo(null);
		// This is necessary to allow JFrame elements to be placed freely
		frame.setLayout(null);
		
		JLabel label = new JLabel("Webscraping...");
		label.setBounds(0, 0, 300, 120);
		label.setHorizontalAlignment(JLabel.CENTER);
		frame.getContentPane().add(label);
		
		frame.setVisible(true);
		
		try {
			PDDocument document = PDDocument.load(new URL("https://cfpub.epa.gov/roe/indicator_pdf.cfm?i=31#:~:text=Naturally%20occurring%20levels%20of%20nitrate,L)%20may%20still%20exceed%20recommended").openStream());
			// Instantiate PDFTextStripper class
			PDFTextStripper pdfStripper = new PDFTextStripper();
			// Retrieving text from PDF document
			String text = pdfStripper.getText(document);
			document.close();
			
			// elliot does magic here
			text = text.substring(3996, 4012);
			return text;
		} catch(Exception e) {
			e.printStackTrace();
			return "An error occured web scraping";
		}
		finally {
			frame.dispose();
		}
	}
}
