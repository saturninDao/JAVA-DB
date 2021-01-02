package com.mycompany.tennis.core;

import java.sql.*;

public class TestDeConnection {

    public static void main(String... args){

        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/tennis?useSSL=false", "root", "magnoudewa#2020");

            conn.setAutoCommit(false);

            PreparedStatement preparedStatement=conn.prepareStatement("INSERT INTO JOUEUR(NOM,PRENOM,SEXE) VALUES(?,?,?)");
            String nom = "Errani1";
            String prenom = "Sara1";
            String sexe = "F";

            preparedStatement.setString(1,nom);
            preparedStatement.setString(2,prenom);
            preparedStatement.setString(3,sexe);

            preparedStatement.executeUpdate();

            nom = "Errani2";
            prenom = "Sara2";
            sexe = "H";

            preparedStatement.setString(1,nom);
            preparedStatement.setString(2,prenom);
            preparedStatement.setNull(3, Types.CHAR);

            preparedStatement.executeUpdate();

            conn.commit();

            System.out.println("success");
        }
        catch (SQLException e){
            e.printStackTrace();
            try {
                conn.rollback();
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
}
