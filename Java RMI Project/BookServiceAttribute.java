import java.io.Serializable;
import java.util.ArrayList;

/**
 * @author Nuggus
 * 
 */
public class BookServiceAttribute implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	String topic1, topic2, topic, bookName, author;
	long avgSearch,avgLookup,avgOrder;
	int copies, orderNo;
	int searchRequests;
	int lookupRequests;
	int orderRequests;
	int sucessOrders;
	int failureOrders;
	String bookId;
	double price;
	ArrayList<String> bookIdlist = new ArrayList<String>();

	public long getAvgSearch() {
		return avgSearch;
	}

	public void setAvgSearch(long avgSearch) {
		this.avgSearch = avgSearch;
	}

	public long getAvgLookup() {
		return avgLookup;
	}

	public void setAvgLookup(long avgLookup) {
		this.avgLookup = avgLookup;
	}

	public long getAvgOrder() {
		return avgOrder;
	}

	public void setAvgOrder(long avgOrder) {
		this.avgOrder = avgOrder;
	}

	public int getSearchRequests() {
		return searchRequests;
	}

	public void setSearchRequests(int searchRequests) {
		this.searchRequests = searchRequests;
	}

	public int getLookupRequests() {
		return lookupRequests;
	}

	public void setLookupRequests(int lookupRequests) {
		this.lookupRequests = lookupRequests;
	}

	public int getOrderRequests() {
		return orderRequests;
	}

	public void setOrderRequests(int orderRequests) {
		this.orderRequests = orderRequests;
	}

	public int getSucessOrders() {
		return sucessOrders;
	}

	public void setSucessOrders(int sucessOrders) {
		this.sucessOrders = sucessOrders;
	}

	public int getFailureOrders() {
		return failureOrders;
	}

	public void setFailureOrders(int failureOrders) {
		this.failureOrders = failureOrders;
	}

	public String getTopic1() {
		return topic1;
	}

	public void setTopic1(String topic1) {
		this.topic1 = topic1;
	}

	public String getTopic2() {
		return topic2;
	}

	public void setTopic2(String topic2) {
		this.topic2 = topic2;
	}

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getBookName() {
		return bookName;
	}

	public void setBookName(String bookName) {
		this.bookName = bookName;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public int getCopies() {
		return copies;
	}

	public void setCopies(int copies) {
		this.copies = copies;
	}

	public int getOrderNo() {
		return orderNo;
	}

	public void setOrderNo(int orderNo) {
		this.orderNo = orderNo;
	}

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public ArrayList<String> getBookIdlist() {
		return bookIdlist;
	}

	public void setBookIdlist(ArrayList<String> bookIdlist) {
		this.bookIdlist = bookIdlist;
	}

}
