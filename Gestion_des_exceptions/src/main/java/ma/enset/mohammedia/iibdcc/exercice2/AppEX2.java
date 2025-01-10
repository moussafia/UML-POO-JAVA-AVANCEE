package ma.enset.mohammedia.iibdcc.exercice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppEX2 {
    public static void main(String[] args) {
        try {
            List<? extends CompteBancaire> compteBancaire = new ArrayList<>();
            int nb;
            do {
                System.out.println("1.Ajouter un compte: ");
                System.out.println("2.Ajouter un compte: ");
                System.out.println("3.Supprimer un compte: ");
                System.out.println("4.Effectuer des opérations sur les comptes.: ");
                System.out.println("5.Quitter le programme: ");
                nb = new Scanner(System.in).nextInt();
                switch (nb) {
                    case 1:
                        System.out.println("------------Ajout des comptes--------------");
                        System.out.println("Enter numero de compte: ");
                        Long numCompte = new Scanner(System.in).nextLong();
                        System.out.println("Enter solde de compte: ");
                        Double sold = new Scanner(System.in).nextDouble();
                        System.out.println("Enter nom titulaire de comptes: ");
                        String nomTitulaire = new Scanner(System.in).nextLine();
                        compteBancaire.add(new CompteBancaire(numCompte, sold, nomTitulaire));
                        break;
                    case 2:
                        System.out.println("------------List des comptes-----------------");
                        for (CompteBancaire compte : compteBancaire) {
                            System.out.println(compte);
                        }
                        break;
                    case 3:
                        System.out.println("Enter numero de compte: ");
                        Long numCompteSupprime = new Scanner(System.in).nextLong();
                        for (CompteBancaire compte : compteBancaire) {
                            if (compte.getNumCompte() == numCompteSupprime) {
                                compteBancaire.remove(compte);
                                break;
                            }
                        }
                        break;
                    case 4:
                        System.out.println("Effectuer des operations sur les comptes: ");
                        break;

                    case 5:
                        System.out.println("Quitter le programme ... ");
                        break;

                }

            }while (nb != 5);
        }catch (FondsInsuffisantsException FIex){

        }catch (RuntimeException ex){

        } catch (Exception e) {

        }
    }

    private static void EffectuerOperation(List<CompteBancaire> compteBancaire){
        int choiseEffectuer;
        do {
            System.out.println("1.diposer un virement: ");
            System.out.println("2.retrait un montant: ");
            System.out.println("3.verser vers un autre compte: ");
            System.out.println("4.decouvert un montant: ");
            System.out.println("5.epargne un compte: ");
            System.out.println("6.Quitter le programme: ");
            choiseEffectuer = new Scanner(System.in).nextInt();
            switch (choiseEffectuer) {
                case 1:
                   diposerMontant(compteBancaire);
                   break;
                case 2:
                    retraitMontant(compteBancaire);
                    break;
                case 3:
                    diposerMontant(compteBancaire);
                    break;
                case 4:
                    decouverCompte(compteBancaire);
                    break;
                case 5:
                    diposerMontant(compteBancaire);
                    break;
                case 6:
                    System.out.println("Quitter le programme d'effectuer un operation... ");
                    break;

            }

        }while (choiseEffectuer != 6);
    }

    private static void diposerMontant(List<CompteBancaire> compteBancaire){
        System.out.println("donner le num de compte: ");
        Long numCompteDiposer = new Scanner(System.in).nextLong();
        boolean isCmptExist = false;
        for (CompteBancaire cp: compteBancaire) {
            if (cp.getNumCompte() == numCompteDiposer) {
                System.out.println("donner un montant");
                double montant = new Scanner(System.in).nextDouble();
                cp.deposer(montant);
                isCmptExist = true;
                break;
            }
        }
        if (!isCmptExist) {
            System.out.println("cette compte n'existe pas");
        }
    }

    private static void retraitMontant(List<CompteBancaire> compteBancaire){
        System.out.println("donner le num de compte: ");
        Long numCompteDiposer = new Scanner(System.in).nextLong();
        boolean isCmptExist = false;
        for (CompteBancaire cp: compteBancaire) {
            if (cp.getNumCompte() == numCompteDiposer) {
                System.out.println("donner un montant");
                double montant = new Scanner(System.in).nextDouble();
                cp.retraitSolde(montant);
                isCmptExist = true;
                break;
            }
        }
        if (!isCmptExist) {
            System.out.println("cette compte n'existe pas");
        }
    }

    private static void decouverCompte(List<CompteCourant> compteCourants){
        System.out.println("donner le num de compte: ");
        Long numCompteDiposer = new Scanner(System.in).nextLong();
        boolean isCmptExist = false;
        for (CompteCourant cp: compteCourants) {
            if (cp.getNumCompte() == numCompteDiposer) {
                System.out.println("donner un montant");
                double montant = new Scanner(System.in).nextDouble();
                cp.retraitSolde(montant);
                isCmptExist = true;
                break;
            }
        }
        if (!isCmptExist) {
            System.out.println("cette compte n'existe pas");
        }
    }

    private static void epargneCompte(List<CompteEpargne> compteEpargnes){
        System.out.println("donner le num de compte: ");
        Long numCompteDiposer = new Scanner(System.in).nextLong();
        boolean isCmptExist = false;
        for (CompteEpargne cp: compteEpargnes) {
            if (cp.getNumCompte() == numCompteDiposer) {
                System.out.println("donner un montant");
                double montant = new Scanner(System.in).nextDouble();
                cp.genererInterets();
                isCmptExist = true;
                break;
            }
        }
        if (!isCmptExist) {
            System.out.println("cette compte n'existe pas");
        }
    }
}
