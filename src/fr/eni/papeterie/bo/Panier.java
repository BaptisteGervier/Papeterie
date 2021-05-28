package fr.eni.papeterie.bo;

import java.util.ArrayList;
import java.util.List;

public class Panier {
    private final List<Ligne> lignesPanier;
    private float montant;

    public Panier() {
        lignesPanier = new ArrayList<Ligne>();
    }

    public List<Ligne> getLignesPanier() {
        return lignesPanier;
    }

    public void addLigne(Article article, int qte){
        Ligne ligneAdding = new Ligne(article, qte);
        lignesPanier.add(ligneAdding);
    }

    public final Ligne getLigne(int index){
        return lignesPanier.get(index);
    }

    public void removeLigne(int index){
        lignesPanier.remove(index);
    }

    public void updateLigne(int index, int newQte){
        this.getLigne(index).setQte(newQte);
    }

    public float getMontant() {
        return montant;
    }

    public void setMontant(float montant) {
        this.montant = montant;
    }

    @Override
    public String toString() {
        return "Panier{" +
                "lignesPanier=" + lignesPanier +
                ", montant=" + montant +
                '}';
    }
}
