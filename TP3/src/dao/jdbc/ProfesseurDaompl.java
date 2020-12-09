package dao.jdbc;

import dao.Dao;
import dao.exception.DaoException;
import model.Entity;
import model.Entreprise;
import model.Etudiant;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class ProfesseurDaoImpl extends JdbcDao {

    private ProfesseurDaoImpl professeurDao;

    public ProfesseurDaoImpl(Connection connection) {
        super(connection);
        professeurDao = new ProfesseurDaoImpl(connection);

    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> professeur = new ArrayList<>();

                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM professeur");

                    while (resultSet.next()) {
                        Professeur professeur = new >Etudiant();
                        professeur.setId(resultSet.getInt("professeur"));
                        professeur.setNom(resultSet.getString("nom_professeur"));
                        professeur.add(professeur);
                    }
                } catch (SQLException e) {
                    throw new DaoException(e);
                }

                return professeur;
    }

    @Override
    public Entity findById(int id) throws DaoException {
        return null;
    }

    @Override
    public void create(Entity entity) throws DaoException {

        Professeur professeur = (Professeur) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into professeur(nom_professeur) values (?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            // stmt.setInt(1, 5);

            stmt.setString(1, professeur.getNom());

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


    }

    @Override
    public void delete(Entity entity) throws DaoException {

    }
    }