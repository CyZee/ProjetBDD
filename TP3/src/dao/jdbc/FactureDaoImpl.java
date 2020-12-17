package dao.jdbc;

import dao.Dao;
import dao.exception.DaoException;
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

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class FactureDaoImpl extends JdbcDao {

    private FactureDaoImpl factureDao;

    public FactureDaoImpl(Connection connection) {
        super(connection);


    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> facture = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM marque");

            while (resultSet.next()) {
                ContratDaoImpl contrat = new ContratDaoImpl(connection);

                Facture facture1 = new Facture();
                facture1.setId(resultSet.getInt("id"));
                facture1.setMontant(resultSet.getInt("montant"));
                facture1.setContrat((Contrat)contrat.findById(resultSet.getInt("contrat")));
                facture1.add(facture1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return facture;
    }

    @Override
    public Facture findById(int id) throws DaoException {
        Facture facture = new Facture();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM facture WHERE id="+id);

            while (resultSet.next()) {
                ContratDaoImpl contrat = new ContratDaoImpl(connection);


                facture.setId(resultSet.getInt("id"));
                facture.setMontant(resultSet.getInt("montant"));
                facture.setContrat((Contrat)contrat.findById(resultSet.getInt("contrat")));


            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

        return facture;
    }

    @Override
    public void create(Entity entity) throws DaoException {

        Facture facture = (Facture) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into facture(montant,contrat) values (?,?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connection.prepareStatement(sqlReq);
            stmt.setInt(1, ((Facture)entity).getMontant());
            stmt.setInt(2, ((Facture)entity).getContrat().getId());



            int res = stmt.executeUpdate();
            if (res > 0) {
                System.out.println("Ligne insérée");
            }

        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());

        }
    }

    @Override
    public void update(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "update facture set montant = ?, contrat = ? where id = ?";
        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setInt(1,((Facture)entity).getMontant());
            stmt.setInt(2, ((Facture)entity).getContrat().getId());


            stmt.setInt(3,((Modele) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from facture where id = ?";

        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setInt(1,((Facture) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }
    }
}