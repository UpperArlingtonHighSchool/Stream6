import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

// import org.jfree.chart.ChartFactory;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;

/**
 * Start file
 */
public class Main {
	
	private XYDataset tempXYData;
	private ChartDrawer testDrawer;
	
	public Main() throws IOException
	{
		JFrame frame = new JFrame("Stream6 Project");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// This centers the JFrame to the screen
		frame.setSize(500, 400);
		frame.setLocationRelativeTo(null);
		// This is necessary to allow JFrame elements to be placed freely
		frame.setLayout(null);
		
		JTextPane area = new JTextPane();
		area.setText("This is where we flex\n\nWe discovered the recommended stream ranges are [" + Web.getRange() + "], and blah blah blah sulley does the rest");
		area.setBounds(5, 5, 200, 300);
		area.setEditable(false);
		frame.getContentPane().add(area);
		
		// Example element
		JButton test = new JButton("Open Graph");
		test.setBounds(225, 25, 100, 50);
		test.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFrame graph = new JFrame("Graph");
				graph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				// This centers the JFrame to the screen
				graph.setSize(300, 300);
				graph.setLocationRelativeTo(null);
				// This is necessary to allow JFrame elements to be placed freely
				graph.setLayout(null);
				graph.setResizable(false);
				
				// Let's temporarily create an xy dataset
				double[][] dataTemp = new double[2][20];
				for(int i = 0; i < dataTemp[0].length; i++)
				{
					dataTemp[0][i] = i;
					dataTemp[1][i] = Math.random() * 10;
				}
				
				DefaultXYDataset dataset = new DefaultXYDataset();
				dataset.addSeries("AMOGUS", new Statistics().getData());
				tempXYData = dataset;
				
				testDrawer = new ChartDrawer(graph, tempXYData, "AMOGUS", "X", "Y");
				testDrawer.drawGraph();
				testDrawer.updateGraph(tempXYData);
				
				graph.setVisible(true);
			}
		});
		frame.getContentPane().add(test);
		
		// Let's temporarily create an xy dataset
		double[][] dataTemp = new double[2][20];
		
		for(int i = 0; i < dataTemp[0].length; i++)
		{
			dataTemp[0][i] = i;
			dataTemp[1][i] = Math.random() * 10;
		}
		
		// Call this after adding all JFrame elements
		frame.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException
	{
		 new Main();
	}
}
