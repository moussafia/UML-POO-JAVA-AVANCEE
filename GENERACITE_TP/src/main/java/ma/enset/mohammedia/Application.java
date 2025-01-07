package ma.enset.mohammedia;

import java.util.List;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        int nb;
        IMetier<Produit> metierProduit = new MetierProduitImpl();
        do{
            System.out.println("-------------------- Menu ------------------------");
            System.out.println("1. Afficher la liste des produits.");
            System.out.println("2. Rechercher un produit par son id.");
            System.out.println("3. Ajouter un nouveau produit dans la liste.");
            System.out.println("4. Supprimer un produit par id.");
            System.out.println("5. Quitter ce programme.");
            nb = new Scanner(System.in).nextInt();
            switch(nb){
                case 1:
                    List<Produit> produits = metierProduit.getAll();
                    for (Produit produit : produits) {
                        System.out.println(produit);
                    }
                    break;
                case 2:
                    System.out.println("donner id de produit");
                    Long idRecherche = new Scanner(System.in).nextLong();
                    Produit produitTrouve = metierProduit.findById(idRecherche);
                    if(produitTrouve == null){
                        System.out.println("Produit n'existe pas");
                    }else{
                        System.out.println(produitTrouve);
                    }
                    break;
                case 3:
                    System.out.println("donner id de produit");
                    Long idAjout = new Scanner(System.in).nextLong();
                    System.out.println("donner nom de produit");
                    String nom = new Scanner(System.in).nextLine();
                    System.out.println("donner marque de produit");
                    String marque = new Scanner(System.in).nextLine();
                    System.out.println("donner une description de produit");
                    String description = new Scanner(System.in).nextLine();
                    System.out.println("donner le prix de cette produit");
                    Double prix = new Scanner(System.in).nextDouble();
                    System.out.println("donner la quantite de cette produit");
                    Integer quantite = new Scanner(System.in).nextInt();
                    metierProduit.add(new Produit(idAjout, nom, description, prix, marque, quantite));
                    break;
                case 4:
                    System.out.println("donner id de produit");
                    Long idSuppression = new Scanner(System.in).nextLong();
                    metierProduit.remove(idSuppression);
                    System.out.println("Produi est supprimer en success");
                    break;
                case 5:
                    System.out.println("Quitter ce programme...");
                    break;

            }
        }while(nb != 5);
    }
}
