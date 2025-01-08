package ma.enset.mohammedia.iibdcc.exercice2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class AppEX2 {
    public static void main(String[] args) {
        try {
            List<CompteBancaire> compteBancaire = new ArrayList<>();
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
}
