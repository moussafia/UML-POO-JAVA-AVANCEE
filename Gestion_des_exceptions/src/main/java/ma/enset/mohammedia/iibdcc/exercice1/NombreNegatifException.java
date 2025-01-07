package ma.enset.mohammedia.iibdcc.exercice1;

public class NombreNegatifException extends RuntimeException {
    private final int val;
    public NombreNegatifException(String msg, int val) {
        super(msg);
        this.val = val;
    }
    public int getValeurErronee() {
        return val;
    }
}
