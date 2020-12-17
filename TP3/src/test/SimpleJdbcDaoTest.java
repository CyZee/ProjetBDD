package test;//package test;

import dao.Dao;
import dao.jdbc.VilleDaoImpl;
import dao.jdbc.AgenceDaoImpl;
import dao.jdbc.MarqueDaoImpl;
import dao.jdbc.ClientDaoImpl;
import dao.jdbc.VehiculeDaoImpl;
import dao.jdbc.TypeDaoImpl;
import dao.jdbc.CategorieDaoImpl;
import dao.jdbc.ModeleDaoImpl;
import dao.jdbc.ContratDaoImpl;
import dao.jdbc.FactureDaoImpl;
import dao.exception.DaoException;
import sql.PostgresConnection;

import model.Entity;
import model.Ville;
import model.Agence;
import model.Marque;
import model.Client;
import model.Vehicule;
import model.Type;
import model.Categorie;
import model.Modele;
import model.Contrat;
import model.Facture;
import sql.PostgresConnection;

import java.sql.Connection;
import java.util.Collection;

public class SimpleJdbcDaoTest {
    private Connection connection;
    private Dao dao;

    /*public void testfindAllEntreprises() {
        Dao dao = new EntrepriseDaoImpl(connection);

        try {
            Collection<Entity> entreprises = dao.findAll();
            for (Entity entity : entreprises) {
                Entreprise entreprise = (Entreprise) entity;

                System.out.println(entreprise.getId() + " | " + entreprise.getNom());
            }
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }


    public void testCreateEntreprise(Entreprise entreprise) {
        try {
            dao.create(entreprise);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }*/

    public void testFindAllVille() throws DaoException {
        Dao dao = new VilleDaoImpl(connection);

        try{
            Collection<Entity> ville = dao.findAll();
            for (Entity entity : ville){
                Ville ville1 = (Ville) entity;
                System.out.println(ville1.getId() + " | " + ville1.getNom() + " | " + ville1.getNombreHabitants());
            }
        }catch(DaoException e){
            e.printStackTrace();
        }
    }

    public void testCreateVille(Ville ville) {
            try {
                dao.create(ville);
            } catch (DaoException e) {
                e.printStackTrace();
            }

    }

    public void testFindAllAgance(){
        Dao dao = new AgenceDaoImpl(connection);

        try{
            Collection<Entity> agence = dao.findAll();
            for (Entity entity : agence){
                Agence agence1 = (Agence) entity;
                System.out.println(agence1.getId() + " | " + agence1.getNbEmployes() + " | " + agence1.getVille());
            }
        }catch(DaoException e){
            e.printStackTrace();
        }
    }

    public void testCreateAgence(Agence agence) {
        try {
            dao.create(agence);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    public void testFindAllMarque(){
        Dao dao = new MarqueDaoImpl(connection);

        try{
            Collection<Entity> marque = dao.findAll();
            for (Entity entity : marque){
                Marque marque1 = (Marque) entity;
                System.out.println(marque1.getId() + " | " + marque1.getnomMarque());
            }
        }catch(DaoException e){
            e.printStackTrace();
        }
    }

    public void testCreateMarque(Marque marque) {
        try {
            dao.create(marque);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    public void testFindAllClient(){
        Dao dao = new ClientDaoImpl(connection);

        try{
            Collection<Entity> client = dao.findAll();
            for (Entity entity : client){
                Client client1 = (Client) entity;
                System.out.println(client1.getId() + " | " + client1.getNom() + " | " + client1.getAdresse() + " | " + client1.getCodePostal() + " | " + client1.getVille());
            }
        }catch(DaoException e){
            e.printStackTrace();
        }
    }

    public void testCreateClient(Client client) {
        try {
            dao.create(client);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    public void testFindAllVehicule(){
        Dao dao = new VehiculeDaoImpl(connection);

        try{
            Collection<Entity> vehicule = dao.findAll();
            for (Entity entity : vehicule){
                Vehicule vehicule1 = (Vehicule) entity;
                System.out.println(vehicule1.getId() + " | " + vehicule1.getdateMiseEnCirculation() + " | " + vehicule1.getEtat() + " | " + vehicule1.getNbKilometres() + " | " + vehicule1.getPrixParJourDeLocation() + " | " + vehicule1.getMarque() + " | " + vehicule1.getModele() + " | " + vehicule1.getCategorie() + " | " + vehicule1.getType() + " | " + vehicule1.getAgence());
            }
        }catch(DaoException e){
            e.printStackTrace();
        }
    }

    public void testCreateVehicule(Vehicule vehicule) {
        try {
            dao.create(vehicule);
        } catch (DaoException e) {
            e.printStackTrace();
        }
    }

    public void testFindAllType(){
        Dao dao = new TypeDaoImpl(connection);

        try{
            Collection<Entity> type = dao.findAll();
            for (Entity entity : type){
                Type type1 = (Type) entity;
                System.out.println(type1.getId() + " | " + type1.getLibelle());
            }
        }catch(DaoException e){
            e.printStackTrace();
        }
    }

    public void testCreateType(Type type) {
        try {
            dao.create(type);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    public void testFindAllCategorie(){
        Dao dao = new CategorieDaoImpl(connection);

        try{
            Collection<Entity> categorie = dao.findAll();
            for (Entity entity : categorie){
                Categorie categorie1 = (Categorie) entity;
                System.out.println(categorie1.getId() + " | " + categorie1.getLibelle());
            }
        }catch(DaoException e){
            e.printStackTrace();
        }
    }

    public void testCreateCategorie(Categorie categorie) {
        try {
            dao.create(categorie);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    public void testFindAllModele(){
        Dao dao = new ModeleDaoImpl(connection);

        try{
            Collection<Entity> modele = dao.findAll();
            for (Entity entity : modele){
                Modele modele1 = (Modele) entity;
                System.out.println(modele1.getId() + " | " + modele1.getLibelle() + " | " + modele1.getPuissanceFiscale());
            }
        }catch(DaoException e){
            e.printStackTrace();
        }
    }

    public void testCreateModele(Modele modele) {
        try {
            dao.create(modele);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    public void testFindAllContrat(){
        Dao dao = new ContratDaoImpl(connection);

        try{
            Collection<Entity> contrat = dao.findAll();
            for (Entity entity : contrat){
                Contrat contrat1 = (Contrat) entity;
                System.out.println(contrat1.getId() + " | " + contrat1.getDateDeRetrait() + " | " + contrat1.getDateDeRetour() + " | " + contrat1.getKmRetrait() + " | " + contrat1.getKmRetour() + " | " + contrat1.getClient()  + " | " + contrat1.getAgence());
            }
        }catch(DaoException e){
            e.printStackTrace();
        }
    }

    public void testCreateContrat(Contrat contrat) {
        try {
            dao.create(contrat);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }

    public void testFindAllFacture(){
        Dao dao = new FactureDaoImpl(connection);

        try{
            Collection<Entity> facture = dao.findAll();
            for (Entity entity : facture){
                Facture facture1 = (Facture) entity;
                System.out.println(facture1.getId() + " | " + facture1.getMontant() + " | " + facture1.getContrat());
            }
        }catch(DaoException e){
            e.printStackTrace();
        }
    }

    public void testCreateFacture(Facture facture) {
        try {
            dao.create(facture);
        } catch (DaoException e) {
            e.printStackTrace();
        }

    }











    public void test() throws DaoException{
        connection = PostgresConnection.getInstance();

        dao = new VilleDaoImpl(connection);

        System.out.println("***** Création d'une ville : ");
        Ville ville = new Ville(1, "Belfort",55742);
        testCreateVille(ville);

        System.out.println("***** Liste des villes : ");
        testFindAllVille();


        dao = new AgenceDaoImpl(connection);

        System.out.println("***** Création d'une agence : ");
        Agence agance = new Agence(1, 12, ville);
        testCreateAgence(agance);

        System.out.println("***** Liste des agances : ");
        testFindAllAgance();


        dao = new MarqueDaoImpl(connection);

        System.out.println("***** Création d'une marque : ");
        Marque marque = new Marque(1, "Pegasus");
        testCreateMarque(marque);

        System.out.println("***** Liste des marque : ");
        testFindAllMarque();


        dao = new ClientDaoImpl(connection);

        System.out.println("***** Création d'un client : ");
        Client client = new Client(1, "Wawa", "2 rue Ernest Duvillard", "90000", ville);
        testCreateClient(client);

        System.out.println("***** Liste des clients : ");
        testFindAllClient();

        dao = new TypeDaoImpl(connection);

        System.out.println("***** Création d'un type : ");
        Type type = new Type(1, "auto berlines");
        testCreateType(type);

        System.out.println("***** Liste des types : ");
        testFindAllType();


        dao = new CategorieDaoImpl(connection);

        System.out.println("***** Création d'une categorie : ");
        Categorie categorie = new Categorie(1, "SUV");
        testCreateCategorie(categorie);

        System.out.println("***** Liste des categories : ");
        testFindAllCategorie();


        dao = new ModeleDaoImpl(connection);

        System.out.println("***** Création d'un modele : ");
        Modele modele = new Modele(1, "S520", 500);
        testCreateModele(modele);

        System.out.println("***** Liste des Modeles : ");
        testFindAllModele();

        dao = new VehiculeDaoImpl(connection);

        System.out.println("***** Création d'un vehicule : ");
        Vehicule vehicule = new Vehicule(1, "25/03/2018", "Usée", 15781, 5, marque, modele, categorie, type, agance);
        testCreateVehicule(vehicule);

        System.out.println("***** Liste des vehicules : ");
        testFindAllVehicule();


        dao = new ContratDaoImpl(connection);

        System.out.println("***** Création d'un contrat : ");
        Contrat contrat = new Contrat(1, "18/04/2019", "27/07/2020", 5462, 10423, client, vehicule, agance);
        testCreateContrat(contrat);

        System.out.println("***** Liste des contrats : ");
        testFindAllContrat();


        dao = new FactureDaoImpl(connection);

        System.out.println("***** Création d'une facture : ");
        Facture facture = new Facture(1, 650, contrat);
        testCreateFacture(facture);

        System.out.println("***** Liste des factures : ");
        testFindAllFacture();





    }


    public static void main(String[] args) throws DaoException {
        new SimpleJdbcDaoTest().test();
    }
}