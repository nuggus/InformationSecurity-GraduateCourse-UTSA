import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author Nuggus
 * 
 */
public class BookClient {

	static int searchRequests;
	static int lookupDetails;
	static int sucessOrders;
	static int failureOrders;

	public static void main(String args[]) {
		int choice = 0;

		String a = "y";
		String bId = "y";

		Scanner scan = new Scanner(System.in);
		try {
			//security manager for the client
			System.setProperty("java.system.policy", "policy.all");

			BookServiceAttribute bookServiceAttribute = new BookServiceAttribute();

			Registry registry = LocateRegistry.getRegistry(args[0], 8080);
			BookServerInterface bookServerIntf = (BookServerInterface) registry
					.lookup("//" + args[0] + "/BookServer");

			while (a.equalsIgnoreCase("y")) {
				System.out.println("1. Search");
				System.out.println("2. Lookup");
				System.out.println("3. Order");
				System.out.println("4. Reports");
				System.out.println("Enter your choice:");
				// Scanner in = new Scanner(System.in);
				choice = scan.nextInt();
				if (choice >= 1 && choice <= 5) {
					switch (choice) {
					case 1:// search it will display bookIds based on category

						System.out.println("Enter your search topic:");
						Scanner input = new Scanner(System.in);
						String search = input.nextLine();
						ArrayList<String> bookIdlist = new ArrayList<String>();
						bookServiceAttribute = bookServerIntf.search(search);
						bookIdlist = bookServiceAttribute.getBookIdlist();

						if (bookIdlist.isEmpty()) {
							System.out
									.println("No books are available in the topic "
											+ search);
						} else {
							System.out.println("Book Id's related to" + " "
									+ search + " are:");
							for (int i = 0; i < bookIdlist.size(); i++) {
								System.out.println("BookId: "
										+ bookIdlist.get(i));

							}
						}

						break;
					case 2:
						System.out
								.println("\nEnter the book Id to view book details:");
						bId = scan.next();

						bookServiceAttribute = bookServerIntf.bookDetails(bId);
						lookupDetails = bookServiceAttribute
								.getLookupRequests();
						if (bookServiceAttribute.getBookName() != null) {

							System.out.println("Your Book details");
							System.out
									.println("\nBOOKID\t\t\tBOOKNAME\t\t\tAUTHOR\t\tBOOK PRICE\tCOPIES");
							System.out.println(bookServiceAttribute.getBookId()
									+ "\t" + bookServiceAttribute.getBookName()
									+ "\t" + bookServiceAttribute.getAuthor()
									+ "\t" + bookServiceAttribute.getPrice()
									+ "\t" + bookServiceAttribute.getCopies());

						} else {
							System.out
									.println("Requested book details are not available!");
						}
						break;

					case 3:
						System.out
								.println("\nEnter the book Id you need an order:");
						bId = scan.next();
						bookServiceAttribute = bookServerIntf.bookDetails(bId);
						System.out.println("\nNo of Copies available for "
								+ bId + "requested:"
								+ bookServiceAttribute.getCopies());
						System.out.println("\nEnter no of copies:");
						int noOfCopies = scan.nextInt();
						bookServiceAttribute = bookServerIntf.orderBook(bId,
								noOfCopies);
						if (bookServiceAttribute.getCopies() != 0
								&& bookServiceAttribute.getCopies() >= noOfCopies) {

							System.out.println("\nyour order is sucessful!");
							System.out.println("\nyour order no:"
									+ bookServiceAttribute.getOrderNo());
							sucessOrders = bookServiceAttribute
									.getSucessOrders();
						} else {
							System.out
									.println("your order is not sucessful, due to out of stock!");
							failureOrders = bookServiceAttribute
									.getFailureOrders();
						}
						break;
					case 4:
						bookServiceAttribute = bookServerIntf.reports();
						searchRequests = bookServiceAttribute
								.getSearchRequests();
						lookupDetails = bookServiceAttribute
								.getLookupRequests();
						sucessOrders = bookServiceAttribute.getSucessOrders();
						failureOrders = bookServiceAttribute.getFailureOrders();
						System.out
								.println("1. View Number of Requests for a service");
						System.out
								.println("2. View Number of Orders were sucessful");
						System.out
								.println("3. View Number of Orders were failed");
						System.out.println("4. View Performance of a service");
						int subchoice = 0;
						System.out.println("Enter your choice:");
						subchoice = scan.nextInt();
						switch (subchoice) {
						case 1:
							System.out.println("Total Requests for search:"
									+ searchRequests);
							System.out.println("Total Requests for Lookup:"
									+ lookupDetails);
							System.out.println("Total orders requested:"
									+ (sucessOrders + failureOrders));

							break;// case 1 break in sub switch
						case 2:
							System.out.println("Total Sucessful Orders:"
									+ sucessOrders);
							break;// case 2 break in sub switch
						case 3:
							System.out.println("Total Orders failed:"
									+ failureOrders);
							break;// case 3 break in sub switch
						case 4:
							System.out.println("Performance of search request:"
									+ bookServiceAttribute.getAvgSearch()
									+ "milliseconds");
							System.out.println("Performance of lookup request:"
									+ bookServiceAttribute.getAvgLookup()
									+ "milliseconds");
							System.out.println("Performance of order request:"
									+ bookServiceAttribute.getAvgOrder()
									+ "milliseconds");
							break;// case4 break in sub switch
						default:
							System.out.println("invalid choice!");
							break;
						}
						break;// case 4 break in main switch

					default:
						System.out.println("Enter correct choice!");
						break;
					}// switch

					System.out.println("Continue to Main Menu(Y/N)");
					a = scan.next();
				} else
					System.out.println("Invalid Choice!");
			}
		}// try

		catch (InputMismatchException e) {
			System.out.println("Input only numbers");
		} catch (Exception e) {
			System.out.println("something went wrong please try again!");
		}

	}

}
