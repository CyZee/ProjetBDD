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

public class ModeleDaoImpl extends JdbcDao {

    private ModeleDaoImpl modeleDao;

    public ModeleDaoImpl(Connection connection) {
        super(connection);


    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> modele = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM marque");

            while (resultSet.next()) {
                Modele modele = new Modele();
                modele.setId(resultSet.getInt("id"));
                modele.setLibelle(resultSet.getString("libelle"));
                modele.setPuissanceFiscale(resultSet.getInt("puissanceFiscale"));
                modele.add(modele);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return modele;
    }

    @Override
    public Entity findById(int id) throws DaoException {
        Modele modele = new Modele();

        try {
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM modele WHERE id="+id);

            while (resultSet.next()) {


                modele.setId(resultSet.getInt("id"));
                modele.setLibelle(resultSet.getString("libelle"));
                modele.setPuissanceFiscale(resultSet.getInt("puissanceFiscale"));


            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

        return modele;
    }

    @Override
    public void create(Entity entity) throws DaoException {

        Modele modele = (Modele) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into modele(libelle,puissanceFiscale) values (?,?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connexion.prepareStatement(sqlReq);
            stmt.setString(1, ((Modele)entity).getLibelle());
            stmt.setInt(2, ((Modele)entity).getPuissanceFiscale());



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
        String sqlReq = "update modele set libelle = ?, puissanceFiscale = ? where id = ?";
        try {
            stmt = connexion.prepareStatement(sqlReq);
            stmt.setString(1,((Modele)entity).getlibelle());
            stmt.setInt(2, ((Modele)entity).getPuissanceFiscale());


            stmt.setInt(3,((Modele) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from modele where id = ?";

        try {
            stmt = connexion.prepareStatement(sqlReq);
            stmt.setInt(1,((Modele) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }
    }
}