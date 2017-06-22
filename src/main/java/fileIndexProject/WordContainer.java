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
	
	public void findPrint(String key){
		ArrayList<Pair> set = new ArrayList<Pair>();
		set = data.get(key);
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
	
	public void printWordContainer(){
		Set<String> keys = this.data.keySet();
		for(String key: keys){
			ArrayList<Pair> pairs = this.data.get(key);
			for (Pair pair : pairs) {
				System.out.println("Word: "+key+"\t Position: "+pair.getPosition() + "\t File: " + pair.getFilePath());
			}
            
        }
	}
	
	
}