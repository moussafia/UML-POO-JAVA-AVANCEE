package ma.enset.mohammedia.iibdcc.exercice2;

public class CompteCourant extends CompteEpargne{

    public CompteCourant(Long numCompte, Double solde, String nomTitulaire) {
        super(numCompte, solde, nomTitulaire);
    }
    public void retraitSolde(Double montant, Double decouvertAutorise) {
        System.out.println("monatant " + montant);
        System.out.println("compare to " + (super.getSolde() + decouvertAutorise));
        System.out.println("super 0 " + super.getSolde());
        Double sum = super.getSolde() + decouvertAutorise;
        if(montant.compareTo(sum) > 0){
            throw new FondsInsuffisantsException("Solde insuffisant", super.getNumCompte());
        } else if (montant.compareTo(0.0) <= 0) {
            throw new FondsInsuffisantsException("Le montant du retrait doit être positif.",
                    super.getNumCompte());
        }else {
            super.setSolde(super.getSolde() - montant);
            System.out.println("Retrait de " + montant + " effectué. Nouveau solde: " + super.getSolde() + ".");
        }
    }
}
