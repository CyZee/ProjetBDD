package model;

public  class Modele extends Entity {

    private int id;
    private String libelle;
    private int puissanceFiscale;

    public Modele() {
        this(0);
    }

    public Modele(int id) {
        this(id, null);
    }

    public Modele(int id, String libelle) {
        this(id, libelle, 0);

    }

    public Modele(int id, String libelle, int puissnaceFiscale) {
        super();

        this.id = id;
        this.libelle = libelle;
        this.puissanceFiscale = puissnaceFiscale;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    public int getPuissanceFiscale() {
        return puissanceFiscale;
    }
    public void setPuissanceFiscale(int puissanceFiscale) {
        this.puissanceFiscale = puissanceFiscale;
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
