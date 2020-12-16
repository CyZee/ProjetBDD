package test;//package test;

import dao.Dao;
import dao.jdbc.VilleDaoImpl;
import dao.jdbc.AganceDaoImpl;
import dao.jdbc.MarqueDaoImpl;
import dao.jdbc.ClientDaoImpl;
import dao.jdbc.VehiculeDaoImpl;
import dao.jdbc.TypeDaoImpl;
import dao.jdbc.CategorieDaoImpl;
import dao.jdbc.ModeleDaoImpl;
import dao.jdbc.ContratDaoImpl;
import dao.jdbc.FactureDaoImpl;
import dao.exception.DaoException;

import model.Entity;
import model.Ville;
import model.Agance;
import model.Marque;
import model.Client;
import model.Vehicule;
import model.Type;
import model.Cetagorie;
import model.Modele;
import model.Contrat;
import model.Facture;
import sql.PostgresConnection;

import java.sql.Connection;
import java.sql.SQLException;
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

    public void testFindAllVille(){
        Doa dao = new VilleDaoImpl(connection);

        try{
            Collection<Entity> ville = dao.findAll();
            for (Entity entity : ville){
                Ville ville = (Ville) entity;
                System.out.println(ville.getId() + " | " + ville.getNom() + " | " + ville.getInstance());
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
        Doa dao = new AgenceDaoImpl(connection);

        try{
            Collection<Entity> agence = dao.findAll();
            for (Entity entity : agence){
                Agence agence = (Agence) entity;
                System.out.println(agence.getId + " | " + agence.getNbEmploye() + " | " + agence.getVille());
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
        Doa dao = new MarqueDaoImpl(connection);

        try{
            Collection<Entity> marque = dao.findAll();
            for (Entity entity : marque){
                Marque marque = (Marque) entity;
                System.out.println(marque.getId() + " | " + marque.getNomMarque());
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
        Doa dao = new ClientDaoImpl(connection);

        try{
            Collection<Entity> client = dao.findAll();
            for (Entity entity : client){
                Client client = (Client) entity;
                System.out.println(client.getId() + " | " + client.getNomClient() + " | " + client.getAdresseClient() + " | " + client.getCodePostaleClient() + " | " + client.getVilleId());
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
        Doa dao = new VehiculeDaoImpl(connection);

        try{
            Collection<Entity> vehicule = dao.findAll();
            for (Entity entity : vehicule){
                Vehicule vehicule = (Vehicule) entity;
                System.out.println(vehicule.getId() + " | " + vehicule.getDateMiseEnCirculation() + " | " + vehicule.getEtat() + " | " + vehicule.getNbKilometres() + " | " + vehicule.getPrixParJourDeLocation() + " | " + vehicule.getMarqueId() + " | " + vehicule.getModeleId() + " | " + vehicule.getCategorieId() + " | " + vehicule.getTypeId() + " | " + vehicule.getAgenceId());
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
        Doa dao = new TypeDaoImpl(connection);

        try{
            Collection<Entity> type = dao.findAll();
            for (Entity entity : type){
                Type type = (Type) entity;
                System.out.println(type.getId() + " | " + type.getLibelleType());
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
        Doa dao = new CategoreDaoImpl(connection);

        try{
            Collection<Entity> categorie = dao.findAll();
            for (Entity entity : categorie){
                Categorie categorie = (Categorie) entity;
                System.out.println(categorie.getId() + " | " + categorie.getLibelleCategorie());
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
        Doa dao = new ModeleDaoImpl(connection);

        try{
            Collection<Entity> modele = dao.findAll();
            for (Entity entity : modele){
                Modele modele = (Modele) entity;
                System.out.println(modele.getId() + " | " + modele.getDenomination() + " | " + modele.getPuissanceFiscale());
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
        Doa dao = new ContratDaoImpl(connection);

        try{
            Collection<Entity> contrat = dao.findAll();
            for (Entity entity : contrat){
                Contrat contrat = (Contrat) entity;
                System.out.println(contrat.getId() + " | " + contrat.getDateDeRetrait() + " | " + contrat.getDateDeRetour() + " | " + contrat.getKmRetrait() + " | " + contrat.getKmRetour() + " | " + contrat.getClientId() + " | " + contrat.getImmatriculation() + " | " + contrat.getAgenceDeRetourId());
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
        Doa dao = new FactureDaoImpl(connection);

        try{
            Collection<Entity> facture = dao.findAll();
            for (Entity entity : facture){
                Facture facture = (Facture) entity;
                System.out.println(facture.getId() + " | " + facture.getMontant() + " | " + facture.getContratId());
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







    public void test() {
        connection = PostgresConnection.getInstance();

        dao = new VilleDaoImpl(connection);

        System.out.println("***** Création d'une ville : ");
        Ville ville = new Ville("bruhLand");
        testCreateVille(ville);

        System.out.println("***** Liste des villes : ");
        testFindAllVille();


        dao = new AganceDaoImpl(connection);

        System.out.println("***** Création d'une agance : ");
        Agance agance = new Agance("bruhAndCo");
        testCreateAgance(agance);

        System.out.println("***** Liste des agances : ");
        testFindAllAgance();


        dao = new MarqueDaoImpl(connection);

        System.out.println("***** Création d'une marque : ");
        Marque marque = new Marque("bruh");
        testCreateMarque(marque);

        System.out.println("***** Liste des marque : ");
        testFindAllMarque();


        dao = new ClientDaoImpl(connection);

        System.out.println("***** Création d'un client : ");
        Client client = new Client("Jean_bruh");
        testCreateClient(client);

        System.out.println("***** Liste des clients : ");
        testFindAllClient();


        dao = new VehiculeDaoImpl(connection);

        System.out.println("***** Création d'un vehicule : ");
        Vehicule vehicule = new Vehicule("bruhMobile");
        testCreateVehicule(vehicule);

        System.out.println("***** Liste des vehicules : ");
        testFindAllVehicule();


        dao = new TypeDaoImpl(connection);

        System.out.println("***** Création d'un type : ");
        Type type = new Type("bruuuuuh");
        testCreateType(type);

        System.out.println("***** Liste des types : ");
        testFindAllType();


        dao = new CategorieDaoImpl(connection);

        System.out.println("***** Création d'une categorie : ");
        Categorie categorie = new Categorie("bruhed");
        testCreateCategorie(categorie);

        System.out.println("***** Liste des categories : ");
        testFindAllCategorie();


        dao = new ModeleDaoImpl(connection);

        System.out.println("***** Création d'un modele : ");
        Modele modele = new modele("bruh2000");
        testCreateModele(modele);

        System.out.println("***** Liste des Modeles : ");
        testFindAllModele();


        dao = new ContratDaoImpl(connection);

        System.out.println("***** Création d'un contrat : ");
        Contrat contrat = new Contrat("bruh.txt");
        testCreateContrat(contrat);

        System.out.println("***** Liste des contrats : ");
        testFindAllContrat();


        dao = new FactureDaoImpl(connection);

        System.out.println("***** Création d'une facture : ");
        Facture facture = new Facture("bruhBill");
        testCreateFacture(facture);

        System.out.println("***** Liste des factures : ");
        testFindAllFacture();
    }


    public static void main(String[] args) {
        new SimpleJdbcDaoTest().test();
    }
}