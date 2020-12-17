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

public class MarqueDaoImpl extends JdbcDao {

    private MarqueDaoImpl marqueDao;

    public MarqueDaoImpl(Connection connection) {
        super(connection);


    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> marque = new ArrayList<>();

                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM marque");

                    while (resultSet.next()) {
                        Marque marque = new Marque();
                        marque.setId(resultSet.getInt("id"));
                        marque.setNomMarque(resultSet.getString("nomMarque"));
                        marque.add(marque);
                    }
                } catch (SQLException e) {
                    throw new DaoException(e);
                }

                return marque;
    }

    @Override
    public Entity findById(int id) throws DaoException {
        Marque marque = new Marque();

        try {
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM marque WHERE id="+id);

            while (resultSet.next()) {


                agence.setId(resultSet.getInt("id"));
                agence.setNomMarque(resultSet.getString("nomMarque"));


            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

        return marque;
    }

    @Override
    public void create(Entity entity) throws DaoException {

        Marque marque = (Marque) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into marque(nomMarque) values (?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connexion.prepareStatement(sqlReq);
            stmt.setString(1, ((Marque)entity).getNomMarque());



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
        String sqlReq = "update marque set nomMarque = ? where id = ?";
        try {
            stmt = connexion.prepareStatement(sqlReq);
            stmt.setString(1,((Marque)entity).getNomMarque());


            stmt.setInt(2,((Marque) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from marque where id = ?";

        try {
            stmt = connexion.prepareStatement(sqlReq);
            stmt.setInt(1,((Marque) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }
    }
    }