import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

/**
 * Start file
 */
public class Main {
	
	public Main() throws IOException
	{
		JFrame frame = new JFrame("Project Title");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// This centers the JFrame to the screen
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		// This is necessary to allow JFrame elements to be placed freely
		frame.setLayout(null);
		
		// Example element
		JButton test = new JButton("button");
		test.setBounds(50, 100, 100, 50);
		frame.getContentPane().add(test);
		
		// Call this after adding all JFrame elements
		frame.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException
	{
		new Main();
	}
}
