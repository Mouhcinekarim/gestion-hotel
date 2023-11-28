package dao.user;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import dao.customer.CustomerDao;
import dao.customer.CustomerDaoImpl;
import dao.reservation.ReservationDao;
import dao.reservation.ReservationDaoImpl;
import panier.crud.Crud;
import panier.crud.Modifier;
import panier.crud.Rechercher;
import panier.crud.Supprimer;



public class ConnectDatabase {
	private String url;
    private String username;
    private String password;

    ConnectDatabase(String url, String username, String password) {
        this.url = url;
        this.username = username;
        this.password = password;
    }

    public static ConnectDatabase getInstance() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {

        }

        ConnectDatabase instance = new ConnectDatabase(
                "jdbc:mysql://localhost:3306/hotel2", "root", "");
        return instance;
    }

    public Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, username, password);
    }

    // Récupération du Dao
    public UserDao getUserDao() {
        return new UserDaoImpl(this);
    }
    public CustomerDao getCustomerDao() {
        return new CustomerDaoImpl(this);
    }
    public ReservationDao getReservationDao() {
        return new ReservationDaoImpl(this);
    }
    public Crud getCrudR() {
        return new Rechercher(this);
    }
    public Crud getCrudM() {
        return new Modifier(this);
    }
    public Crud getCrudS() {
        return new Supprimer(this);
    }
}
