
/*
 * @author jguedel
 * @version 1.0
 * 
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

// TODO: Auto-generated Javadoc
/**
 * The Class tests.
 */
public class tests {

	/**
	 * Not num.
	 *
	 * @param value one number from file
	 * @return true, if value is not a number
	 */
	public static boolean notNum(String value) {
		// IF NUMBER CONTAINS INVALID CHARACTER MAKING IT NOT A REAL NUMBER
		boolean test = true;
		for (int i = 0; i <= value.length() - 1; i++) {
			char check = value.charAt(i);
			if (Character.isDigit(check))
				test = false;
			else {
				test = true;
				break;
			}

		}
		return test;
	}

	/**
	 * Checks if is empty.
	 *
	 * @param listNums the list of numbers
	 * @return true, if is empty
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	public static boolean isEmpty(File listNums) throws IOException {
		BufferedReader br = new BufferedReader(new FileReader(listNums));
		if (br.readLine() == null) {
			br.close();
			return true;
		} else {
			br.close();
			return false;
		}
	}

}
