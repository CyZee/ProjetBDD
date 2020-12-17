package model;//package model;

public abstract class Entity {
    public abstract void add(Agence agence1);
    public abstract void add(Type type1);
    public abstract void add(Ville ville1);
    public abstract void add(Categorie categorie1);

    public abstract void add(Vehicule vehicule1);

    public abstract void add(Modele modele1);

    public abstract void add(Marque marque1);

    public abstract void add(Contrat contrat1);

    public abstract void add(Client client1);

    public abstract void add(Facture facture1);
    // For polymorphism purpose
}