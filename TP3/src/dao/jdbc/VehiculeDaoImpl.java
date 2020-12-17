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

public class VehiculeDaoImpl extends JdbcDao {

    private VehiculeDaoImpl vehiculeDao;

    public VehiculeDaoImpl(Connection connection) {
        super(connection);


    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> vehicule = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicule");

            while (resultSet.next()) {
                AgenceDaoImpl agence = new AgenceDaoImpl(connection);
                ModeleDaoImpl modele = new ModeleDaoImpl(connection);
                MarqueDaoImpl marque = new MarqueDaoImpl(connection);
                CategorieDaoImpl categorie = new CategorieDaoImpl(connection);
                TypeDaoImpl type = new TypeDaoImpl(connection);

                Vehicule vehicule1 = new Vehicule();
                vehicule1.setId(resultSet.getInt("id"));
                vehicule1.setdateMiseEnCirculation(resultSet.getString("dateMiseEnCirculation"));
                vehicule1.setEtat(resultSet.getString("etat"));
                vehicule1.setNbKilometres(resultSet.getInt("nbKilometres"));
                vehicule1.setPrixParJourDeLocation(resultSet.getInt("prixParJourDeLocation"));
                vehicule1.setMarque((Marque)marque.findById(resultSet.getInt("marque")));
                vehicule1.setModele((Modele)modele.findById(resultSet.getInt("modele")));
                vehicule1.setCategorie((Categorie)categorie.findById(resultSet.getInt("categorie")));
                vehicule1.setType((Type)type.findById(resultSet.getInt("type")));
                vehicule1.setAgence((Agence)agence.findById(resultSet.getInt("agence")));
                vehicule.add(vehicule1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return vehicule;
    }

    @Override
    public Vehicule findById(int id) throws DaoException {
        Vehicule vehicule = new Vehicule();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicule WHERE id="+id);

            while (resultSet.next()) {
                AgenceDaoImpl agence = new AgenceDaoImpl(connection);
                ModeleDaoImpl modele = new ModeleDaoImpl(connection);
                MarqueDaoImpl marque = new MarqueDaoImpl(connection);
                CategorieDaoImpl categorie = new CategorieDaoImpl(connection);
                TypeDaoImpl type = new TypeDaoImpl(connection);




                vehicule.setId(resultSet.getInt("id"));
                vehicule.setdateMiseEnCirculation(resultSet.getString("dateMiseEnCirculation"));
                vehicule.setEtat(resultSet.getString("etat"));
                vehicule.setNbKilometres(resultSet.getInt("nbKilometres"));
                vehicule.setPrixParJourDeLocation(resultSet.getInt("prixParJourDeLocation"));
                vehicule.setMarque((Marque) marque.findById(resultSet.getInt("marque")));
                vehicule.setModele((Modele) modele.findById(resultSet.getInt("modele")));
                vehicule.setCategorie((Categorie) categorie.findById(resultSet.getInt("categorie")));
                vehicule.setType((Type) type.findById(resultSet.getInt("type")));
                vehicule.setAgence((Agence) agence.findById(resultSet.getInt("agence")));


            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

        return vehicule;
    }

    @Override
    public void create(Entity entity) throws DaoException {

        Vehicule vehicule = (Vehicule) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into vehicule(\"dateMiseEnCirculation\",etat,\"nbKilometres\",\"prixParJourDeLocation\",marque,modele,categorie,type,agence) values (?,?,?,?,?,?,?,?,?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connection.prepareStatement(sqlReq);
            stmt.setString(1, ((Vehicule)entity).getdateMiseEnCirculation());
            stmt.setString(2, ((Vehicule)entity).getEtat());
            stmt.setInt(3, ((Vehicule)entity).getNbKilometres());
            stmt.setInt(4, ((Vehicule)entity).getPrixParJourDeLocation());
            stmt.setInt(5, ((Vehicule)entity).getMarque().getId());
            stmt.setInt(6, ((Vehicule)entity).getModele().getId());
            stmt.setInt(7, ((Vehicule)entity).getCategorie().getId());
            stmt.setInt(8, ((Vehicule)entity).getType().getId());
            stmt.setInt(9, ((Vehicule)entity).getAgence().getId());



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
        String sqlReq = "update vehicule set \"dateMiseEnCirculation\" = ?, etat = ? , \"nbKilometres\" = ? , \"prixParJourDeLocation\" = ? , marque = ? , modele = ?, categorie = ?, type = ?, agence = ? where id = ?";
        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setString(1, ((Vehicule)entity).getdateMiseEnCirculation());
            stmt.setString(2, ((Vehicule)entity).getEtat());
            stmt.setInt(3, ((Vehicule)entity).getNbKilometres());
            stmt.setInt(4, ((Vehicule)entity).getPrixParJourDeLocation());
            stmt.setInt(5, ((Vehicule)entity).getMarque().getId());
            stmt.setInt(6, ((Vehicule)entity).getModele().getId());
            stmt.setInt(7, ((Vehicule)entity).getCategorie().getId());
            stmt.setInt(8, ((Vehicule)entity).getType().getId());
            stmt.setInt(9, ((Vehicule)entity).getAgence().getId());


            stmt.setInt(10,((Vehicule) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from vehicule where id = ?";

        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setInt(1,((Vehicule) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }
    }

    public Vehicule question10() throws DaoException{
        Vehicule vehicule = new Vehicule();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT count(vehicule.id), vehicule.agence FROM vehicule WHERE vehicule.agence<count(vehicule.agence)");

            while (resultSet.next()) {
                AgenceDaoImpl agence = new AgenceDaoImpl(connection);

                vehicule.setId(resultSet.getInt("id"));
                vehicule.setAgence((Agence)agence.findById(resultSet.getInt("agence")));



            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

        return vehicule;
    }


}