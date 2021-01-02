package com.mycompany.tennis.core;

import java.sql.*;

public class TestDeConnection {

    public static void main(String... args){

        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/tennis?useSSL=false", "root", "magnoudewa#2020");
            PreparedStatement preparedStatement=conn.prepareStatement("UPDATE JOUEUR SET NOM=?, PRENOM=? WHERE ID=?");
            long identifiant=24L;
            String nom = "Errani";
            String prenom = "Sara";

            preparedStatement.setString(1,nom);
            preparedStatement.setString(2,prenom);
            preparedStatement.setLong(3,identifiant);

            int nbEnregistrementModifies =preparedStatement.executeUpdate();

            System.out.println("nbEnregistrementModifies="+nbEnregistrementModifies);
            System.out.println("success");
        }
        catch (SQLException e){
            e.printStackTrace();
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
}
