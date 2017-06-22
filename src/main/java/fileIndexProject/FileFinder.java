package fileIndexProject;

import java.io.File;
import java.io.FilenameFilter;

/**
 * 
 * Return all files in entered directory
 *
 */
public class FileFinder {
	public File[] find(String dirName){ 
        File dir = new File(dirName);
        return dir.listFiles(new FilenameFilter() { 
                 public boolean accept(File dir, String filename)
                      { return filename.endsWith(".txt"); }
        } );

    }
}
