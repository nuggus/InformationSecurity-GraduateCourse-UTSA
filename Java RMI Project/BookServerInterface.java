import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BookServerInterface extends Remote {
	BookServiceAttribute search(String topic) throws RemoteException;//for search
	BookServiceAttribute bookDetails(String bookId) throws RemoteException;//for lookup
	BookServiceAttribute orderBook(String bookId,int no) throws RemoteException;//for order
	BookServiceAttribute reports() throws RemoteException;//for reports
}
