package chapter_four;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.junit.Test;

import junit.framework.TestCase;
import junit.framework.TestSuite;

public class FileReaderTester extends TestCase {

	FileReader _input;
	// 好像相对路径不管用，只能这样写绝对路径，把家目录用"~"表示也不行
	File file = new File("/Users/peckliu/Java_Project/refactoring_study_note/src/chapter_four/data.txt");
	
	public FileReaderTester(String name) {
		super(name);
	}	


	protected void setUp() throws Exception {
		try {
			_input = new FileReader(file);
		} catch (FileNotFoundException e) {
			// TODO: handle exception
			throw new RuntimeException("unable to open test file");
		}
	}

	protected void tearDown() throws Exception {
		try {
			_input.close();
		} catch (IOException e) {
			// TODO: handle exception
			throw new RuntimeException("error on open test file");
		}
	}

	@Test
	public void testRead() throws IOException{
		char ch = '&';
		for (int i = 0; i < 4; i++) {
			System.out.println(ch);
			ch = (char)_input.read();
		}
		assert ('d' == ch);
	}
	
	public static TestSuite suite() {
		TestSuite suite = new TestSuite();
		suite.addTest(new FileReaderTester("testRead"));
		return suite;
	}
	
	public static void main(String[] args) {
		junit.textui.TestRunner.run(suite());
	}

}
