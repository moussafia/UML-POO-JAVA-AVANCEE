package ma.enset.mohammedia.iibdcc.exercice2;

public class FondsInsuffisantsException extends RuntimeException{
    private Long numCompte = null;
    public FondsInsuffisantsException(String msg, Long numCompte) {
        super(msg);
        this.numCompte = numCompte;

    }
    public FondsInsuffisantsException(String msg) {
        super(msg);
    }
    public Long getNumCompte() {
        return numCompte;
    }
}
