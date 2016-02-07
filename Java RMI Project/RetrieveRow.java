import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class RetrieveRow {
	Connection con = null;
	PreparedStatement stmt = null;

	// case1:retrieves all bookids related to search category of books
	public ArrayList<String> retrieve_bookId(String search) throws SQLException {
		String query = "select * from mybooks where category='" + search + "'";
		System.out.println("query:" + query);
		con = ConnectionEstablishment.createConnection();
		stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		ArrayList<String> bookIdlist = new ArrayList<String>();
		while (rs.next()) {
			String bookid = rs.getString("bookid");
			bookIdlist.add(bookid);
		}
		stmt.close();
		con.close();
		return bookIdlist;
	}

	// case2:retrieve book details based on bookid
	public BookServiceAttribute retrieve_bookDetails(String bookid)
			throws SQLException {
		String query = "select * from mybooks where bookid='" + bookid + "'";
		System.out.println("query:" + query);
		con = ConnectionEstablishment.createConnection();
		stmt = con.prepareStatement(query);
		ResultSet rs = stmt.executeQuery(query);
		BookServiceAttribute bookAttributes = new BookServiceAttribute();
		while (rs.next()) {
			bookAttributes.setBookId(rs.getString("bookid"));
			bookAttributes.setAuthor(rs.getString("author"));
			bookAttributes.setBookName(rs.getString("bookname"));
			bookAttributes.setPrice(rs.getDouble("price"));
			bookAttributes.setTopic(rs.getString("category"));
			bookAttributes.setCopies(rs.getInt("copies"));
		}
		stmt.close();
		con.close();
		return bookAttributes;
	}

	// case3:update no of copies
	public Boolean update_noOfCopies(String bookid, int no) throws SQLException {

		String query = "update mybooks set copies=" + no + " where bookid='"
				+ bookid + "'";
		System.out.println("query:" + query);
		con = ConnectionEstablishment.createConnection();
		stmt = con.prepareStatement(query);
		int rows = stmt.executeUpdate();
		stmt.close();
		con.close();
		if (rows != 0)
			return true;
		else
			return false;
	}

}
