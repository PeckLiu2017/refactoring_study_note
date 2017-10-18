package chapter_one;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String _title;
	private int _pricecode;
	private Price _price;
	
	public Movie(String title,int pricecode) {
		// TODO Auto-generated constructor stub
		_title = title;
		setPriceCode(pricecode);
	}
	
	public int getPriceCode() {
		return _price.getPriceCode();
	}

	public void setPriceCode(int arg) {
		switch (arg) {
		case REGULAR:
			_price = new RegularPrice();	
			break;
		case CHILDRENS:
			_price = new ChildrensPrice();	
			break;
		case NEW_RELEASE:
			_price = new NewReleasePrice();	
			break;
		default:
			throw new IllegalArgumentException("Incorrect Price Code");
		}
	}

	public String getTitle() {
		return _title;
	}
	
	// 价格计算
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
	
	// 积分计算
	public int getFrequentRenterPoints(int daysRented) {
		// add bonus for a two day new release rental —— 租新片额外加积分
		if ((_pricecode == Movie.NEW_RELEASE) && daysRented > 1) 
			return 2;
		else
			// 正常情况积分加一
			return 1;
	}
	
}

