package RMIServer;



import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RMIServer {
    public static void main(String[] args) {
        try {
            LocateRegistry.createRegistry(1099);
            RMIGradeImpl obj = new RMIGradeImpl();
            Naming.rebind("rmi://localhost/StudentGrade", obj);
            System.out.println("Server is ok");
        } catch (Exception e) {
            System.out.println("Server error: " + e);
        }
    }
}
