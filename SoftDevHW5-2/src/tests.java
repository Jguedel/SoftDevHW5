import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class tests {

	public static boolean notNum(String value) {
		//IF NUMBER CONTAINS INVALID CHARACTER MAKING IT NOT A REAL NUMBER
		if (value.contains("a") || value.contains("b") || value.contains("c") || value.contains("d")
				|| value.contains("e") || value.contains("f") || value.contains("g") || value.contains("h")
				|| value.contains("i") || value.contains("j") || value.contains("k") || value.contains("l")
				|| value.contains("m") || value.contains("n") || value.contains("o") || value.contains("p")
				|| value.contains("q") || value.contains("r") || value.contains("s") || value.contains("t")
				|| value.contains("u") || value.contains("v") || value.contains("w") || value.contains("x")
				|| value.contains("y") || value.contains("z")) {
			return true;
		} else {
			return false;
		}
	}

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
