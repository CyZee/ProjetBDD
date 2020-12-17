package dao.jdbc;

import dao.Dao;
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
                Contrat contrat = new Contrat();
                contrat.setId(resultSet.getInt("id"));
                contrat.setDateDeRetrait(resultSet.getString("dateDeRetrait"));
                contrat.setDateDeRetour(resultSet.getString("dateDeRetour"));
                contrat.setKmRetrait(resultSet.getInt("kmRetrait"));
                contrat.setKmRetour(resultSet.getInt("kmRetour"));
                contrat.setClient((Client)clientDaoImpl.findById(resultSet.getInt("client")));
                contrat.setVehicule((Vehicule)vehiculeDaoImpl.findById(resultSet.getInt("vehicule")));
                contrat.setAgence((Agence)agenceDaoImpl.findById(resultSet.getInt("agence")));
                contrat.setImmatriculation(resultSet.getString("immatriculation"));
                contrat.add(contrat);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return modele;
    }

    @Override
    public Entity findById(int id) throws DaoException {
        Contrat contrat = new Contrat();

        try {
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM contrat WHERE id="+id);

            while (resultSet.next()) {

                ClientRepository clientRepository = new ClientRepository();
                VehiculeRepository vehiculeRepository = new VehiculeRepository();
                AgenceRepository agenceRepository = new AgenceRepository();



                contrat.setId(resultSet.getInt("id"));
                contrat.setDateDeRetrait(resultSet.getString("dateDeRetrait"));
                contrat.setDateDeRetour(resultSet.getString("dateDeRetour"));
                contrat.setKmRetrait(resultSet.getInt("kmRetrait"));
                contrat.setKmRetour(resultSet.getInt("kmRetour"));
                contrat.setClient((Client)clientRepository.findById(resultSet.getInt("client")));
                contrat.setVehicule((Vehicule)vehiculeRepository.findById(resultSet.getInt("vehicule")));
                contrat.setAgence((Agence)agenceRepository.findById(resultSet.getInt("agence")));
                contrat.setImmatriculation(resultSet.getString("immatriculation"));


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

        String sqlReq = "insert into contart(dateDeRetrait,dateDeRetour,kmRetrait,kmRetour,client,vehicule,agence,immatriculation) values (?,?,?,?,?,?,?,?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connexion.prepareStatement(sqlReq);
            stmt.setString(1, ((Contrat)entity).getDateDeRetrait());
            stmt.setString(2, ((Contrat)entity).getDateDeRetour());
            stmt.setInt(3, ((Contrat)entity).getKmRetrait());
            stmt.setInt(4, ((Contrat)entity).getKmRetour());
            stmt.setInt(5, ((Contrat)entity).getClient().getId());
            stmt.setInt(6, ((Contrat)entity).getVehicule().getId());
            stmt.setInt(7, ((Contrat)entity).getAgence().getId());
            stmt.setString(8, ((Contrat)entity).getImmatriculation());



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
        String sqlReq = "update contrat set dateDeRetrait = ?, dateDeRetour = ?, kmRetrait = ?, kmRetour = ?, client = ?, vehicule = ?, agence = ?, immatriculation = ?  where id = ?";
        try {
            stmt = connexion.prepareStatement(sqlReq);
            stmt.setString(1, ((Contrat)entity).getDateDeRetrait());
            stmt.setString(2, ((Contrat)entity).getDateDeRetour());
            stmt.setInt(3, ((Contrat)entity).getKmRetrait());
            stmt.setInt(4, ((Contrat)entity).getKmRetour());
            stmt.setInt(5, ((Contrat)entity).getClient().getId());
            stmt.setInt(6, ((Contrat)entity).getVehicule().getId());
            stmt.setInt(7, ((Contrat)entity).getAgence().getId());
            stmt.setString(8, ((Contrat)entity).getImmatriculation());


            stmt.setInt(9,((Contrat) entity).getId());
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
            stmt = connexion.prepareStatement(sqlReq);
            stmt.setInt(1,((Contrat) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }
    }
}