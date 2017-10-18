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
		// 构造器的参数留到下面的方法用
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
	
	// 根据 pricecode 和 daysRented 计算价格
	public double getCharge(int daysRented) {
		return _price.getCharge(daysRented);
	}
	
	// 计算顾客积分
	public int getFrequentRenterPoints(int daysRented) {
		return _price.getFrequentRenterPoints(daysRented);
	}
	
}

