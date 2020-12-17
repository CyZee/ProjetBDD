package model;

public class Modele extends Entity {

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

    public void setPuissancePascale(int puissanceFiscale) {
        this.puissanceFiscale = puissanceFiscale;
    }
}
