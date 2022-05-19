import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Statistics {
	
	public ArrayList<String> location = new ArrayList();
	public ArrayList<Integer> date = new ArrayList();
	public ArrayList<Double> pH = new ArrayList();
	public ArrayList<Double> nitrate = new ArrayList();
	public double pHMean ,pHStDev, nitrateMean, nitrateStDev;
	public double[][] pHvsNitrate = new double[2][20];
	public double[][] oneVarGraphPH = new double[2][20];
	public double[][] oneVarGraphNitrate = new double[2][20];
	
	public Statistics() throws FileNotFoundException {
		getData();
	}
	
	//reads the data from the data file and puts the interested data into array lists
	public void getData() throws FileNotFoundException {
		Scanner read = new Scanner(new File("src/main/resources/AllTheDataCorrected.txt"));
		while(read.hasNextLine()) {
			location.add(read.next());
			date.add(read.nextInt());
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			pH.add(read.nextDouble());
			nitrate.add(read.nextDouble());
			read.nextDouble();
			read.nextDouble();
		}
		System.out.println("Locations: " + location + "\nDates: " + date + "\npH: " + pH + "\nNitrate: " + nitrate);
		oneVarStat("pH");
		oneVarStat("Nitrate");
		setMatrix();
	}
	
	//sets the 2D-Array of pH and nitrate for use in line graphs
	public void setMatrix() {
		ArrayList<Double> tempPH = new ArrayList(pH);
		ArrayList<Double> tempNitrate = new ArrayList(nitrate);
		int spot = 0;
		for(int i = tempPH.size() - 1; i >= 0; i--) {
			pHvsNitrate[0][spot] = tempPH.remove(i);
			pHvsNitrate[1][spot] = tempNitrate.remove(i);
			spot++;
		}
		
		for(double[] column : pHvsNitrate)
		{
			System.out.println(Arrays.toString(column));
		}
		
	}
	
	//finds the mean and standard deviation of the data for either pH or nitrate
	public void oneVarStat(String data) {
		//finds the mean and standard deviation of the pH
		if (data.equals("pH")) {
			ArrayList<Double> tempPH = new ArrayList(pH);
			for(int i = tempPH.size() - 1; i >= 0; i--) {
				pHMean += tempPH.remove(i);
			}
			pHMean /= 20;
			tempPH = new ArrayList(pH);
			for(int i = tempPH.size() - 1; i >= 0; i--) {
				pHStDev += Math.pow((tempPH.remove(i) - pHMean), 2);
			}
			pHStDev = Math.sqrt(pHStDev /= 20);
			System.out.println(pHMean + "\n" + pHStDev);
			
			tempPH = new ArrayList(pH);
			ArrayList<Integer> tempYear = new ArrayList(date);
			int spot = 0;
			for(int i = tempPH.size() - 1; i >= 0; i--) {
				oneVarGraphPH[1][spot] = tempPH.remove(i);
				oneVarGraphPH[0][spot] = tempYear.remove(i);
				spot++;
			}
			for(double[] column : oneVarGraphPH)
			{
				System.out.println(Arrays.toString(column));
			}
		}
		//finds the mean and standard deviation of the nitrate
		else if(data.equals("Nitrate")) {
			ArrayList<Double> tempNitrate = new ArrayList(nitrate);
			for(int i = tempNitrate.size() - 1; i >= 0; i--) {
				nitrateMean += tempNitrate.remove(i);
			}
			nitrateMean /= 20;
			tempNitrate = new ArrayList(nitrate);
			for(int i = tempNitrate.size() - 1; i >= 0; i--) {
				nitrateStDev += Math.pow((tempNitrate.remove(i) - nitrateMean), 2);
			}
			nitrateStDev = Math.sqrt(nitrateStDev /= 20);
			System.out.println(nitrateMean + "\n" + nitrateStDev);
			
			tempNitrate = new ArrayList(nitrate);
			ArrayList<Integer> tempYear = new ArrayList(date);
			int spot = 0;
			for(int i = tempNitrate.size() - 1; i >= 0; i--) {
				oneVarGraphNitrate[1][spot] = tempNitrate.remove(i);
				oneVarGraphNitrate[0][spot] = tempYear.remove(i);
				spot++;
			}
			for(double[] column : oneVarGraphNitrate)
			{
				System.out.println(Arrays.toString(column));
			}
			System.out.println("boo");
		}

	}
	
	public void twoVarStat() {
		
	}
}
