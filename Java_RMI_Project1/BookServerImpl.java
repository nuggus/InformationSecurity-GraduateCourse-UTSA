import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Random;

public class BookServerImpl extends UnicastRemoteObject implements
		BookServerInterface {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	int searchRequests;
	int lookupDetails;
	int orderRequests;
	int sucessOrders;
	int failureOrders;
	long startTime = 0, endTime = 0;
	long searchTime = 0, lookupTime = 0, orderTime = 0;

	public BookServerImpl() throws RemoteException {
	}
//search functionality
	public BookServiceAttribute search(String topic) throws RemoteException {
		startTime = System.currentTimeMillis();
		BookServiceAttribute bookAttributes = new BookServiceAttribute();
		RetrieveRow r = new RetrieveRow();
		ArrayList<String> bookIdlist = new ArrayList<String>();
		try {

			bookIdlist = r.retrieve_bookId(topic);
			bookAttributes.setBookIdlist(bookIdlist);
			searchRequests++;
			// r.update_noOfRequests("search", searchRequests);
			bookAttributes.setSearchRequests(searchRequests);

		} catch (SQLException e) {
			System.out.println("Service down!");
		}
		endTime = System.currentTimeMillis();
		searchTime += (endTime - startTime);
		return bookAttributes;

	}
//lookup functionality to view book details
	public BookServiceAttribute bookDetails(String bookId)
			throws RemoteException {
		startTime = System.currentTimeMillis();
		BookServiceAttribute bookAttributes = new BookServiceAttribute();
		BookServiceAttribute temp = new BookServiceAttribute();
		RetrieveRow r = new RetrieveRow();
		try {

			temp = r.retrieve_bookDetails(bookId);
			bookAttributes.setAuthor(temp.getAuthor());
			bookAttributes.setBookId(temp.getBookId());
			bookAttributes.setBookName(temp.getBookName());
			bookAttributes.setCopies(temp.getCopies());
			bookAttributes.setPrice(temp.getPrice());
			bookAttributes.setTopic(temp.getTopic());
			lookupDetails++;
			bookAttributes.setLookupRequests(lookupDetails);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		endTime = System.currentTimeMillis();
		lookupTime += (endTime - startTime);
		return bookAttributes;

	}

	Random t = new Random();
//order functionality hadles both sucess and failure cases
	public BookServiceAttribute orderBook(String bookId, int no)
			throws RemoteException {
		startTime = System.currentTimeMillis();
		int count = 0;
		int orderNo = 0;
		BookServiceAttribute bookAttributes = new BookServiceAttribute();
		BookServiceAttribute temp = new BookServiceAttribute();
		RetrieveRow r = new RetrieveRow();
		try {

			temp = r.retrieve_bookDetails(bookId);
			bookAttributes.setCopies(temp.getCopies());
			if ((temp.getCopies() < no)) {
				bookAttributes.setOrderNo(0);
				failureOrders++;
				bookAttributes.setFailureOrders(failureOrders);
			} else {
				orderNo = t.hashCode() * count;
				bookAttributes.setOrderNo(orderNo);
				int updateNo = temp.getCopies() - no;
				boolean result = r.update_noOfCopies(bookId, updateNo);
				System.out.println("update status:" + result);
				sucessOrders++;
				bookAttributes.setSucessOrders(sucessOrders);
			}
		} catch (SQLException e) {
			System.out.println("");
		}
		endTime = System.currentTimeMillis();
		orderTime += (endTime - startTime);
		System.out.println(orderTime);
		return bookAttributes;

	}
//to generate reports
	public BookServiceAttribute reports() throws RemoteException {
		BookServiceAttribute bookAttributes = new BookServiceAttribute();
		bookAttributes.setSearchRequests(searchRequests);
		bookAttributes.setSucessOrders(sucessOrders);
		bookAttributes.setFailureOrders(failureOrders);
		bookAttributes.setLookupRequests(lookupDetails-(sucessOrders+failureOrders));
		System.out.println(orderTime);
		if(searchRequests>0)
		bookAttributes.setAvgSearch((searchTime / searchRequests));
		if(lookupDetails-(sucessOrders+failureOrders)>0)
		bookAttributes.setAvgLookup(lookupTime / lookupDetails);
		if((sucessOrders+failureOrders)>0)
		bookAttributes.setAvgOrder((orderTime / (sucessOrders+failureOrders)));
		return bookAttributes;
	}
}
