package chapter_one;

public class Rental {
	
	private Movie _movie;
	private int _daysRented;

	public Rental(Movie movie,int daysRented) {
		_movie = movie;
		_daysRented = daysRented;
	}
	
	public int getDaysRented() {
		return _daysRented;
	}
	
	public Movie getMovie() {
		return _movie;
	}

	//价格计算
	public double getCharge() {
		double result = 0;
		switch (getMovie().getPriceCode()) {
		case Movie.REGULAR:
			result += 2;
			if (getDaysRented() > 2) {
				result += (getDaysRented() -2) * 1.5;
			}
			break;
		case Movie.NEW_RELEASE:
			result += getDaysRented() * 3;
			break;
		case Movie.CHILDRENS:
			result += 1.5;
			if (getDaysRented() > 3) {
				result += (getDaysRented() -3) * 1.5;
			}
			break;
		}
		return result;
	}
	
	// add frequent renter points —— 常客积分计算
	public int getFrequentRenterPoints() {
		// add bonus for a two day new release rental —— 租新片额外加积分
		if ((getMovie().getPriceCode() == Movie.NEW_RELEASE) && getDaysRented() > 1) 
			return 2;
		else
			// 正常情况积分加一
			return 1;
	}
}
