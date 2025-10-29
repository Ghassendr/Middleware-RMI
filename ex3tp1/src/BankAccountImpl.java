import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;

public class BankAccountImpl extends UnicastRemoteObject implements BankAccountInterface{


    private HashMap<Integer, Double> comptes;

    public BankAccountImpl() throws RemoteException {
        super();
        comptes = new HashMap<>();

        comptes.put(1, 500.0);
        comptes.put(2, 1200.0);
        comptes.put(3, 0.0);
    }



    @Override
    public String retrait(int iban, double montant) throws RemoteException {
        double solde = comptes.get(iban);
        comptes.put(iban, comptes.get(iban)-montant);
        return "Retrait de " + montant + " effectue de iban "+iban;
    }

    @Override
    public String depot(int iban, double montant) throws RemoteException {

        comptes.put(iban, comptes.get(iban) + montant);
        return "depot ok  pour iban " +comptes.get(iban) ;
    }

    @Override
    public double consultation(int iban) throws RemoteException {
        return comptes.get(iban);
    }
}




