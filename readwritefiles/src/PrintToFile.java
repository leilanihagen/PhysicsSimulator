

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

public class PrintToFile {

	public static void main(String[] args) throws FileNotFoundException, UnsupportedEncodingException {
		// Print lines of text to an output file:
		PrintWriter writer = new PrintWriter("dump.txt", "UTF-8");
		writer.println("It works!");
		writer.close();
	}
}
