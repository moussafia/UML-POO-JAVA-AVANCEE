package ma.enset.mohammedia.iibdcc.exercice2;

public class CompteCourant extends CompteBancaire{
    private Double decouvertAutorise;

    public CompteCourant(Long numCompte, Double solde, String nomTitulaire, Double decouvertAutorise) {
        super(numCompte, solde, nomTitulaire);
        this.decouvertAutorise = decouvertAutorise;
    }

    @Override
    public void retraitSolde(Double montant) {
        if(montant > (super.getSolde() + decouvertAutorise)){
            throw new FondsInsuffisantsException("Solde insuffisant", super.getNumCompte());
        } else if (montant <= 0) {
            throw new FondsInsuffisantsException("Le montant du retrait doit être positif.",
                    super.getNumCompte());

        }else {
            super.retraitSolde(montant);
            System.out.println("Retrait de " + montant + " effectué. Nouveau solde: " + super.getSolde() + ".");
        }
    }
}
