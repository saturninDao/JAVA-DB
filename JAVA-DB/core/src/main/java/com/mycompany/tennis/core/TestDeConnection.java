package com.mycompany.tennis.core;
import com.mycompany.tennis.core.repository.JoueurRepositoryImpl;
import com.mycompany.tennis.core.repository.entity.Joueur;
import com.mysql.cj.jdbc.MysqlDataSource;
import org.apache.commons.dbcp2.BasicDataSource;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class TestDeConnection {

    public static void main(String... args){
        JoueurRepositoryImpl joueurRepository = new JoueurRepositoryImpl();
        Joueur bartoli = joueurRepository.getById(34L);
        System.out.println(bartoli.getNom()+" "+bartoli.getPrenom());
        /*
        Joueur noah = new Joueur();
        noah.setPrenom("Yannick");
        noah.setNom("Noah");
        noah.setSexe('H');
        joueurRepository.create(noah);
        */

        /*
        Joueur noah = new Joueur();
        noah = joueurRepository.getById(57L);
        noah.setPrenom("Yannicko");
        joueurRepository.update(noah);
        */

        /*
        Joueur noah = joueurRepository.getById(57L);
        joueurRepository.delete(noah.getId());
         */

        List<Joueur> liste =  joueurRepository.list();

        for(Joueur joueur: liste){
            System.out.println(joueur.getPrenom()+" "+joueur.getNom());
        }



    }
}
