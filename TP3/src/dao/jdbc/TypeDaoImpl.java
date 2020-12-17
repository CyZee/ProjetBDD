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

public class TypeDaoImpl extends JdbcDao {



    public TypeDaoImpl(Connection connection) {
        super(connection);


    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> type = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM type");

            while (resultSet.next()) {
                Type type1 = new Type();
                type1.setId(resultSet.getInt("id"));
                type1.setLibelle(resultSet.getString("libelle"));
                type.add(type1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return type;
    }

    @Override
    public  Type findById(int id) throws DaoException {
        Type type = new Type();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM type WHERE id="+id);

            while (resultSet.next()) {


                type.setId(resultSet.getInt("id"));
                type.setLibelle(resultSet.getString("libelle"));


            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

        return type;
    }

    @Override
    public void create(Entity entity) throws DaoException {

        Type type = (Type) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into type(libelle) values (?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connection.prepareStatement(sqlReq);
            stmt.setString(1, ((Type)entity).getLibelle());



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
        String sqlReq = "update type set libelle = ? where id = ?";
        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setString(1,((Type)entity).getLibelle());


            stmt.setInt(2,((Type) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from type where id = ?";

        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setInt(1,((Type) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }
    }
}