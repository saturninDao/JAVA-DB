package com.mycompany.tennis.core;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;

public class TestDeConnection {

    public static void main(String... args){

        Connection conn=null;
        try {
            BasicDataSource dataSource = new BasicDataSource();
            dataSource.setInitialSize(5);

            //conn = DriverManager.getConnection("jdbc:mysql://localhost:3309/tennis?useSSL=false", "root", "magnoudewa#2020");

            dataSource.setUrl("jdbc:mysql://localhost:3309/tennis?useSSL=false");
            dataSource.setUsername("root");
            dataSource.setPassword("magnoudewa#2020");

            /*

            dataSource.setServerName("localhost");
            dataSource.setPort(3309);
            dataSource.setDatabaseName("tennis");
            dataSource.setUseSSL(false);
            dataSource.setUser("root");
            dataSource.setPassword("magnoudewa#2020");

             */


            conn = dataSource.getConnection();

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
            preparedStatement.setString(3, sexe);

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
