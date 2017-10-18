package chapter_one;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String _title;
	private int _pricecode;
	
	public Movie(String title,int pricecode) {
		// TODO Auto-generated constructor stub
		_title = title;
		_pricecode = pricecode;
	}
	
	public int getPriceCode() {
		return _pricecode;
		
	}

	public void setPriceCode(int arg) {
		_pricecode = arg;
	}

	public String getTitle() {
		return _title;
	}
	
	//价格计算
	public double getCharge(int daysRented) {
		double result = 0;
		switch (getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (daysRented > 2) {
				result += (daysRented -2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += daysRented * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (daysRented > 3) {
				result += (daysRented -3) * 1.5;
			}
			break;
		}
		return result;
	}
	
}

