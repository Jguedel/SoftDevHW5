/*
 * @author jguedel
 * @version 1.0
 * 
 */
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

// TODO: Auto-generated Javadoc
/**
 * The Class Calc.
 */
public class Calc {
	
	/** The mean. */
	private static double mean;
	
	/** The sd. */
	private static double SD;
	
	/** The list num. */
	private static String listNum;
	
	/** The num. */
	private static String[] num;
	
	/** The on. */
	private static Node on;

	// MY CODE WILL STILL RUN WITH ONE NUMBER JUST MAKES THE MEAN = TO THE NUMBER
	// AND SD = 0.

	/**
	 * Calc.
	 *
	 * @param listNums the list nums
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	static void calc(File listNums) throws IOException {
		// CRASH IF FILE SELECTED IS EMPTY
		assert tests.isEmpty(listNums) == false : "Error: The file is empty";
		listNum = new String(Files.readAllBytes(Paths.get(listNums.toString())));

		// FORMAT LIST TO TAKE OUT EVERY WHITE SPACE SO ALL NUMBERS ARE SEPERATED BY " "
		// ALSO TAKES AWAY THE BLANK LINE ERROR
		listNum = listNum.replaceAll("\\s+", " ");
		num = listNum.split(" ");

		// CRASH IF ONE NUMBER IN FILE IS NOT A REAL NUMBER
		for (int i = 0; i <= num.length - 1; i++) {
			assert tests.notNum(num[i]) == false : "Error: " + num[i] + " is not a real number";
		}

		// ADD TO LINKLIST
		for (int i = 0; i <= num.length - 1; i++) {
			linkList.addNode(Integer.valueOf(num[i]));
		}
		mean = calcMean();
		SD = calcSD(mean);

	}

	/**
	 * Calc SD.
	 *
	 * @param mean the mean
	 * @return the SD
	 */
	private static double calcSD(double mean) {
		SD = Math.sqrt(variance(linkList.getSize(), mean));
		return SD;
	}

	/**
	 * Variance.
	 *
	 * @param length the length of linkList
	 * @param mean   the mean
	 * @return the variance
	 */
	private static double variance(double length, double mean) {

		// Compute sum squared differences with
		// mean.
		double sqDiff = 0;
		on = linkList.getHead();
		sqDiff += (linkList.getHead().n - mean) * (linkList.getHead().n - mean);
		while (on.next != null) {
			on = on.next;
			sqDiff += (on.n - mean) * (on.n - mean);
		}
		return sqDiff / length;
	}

	/**
	 * Calc mean.
	 *
	 * @return the mean
	 */
	private static double calcMean() {
		double sum = 0;
		on = linkList.getHead();
		;
		sum += on.n;
		while (on.next != null) {
			on = on.next;
			sum += on.n;
		}
		// Get the length of the array
		double numbersCnt = num.length;
		// Return the average / mean.
		mean = (sum / numbersCnt);
		return mean;
	}

	/**
	 * Gets the mean.
	 *
	 * @return the mean
	 */
	public static double getMean() {
		return mean;
	}

	/**
	 * Gets the sd.
	 *
	 * @return the sd
	 */
	public static double getSD() {
		return SD;
	}

}