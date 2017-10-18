package chapter_one;

import java.util.Enumeration;
import java.util.Vector;

public class Customer {
	
	private String _name;
	private Vector _rentals = new Vector();
	
	public Customer(String name) {
		// TODO Auto-generated constructor stub
		_name = name;
	}
	
	public void addRental(Rental arg) {
		_rentals.addElement(arg);
	}
	
	public String getName() {
		return _name;
	}
	
	public String statement() {
		int frequentRenterPoints = 0;
		Enumeration rentals = _rentals.elements();
		String result = "Rental Record for" + "\t" + getName() + "\n";
		while (rentals.hasMoreElements()) {
			Rental each = (Rental)rentals.nextElement();
			frequentRenterPoints += each.getFrequentRenterPoints();
			result += "\t" + each.getMovie().getTitle() + "\t"  //租的电影名字和价格
					+ String.valueOf(each.getCharge()) + "\n";
		}
			// add footer lines
			result += "Amount owed is " + String.valueOf(getTotalCharge()) + "\n";
			result += "You earned "
					+ String.valueOf(getTotalFrequentRenterPoints())
					+ " frequent renter points";
			return result;
		}

	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental)rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	
	private int getTotalFrequentRenterPoints() {
		int result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental)rentals.nextElement();
			result += each.getFrequentRenterPoints();
		}
		return result;
	}
}
