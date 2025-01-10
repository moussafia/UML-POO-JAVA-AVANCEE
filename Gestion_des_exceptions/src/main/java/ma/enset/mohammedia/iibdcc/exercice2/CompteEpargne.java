package ma.enset.mohammedia.iibdcc.exercice2;

public class CompteEpargne extends CompteBancaire{

    public CompteEpargne(Long numCompte, Double solde, String nomTitulaire) {
        super(numCompte, solde, nomTitulaire);
    }


    public void genererInterets(Double tauxInteret){
        Double interet = (super.getSolde()*tauxInteret)/100;
        super.deposer(interet);
        System.out.println("Intérêts de " + interet + " générés. Nouveau solde: " + super.getSolde() + ".");
    }
}
