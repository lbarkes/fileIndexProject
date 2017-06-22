package fileIndexProject;
/**
 * 
 * @author lbarkes
 * Pair class is a class that holds a string and an int, used for file path 
 * or position of a word and for a word and its position.
 */
public class Pair {
	private String filePath;
	private int position;
	
	public Pair(String filePath, int position){
		this.filePath = filePath;
		this.position = position;
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
	}
	
}
