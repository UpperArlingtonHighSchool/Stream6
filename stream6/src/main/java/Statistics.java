import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Statistics {
	
	public ArrayList<String> location = new ArrayList();
	public ArrayList<String> date = new ArrayList();
	public ArrayList<Double> pH = new ArrayList();
	public ArrayList<Double> nitrate = new ArrayList();
	public double pHMean ,pHStDev, pHPValue, nitrateMean, nitrateStDev, nitratePValue;
	
	public Statistics() throws FileNotFoundException {
		getData();
	}
	//reads the data from the data file and puts the interested data into array lists
	public void getData() throws FileNotFoundException {
		Scanner read = new Scanner(new File("src/main/resources/AllTheDataCorrected.txt"));
		int hi = 0;
		while(read.hasNextLine()) {
			location.add(read.next());
			date.add(read.next());
			read.nextDouble();
			nitrate.add(read.nextDouble());
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			pH.add(read.nextDouble());
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			read.nextDouble();
			hi++;
		}
		System.out.println("Locations: " + location + "\nDates: " + date + "\npH: " + pH + "\nNitrate: " + nitrate);
		oneVarStat("pH");
		oneVarStat("Nitrate");
	}
	
	public void oneVarStat(String data) {
		if (data.equals("pH")) {
			ArrayList<Double> tempPH = pH;
			for(int i = tempPH.size() - 1; i >= 0; i--) {
				pHMean += tempPH.remove(i);
			}
			pHMean /= 20;
			System.out.println(pHMean);
		}
		else if(data.equals("Nitrate")) {
			ArrayList<Double> tempNitrate = nitrate;
			for(int i = tempNitrate.size() - 1; i >= 0; i--) {
				nitrateMean += tempNitrate.remove(i);
			}
			nitrateMean /= 20;
			System.out.println(nitrateMean);
		}
	}
	
	public void twoVarStat() {
		
	}
}
