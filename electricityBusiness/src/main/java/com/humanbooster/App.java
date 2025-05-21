package com.humanbooster;

import com.humanbooster.dao.Connector;
import com.humanbooster.dao.UtilisateurDAO;
import com.humanbooster.model.Utilisateur;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println("Hello World!");
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(true);

        Utilisateur u1 = new Utilisateur();
        u1.setNom("John Doe");
        u1.setEmail("johndoe@email.com");
        u1.setMotDePasse("123456");
        u1.setRole("ROLE_ADMIN");

        utilisateurDAO.create(u1);

        Utilisateur u1Read = utilisateurDAO.read(1L);
        u1Read.print();
    }
}
