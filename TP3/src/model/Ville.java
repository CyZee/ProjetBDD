package model;//package model;

public class Ville extends Entity {

    private int id;
    private String nom;
    private int nombreHabitants;

    public Ville() {
        this(0);
    }

    public Ville(int id) {
        this(id, null);
    }

    public Ville(String nom) {
        this.nom = nom;
    }

    public Ville(int id, String nom, int nombreHabitants) {
        super();

        this.id = id;
        this.nom = nom;
        this.nombreHabitants = nombreHabitants;
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

    public int getNombreHabitants(){
        return nombreHabitants;

    }

    public void setNombreHabitants(String nombreHabitants) {
            this.nombreHabitants = nombreHabitants;
        }
}