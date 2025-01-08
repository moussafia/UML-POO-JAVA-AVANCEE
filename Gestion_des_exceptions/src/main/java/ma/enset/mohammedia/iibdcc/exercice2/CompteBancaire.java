package ma.enset.mohammedia.iibdcc.exercice2;

public class CompteBancaire {
    private Long numCompte;
    private Double solde;
    private String nomTitulaire;

    public CompteBancaire(Long numCompte, Double solde, String nomTitulaire) {
        this.numCompte = numCompte;
        this.solde = solde;
        this.nomTitulaire = nomTitulaire;
    }

    public CompteBancaire() {
    }


    public Long getNumCompte() {
        return numCompte;
    }

    public void setNumCompte(Long numCompte) {
        this.numCompte = numCompte;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void setNomTitulaire(String nomTitulaire) {
        this.nomTitulaire = nomTitulaire;
    }

    public void retraitSolde(Double montant) {
        if(this.solde < montant){
            throw new FondsInsuffisantsException("solde insuffisant", numCompte);
        }
        this.solde -= montant;
        System.out.println("Retrait de " + montant + " effectué. Nouveau solde: " + solde + ".");
    }

    public void deposer(Double montant){
        if(montant <= 0){
            throw new FondsInsuffisantsException("montant doit etre positive strictement", numCompte);
        }
        solde += montant;
        System.out.println("Dépôt de " + montant + " effectué. Nouveau solde: " + solde + ".");
    }

    public Double getSolde() {
        return solde;
    }


    public void Transfert(Double montant, CompteBancaire compteDestinataire){
        if(compteDestinataire == null){
            throw new RuntimeException("compte bancaire Destinataire null");
        }
        if(montant > solde){
            throw new FondsInsuffisantsException("montant doit etre inferieur ou egal de votre solde", numCompte);
        } else if (montant <= 0) {
            throw new FondsInsuffisantsException("montant doit etre positive strictement", numCompte);
        }else {
            solde -= montant;
            compteDestinataire.deposer(montant);
            System.out.println("Transfert de " + montant + " effectué vers le compte " + compteDestinataire.getNumCompte() + ".");
        }

    }

    @Override
    public String toString() {
        return "CompteBancaire{" +
                "numCompte=" + numCompte +
                ", solde=" + solde +
                ", nomTitulaire='" + nomTitulaire + '\'' +
                '}';
    }
}
