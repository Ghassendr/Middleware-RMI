package RMIClient;



import RMIServer.StudentGradeInterface;
import java.rmi.Naming;

public class RMIClient {
    public static void main(String[] args) {
        try {

            StudentGradeInterface intr = (StudentGradeInterface) Naming.lookup("rmi://localhost/StudentGrade");
            double grade = intr.getStudentGrade(10, "mdlw");
            System.out.println(" grade: " + grade);
        } catch (Exception e) {
            System.out.println("Client error: " + e);
        }
    }
}
