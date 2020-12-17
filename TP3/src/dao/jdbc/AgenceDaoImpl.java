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

public class AgenceDaoImpl extends JdbcDao {

    private AgenceDaoImpl AgenceDao;

    public AgenceDaoImpl(Connection connection) {
        super(connection);


    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> agence = new ArrayList<>();

                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM agence");

                    while (resultSet.next()) {

                        VilleDaoImpl ville = new VilleDaoImpl(connection);

                        Agence agence1 = new Agence();
                        agence1.setId(resultSet.getInt("id"));
                        agence1.setNbEmployes(resultSet.getInt("nbEmployes"));
                        agence1.setVille((Ville)ville.findById(resultSet.getInt("ville")));
                        agence.add(agence1);
                    }
                } catch (SQLException e) {
                    throw new DaoException(e);
                }

                return agence;
    }

    @Override
    public  Agence findById(int id) throws DaoException {
        Agence agence = new Agence();

                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM agence WHERE id="+id);

                    while (resultSet.next()) {

                        VilleDaoImpl ville = new VilleDaoImpl(connection);

                        agence.setId(resultSet.getInt("id"));
                        agence.setNbEmployes(resultSet.getInt("nbEmployes"));

                        agence.setVille((Ville) ville.findById(resultSet.getInt("ville")));

                    }
                } catch (SQLException e) {
                    System.err.println("Erreur SQL : " + e.getLocalizedMessage());
                }

                return agence;
    }

    @Override
    public void create(Entity entity) throws DaoException {

        Agence agence = (Agence) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into agence(\"nbEmployes\",ville) values (?,?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connection.prepareStatement(sqlReq);
            stmt.setInt(1, ((Agence)entity).getNbEmployes());

            stmt.setInt(2, ((Agence)entity).getVille().getId());


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
        String sqlReq = "update agence set \"nbEmployes\" = ?,ville = ? where id = ?";
        try {
                    stmt = connection.prepareStatement(sqlReq);
                    stmt.setInt(1,((Agence)entity).getNbEmployes());

                    stmt.setInt(2,((Agence)entity).getVille().getId());

                    stmt.setInt(3,((Agence) entity).getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Erreur SQL : " + e.getLocalizedMessage());
                }

    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from agence where id = ?";

        try {
                    stmt = connection.prepareStatement(sqlReq);
                    stmt.setInt(1,((Agence) entity).getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Erreur SQL : " + e.getLocalizedMessage());
                }
    }
    }