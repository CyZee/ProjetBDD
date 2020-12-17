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

public class ClientDaoImpl extends JdbcDao {



    public ClientDaoImpl(Connection connection) {
        super(connection);


    }

    @Override
    public Collection<Entity> findAll() throws DaoException {

        Collection<Entity> client = new ArrayList<>();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM client");

            while (resultSet.next()) {
                VilleDaoImpl ville = new VilleDaoImpl(connection);

                Client client1 = new Client();
                client1.setId(resultSet.getInt("id"));
                client1.setNom(resultSet.getString("nomClient"));
                client1.setAdresse(resultSet.getString("adresseClient"));
                client1.setCodePostal(resultSet.getString("codePostalClient"));
                client1.setVille((Ville)ville.findById(resultSet.getInt("ville")));
                client.add(client1);
            }
        } catch (SQLException e) {
            throw new DaoException(e);
        }

        return client;
    }

    @Override
    public Client findById(int id) throws DaoException {
        Client client = new Client();

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM client WHERE id="+id);

            while (resultSet.next()) {
                VilleDaoImpl ville = new VilleDaoImpl(connection);

                client.setId(resultSet.getInt("id"));
                client.setNom(resultSet.getString("nomClient"));
                client.setAdresse(resultSet.getString("adresseClient"));
                client.setCodePostal(resultSet.getString("codePostalClient"));

                client.setVille((Ville) ville.findById(resultSet.getInt("ville")));

            }
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

        return client;
    }

    @Override
    public void create(Entity entity) throws DaoException {

        Client client = (Client) entity;

        PreparedStatement stmt= null;

        String sqlReq = "insert into client(\"nomClient\",\"adresseClient\",\"codePostalClient\",ville) values (?,?,?,?)";

        try {

            stmt = connection.prepareStatement(sqlReq);

            stmt = connection.prepareStatement(sqlReq);
            stmt.setString(1, ((Client)entity).getNom());
            stmt.setString(2, ((Client)entity).getAdresse());
            stmt.setString(3, ((Client)entity).getCodePostal());

            stmt.setInt(4, ((Client)entity).getVille().getId());


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
        String sqlReq = "update client set \"nomClient\" = ?,\"adresseClient\" = ?, \"codePostalClient\" = ?, ville = ? where id = ?";
        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setString(1,((Client)entity).getNom());
            stmt.setString(2,((Client)entity).getAdresse());
            stmt.setString(3,((Client)entity).getCodePostal());

            stmt.setInt(4,((Client)entity).getVille().getId());

            stmt.setInt(5,((Client) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }

    }

    @Override
    public void delete(Entity entity) throws DaoException {
        PreparedStatement stmt= null;
        String sqlReq = "delete from client where id = ?";

        try {
            stmt = connection.prepareStatement(sqlReq);
            stmt.setInt(1,((Client) entity).getId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.err.println("Erreur SQL : " + e.getLocalizedMessage());
        }
    }
}