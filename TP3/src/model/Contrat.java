package model;

public class Contrat extends Entity {

    private int id;
    private String dateDeRetrait;
    private String dateDeRetour;
    private int kmRetrait;
    private int kmRetour;
    private Client client;
    private Vehicule vehicule;
    private Agence agence;
    private String immatriculation;

    public Contrat() {
        this(0);
    }

    public Contrat(int id) {
        this(id,null);
    }

    public Contrat(int id, String dateDeRetrait) {
        this(id, dateDeRetrait, null);
    }

    public Contrat(int id, String dateDeRetrait, String dateDeRetour) {
        this(id, dateDeRetrait, dateDeRetour, 0);
    }

    public Contrat(int id, String dateDeRetrait, String dateDeRetour, int kmRetrait) {
        this(id, dateDeRetrait, dateDeRetour, kmRetrait, 0);
    }

    public Contrat(int id, String dateDeRetrait, String dateDeRetour, int kmRetrait, int kmRetour) {
        this(id, dateDeRetrait, dateDeRetour, kmRetrait, kmRetour, null);
    }

    public Contrat(int id, String dateDeRetrait, String dateDeRetour, int kmRetrait, int kmRetour, Client client) {
        this(id, dateDeRetrait, dateDeRetour, kmRetrait, kmRetour, client, null);
    }

    public Contrat(int id, String dateDeRetrait, String dateDeRetour, int kmRetrait, int kmRetour, Client client, Vehicule vehicule) {
        this(id, dateDeRetrait, dateDeRetour, kmRetrait, kmRetour, client, vehicule, null);
    }

    public Contrat(int id, String dateDeRetrait, String dateDeRetour, int kmRetrait, int kmRetour, Client client, Vehicule vehicule, String immatriculation) {
        this(id, dateDeRetrait, dateDeRetour, kmRetrait, kmRetour, client, vehicule,immatriculation, null);
    }

    public Contrat(int id, String dateDeRetrait, String dateDeRetour, int kmRetrait, int kmRetour, Client client, Vehicule vehicule, Agence agence, String immatriculation) {
        super();

        this.id = id;
        this.dateDeRetrait = dateDeRetrait;
        this.dateDeRetour = dateDeRetour;
        this.kmRetrait = kmRetrait;
        this.kmRetour = kmRetour;
        this.client = client;
        this.vehicule = vehicule;
        this.agence = agence;
        this.immatriculation = immatriculation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateDeRetrait() {
        return dateDeRetrait;
    }

    public void setDateDeRetrait(String dateDeRetrait) {
        this.dateDeRetrait = dateDeRetrait;
    }

    public String getDateDeRetour() {
        return dateDeRetour;
    }

    public void setDateDeRetour(String dateDeRetour) {
        this.dateDeRetour = dateDeRetour;
    }

    public int getKmRetrait() {
        return kmRetrait;
    }

    public void setKmRetrait(int kmRetrait) {
        this.kmRetrait = kmRetrait;
    }

    public int getKmRetour() {
        return kmRetour;
    }

    public void setKmRetour(int kmRetour) {
        this.kmRetour = kmRetour;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Vehicule vehicule) {
        this.vehicule = vehicule;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public void setImmatriculation(String immatriculation){this.immatriculation = immatriculation;}

    public String getImmatriculation(){return immatriculation;}
}