package model;//package model;

public  class Ville extends Entity {

    private int id;
    private String nom;
    private int nombreHabitants;

    public Ville() {
        this(0);
    }

    public Ville(int id) {
        this(id, null);
    }

    public Ville(int id, String nom){
        this(id, nom, 0);
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

    public int getNombreHabitants() {
        return nombreHabitants;
    }

    public void setNombreHabitants(int nombreHabitants) {
        this.nombreHabitants = nombreHabitants;
    }

    @Override
    public void add(Agence agence1) {

    }

    @Override
    public void add(Type type1) {

    }

    @Override
    public void add(Ville ville1) {

    }

    @Override
    public void add(Categorie categorie1) {

    }

    @Override
    public void add(Vehicule vehicule1) {

    }

    @Override
    public void add(Modele modele1) {

    }

    @Override
    public void add(Marque marque1) {

    }

    @Override
    public void add(Contrat contrat1) {

    }

    @Override
    public void add(Client client1) {

    }

    @Override
    public void add(Facture facture1) {

    }
}