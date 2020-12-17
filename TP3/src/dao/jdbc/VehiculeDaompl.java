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

public class VehiculeDaoImpl extends JdbcDao {

    private VehiculeDaoImpl vehiculeDao;

    public VehiculeDaoImpl(Connection connection) {
        super(connection);


    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> marque = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicule");

            while (resultSet.next()) {
                Vehicule vehicule = new Vehicule();
                vehicule.setId(resultSet.getInt("id"));
                vehicule.setDateMiseEnCirculation(resultSet.getString("dateMiseEnCirculation"));
                vehicule.setEtat(resultSet.getString("etat"));
                vehicule.setNbKilometres(resultSet.getInt("nbKilometres"));
                vehicule.setPrixParJourDeLocation(resultSet.getInt("prixParJourDeLocation"));
                vehicule.setMarque(resultSet.getMarque("marque"));
                vehicule.setModele(resultSet.getModele("modele"));
                vehicule.setCategorie(resultSet.getCategorie("categorie"));
                vehicule.setType(resultSet.getType("type"));
                vehicule.setAgence(resultSet.getAgence("agence"));
                vehicule.add(vehicule);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return marque;
    }

    @Override
    public Entity findById(int id) throws DaoException {
        Vehicule vehicule = new Vehicule();

        try {
            Statement statement = connexion.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM vehicule WHERE id="+id);

            while (resultSet.next()) {
                MarqueRepository marqueRepository = new MarqueRepository();
                ModeleRepository modeleRepository = new ModeleRepository();
                CategorieRepository categorieRepository = new CategorieRepository();
                TypeRepository typeRepository = new TypeRepository();
                AgenceRepository agenceRepository = new AgenceRepository();


                vehicule.setId(resultSet.getInt("id"));
                vehicule.setDateMiseEnCirculation(resultSet.getString("dateMiseEnCirculation"));
                vehicule.setEtat(resultSet.getString("etat"));
                vehicule.setNbKilometre(resultSet.getInt("nbKilometres"));
                vehicule.setPrixParJourDeLocation(resultSet.getInt("prixParJourDeLocation"));
                vehicule.setMarque((Marque)marqueRepository.findById(resultSet.getMarque("marque")));
                vehicule.setModele((Modele)modeleRepository.findById(resultSet.getModele("modele")));
                vehicule.setCategorie((Categorie)categorieRepository.findById(resultSet.getCategorie("categorie")));
                vehicule.setType((Type)typeRepository.findById(resultSet.getType("type")));
                vehicule.setAgence((Agence)agenceRepository.findById(resultSet.getAgence("agence")));


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

        String sqlReq = "insert into vehicule(dateMiseEnCirculation,etat,nbKilometres,prixParJourDeLocation,marque,modele,categorie,type,agence) values (?,?,?,?,?,?,?,?,?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connexion.prepareStatement(sqlReq);
            stmt.setString(1, ((Vehicule)entity).getDateMiseEnCirculation());
            stmt.setString(2, ((Vehicule)entity).getEtat());
            stmt.setInt(3, ((Vehicule)entity).getNbKilometre());
            stmt.setInt(4, ((Vehicule)entity).getPrixParJourDeLocation());
            stmt.setInt(5, ((Vehicule)entity).getMarque.getId());
            stmt.setInt(6, ((Vehicule)entity).getModele.getId());
            stmt.setInt(7, ((Vehicule)entity).getCategorie.getId());
            stmt.setInt(8, ((Vehicule)entity).getType.getId());
            stmt.setInt(9, ((Vehicule)entity).getAgence.getId());



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
        String sqlReq = "update vehicule set dateMiseEnCirculation = ?, etat = ? , nbKilometre = ? , prixParJourDeLocation = ? , marque = ? , modele = ?, categorie = ?, type = ?, agence = ? where id = ?";
        try {
            stmt = connexion.prepareStatement(sqlReq);
            stmt.setString(1, ((Vehicule)entity).getDateMiseEnCirculation());
            stmt.setString(2, ((Vehicule)entity).getEtat());
            stmt.setInt(3, ((Vehicule)entity).getNbKilometre());
            stmt.setInt(4, ((Vehicule)entity).getPrixParJourDeLocation());
            stmt.setInt(5, ((Vehicule)entity).getMarque.getId());
            stmt.setInt(6, ((Vehicule)entity).getModele.getId());
            stmt.setInt(7, ((Vehicule)entity).getCategorie.getId());
            stmt.setInt(8, ((Vehicule)entity).getType.getId());
            stmt.setInt(9, ((Vehicule)entity).getAgence.getId());


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
            stmt = connexion.prepareStatement(sqlReq);
            stmt.setInt(1,((vehicule) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }
    }
}