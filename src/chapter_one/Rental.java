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
		return _movie.getCharge(_daysRented);
	}
	
	// add frequent renter points —— 常客积分计算
	public int getFrequentRenterPoints() {
			return _movie.getFrequentRenterPoints(_daysRented);
	}
}
