package consoleHist;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsoleHistogram {

	public static void main(String[] args) {

		// Set up scanner for input from console.
		
		Scanner scan = new Scanner(System.in);
		int numBins = scan.nextInt();
		
		// read in data points for histogram 
		ArrayList <Integer> dataPoints = new ArrayList <Integer>(); 
		
		// add the data points to the histogram and break when input equals "end"
		while(scan.hasNextInt() ) {
			dataPoints.add(scan.nextInt() );
		}// end while loop
		
		scan.close();  // close the scanner
	
		
		int [] hist = new int[numBins]; // array for histogram
		int [] bin = new int[numBins]; // array for bins
		int rng = max(dataPoints) - min(dataPoints); //find the range of the bins
		double binWidth = (rng / numBins)*2 ; //find the width of the bins
		
		/** For loop to add to the histogram array  **/
		for (int i = 0 ; i < dataPoints.size() ; i++) {
			for(int j = 0 ; j < bin.length ; j++) {
				if(dataPoints.get(i) >= bin[j] && dataPoints.get(i) < bin[j] + binWidth) {
					hist[j] ++;
				}
			}
		}

		// print out the number of bins, min, max, average, and the histogram
		
		System.out.println("Num bins: " + numBins);
		System.out.println("Min: " + min(dataPoints));
		System.out.println("Max: " + max(dataPoints));
		System.out.println("Avg: " + avg(dataPoints));
		printHist(hist, bin);

} //end main
	
	/** Begin helper methods **/
	
	
	// print out the histogram 
	private static void printHist (int [] hist, int [] bin) {
		for (int i = 0 ; i < hist.length ; i++) {
			String x = bin[i] + " : ";
			System.out.println(x + asteriks(hist[i]) + " " + hist[i] );
		}
	}

	// make the asteriks to print onto the histogram
	private static String asteriks(int y) {
		StringBuilder build = new StringBuilder();
		for(int i = 0 ; i < y ; i++) {
			build.append("*");
		}
		return build.toString();
	}

	// calculate max of the data
	private static int max (ArrayList<Integer>dataPoints) {
		int max = 0;
	for(int i = 0 ; i < dataPoints.size(); i++) {
		if(dataPoints.get(i) > max)
			max = dataPoints.get(i);
	}
	return max;
}

// find minimum value of the bins
private static int min (ArrayList<Integer>dataPoints) {
	int min = 0;
	for(int i = 0 ; i < dataPoints.size(); i++) {
		if(dataPoints.get(i) < min)
			min = dataPoints.get(i);
	}
	return min;
}

// find average value of the bins
private static double avg(ArrayList<Integer>dataPoints) {
	int total = 0;
	
	for(int i = 0 ; i < dataPoints.size(); i++) {
		total += dataPoints.get(i);
	}
	
	return (total / dataPoints.size() );
}
 
 
}// end ConsoleHistogram class

