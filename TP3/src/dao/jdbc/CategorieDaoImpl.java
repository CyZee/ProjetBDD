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

public class CategorieDaoImpl extends JdbcDao {

    private CategorieDaoImpl categorieDao;

    public CategorieDaoImpl(Connection connection) {
        super(connection);


    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> categorie = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM marque");

            while (resultSet.next()) {
                Categorie categorie1 = new Categorie();
                categorie1.setId(resultSet.getInt("id"));
                categorie1.setLibelle(resultSet.getString("libelle"));
                categorie1.add(categorie1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return categorie;
    }

    @Override
    public  Categorie findById(int id) throws DaoException {
        Categorie categorie = new Categorie();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM categorie WHERE id="+id);

            while (resultSet.next()) {


                categorie.setId(resultSet.getInt("id"));
                categorie.setLibelle(resultSet.getString("libelle"));


            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

        return categorie;
    }

    @Override
    public void create(Entity entity) throws DaoException {

        Categorie categorie = (Categorie) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into categorie(libelle) values (?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connection.prepareStatement(sqlReq);
            stmt.setString(1, ((Categorie)entity).getLibelle());



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
        String sqlReq = "update categorie set libelle = ? where id = ?";
        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setString(1,((Categorie)entity).getLibelle());


            stmt.setInt(2,((Categorie) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from categorie where id = ?";

        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setInt(1,((Categorie) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }
    }
}