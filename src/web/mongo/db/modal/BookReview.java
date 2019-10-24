package web.mongo.db.modal;

public class BookReview {
	private String userName;
	private String review;
	
	public BookReview(String a, String b){
		this.userName=a;
		this.review=b;
	}
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getReview() {
		return review;
	}
	public void setReview(String review) {
		this.review = review;
	}
}
