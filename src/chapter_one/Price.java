package chapter_one;

public abstract class Price {
	
	abstract int getPriceCode();
	
	public abstract double getCharge(int daysRented);

	// 这个方法作为默认情况,如果子类中有特殊情况，就被子类覆盖
	public int getFrequentRenterPoints(int daysRented) {
		// 正常情况积分加一
		return 1;
	}

}
