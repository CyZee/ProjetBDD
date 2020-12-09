package test;//package test;

import dao.Dao;
import dao.jdbc.EntrepriseDaoImpl;
import dao.exception.DaoException;
//import dao.jdbc.EtudiantDaoImpl;
import model.Entity;
import model.Entreprise;
import model.Etudiant;
import sql.PostgresConnection;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collection;

public class SimpleJdbcDaoTest {
    private Connection connection;
    private Dao dao;

    public void testfindAllEntreprises() {
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

    }

    public void test() {
        connection = PostgresConnection.getInstance();
        dao = new EntrepriseDaoImpl(connection);

        System.out.println("***** Création d'une entreprise : ");
        Entreprise entreprise = new Entreprise("HP");
        testCreateEntreprise(entreprise);


        System.out.println("***** Liste des entreprises : ");
        testfindAllEntreprises();
    }


    public static void main(String[] args) {
        new SimpleJdbcDaoTest().test();
    }
}