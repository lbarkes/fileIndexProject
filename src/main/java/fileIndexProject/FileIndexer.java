package fileIndexProject;

import java.io.BufferedReader;
import java.io.File;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.IOException;

public class FileIndexer {
	public ArrayList<Pair> read(File file) throws IOException{
		try{
			BufferedReader input = new BufferedReader(new FileReader(file));
			ArrayList<Pair> set = new ArrayList<Pair>();
			StringBuilder word = new StringBuilder();
			int letterInt;
			int curPosition = 0;
			boolean start = false;
			int prevPosition = 0;
			while((letterInt = input.read()) != -1){ //continue until end of file/stream is reached
				curPosition++;
				char letter = (char)letterInt;
				//check if letter is a part of a word
				if(letter != ' ' && letter != '\n' && letter != '\r' && letter != '\t' && letter != '\b' && letter != '\f'){
					if(start == false){ //new word found
						start = true;
						prevPosition = curPosition;
						word.append(letter);
					}
					else{//word is continuing 
						
						/*if word ends with comma or period, add the word without the comma or period 
						 * and then when character not part of word is found,
						add word with comma or period*/
						if(letter == ',' || letter == '.'){
							Pair pair = new Pair(word.toString(), prevPosition);
							set.add(pair);
						}
						word.append(letter);
					}
				}
				else if(start == true){ // word has ended
					start = false;
					Pair pair = new Pair(word.toString(), prevPosition);
					set.add(pair); //add pair to the set of pairs;
					prevPosition = curPosition;
					word.setLength(0);
				}
				else{ //none word character found that is not part of a word
					prevPosition = curPosition;
				}
			}
			input.close();
			return set;
		} catch(IllegalArgumentException e) {
			System.out.println("Error: File not found.");
			return null;
		}
		
	}
}
