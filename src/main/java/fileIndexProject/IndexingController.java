package fileIndexProject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class IndexingController {
	
	private String directory; 
	
	public WordContainer indexDirectory(String dir) throws IOException{
		this.directory = dir;
		WordContainer index = new WordContainer();
		FileFinder f = new FileFinder();
		File[] test = f.find(dir);
		if(test == null){
			return null;
		}
		for(File file : test){
			ArrayList<Pair> set = new ArrayList<Pair>();
			if(test != null){
				FileIndexer r = new FileIndexer();
				try{
					set = r.read(file);
				} catch(IllegalArgumentException e) {
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
	
	public String getDirectory(){
		return directory;
	}
	
}
