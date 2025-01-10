package ma.enset.mohammedia.iibdcc.exercice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class AppEX2 {
    private static final Scanner scanner = new Scanner(System.in);
    private static List<CompteCourant> compteCourant = new ArrayList<>();
    
    public static void main(String[] args) {
        try {
            int nb;
            do {
                System.out.println("1.Ajouter un compte: ");
                System.out.println("2.Afficher comptes: ");
                System.out.println("3.Supprimer un compte: ");
                System.out.println("4.Effectuer des opérations sur les comptes: ");
                System.out.println("5.Quitter le programme: ");
                nb = scanner.nextInt();
                switch (nb) {
                    case 1:
                        System.out.println("------------Ajout des comptes--------------");
                        System.out.println("Enter numero de compte: ");
                        Long numCompte = scanner.nextLong();
                        System.out.println("Enter solde de compte: ");
                        Double sold = scanner.nextDouble();
                        scanner.nextLine();
                        System.out.println("Enter nom titulaire de comptes: ");
                        String nomTitulaire = scanner.nextLine();
                        compteCourant.add(new CompteCourant(numCompte, sold, nomTitulaire));
                        break;
                    case 2:
                        System.out.println("------------List des comptes-----------------");
                        for (CompteCourant compte : compteCourant) {
                            System.out.println(compte);
                        }
                        break;
                    case 3:
                        System.out.println("Enter numero de compte: ");
                        Long numCompteSupprime = scanner.nextLong();
                        for (CompteCourant compte : compteCourant) {
                            if (Objects.equals(compte.getNumCompte(), numCompteSupprime)) {
                                compteCourant.remove(compte);
                                break;
                            }
                        }
                        break;
                    case 4:
                        EffectuerOperation(compteCourant);
                        break;

                    case 5:
                        System.out.println("Quitter le programme ... ");
                        break;

                }

            }while (nb != 5);
        }catch (FondsInsuffisantsException FIex){
            System.out.println(FIex.getMessage());
        }catch (Exception e) {
            System.out.println(e.getMessage());

        }
    }

    private static void EffectuerOperation(List<CompteCourant> compteCourant){
        System.out.println("Effectuer des operations sur les comptes: ");
        int choiseEffectuer;
        do {
            System.out.println("1.diposer un virement: ");
            System.out.println("2.retrait un montant: ");
            System.out.println("3.verser vers un autre compte: ");
            System.out.println("4.decouvert un montant: ");
            System.out.println("5.epargne un compte: ");
            System.out.println("6.Quitter le programme d'effectuation des operation bancaire : ");
            choiseEffectuer = scanner.nextInt();
            switch (choiseEffectuer) {
                case 1:
                   diposerMontant(compteCourant);
                   break;
                case 2:
                    retraitMontant(compteCourant);
                    break;
                case 3:
                    verserVersAutreCompte(compteCourant);
                    break;
                case 4:
                    decouverCompte(compteCourant);
                    break;
                case 5:
                    epargneCompte(compteCourant);
                    break;
                case 6:
                    System.out.println("Quitter le programme d'effectuer un operation... ");
                    break;

            }

        }while (choiseEffectuer != 6);
    }



    private static void diposerMontant(List<CompteCourant> CompteCourant){
        System.out.println("donner le num de compte: ");
        Long numCompteDiposer = scanner.nextLong();
        boolean isCmptExist = false;
        for (CompteCourant cp: CompteCourant) {
            if (cp.getNumCompte().equals(numCompteDiposer)) {
                System.out.println("donner un montant");
                Double montant = scanner.nextDouble();
                cp.deposer(montant);
                isCmptExist = true;
                break;
            }
        }
        if (!isCmptExist) {
            System.out.println("cette compte n'existe pas");
        }
    }

    private static void retraitMontant(List<CompteCourant> CompteCourant){
        System.out.println("donner le num de compte: ");
        Long numCompteDiposer = scanner.nextLong();
        boolean isCmptExist = false;
        for (CompteCourant cp: CompteCourant) {
            if (cp.getNumCompte().equals(numCompteDiposer)) {
                System.out.println("donner un montant");
                Double montant = scanner.nextDouble();
                cp.retraitSolde(montant);
                isCmptExist = true;
                break;
            }
        }
        if (!isCmptExist) {
            System.out.println("cette compte n'existe pas");
        }
    }

    private static void decouverCompte(List<CompteCourant> compteCourantsList){
        System.out.println("donner le num de compte: ");
        Long numCompteDiposer = scanner.nextLong();
        scanner.nextLine();
        boolean isCmptDecouvertExist = false;
        for (CompteCourant cp: compteCourantsList) {
            if (Objects.equals(cp.getNumCompte(), numCompteDiposer)) {
                System.out.println("donner un montant");
                Double montant = scanner.nextDouble();
                scanner.nextLine();
                System.out.println("donner la valeur du decouvert montant");
                Double decouvetMt = scanner.nextDouble();
                scanner.nextLine();
                cp.retraitSolde(montant, decouvetMt);
                isCmptDecouvertExist = true;
                break;
            }
        }
        if (!isCmptDecouvertExist) {
            System.out.println("cette compte n'existe pas");
        }
    }

    private static void epargneCompte(List<CompteCourant> compteCourantList){
        System.out.println("donner le num de compte: ");
        Long numCompteDiposer = scanner.nextLong();
        scanner.nextLine();
        boolean isCmptEprgneExist = false;
        for (CompteEpargne cp: compteCourantList) {
            if (Objects.equals(cp.getNumCompte(), numCompteDiposer)) {
                System.out.println("donner taux d'interet pour cette compte: " + cp.getNomTitulaire());
                Double taux = scanner.nextDouble();
                cp.genererInterets(taux);
                isCmptEprgneExist = true;
                System.out.println("taux d'interet a ete ajouté en success ....");
                break;
            }
        }
        if (!isCmptEprgneExist) {
            System.out.println("cette compte n'existe pas");
        }
    }

    private static void verserVersAutreCompte(List<CompteCourant> compteCourant) {

            CompteCourant compteDest =  getNumDestinataire();

            if(compteDest != null){
                transfererMoney(compteDest);
            }else{
                System.out.println("compte destinataire n'existe pas");
            }

    }

    private static CompteCourant getNumDestinataire() {
        CompteCourant cmptEpr = null;
        System.out.println("donner le numero de distinataire ");
        Long numDes = scanner.nextLong();
        scanner.nextLine();
        for (CompteCourant cp: compteCourant) {
            if (Objects.equals(cp.getNumCompte(), numDes)) {
                cmptEpr = cp;
                System.out.println("compte desitinataire touvez en success ....");
                break;
            }
        }
        return cmptEpr;
    }
    private static void transfererMoney(CompteCourant compteDest){
        System.out.println("donner votre compte ");
        Long compteEmtt = scanner.nextLong();
        scanner.nextLine();
        boolean isCmptEprgneExist = false;
        for (CompteCourant cp: compteCourant) {
            if (Objects.equals(cp.getNumCompte(), compteEmtt)) {
                System.out.println("donner le montant que vous voullez de faire transfere vers compte " + compteDest.getNumCompte());
                Double mt = scanner.nextDouble();
                scanner.nextLine();
                cp.Transfert(mt, compteDest);
                isCmptEprgneExist = true;
                System.out.println("l'operation transfer fait en success ....");
                break;
            }
        }
        if (!isCmptEprgneExist) {
            System.out.println(" compte destinataire n'existe pas");
        }
    }

    
}
