package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chapter_one.Customer;
import chapter_one.Movie;
import chapter_one.Rental;
import junit.framework.TestCase;

public class JUnitTest extends TestCase{
	
	// 重构应该使代码的意图变得容易理解
	// 像这里的测试代码的意思就是
	// 一部新发行电影，价格码是1
	// 租了2天
	// 根据电影价格码，天数参数来计算租电影的价格以及随之增加的顾客积分
	@Test
	public void test_new_release_movie() {
		Movie movie = new Movie("New_Release_Movie", 1);
		Rental rental = new Rental(movie, 2);
		Customer customer = new Customer("peck");
		customer.addRental(rental);
		String result = customer.statement();
		assertEquals(result , "Rental Record for	peck\n" + 
				"	New_Release_Movie	6.0\n" + 
				"Amount owed is 6.0\n" + 
				"You earned 2 frequent renter points");
	}
	
	@Test
	public void test_children_movie() {
		Movie movie = new Movie("Children_Movie", 2);
		Rental rental = new Rental(movie, 2);
		Customer customer = new Customer("peck");
		customer.addRental(rental);
		String result = customer.statement();
		System.out.println(result);
		assertEquals(result , "Rental Record for	peck\n" + 
				"	Children_Movie	1.5\n" + 
				"Amount owed is 1.5\n" + 
				"You earned 1 frequent renter points");
	}
}
