package model;

public class Vehicule extends Entity {

    private int id;
    private String dateMiseEnCirculation;
    private String etat;
    private int nbKilometres;
    private int prixParJourDeLocation;
    private Marque marque;
    private Modele modele;
    private Categorie categorie;
    private Type type;
    private Agence agence;

    public Vehicule() {
        this(0);
    }

    public Vehicule(int id) {
        this(id, null);
    }

    public Vehicule(int id, String dateMiseEnCirculation) {
        this(id, dateMiseEnCirculation, null);
    }

    public Vehicule(int id, String dateMiseEnCirculation, String etat) {
        this(id, dateMiseEnCirculation, etat, 0);
    }

    public Vehicule(int id, String dateMiseEnCirculation, String etat, int nbKilometres) {
        this(id, dateMiseEnCirculation, etat, nbKilometres, 0);
    }

    public Vehicule(int id, String dateMiseEnCirculation, String etat, int nbKilometres, int prixParJourDeLocation) {
        this(id, dateMiseEnCirculation, etat, nbKilometres, prixParJourDeLocation, null);
    }

    public Vehicule(int id, String dateMiseEnCirculation, String etat, int nbKilometres, int prixParJourDeLocation, Marque marque) {
        this(id, dateMiseEnCirculation, etat, nbKilometres, prixParJourDeLocation, marque, null);
    }

    public Vehicule(int id, String dateMiseEnCirculation, String etat, int nbKilometres, int prixParJourDeLocation, Marque marque, Modele modele) {
        this(id, dateMiseEnCirculation, etat, nbKilometres, prixParJourDeLocation, marque, modele, null);
    }

    public Vehicule(int id, String dateMiseEnCirculation, String etat, int nbKilometres, int prixParJourDeLocation, Marque marque, Modele modele, Categorie categorie) {
        this(id, dateMiseEnCirculation, etat, nbKilometres, prixParJourDeLocation, marque, modele, categorie, null);
    }

    public Vehicule(int id, String dateMiseEnCirculation, String etat, int nbKilometres, int prixParJourDeLocation, Marque marque, Modele modele, Categorie categorie, Type type) {
        this(id, dateMiseEnCirculation, etat, nbKilometres, prixParJourDeLocation, marque, modele, categorie, type, null);
    }

    public Vehicule(int id, String dateMiseEnCirculation, String etat, int nbKilometres, int prixParJourDeLocation, Marque marque, Modele modele, Categorie categorie, Type type, Agence agence) {
        super();

        this.id = id;
        this.dateMiseEnCirculation = dateMiseEnCirculation;
        this.etat = etat;
        this.nbKilometres = nbKilometres;
        this.prixParJourDeLocation = prixParJourDeLocation;
        this.marque = marque;
        this.modele = modele;
        this.categorie = categorie;
        this.type = type;
        this.agence = agence;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDateMiseEnCirculation() {
        return dateMiseEnCirculation;
    }

    public void setDateMiseEnCirculation(String dateMiseEnCirculation) {
        this.dateMiseEnCirculation = dateMiseEnCirculation;
    }

    public String getEtat() {
        return etat;
    }

    public void setEtat(String etat) {
        this.etat = etat;
    }

    public int getNbKilometres() {
        return nbKilometres;
    }

    public void setNbKilometres(int nbKilometres) {
        this.nbKilometres = nbKilometres;
    }

    public int getPrixParJourDeLocation() {
        return prixParJourDeLocation;
    }

    public void setPrixParJourDeLocation(int prixParJourDeLocation) {
        this.prixParJourDeLocation = prixParJourDeLocation;
    }

    public Marque getMarque() {
        return marque;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Modele getModele() {
        return modele;
    }

    public void setModele(Modele modele) {
        this.modele = modele;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Agence getAgence() {
        return agence;
    }

    public void setAgence(Agence agence) {
        this.agence = agence;
    }
}