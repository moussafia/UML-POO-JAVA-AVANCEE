package ma.enset.mohammedia.iibdcc.exercice2;

public class FondsInsuffisantsException extends RuntimeException{
    private final Long numCompte;
    public FondsInsuffisantsException(String msg, Long numCompte) {
        super(msg);
        this.numCompte = numCompte;

    }
    public Long getNumCompte() {
        return numCompte;
    }
}
