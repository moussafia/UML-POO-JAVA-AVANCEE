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

    public Double getSolde() {
        return solde;
    }

    public void setSolde(Double solde) {
        this.solde = solde;
    }

    public String getNomTitulaire() {
        return nomTitulaire;
    }

    public void setNomTitulaire(String nomTitulaire) {
        this.nomTitulaire = nomTitulaire;
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
