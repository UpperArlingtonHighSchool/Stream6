import java.util.ArrayList;

import javax.swing.JFrame;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.xy.XYDataset;


public class ChartDrawer {
	
	private JFrame mainFrame;
	private double[][] dataMatrix;
	private XYDataset dataset;
	private JFreeChart mainChart;
	private ChartPanel mainPanel;
	
	// Constructors
	public ChartDrawer(JFrame frame) {
		mainFrame = frame;
	}
	
	public ChartDrawer(JFrame frame, XYDataset data) {
		mainFrame = frame;
		dataset = data;
	}
	
	public ChartDrawer(JFrame frame, XYDataset data, String title, String xAxis, String yAxis) {
		mainFrame = frame;
		dataset = data;
		
		mainChart = ChartFactory.createXYLineChart(title, xAxis, yAxis, data, PlotOrientation.VERTICAL, false, false, false);
		mainPanel = new ChartPanel(mainChart);
		
	}
	
	// Use these to import data
	public void importData(XYDataset data) {
		dataset = data;
		
	}
	
	public void importData(ArrayList<Double> xData, ArrayList<Double> yData) {
		dataMatrix = new double[2][xData.size()];
		for (int i = 0; i < xData.size(); i++) {
			dataMatrix[0][i] = xData.get(i);
			dataMatrix[1][i] = yData.get(i);
		}
	}
	
	// Use this to update the graph
	public void updateGraph(XYDataset data) {
		dataset = data;
		mainChart.getXYPlot().setDataset(data);
		mainPanel.repaint();
	}
	
	public void updateGraph(ArrayList<Double> x, ArrayList<Double> y) {
		importData(x, y);
		updateGraph(dataset);
	}
	
	// Use this to draw the graph
	public void drawGraph() {
		mainPanel.setBounds(0, 0, 300, 300);
		mainFrame.getContentPane().add(mainPanel);
	}
	
}
