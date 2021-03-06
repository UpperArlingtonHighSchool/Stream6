import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Statistics {
	
	public ArrayList<String> location = new ArrayList<String>();
	public ArrayList<String> date = new ArrayList<String>();
	public ArrayList<Double> pH = new ArrayList<Double>();
	public ArrayList<Double> nitrate = new ArrayList<Double>();
	public double pHMean, pHStDev, nitrateMean, nitrateStDev;
	public double[][] pHvsNitrate = new double[2][20];
	public double lowPH, highPH,lowNitrate, highNitrate;
	
	// reads the data from the data file and puts the interested data into array lists
	private void updateData() throws FileNotFoundException
	{
		Scanner read = new Scanner(new File("src/main/resources/AllTheDataCorrected.txt"));
		
		while(read.hasNextLine())
		{
			location.add(read.next());
			date.add(read.next());
			read.nextDouble();
			nitrate.add(read.nextDouble());
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			pH.add(read.nextDouble());
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
		}
		
		System.out.println("Locations: " + location + "\nDates: " + date + "\npH: " + pH + "\nNitrate: " + nitrate);
		oneVarStat("pH");
		oneVarStat("Nitrate");
		setMatrix();
	}
	
	//sets the 2D-Array of pH and nitrate for use in line graphs
	private void setMatrix()
	{
		ArrayList<Double> tempPH = new ArrayList<Double>(pH);
		ArrayList<Double> tempNitrate = new ArrayList<Double>(nitrate);
		int spot = 0;
		for(int i = tempPH.size() - 1; i >= 0; i--)
		{
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
	private void oneVarStat(String data)
	{
		//finds the mean and standard deviation of the pH
		if(data.equals("pH"))
		{
			ArrayList<Double> tempPH = new ArrayList<Double>(pH);
			lowPH = tempPH.get(0);
			highPH = tempPH.get(0);
			for(int i = tempPH.size() - 1; i >= 0; i--) 
			{
				if(tempPH.get(i) < lowPH) 
				{
					lowPH = tempPH.get(i);
				}
				else if(tempPH.get(i) > highPH) 
				{
					highPH = tempPH.get(i);
				}
				pHMean += tempPH.remove(i);
			}
			pHMean /= 20;
			tempPH = new ArrayList<Double>(pH);
			for(int i = tempPH.size() - 1; i >= 0; i--)
			{
				pHStDev += Math.pow((tempPH.remove(i) - pHMean), 2);
			}
			pHStDev = Math.sqrt(pHStDev /= 20);
			System.out.println(pHMean + "\n" + pHStDev);
		}
		//finds the mean and standard deviation of the nitrate
		else if(data.equals("Nitrate"))
		{
			ArrayList<Double> tempNitrate = new ArrayList<Double>(nitrate);
			lowNitrate = tempNitrate.get(0);
			highNitrate = tempNitrate.get(0);
			for(int i = tempNitrate.size() - 1; i >= 0; i--) 
			{
				if(tempNitrate.get(i) < lowNitrate) 
				{
					lowNitrate = tempNitrate.get(i);
				}
				else if(tempNitrate.get(i) > highNitrate) 
				{
					highNitrate = tempNitrate.get(i);
				}
				nitrateMean += tempNitrate.remove(i);
			}
			nitrateMean /= 20;
			tempNitrate = new ArrayList<Double>(nitrate);
			for(int i = tempNitrate.size() - 1; i >= 0; i--)
			{
				nitrateStDev += Math.pow((tempNitrate.remove(i) - nitrateMean), 2);
			}
			nitrateStDev = Math.sqrt(nitrateStDev /= 20);
			System.out.println(nitrateMean + "\n" + nitrateStDev);
		}
	}
	
	public double[][] getData()
	{
		try {
			updateData();
		} catch(FileNotFoundException e) {
			e.printStackTrace();
		}
		
		return pHvsNitrate;
	}
}
