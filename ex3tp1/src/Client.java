/*
import java.rmi.Naming;

public class Client
{
    public static void main(String[] args)
    {
        // TODO Auto-generated method stub

        try
        {
            BankAccountInterface bank = (BankAccountInterface) Naming.lookup("rmi://localhost/Bank");
            System.out.println ("RMI client is ready!");
            System.out.println(bank.consultation(1));
            System.out.println(bank.consultation(2));
            System.out.println(bank.consultation(3));



            System.out.println(bank.depot(2,50));

            System.out.println(bank.retrait(1,30));

            System.out.println(bank.depot(3,300));

            System.out.println(bank.consultation(1));
            System.out.println(bank.consultation(2));
            System.out.println(bank.consultation(3));


        }
        catch (Exception e)
        {
            System.out.println ("RMI Client is failed because " + e);
        }
    }
} */


import java.rmi.Naming;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {
        try {
            BankAccountInterface bank = (BankAccountInterface) Naming.lookup("rmi://localhost/Bank");
            System.out.println(" RMI client is ready!");

            Scanner sc = new Scanner(System.in);

            System.out.print(" Entrer votre IBAN : ");
            int iban = sc.nextInt();

            // Vérifier si le compte existe
            try {
                double solde = bank.consultation(iban);
                System.out.println(" Compte trouvé ! Solde actuel : " + solde);
            } catch (Exception e) {
                System.out.println(" Compte inexistant !");
                return;
            }

            int choix;
            do {
                System.out.println("\n=== MENU ===");
                System.out.println("1. Consultation du solde");
                System.out.println("2. Dépôt");
                System.out.println("3. Retrait");
                System.out.println("0. Quitter");
                System.out.print(" Votre choix : ");
                choix = sc.nextInt();

                switch (choix) {
                    case 1:
                        System.out.println(" Solde actuel : " + bank.consultation(iban));
                        break;

                    case 2:
                        System.out.print(" Montant à déposer : ");
                        double montantDepot = sc.nextDouble();
                        System.out.println("Nouveau solde : " + bank.depot(iban, montantDepot));
                        break;

                    case 3:
                        System.out.print("👉 Montant à retirer : ");
                        double montantRetrait = sc.nextDouble();
                        System.out.println(" Nouveau solde : " + bank.retrait(iban, montantRetrait));
                        break;

                    case 0:
                        System.out.println(" Merci d'avoir utilisé notre service !");
                        break;

                    default:
                        System.out.println("️ Choix invalide !");
                }
            } while (choix != 0);

            sc.close();

        } catch (Exception e) {
            System.out.println(" RMI Client failed because: " + e);
        }
    }
}

