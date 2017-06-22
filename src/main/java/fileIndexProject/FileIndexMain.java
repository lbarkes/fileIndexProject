package fileIndexProject;

import java.util.Scanner;

public class FileIndexMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordContainer index = new WordContainer();
		IndexingController indexer = new IndexingController();
		index = indexer.indexDirectory("C:\\Users\\lbarkes\\Documents\\Text Files Test");
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		String input;
		System.out.println("Enter a word: ");
		while(reader.hasNextLine()){
			input = reader.nextLine();
			index.findPrint(input);
		}
		reader.close();
		//index.printWordContainer();
		
		
	}

}
