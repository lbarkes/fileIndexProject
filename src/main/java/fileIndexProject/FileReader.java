package fileIndexProject;

import java.io.*;
import java.util.Scanner;
import java.util.ArrayList;
/**
 * 
 * @author lbarkes
 * For a file, get every word and its starting character position
 *
 */
public class FileReader {
	
	public ArrayList<Pair> read(File file) throws FileNotFoundException{
		ArrayList<Pair> set = new ArrayList<Pair>();
		String word = "";
		int position = 0;
		try{
			Scanner input=new Scanner(file);
			input.useDelimiter(" +|(\\.)|(\\n)|(\\r)|(\\t)|(\\b)|(\\f)"); //delimit whitespace, periods, newline, return carriage and tabs
			while(input.hasNext()) {
				word = input.next();
				if(!word.equals("")){
					position = input.match().start();
					Pair pair = new Pair(word, position);
					set.add(pair); //add pair to the set of pairs
				}
			}
			input.close();
			return set;
			
		} catch(FileNotFoundException e) {
			System.out.println("Error: File not found.");
			return null;
		}
		
	}
}
		
		