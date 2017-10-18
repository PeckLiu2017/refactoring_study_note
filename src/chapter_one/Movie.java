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
	
}

