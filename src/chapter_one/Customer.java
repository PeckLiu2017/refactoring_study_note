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
	
	// 计算租电影的价格以及随之增加的顾客点数
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
	// 为了消除临时变量，临时变量又用到了循环的数据
	// 提取它出来的时候就不得不带着重复的循环代码
	// 根据 pricecode 和 daysRented 计算价格
	private double getTotalCharge() {
		double result = 0;
		Enumeration rentals = _rentals.elements();
		while (rentals.hasMoreElements()) {
			Rental each = (Rental)rentals.nextElement();
			result += each.getCharge();
		}
		return result;
	}
	
	// 计算顾客积分
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
