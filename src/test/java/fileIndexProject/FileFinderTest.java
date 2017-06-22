package fileIndexProject;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileFinderTest {
	
	private FileFinder f;

	@Before
	public void setUp() throws Exception {
		this.f = new FileFinder();
		
	}

	@After
	public void tearDown() throws Exception {
		this.f = null;
	}

	@Test
	public void test() {
		File[] test = this.f.find("C:\\Users\\lbarkes\\workspace\\fileIndexProject\\src\\test\\resources");
		assertEquals(test[0].getName(),"6files.txt");
		assertEquals(test[1].getName(),"file 2.txt");
		assertEquals(test[2].getName(),"file1.txt");
		assertEquals(test[3].getName(),"helloWorld.txt");
	}

}
