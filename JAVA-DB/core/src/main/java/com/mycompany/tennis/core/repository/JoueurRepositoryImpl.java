package com.mycompany.tennis.core.repository;

import com.mycompany.tennis.core.repository.entity.Joueur;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JoueurRepositoryImpl {

    public void create(Joueur joueur){
        Connection conn=null;
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setInitialSize(5);
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/tennis?useSSL=false", "root", "magnoudewa#2020");
            dataSource.setUrl("jdbc:mysql://localhost:3309/tennis?useSSL=false");
            dataSource.setUsername("root");
            dataSource.setPassword("magnoudewa#2020");

            conn = dataSource.getConnection();

            PreparedStatement preparedStatement=conn.prepareStatement("INSERT INTO JOUEUR(NOM,PRENOM,SEXE) VALUES(?,?,?)");
            String nom = "Errani1";
            String prenom = "Sara1";
            String sexe = "F";
            preparedStatement.setString(1,joueur.getNom());
            preparedStatement.setString(2,joueur.getPrenom());
            preparedStatement.setString(3,joueur.getSexe().toString());

            preparedStatement.executeUpdate();

            System.out.println("joeur créé");
        }
        catch (SQLException e){
            e.printStackTrace();
            try {
                if(conn!=null) conn.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
        }
        finally {

            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void update(Joueur joueur){
        Connection conn=null;
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setInitialSize(5);
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/tennis?useSSL=false", "root", "magnoudewa#2020");
            dataSource.setUrl("jdbc:mysql://localhost:3309/tennis?useSSL=false");
            dataSource.setUsername("root");
            dataSource.setPassword("magnoudewa#2020");

            conn = dataSource.getConnection();

            PreparedStatement preparedStatement=conn.prepareStatement("UPDATE JOEUR SET NOM=?, PRENOM=?, SEXE=? WHERE ID = ?");
            preparedStatement.setString(1,joueur.getNom());
            preparedStatement.setString(2,joueur.getPrenom());
            preparedStatement.setString(3,joueur.getSexe().toString());
            preparedStatement.setLong(4,joueur.getId());

            preparedStatement.executeUpdate();

            System.out.println("joueur modifié");
        }
        catch (SQLException e){
            e.printStackTrace();
            try {
                if(conn!=null) conn.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
        }
        finally {

            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public void delete(Long id){
        Connection conn=null;
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setInitialSize(5);
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/tennis?useSSL=false", "root", "magnoudewa#2020");
            dataSource.setUrl("jdbc:mysql://localhost:3309/tennis?useSSL=false");
            dataSource.setUsername("root");
            dataSource.setPassword("magnoudewa#2020");

            conn = dataSource.getConnection();

            PreparedStatement preparedStatement=conn.prepareStatement("DELETE FROM JOUEUR WHERE ID = ?");
            preparedStatement.setLong(1,id);

            preparedStatement.executeUpdate();

            System.out.println("joueur supprimé");
        }
        catch (SQLException e){
            e.printStackTrace();
            try {
                if(conn!=null) conn.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
        }
        finally {

            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public Joueur getById(Long id){
        Connection conn=null;
        Joueur joueur = null;
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setInitialSize(5);
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/tennis?useSSL=false", "root", "magnoudewa#2020");
            dataSource.setUrl("jdbc:mysql://localhost:3309/tennis?useSSL=false");
            dataSource.setUsername("root");
            dataSource.setPassword("magnoudewa#2020");

            conn = dataSource.getConnection();

            PreparedStatement preparedStatement=conn.prepareStatement("SELECT NOM, PRENOM, SEXE FROM JOUEUR WHERE ID = ?");
            preparedStatement.setLong(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            if (rs.next()){
                joueur = new Joueur();
                joueur.setId(id);
                joueur.setNom(rs.getString("NOM"));
                joueur.setPrenom(rs.getString("PRENOM"));
                joueur.setSexe(rs.getString("SEXE").charAt(0));
            }

            System.out.println("joueur lu");
        }
        catch (SQLException e){
            e.printStackTrace();
            try {
                if(conn!=null) conn.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
        }
        finally {

            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return joueur;
    }

    public List<Joueur> list(Long id){
        Connection conn=null;
        List<Joueur> joueurs = new ArrayList<>();
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setInitialSize(5);
            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/tennis?useSSL=false", "root", "magnoudewa#2020");
            dataSource.setUrl("jdbc:mysql://localhost:3309/tennis?useSSL=false");
            dataSource.setUsername("root");
            dataSource.setPassword("magnoudewa#2020");

            conn = dataSource.getConnection();

            PreparedStatement preparedStatement=conn.prepareStatement("SELECT NOM, PRENOM, SEXE FROM JOUEUR WHERE ID=");
            preparedStatement.setLong(1,id);

            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()){
                Joueur joueur = new Joueur();
                joueur.setId(id);
                joueur.setNom(rs.getString("NOM"));
                joueur.setPrenom(rs.getString("PRENOM"));
                joueur.setSexe(rs.getString("SEXE").charAt(0));

                joueurs.add(joueur);
            }

            System.out.println("joueurs lus");
        }
        catch (SQLException e){
            e.printStackTrace();
            try {
                if(conn!=null) conn.rollback();
            } catch (SQLException el) {
                el.printStackTrace();
            }
        }
        finally {

            try {
                if (conn!=null) {
                    conn.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return joueurs;
    }
}
