import java.io.IOException;

import javax.swing.JButton;
import javax.swing.JFrame;

import org.jfree.*;
import org.jfree.chart.*;
//import org.jfree.chart.ChartFactory;
import org.jfree.data.xy.DefaultXYDataset;
import org.jfree.data.xy.XYDataset;
import org.jfree.chart.plot.*;
import java.awt.event.*;

/**
 * Start file
 */
public class Main {
	
	private XYDataset tempXYData;
	private ChartDrawer testDrawer;
	
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

		// Let's temporarily create an xy dataset
		double[][] dataTemp = new double[2][20];
		
		for (int i = 0; i < dataTemp[0].length; i++) {
			dataTemp[0][i] = i;
			dataTemp[1][i] = Math.random() * 10;
		}
		
		System.out.println(dataTemp[0].length);
		
		tempXYData = createDataset("AMOGUS", dataTemp);
		testDrawer = new ChartDrawer(frame, tempXYData, "title", "X", "Y");
		testDrawer.drawGraph();

		/*
		
		// Let's temporarily create an xy dataset
		double[][] dataTemp = new double[2][2];
		for (int i = 0; i < dataTemp.length; i++) {
			for (int j = 0; j < dataTemp.length; j++) {
				dataTemp[i][j] = Math.random() * 10;
			}
		}
		tempXYData = createDataset("AMOGUS", dataTemp);
		
		//JFreeChart tempChart = ChartFactory.createXYLineChart("AMOGUS", "X Axis", "Y Axis", tempXYData, null, false, false, false);
		JFreeChart tempChart = ChartFactory.createXYLineChart("AMOGUS", "X Axis", "Y Axis", tempXYData, PlotOrientation.VERTICAL, false, false, false);
		ChartPanel tempChartPanel = new ChartPanel(tempChart);
		
		tempChartPanel.setBounds(100, 105, 300, 300);
		frame.getContentPane().add(tempChartPanel);
		
		
		// let's make the button do something
		test.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				double[][] dataTemp = new double[2][2];
				for (int i = 0; i < dataTemp.length; i++) {
					for (int j = 0; j < dataTemp.length; j++) {
						dataTemp[i][j] = Math.random() * 10;
					}
				}
				tempXYData = createDataset("AMOGUS", dataTemp);
				
			}
		});
		*/
		
		test.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				double[][] dataTemp = new double[2][20];
				for (int i = 0; i < dataTemp[0].length; i++) {
					dataTemp[0][i] = i;
					dataTemp[1][i] = Math.random() * 10;
				}
				tempXYData = createDataset("AMOGUS", dataTemp);
				testDrawer.updateGraph(tempXYData);
				
			}
		});
		
		// Call this after adding all JFrame elements
		frame.setVisible(true);
	}
	
	public static void main(String[] args) throws IOException
	{
		new Main();
	}
	
	public static XYDataset createDataset(String seriesName, double[][] data) {
		DefaultXYDataset dataset = new DefaultXYDataset();
		
		dataset.addSeries(seriesName, data);
		
		return dataset;
	}
}
