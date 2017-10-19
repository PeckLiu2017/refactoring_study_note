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

	// 测试第四个字符是'd'
	@Test
	public void testRead() throws IOException{
		char ch = '&';
		// 这个循环返回读到的最后一个char
		for (int i = 0; i < 4; i++) {
			ch = (char)_input.read();
		}
		assertEquals('d', ch);
	}
	
	// 测试文件一共有227个字符
	// 当它被读完之后
	// 如果程序没错
	// _input.read()会返回-1
	@Test
	public void testReadAtEnd() throws IOException{
		int ch = -1234;
		// 这个循环返回读到的最后一个char
		for (int i = 0; i < 227; i++) {
			ch = _input.read();
		}
		assertEquals(-1, _input.read());
	}
	
	// 测试最后一个字符是'6'
	@Test
	public void testReadLast() throws IOException{
		char ch = '&';
		// 这个循环返回读到的最后一个char
		for (int i = 0; i < 227; i++) {
			ch = (char)_input.read();
		}
		assertEquals('6', ch);	
	}
	
	public void testReadBoundaries() throws IOException{
		assertEquals("read first char", 'B', _input.read());
		int ch;
		for (int i = 1; i < 227; i++) {
			ch = _input.read();
		}
//		assertEquals("read last char", '6', _input.read());
		assertEquals("read at end", -1, _input.read());
	}
	
	// 一次增加所有测试
	public static void main(String[] args) {
		junit.textui.TestRunner.run(new TestSuite(FileReaderTester.class));
	}


}
