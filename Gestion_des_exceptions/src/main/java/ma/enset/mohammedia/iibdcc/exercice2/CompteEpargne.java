package ma.enset.mohammedia.iibdcc.exercice2;

public class CompteEpargne extends CompteBancaire{
    private Double tauxInteret;

    public CompteEpargne(Long numCompte, Double solde, String nomTitulaire, Double tauxInteret) {
        super(numCompte, solde, nomTitulaire);
        this.tauxInteret = tauxInteret;
    }

    public void genererInterets(){
        Double interet = (super.getSolde()*tauxInteret)/100;
        super.deposer(interet);
        System.out.println("Intérêts de " + interet + " générés. Nouveau solde: " + super.getSolde() + ".");
    }
}
