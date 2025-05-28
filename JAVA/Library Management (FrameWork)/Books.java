public class Books{
	
	String book_name,book_author;
	int book_id;
	double book_price;
	
	static String lib_name = "Anna Library";
	
	Books() {}
	
	 Books (int book_id, String book_name, String book_author, double book_price){
		this.book_id = book_id;
		this.book_name = book_name;
		this.book_author = book_author;
		this.book_price = book_price;
	}
	
	@Override
	public String toString() {
		return "\nBook ID : "+book_id +"\nBook Name: "+book_name+" \nBook Author: "+book_author+"\nBook Price: "+book_price;
	}
}