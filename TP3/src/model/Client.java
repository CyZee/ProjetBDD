package model;

public class Client extends Entity {

    private int id;
    private String nom;
    private String adresse;
    private String codePostal;
    private Ville ville;

    public Client() {
        this(0);
    }

    public Client(int id) {
        this(id, null);
    }

    public Client(int id, String nom) {
        this(id, nom, null);
    }

    public Client(int id, String nom, String adresse) {
        this(id, nom, adresse, null);
    }

    public Client(int id, String nom, String adresse, String codePostal) {
        this(id, nom, adresse, codePostal, null);
    }

    public Client(int id, String nom, String adresse, String codePostal, Ville ville) {
        super();

        this.id = id;
        this.nom = nom;
        this.adresse = adresse;
        this.codePostal = codePostal;
        this.ville = ville;
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

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getCodePostal() {
        return codePostal;
    }

    public void setCodePostal(String codePostal) {
        this.codePostal = codePostal;
    }

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
}