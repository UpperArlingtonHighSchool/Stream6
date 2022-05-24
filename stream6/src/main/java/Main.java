import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Arrays;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextPane;

import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYDataset;

/**
 * Start file
 */
public class Main {
	
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
		area.setText("Stream 6 Project Summary\n\nThe relationship between PH and nitrate is as PH goes down, nitrate goes up.\n\n"
											+ "We were able to prove this by comparing the two graphs below. We had a range of streams "
											+ "that had pH levels ranging from 5-9, and their corresponding nitrate levels are shown "
											+ "in the nitrate graph. It's visible that the lowest pH streams have the highest nitrate "
											+ "concentrations, and the highest pH streams have the lowest.\n\n"
											+ "We webscraped the currently accepted PH range for streams, "
											+ "which is " + Web.getRange() + ".");
		area.setBounds(5, 5, 490, 300);
		area.setEditable(false);
		frame.getContentPane().add(area);
		
		// Example element
		JButton test = new JButton("Open pH Graph");
		test.setBounds(5, 305, 240, 70);
		test.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFrame graph = new JFrame("Graph");
				graph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				// This centers the JFrame to the screen
				graph.setSize(300, 300 + 23);
				graph.setLocationRelativeTo(null);
				// This is necessary to allow JFrame elements to be placed freely
				graph.setLayout(null);
				graph.setResizable(false);
				
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				double[][] data = new Statistics().getData();
				double[] phValues = data[0];
				
				int val56 = 0;
				int val67 = 0;
				int val78 = 0;
				int val89 = 0;
				int val90 = 0;
				
				for(double sample : phValues)
				{
					if(sample >= 5 && sample < 6) val56++;
					else if(sample >= 6 && sample < 7) val67++;
					else if(sample >= 7 && sample < 8) val78++;
					else if(sample >= 8 && sample < 9) val89++;
					else val90++;
				}
				
				// 1st string = ph
				// double = nitrate
				
				dataset.addValue(val56, "pH <5", "");
				dataset.addValue(val67, "pH 6-7", "");
				dataset.addValue(val78, "pH 7-8", "");
				dataset.addValue(val89, "pH 8-9", "");
				dataset.addValue(val90, "pH >9", "");
				
//				dataset.addSeries("PH vs. Nitrate (Stream 6)", data);
				
				ChartDrawer testDrawer = new ChartDrawer(graph, dataset, "pH Distribution Across Samples", "X (pH)", "Y (# streams)");
				testDrawer.drawGraph();
				
				graph.setVisible(true);
			}
		});
		frame.getContentPane().add(test);
		
		JButton test2 = new JButton("Open Nitrate Graph");
		test2.setBounds(255, 305, 240, 70);
		test2.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				JFrame graph = new JFrame("Graph");
				graph.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				// This centers the JFrame to the screen
				graph.setSize(300, 300 + 23);
				graph.setLocationRelativeTo(null);
				// This is necessary to allow JFrame elements to be placed freely
				graph.setLayout(null);
				graph.setResizable(false);
				
				DefaultCategoryDataset dataset = new DefaultCategoryDataset();
				double[][] data = new Statistics().getData();
				double[] phValues = data[0];
				double[] nitrateValues = data[1];
				
				for(int i = 0; i < phValues.length; i++)
				{
					double sample = phValues[i];
					dataset.addValue(sample, nitrateValues[i] + "", "");
				}
				
				// 1st string = ph
				// double = nitrate
				
//				dataset.addSeries("PH vs. Nitrate (Stream 6)", data);
				
				ChartDrawer testDrawer = new ChartDrawer(graph, dataset, "Nitrate Concentration", "", "Y (pH)");
				testDrawer.drawGraph();
				
				graph.setVisible(true);
			}
		});
		frame.getContentPane().add(test2);
		
		// Call this after adding all JFrame elements
		frame.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException
	{
		 new Main();
	}
}
