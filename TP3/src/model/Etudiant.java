package model;

public class Etudiant extends Entity {

    private int id;
    private String nom;
    private Entreprise entreprise;

    public Etudiant() {
        this(0);
    }

    public Etudiant(int id) {
        this(id, null);
    }

    public Etudiant(int id, String nom) {
        this(id, nom, null);
    }

    public Etudiant(int id, String nom, Entreprise entreprise) {
        super();

        this.id = id;
        this.nom = nom;
        this.entreprise = entreprise;
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

    public Entreprise getEntreprise() {
        return entreprise;
    }

    public void setEntreprise(Entreprise entreprise) {
        this.entreprise = entreprise;
    }
}