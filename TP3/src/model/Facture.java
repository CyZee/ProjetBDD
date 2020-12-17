package model;

public  class Facture extends Entity {

    private int id;
    private int montant;
    private Contrat contrat;

    public Facture() {
        this(0);
    }

    public Facture(int id) {
        this(id, 0);
    }

    public Facture(int id, int montant) {
        this(id, montant, null);
    }

    public Facture(int id, int montant, Contrat contrat) {
        super();

        this.id = id;
        this.montant = montant;
        this.contrat = contrat;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMontant() {
        return montant;
    }

    public void setMontant(int montant) {
        this.montant = montant;
    }

    public Contrat getContrat() {
        return contrat;
    }

    public void setContrat(Contrat contrat) {
        this.contrat = contrat;
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