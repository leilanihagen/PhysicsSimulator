

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFromFile {
	
	private static final String FILENAME = "/Users/Leila/Programming/Physics_Sim/printtofile/dump.txt";
	
	public static void main(String[] args) {
		
		// Initialize readers to null?
		BufferedReader br = null;
		FileReader fr = null;
		
		try {
			
			fr = new FileReader(FILENAME);
			br = new BufferedReader(fr);
			
			String sCurrentLine;
			
			while ((sCurrentLine = br.readLine()) != null) {
				System.out.println(sCurrentLine);
			}
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} finally {
			
			try {
				
				if (br != null) {
					br.close();
				}
				
				if (fr != null) {
					fr.close();
				}
			} catch (IOException ex) {
				
				ex.printStackTrace();
			}
		}
	}
}
