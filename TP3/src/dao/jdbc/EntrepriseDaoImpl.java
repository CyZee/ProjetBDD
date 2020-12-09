package dao.jdbc;//package dao.jdbc;

import dao.exception.DaoException;
import model.Entity;
import model.Entreprise;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class EntrepriseDaoImpl extends JdbcDao {

    public EntrepriseDaoImpl(Connection connection) {
        super(connection);
    }

    @Override public Collection<Entity> findAll() throws DaoException {
        Collection<Entity> entreprises = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM entreprise");

            while (resultSet.next()) {
                Entreprise entreprise = new Entreprise();
                entreprise.setId(resultSet.getInt("id_entreprise"));
                entreprise.setNom(resultSet.getString("nomEntreprise"));
                entreprises.add(entreprise);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return entreprises;
    }

    @Override
    public Entity findById(int id) throws DaoException {

       Entreprise entreprise = new Entreprise();

               try {
                   Statement statement = connexion.createStatement();
                   ResultSet resultSet = statement.executeQuery("SELECT * FROM entreprise WHERE id_entreprise="+id);

                   while (resultSet.next()) {
                       entreprise.setId(resultSet.getInt("id_entreprise"));
                       entreprise.setNom(resultSet.getString("nomEntreprise"));
                   }
               } catch (SQLException e) {
                   System.err.println("Erreur SQL : " + e.getLocalizedMessage());
               }

               return entreprise;

    }

    @Override
    public void create(Entity entity) throws DaoException {

        Entreprise entreprise = (Entreprise) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into entreprise(nomEntreprise) values (?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            // stmt.setInt(1, 5);

            stmt.setString(1, entreprise.getNom());

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
        String sqlReq = "update entreprise set nomEntreprise = ? where id_entreprise = ?";
        try {
                    stmt = connexion.prepareStatement(sqlReq);
                    stmt.setString(1,((Entreprise)entity).getNom());
                    stmt.setInt(2,((Entreprise) entity).getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Erreur SQL : " + e.getLocalizedMessage());
                }
    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from entreprise where id_entreprise = ?";

        try {
                    stmt = connexion.prepareStatement(sqlReq);
                    stmt.setInt(1,((Entreprise) entity).getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Erreur SQL : " + e.getLocalizedMessage());
                }
    }

}