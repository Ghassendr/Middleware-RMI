import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
public class Sever {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            BankAccountImpl obj1 = new BankAccountImpl();
            Naming.rebind("rmi://localhost/Bank", obj1);


            System.out.println("Server is ok");
        } catch (Exception e) {
            System.out.println("Server error: " + e);
        }
    }
}
