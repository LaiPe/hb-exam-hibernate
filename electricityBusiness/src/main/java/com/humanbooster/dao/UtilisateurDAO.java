package com.humanbooster.dao;

import com.humanbooster.model.Utilisateur;

public class UtilisateurDAO extends GenericDAOImpl<Utilisateur, Long> implements GenericDAO<Utilisateur, Long> {

    public UtilisateurDAO(boolean verbose) {
        super(Utilisateur.class, verbose);
    }
}
