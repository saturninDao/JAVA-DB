package com.mycompany.tennis.core;

import java.sql.*;

public class TestDeConnection {

    public static void main(String... args){

        Connection conn=null;
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/tennis?useSSL=false", "root", "magnoudewa#2020");
            PreparedStatement preparedStatement=conn.prepareStatement("SELECT NOM,PRENOM,ID FROM JOUEUR WHERE ID=?");
            long identifiant=43L;
            preparedStatement.setLong(1,identifiant);

            ResultSet rs=preparedStatement.executeQuery();

            if (rs.next()){
                final String nom=rs.getString("NOM");
                final String prenom=rs.getString("PRENOM");
                final Long id=rs.getLong("ID");
                System.out.println("Le joueur / la joueuse représenté(e) par le numéro "+id+" est "+prenom+" "+nom);
            }
            else {
                System.out.println("Il n'y a pas d'enregistrement d'ID 128");
            }

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
