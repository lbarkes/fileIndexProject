package fileIndexProject;

import java.io.IOException;
import java.util.Scanner;

public class FileIndexMain {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		WordContainer index = new WordContainer();
		IndexingController indexer = new IndexingController();
		index = indexer.indexDirectory("C:\\Users\\lbarkes\\Documents\\Text Files Test");
		//index.printWordContainer();
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		String input;
		System.out.println("Enter a Phrase: ");
		while(reader.hasNextLine()){
			input = reader.nextLine();
			index.findPhrase(input);
			System.out.println("Enter a Word: ");
			input = reader.nextLine();
			index.findWord(input);
			System.out.println("Enter a Phrase: ");
		}
		reader.close();
		//index.printWordContainer();
		
		
	}

}
