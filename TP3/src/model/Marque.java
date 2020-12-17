package model;

public  class Marque extends Entity {

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

    public String getnomMarque() {
        return nomMarque;
    }

    public void setnomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
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