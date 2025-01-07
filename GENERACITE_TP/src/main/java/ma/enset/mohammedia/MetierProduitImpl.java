package ma.enset.mohammedia;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MetierProduitImpl implements IMetier<Produit>{

    private List<Produit> produits = new ArrayList<>();

    @Override
    public void add(Produit pr) {
        produits.add(pr);
    }

    @Override
    public void remove(Long id) {
        for (Produit p : produits) {
            if (Objects.equals(p.getId(), id)) {
                produits.remove(p);
                return;
            }
        }
    }

    @Override
    public Produit findById(Long id) {
        for(Produit p : produits){
            if(p.getId().equals(id)){
                return p;
            }
        }
        return null;
    }

    @Override
    public List<Produit> getAll() {
        return produits;
    }
}
