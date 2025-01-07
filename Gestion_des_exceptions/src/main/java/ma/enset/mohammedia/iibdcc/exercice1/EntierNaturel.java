package ma.enset.mohammedia.iibdcc.exercice1;

public class EntierNaturel {
    private int val;

    public EntierNaturel(int val) {
        if(val < 0)
            throw new NombreNegatifException("ce nombre est negative", val);
        this.val = val;
    }

    public EntierNaturel() {
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        if(val < 0)
            throw new NombreNegatifException("ce nombre est negative", val);
        this.val = val;
    }
    public void decrementer() {
        if(val == 0)
            throw new NombreNegatifException("ce nombre est negative", val);
        this.val--;
    }

    @Override
    public String toString() {
        return "EntierNaturel{" +
                "val=" + val +
                '}';
    }
}
