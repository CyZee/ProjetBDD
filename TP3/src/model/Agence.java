package model;

public class Agence extends Entity {

    private int id;
    private int nbEmployes;
    private Ville ville;

    public Ville() {
        this(0);
    }

    public Ville(int id) {
        this(id, null);
    }

    public Ville(int id, int nbEmployes) {
        this(id, nbEmployes, null);
    }

    public Ville(int id, int nbEmployes, Ville ville) {
        super();

        this.id = id;
        this.nbEmployes = nbEmployes;
        this.ville = ville;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNbEmployes() {
        return nbEmployes;
    }

    public void setNbEmployes(int nbEmployes) {
        this.nbEmployes = nbEmployes;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
}