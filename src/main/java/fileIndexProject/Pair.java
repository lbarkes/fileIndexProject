package fileIndexProject;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * 
 * @author lbarkes
 * Pair class is a class that holds a string and an int, used for file path 
 * or position of a word and for a word and its position.
 */
public class Pair {
	private String filePath;
	private int position;
	private StringProperty filePathProperty;
	private IntegerProperty positionProperty;
	
	public Pair(String filePath, int position){
		this.filePath = filePath;
		this.position = position;
		this.filePathProperty = new SimpleStringProperty(filePath);
		this.positionProperty = new SimpleIntegerProperty(position);
	}
	
	public String getFilePath() {
		return filePath;
	}
	public void setFilePath(String filePath) {
		this.filePath = filePath;
		this.filePathProperty = new SimpleStringProperty(filePath);
	}
	public int getPosition() {
		return position;
	}
	public void setPosition(int position) {
		this.position = position;
		this.positionProperty = new SimpleIntegerProperty(position);
	}
	public StringProperty getfilePathProperty() {
        return filePathProperty;
    }
	public IntegerProperty getPositionProperty(){
		return positionProperty;
	}
}
