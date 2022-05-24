// Zachary Windisch
// IB Computer Science, May of 2022

import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.xy.XYDataset;


public class ChartDrawer {
	
	private JFrame mainFrame;
	private double[][] dataMatrix;
	private CategoryDataset dataset;
	private JFreeChart mainChart;
	private ChartPanel mainPanel;
	
	// Constructors
	public ChartDrawer(JFrame frame) {
		mainFrame = frame;
	}
	
	// The CategoryDataset thing is the data
	public ChartDrawer(JFrame frame, CategoryDataset data) {
		mainFrame = frame;
		dataset = data;
	}
	
	// The title, xAxis, and yAxis are the title strings for the respective elements
	public ChartDrawer(JFrame frame, CategoryDataset data, String title, String xAxis, String yAxis) {
		mainFrame = frame;
		dataset = data;
		
		mainChart = ChartFactory.createBarChart(title, xAxis, yAxis, data, PlotOrientation.VERTICAL, true, true, false);
		mainPanel = new ChartPanel(mainChart);
		
	}
	
	// Use these to import data
	public void importData(CategoryDataset data) {
		dataset = data;
		
	}
	
	public void importData(ArrayList<Double> xData, ArrayList<Double> yData) {
		dataMatrix = new double[2][xData.size()];
		for (int i = 0; i < xData.size(); i++) {
			dataMatrix[0][i] = xData.get(i);
			dataMatrix[1][i] = yData.get(i);
		}
	}
	
	// Use this to draw the graph
	public void drawGraph() {
		mainPanel.setBounds(0, 0, 300, 300);
		mainFrame.getContentPane().add(mainPanel);
	}
	
}
