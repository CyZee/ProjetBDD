package dao.jdbc;

import dao.Dao;
import dao.exception.DaoException;
import model.Entity;
import model.Entreprise;
import model.Etudiant;
import model.Professeur;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

public class EtudiantDaoImpl extends JdbcDao {

    private EntrepriseDaoImpl entrepriseDao;

    public EtudiantDaoImpl(Connection connection) {
        super(connection);
        entrepriseDao = new EntrepriseDaoImpl(connection);

    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> etudiant = new ArrayList<>();

                try {
                    Statement statement = connection.createStatement();
                    ResultSet resultSet = statement.executeQuery("SELECT * FROM etudiant");

                    while (resultSet.next()) {
                        Etudiant etudiant = new >Etudiant();
                        etudiant.setId(resultSet.getInt("no_etudiant"));
                        etudiant.setNom(resultSet.getString("nom_etu"));
                        etudiant.setTuteur(resultSet.getInt("tuteurpresent"));
                        etudiant.setEntreprise((Entreprise)entrepriseDaompl.findById(resultSet.getInt("id_entreprise")));
                        etudiant.setProfesseur((Professeur)professeurDaompl.findById(resultSet.getInt("no_professeur")));
                        etudiant.add(etudiant);
                    }
                } catch (SQLException e) {
                    throw new DaoException(e);
                }

                return etudiant;
    }

    @Override
    public Entity findById(int id) throws DaoException {
        return null;
    }

    @Override
    public void create(Entity entity) throws DaoException {

        Etudiant etudiant = (Etudiant) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into etudiant(nom_etu,tuteur_present,id_entreprise,no_professeur) values (?,?,?,?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connexion.prepareStatement(sqlReq);
            stmt.setString(1, ((Etudiant)entity).getNom());
            stmt.setInt(2, ((Etudiant)entity).getTuteur());
            stmt.setInt(3, ((Etudiant)entity).getEntreprise().getId());
            stmt.setInt(4, ((Etudiant)entity).getProfesseur().getId());

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
        String sqlReq = "update etudiant set nom_etu = ?,tuteur_present = ?, id_entreprise = ?, no_professeur = ? where no_etudiant = ?";
        try {
                    stmt = connexion.prepareStatement(sqlReq);
                    stmt.setString(1,((Etudiant)entity).getNom());
                    statement.setInt(2,((Etudiant)entity).getTuteur());
                    statement.setInt(3,((Etudiant)entity).getEntreprise().getId());
                    statement.setInt(4,((Etudiant)entity).getProfesseur().getId());
                    stmt.setInt(5,((Etudiant) entity).getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Erreur SQL : " + e.getLocalizedMessage());
                }

    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from etudiant where no_etudiant = ?";

        try {
                    stmt = connexion.prepareStatement(sqlReq);
                    stmt.setInt(1,((Etudiant) entity).getId());
                    stmt.executeUpdate();
                } catch (SQLException e) {
                    System.err.println("Erreur SQL : " + e.getLocalizedMessage());
                }
    }
    }