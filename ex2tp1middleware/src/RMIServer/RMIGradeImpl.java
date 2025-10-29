package RMIServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class RMIGradeImpl extends UnicastRemoteObject implements StudentGradeInterface {

    public RMIGradeImpl() throws RemoteException {
        super();
    }

    @Override
    public double getStudentGrade(int studentID, String subjectName) throws RemoteException {
        double grade = Math.random() *10;
        return grade;
    }
}
