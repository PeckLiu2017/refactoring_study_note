package chapter_one;

public class NewReleasePrice extends Price{

	@Override
	public int getPriceCode() {
		// TODO Auto-generated method stub
		return Movie.NEW_RELEASE;
	}

	@Override
	public double getCharge(int daysRented) {
		return daysRented * 3;
	}
	
	// 不是抽象方法的情况下，程序先执行这里的函数，再执行 price 里的函数
	public int getFrequentRenterPoints(int daysRented) {
		// 租新片加两分
		System.out.println("2222");
		return (daysRented >1) ? 2:1;
	}
}
