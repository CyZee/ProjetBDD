package dao.jdbc;//package dao.jdbc;

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

public class VilleDaoImpl extends JdbcDao {

    public VilleDaoImpl(Connection connection) {
        super(connection);
    }


    @Override
    public Collection<Entity> findAll() throws DaoException {
        Collection<Entity> ville = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM ville");

            while (resultSet.next()) {
                Ville ville = new Ville();
                ville.setId(resultSet.getInt("id"));
                ville.setNom(resultSet.getString("nom"));
                ville.setId(resultSet.getInt("nombreHabitants"));
                ville.add(ville);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return ville;
    }

    @Override
    public Entity findById(int id) throws DaoException {

       Ville ville = new Ville();

               try {
                   Statement statement = connexion.createStatement();
                   ResultSet resultSet = statement.executeQuery("SELECT * FROM ville WHERE id="+id);

                   while (resultSet.next()) {
                       ville.setId(resultSet.getInt("id"));
                       ville.setNom(resultSet.getString("nom"));
                       ville.setId(resultSet.getInt("nombreHabitants"));
                   }
               } catch (SQLException e) {
                   System.err.println("Erreur SQL : " + e.getLocalizedMessage());
               }

               return ville;

    }

    @Override
    public void create(Entity entity) throws DaoException {

        Ville ville = (Ville) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into ville(nom,nombreHabitants) values (?,?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            // stmt.setInt(1, 5);

            stmt.setString(1, ville.getNom());
            stmt.setString(2, ville.getNombreHabitants());

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
        String sqlReq = "update ville set nom = ?, nombreHabitants = ? where id = ?";
        try {
                    stmt = connexion.prepareStatement(sqlReq);
                    stmt.setString(1,((Ville)entity).getNom());
                    stmt.setString(2,((Ville)entity).getNombreHabitants());
                    stmt.setInt(3,((Ville) entity).getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Erreur SQL : " + e.getLocalizedMessage());
                }
    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from ville where id = ?";

        try {
                    stmt = connexion.prepareStatement(sqlReq);
                    stmt.setInt(1,((Ville) entity).getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Erreur SQL : " + e.getLocalizedMessage());
                }
    }

}