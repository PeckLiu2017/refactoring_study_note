package chapter_one;

public class Movie {

	public static final int CHILDRENS = 2;
	public static final int REGULAR = 0;
	public static final int NEW_RELEASE = 1;
	
	private String _title;
	private int _pricecode;
	
	public Movie() {
		// TODO Auto-generated constructor stub
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
	
}

