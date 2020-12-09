package model;

public class Marque extends Entity {

    private int id;
    private String nomMarque;

    public Ville() {
        this(0);
    }

    public Ville(int id) {
        this(id, null);
    }

    public Ville(int id, String nomMarque) {
        this(id, nomMarque, null);
    }

    public Ville(int id, String nomMarque) {
        super();

        this.id = id;
        this.nomMarque = nomMarque;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }


}