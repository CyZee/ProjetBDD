package model;//package model;

public class Entreprise extends Entity {

    private int id;
    private String nom;

    public Entreprise() {
        this(0);
    }

    public Entreprise(int id) {
        this(id, null);
    }

    public Entreprise(String nom) {
        this.nom = nom;
    }

    public Entreprise(int id, String nom) {
        super();

        this.id = id;
        this.nom = nom;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}