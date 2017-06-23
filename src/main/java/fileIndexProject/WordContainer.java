package fileIndexProject;
import java.util.Hashtable;
import java.util.Set;
import java.util.ArrayList;
/**
 * 
 * @author lbarkes
 * A hashtable of arraylists.
 * the key is the word and the value a arrayList of Pairs that hold a position and filepath of the word key
 */
public class WordContainer {
	private Hashtable<String, ArrayList<Pair>> data;
	

	public WordContainer() {
		this.data = new Hashtable<String, ArrayList<Pair>>();
		
	}
	
	//inserts new LetterContainer class into the hash table
	public void put(String word, Pair pair){
		if(!this.data.containsKey(word)){
			ArrayList<Pair> pairs = new ArrayList<Pair>();
			pairs.add(pair);
			data.put(word, pairs);
		}
		else {
			ArrayList<Pair> pairs = data.get(word);
			pairs.add(pair);
		}
	}
	
	
	public ArrayList<Pair> get(String key){
		if(!this.data.containsKey(key)){
			return null;
		}
		else {
			return data.get(key);
		}
	}
	
	public void findWord(String key){
		//do stuff
		printKeyResult(this.data.get(key));
		
	}
	
	/**
	 * 
	 * @param phrase
	 * finds if the phrase exists in the files
	 * Input: String phrase, only excepts characters a-Z, 0-9, comma, period, whitespace
	 * Output: System out of file and position beginning of phrase
	 */
	public void findPhrase(String phrase){
		if(phrase.equals("")){ //check for empty input
			return;
		}
		else if(phrase.trim().length() == 0){ //check for string that is only whitespace
			return;
		}
		//initialize everything
		StringBuilder word = new StringBuilder();
		ArrayList<String> phraseSplit = new ArrayList<String>();
		boolean isWord = false;
		boolean added = false;
		phrase = phrase.trim(); //trim leading and trailing whitespace
		
		//split the phrase by whitespace
		for(int i = 0; i < phrase.length(); i++){
			if(phrase.charAt(i) == ' '){
				if(isWord == false){
					phraseSplit.add(" ");
					added = true;
				}
				else if(isWord == true){
					isWord = false;
					phraseSplit.add(word.toString());
					word.setLength(0);
					phraseSplit.add(" ");
					added = false;
				}
			}
			else {
				isWord = true;
				added = false;
				word.append(phrase.charAt(i));
			}
		}
		//add last word if it is not added
		if(added == false){
			phraseSplit.add(word.toString());
		}
		
		//check if phrase is actually just one word
		if(this.data.containsKey(phraseSplit.get(0)) && phraseSplit.size() == 1){
			findWord(phraseSplit.get(0));
			return;
		}
		
		//find if phrase exists
		//TODO
		int totalWhiteSpace = 0;
		ArrayList<Pair> wordList1 = new ArrayList<Pair>();
		wordList1 = this.data.get(phraseSplit.get(0));
		String word1 = "";
		String word2 = "";
		int j = 1;
		for(int i = 0; i < phraseSplit.size()-1; i++){
			while(phraseSplit.get(j).equals(" ")){ //add up white space in between both words
				totalWhiteSpace++;
				j++;
			}
			
			//check if both i and i++ words are in data.
			if(this.data.containsKey(phraseSplit.get(i)) && this.data.containsKey(phraseSplit.get(j))){
				word1 = phraseSplit.get(i);
				word2 = phraseSplit.get(j);
				ArrayList<Pair> wordList2 = new ArrayList<Pair>();
				ArrayList<Pair> wordList = new ArrayList<Pair>();
				wordList2 = this.data.get(phraseSplit.get(j));
				boolean search = false;
				// Then compare the sets of each word.
				for(Pair pair1 : wordList1){
					for(Pair pair2 : wordList2){
						if(pair1.getFilePath().equals(pair2.getFilePath())){//if their file paths are the same
							if((pair1.getPosition() + totalWhiteSpace + word1.length()) == pair2.getPosition()){ //if they are next to each other
								search = true;
								wordList.add(pair2);
							}
						}
					}
				}
				if(search == false){ //nothing matches
					System.out.println("This phrase does not exist.");
					return;
				}
				wordList1 = wordList;
				totalWhiteSpace = 0;
				i = j-1; //move i to the next 
				j++;
			}
			else{
				System.out.println("This phrase does not exist.");
				return;
			}
		}
		if(wordList1.isEmpty()){
			System.out.println("This phrase does not exist.");
			return;
		}
		else{
			for(Pair phrases : wordList1){
				System.out.println("File Path: " + phrases.getFilePath());
				System.out.println("Phrase Position: " + (phrases.getPosition() + word2.length() - phrase.length()));
			}
		}
	}
	
	public void printWordContainer(){
		Set<String> keys = this.data.keySet();
		for(String key: keys){
			ArrayList<Pair> pairs = this.data.get(key);
			for (Pair pair : pairs) {
				System.out.println("Word: "+key+"\t Position: "+pair.getPosition() + "\t File: " + pair.getFilePath());
			}
            
        }
	}
	
	public void printKeyResult(ArrayList<Pair> set){
		if(set != null){
			for(Pair pair : set){
				System.out.println("File Path: " + pair.getFilePath());
				System.out.println("Word Position: " + pair.getPosition());
			}
		}
		else {
			System.out.println("Word does not exist in data set.");
		}
	}
	
	
}