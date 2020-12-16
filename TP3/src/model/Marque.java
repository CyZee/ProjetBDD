package model;

public class Marque extends Entity {

    private int id;
    private String nomMarque;

    public Marque() {
        this(0);
    }

    public Marque(int id) {
        this(id, null);
    }

    public Marque(int id, String nomMarque) {
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

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

}