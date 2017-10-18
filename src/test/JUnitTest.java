package test;

import static org.junit.Assert.*;

import org.junit.Test;

import chapter_one.Customer;
import chapter_one.Movie;
import chapter_one.Rental;
import junit.framework.TestCase;

public class JUnitTest extends TestCase{

	@Test
	public void test() {
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
}
