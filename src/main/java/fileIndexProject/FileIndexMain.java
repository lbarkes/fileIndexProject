package fileIndexProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class FileIndexMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WordContainer index = new WordContainer();
		FileFinder f = new FileFinder();
		File[] test = f.find("C:\\Users\\lbarkes\\Documents\\Text Files Test");
		for(File file : test){
			//System.out.println("File Name: " + file.getName() + "\t \t" + " File Path: " + file.getAbsolutePath());
			//System.out.println("");
			ArrayList<Pair> set = new ArrayList<Pair>();
			if(test != null){
				FileReader r = new FileReader();
				try{
					set = r.read(file);
				} catch(FileNotFoundException e) {
					System.out.println("Error: File not found.");
				}
			}
			for (Pair wordPos : set){
				Pair posPath = new Pair(file.getAbsolutePath(),wordPos.getPosition());
				index.put(wordPos.getFilePath(),posPath);
			}
		}
		//index.printWordContainer();
		ArrayList<Pair> set = new ArrayList<Pair>();
		Scanner reader = new Scanner(System.in);  // Reading from System.in
		String input;
		System.out.println("Enter a word: ");
		while(reader.hasNextLine()){
			input = reader.nextLine();
			set = index.get(input);
			if(set != null){
				for(Pair pair : set){
					System.out.println("File Path: " + pair.getFilePath());
					System.out.println("Word Position: " + pair.getPosition());
				}
			}
			else {
				System.out.println("Word does not exist in data set.");
			}
			System.out.println("Enter a word: ");
		}
		reader.close();
		
	}

}
