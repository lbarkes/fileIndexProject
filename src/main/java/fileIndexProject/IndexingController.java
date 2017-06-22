package fileIndexProject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class IndexingController {
	
	public WordContainer indexDirectory(String dir){
		WordContainer index = new WordContainer();
		FileFinder f = new FileFinder();
		File[] test = f.find(dir);
		for(File file : test){
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
		return index;
	}
	
}
