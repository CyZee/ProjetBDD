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

public class ContratDaoImpl extends JdbcDao {

    private ContratDaoImpl contratDao;

    public ContratDaoImpl(Connection connection) {
        super(connection);


    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> contrat = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contrat");

            while (resultSet.next()) {
                ClientDaoImpl client = new ClientDaoImpl(connection);
                VehiculeDaoImpl vehicule = new VehiculeDaoImpl(connection);
                AgenceDaoImpl agence = new AgenceDaoImpl(connection);

                Contrat contrat1 = new Contrat();
                contrat1.setId(resultSet.getInt("id"));
                contrat1.setDateDeRetrait(resultSet.getString("dateDeRetrait"));
                contrat1.setDateDeRetour(resultSet.getString("dateDeRetour"));
                contrat1.setKmRetrait(resultSet.getInt("kmRetrait"));
                contrat1.setKmRetour(resultSet.getInt("kmRetour"));
                contrat1.setClient((Client)client.findById(resultSet.getInt("client")));
                contrat1.setVehicule((Vehicule)vehicule.findById(resultSet.getInt("immatriculation")));
                contrat1.setAgence((Agence)agence.findById(resultSet.getInt("agence")));
                contrat1.add(contrat1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return contrat;
    }

    @Override
    public Entity findById(int id) throws DaoException {
        Contrat contrat = new Contrat();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contrat WHERE id="+id);

            while (resultSet.next()) {

                ClientDaoImpl client = new ClientDaoImpl(connection);
                VehiculeDaoImpl vehicule = new VehiculeDaoImpl(connection);
                AgenceDaoImpl agence = new AgenceDaoImpl(connection);



                contrat.setId(resultSet.getInt("id"));
                contrat.setDateDeRetrait(resultSet.getString("dateDeRetrait"));
                contrat.setDateDeRetour(resultSet.getString("dateDeRetour"));
                contrat.setKmRetrait(resultSet.getInt("kmRetrait"));
                contrat.setKmRetour(resultSet.getInt("kmRetour"));
                contrat.setClient((Client)client.findById(resultSet.getInt("client")));
                contrat.setVehicule((Vehicule)vehicule.findById(resultSet.getInt("immatriculation")));
                contrat.setAgence((Agence) agence.findById(resultSet.getInt("agence")));



            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

        return contrat;
    }

    @Override
    public void create(Entity entity) throws DaoException {

        Contrat modele = (Contrat) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into contrat(\"dateDeRetrait\",\"dateDeRetour\",\"kmRetrait\",\"kmRetour\",client,immatriculation,agence) values (?,?,?,?,?,?,?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connection.prepareStatement(sqlReq);
            stmt.setString(1, ((Contrat)entity).getDateDeRetrait());
            stmt.setString(2, ((Contrat)entity).getDateDeRetour());
            stmt.setInt(3, ((Contrat)entity).getKmRetrait());
            stmt.setInt(4, ((Contrat)entity).getKmRetour());
            stmt.setInt(5, ((Contrat)entity).getClient().getId());
            stmt.setInt(6, ((Contrat)entity).getVehicule().getId());
            stmt.setInt(7, ((Contrat)entity).getAgence().getId());




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
        String sqlReq = "update contrat set \"dateDeRetrait\" = ?, \"dateDeRetour\" = ?, \"kmRetrait\" = ?, \"kmRetour\" = ?, client = ?, immatriculation = ?, agence = ?  where id = ?";
        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setString(1, ((Contrat)entity).getDateDeRetrait());
            stmt.setString(2, ((Contrat)entity).getDateDeRetour());
            stmt.setInt(3, ((Contrat)entity).getKmRetrait());
            stmt.setInt(4, ((Contrat)entity).getKmRetour());
            stmt.setInt(5, ((Contrat)entity).getClient().getId());
            stmt.setInt(6, ((Contrat)entity).getVehicule().getId());
            stmt.setInt(7, ((Contrat)entity).getAgence().getId());



            stmt.setInt(8,((Contrat) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from contrat where id = ?";

        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setInt(1,((Contrat) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }
    }

    public Contrat question3(int id) throws DaoException{
        Contrat contrat = new Contrat();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT contrat.\"dateDeRetour\" FROM contrat WHERE id="+id);

            while (resultSet.next()) {
                VehiculeDaoImpl vehicule = new VehiculeDaoImpl(connection);

                contrat.setDateDeRetour(resultSet.getString("dateRetour"));
                contrat.setVehicule((Vehicule)vehicule.findById(resultSet.getInt("vehicule")));



            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

        return contrat;
    }
}