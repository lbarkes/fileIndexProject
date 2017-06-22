package fileIndexProject;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileReaderTest {
	
	private FileFinder f;
	private File[] test;
	private FileReader reader;
	
	@Before
	public void setUp() throws Exception {
		this.f = new FileFinder();
		this.test = f.find("C:\\Users\\lbarkes\\workspace\\fileIndexProject\\src\\test\\resources");
		this.reader = new FileReader();
	}

	@After
	public void tearDown() throws Exception {
		this.f = null;
		this.test = null;
		this.reader = null;
	}

	@Test
	public void test() throws FileNotFoundException {
		ArrayList<Pair> set = new ArrayList<Pair>();
		set = reader.read(this.test[0]);
		
		for(Pair pair : set){
			System.out.println(pair.getFilePath() + " " + pair.getPosition());
		}
		
		assertEquals(set.get(0).getFilePath(), "Hello");
		assertEquals(set.get(1).getFilePath(), "my");
		assertEquals(set.get(2).getFilePath(), "name");
		assertEquals(set.get(3).getFilePath(), "is");
		assertEquals(set.get(4).getFilePath(), "Logan");
		assertEquals(set.get(5).getFilePath(), "This");
		assertEquals(set.get(6).getFilePath(), "is");
		assertEquals(set.get(7).getFilePath(), "a");
		assertEquals(set.get(8).getFilePath(), "test");
		
		assertEquals(set.get(0).getPosition(), 0);
		assertEquals(set.get(1).getPosition(), 6);
		assertEquals(set.get(2).getPosition(), 9);
		assertEquals(set.get(3).getPosition(), 14);
		assertEquals(set.get(4).getPosition(), 17);
		assertEquals(set.get(5).getPosition(), 24);
		assertEquals(set.get(6).getPosition(), 29);
		assertEquals(set.get(7).getPosition(), 32);
		assertEquals(set.get(8).getPosition(), 34);
		
		
		
	}

}
