import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class BookServer {
	public static void main(String args[]) {
		System.setProperty("java.security.policy", "policy.all");
		try {

			BookServerImpl bookServerImpl = new BookServerImpl();

			Registry registry = LocateRegistry.createRegistry(8080);
			registry.rebind("//"+args[0]+"/BookServer", bookServerImpl);

			Naming.rebind("BookServer", bookServerImpl);
			System.out.println("Server is running...");

		} catch (Exception e) {
			System.out.println("Exception: " + e);
		}
	}
}
