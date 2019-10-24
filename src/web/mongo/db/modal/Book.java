package web.mongo.db.modal;

public class Book {
	private int bookId;
	private String bookName;
	private String bookAuthor;
	public String getBookType() {
		return bookType;
	}

	public void setBookType(String bookType) {
		this.bookType = bookType;
	}

	private String bookType;
	private String addReviews;
	
	public Book(int a, String b, String c, String e){
		this.bookId=a;
		this.bookName=b;
		this.bookAuthor=c;
		//this.addReviews=d;
		this.bookType=e;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getBookAuthor() {
		return bookAuthor;
	}

	public void setBookAuthor(String bookAuthor) {
		this.bookAuthor = bookAuthor;
	}

	public String getAddReviews() {
		return addReviews;
	}

	public void setAddReviews(String addReviews) {
		this.addReviews = addReviews;
	}
}
