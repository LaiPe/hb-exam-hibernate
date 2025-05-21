package com.humanbooster;

import com.humanbooster.dao.*;
import com.humanbooster.model.*;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // Initialize DAOs
        UtilisateurDAO utilisateurDAO = new UtilisateurDAO(false);
        LieuRechargeDAO lieuRechargeDAO = new LieuRechargeDAO(false);
        BorneRechargeDAO borneRechargeDAO = new BorneRechargeDAO(false);
        ReservationDAO reservationDAO = new ReservationDAO(false);

        // Create multiple users
        Utilisateur admin = new Utilisateur();
        admin.setNom("Admin User");
        admin.setEmail("admin@example.com");
        admin.setMotDePasse("admin123");
        admin.setRole("ROLE_ADMIN");
        admin.setValide(true);
        utilisateurDAO.create(admin);

        Utilisateur user1 = new Utilisateur();
        user1.setNom("John Doe");
        user1.setEmail("john@example.com");
        user1.setMotDePasse("user123");
        user1.setRole("ROLE_USER");
        user1.setValide(true);
        utilisateurDAO.create(user1);

        Utilisateur user2 = new Utilisateur();
        user2.setNom("Jane Smith");
        user2.setEmail("jane@example.com");
        user2.setMotDePasse("user456");
        user2.setRole("ROLE_USER");
        user2.setValide(true);
        utilisateurDAO.create(user2);

        // Create multiple charging locations
        LieuRecharge parking1 = new LieuRecharge();
        parking1.setNom("Parking Central");
        parking1.setAdresse("123 Main Street, City Center");
        lieuRechargeDAO.create(parking1);

        LieuRecharge parking2 = new LieuRecharge();
        parking2.setNom("Shopping Mall Parking");
        parking2.setAdresse("456 Shopping Avenue, Downtown");
        lieuRechargeDAO.create(parking2);

        LieuRecharge parking3 = new LieuRecharge();
        parking3.setNom("Business District Parking");
        parking3.setAdresse("789 Business Park, Financial District");
        lieuRechargeDAO.create(parking3);

        // Create multiple charging stations
        BorneRecharge borne1 = new BorneRecharge();
        borne1.setNum(1);
        borne1.setEtat("DISPONIBLE");
        borne1.setTarifHoraire(new BigDecimal("2.50"));
        borne1.setDescription("Fast charging station with Type 2 connector. Maximum power: 22kW.");
        borne1.setInstructions("1. Park your vehicle\n2. Connect the cable\n3. Start charging using the app");
        borne1.setLieuRecharge(parking1);
        borneRechargeDAO.create(borne1);

        BorneRecharge borne2 = new BorneRecharge();
        borne2.setNum(2);
        borne2.setEtat("OCCUPEE");
        borne2.setTarifHoraire(new BigDecimal("3.00"));
        borne2.setDescription("Ultra-fast charging station with CCS connector. Maximum power: 150kW.");
        borne2.setInstructions("1. Park your vehicle\n2. Connect the cable\n3. Start charging using the app");
        borne2.setLieuRecharge(parking2);
        borneRechargeDAO.create(borne2);

        BorneRecharge borne3 = new BorneRecharge();
        borne3.setNum(3);
        borne3.setEtat("MAINTENANCE");
        borne3.setTarifHoraire(new BigDecimal("2.75"));
        borne3.setDescription("Standard charging station with Type 2 connector. Maximum power: 11kW.");
        borne3.setInstructions("1. Park your vehicle\n2. Connect the cable\n3. Start charging using the app");
        borne3.setLieuRecharge(parking3);
        borneRechargeDAO.create(borne3);

        // Create multiple reservations
        Reservation res1 = new Reservation();
        res1.setDateDebut(LocalDate.now());
        res1.setDateFin(LocalDate.now().plusDays(1));
        res1.setStatut("CONFIRMEE");
        res1.setUtilisateur(user1);
        res1.setBorneRecharge(borne1);
        reservationDAO.create(res1);

        Reservation res2 = new Reservation();
        res2.setDateDebut(LocalDate.now().plusDays(1));
        res2.setDateFin(LocalDate.now().plusDays(2));
        res2.setStatut("EN_ATTENTE");
        res2.setUtilisateur(user2);
        res2.setBorneRecharge(borne2);
        reservationDAO.create(res2);

        Reservation res3 = new Reservation();
        res3.setDateDebut(LocalDate.now().plusDays(2));
        res3.setDateFin(LocalDate.now().plusDays(3));
        res3.setStatut("ANNULEE");
        res3.setUtilisateur(user1);
        res3.setBorneRecharge(borne3);
        reservationDAO.create(res3);

        // Test UPDATE operations
        // Update users
        user1.setNom("John Updated Doe");
        user1.setEmail("john.updated@example.com");
        utilisateurDAO.update(user1);

        user2.setRole("ROLE_PREMIUM");
        utilisateurDAO.update(user2);

        // Update locations
        parking1.setNom("Updated Central Parking");
        parking1.setAdresse("123 Updated Street, New City Center");
        lieuRechargeDAO.update(parking1);

        parking2.setNom("Updated Mall Parking");
        lieuRechargeDAO.update(parking2);

        // Update charging stations
        borne1.setTarifHoraire(new BigDecimal("3.50"));
        borne1.setEtat("OCCUPEE");
        borneRechargeDAO.update(borne1);

        borne2.setDescription("Updated ultra-fast charging station with enhanced features");
        borneRechargeDAO.update(borne2);

        // Update reservations
        res1.setStatut("TERMINEE");
        reservationDAO.update(res1);

        res2.setDateFin(LocalDate.now().plusDays(3));
        reservationDAO.update(res2);

        // Test READ operations
        // Read users
        Utilisateur readUser1 = utilisateurDAO.read(user1.getId());
        readUser1.print();
        Utilisateur readUser2 = utilisateurDAO.read(user2.getId());
        readUser2.print();
        Utilisateur readAdmin = utilisateurDAO.read(admin.getId());
        readAdmin.print();

        // Read locations
        LieuRecharge readParking1 = lieuRechargeDAO.read(parking1.getId());
        readParking1.print();
        LieuRecharge readParking2 = lieuRechargeDAO.read(parking2.getId());
        readParking2.print();
        LieuRecharge readParking3 = lieuRechargeDAO.read(parking3.getId());
        readParking3.print();

        // Read charging stations
        BorneRecharge readBorne1 = borneRechargeDAO.read(borne1.getId());
        readBorne1.print();
        BorneRecharge readBorne2 = borneRechargeDAO.read(borne2.getId());
        readBorne2.print();
        BorneRecharge readBorne3 = borneRechargeDAO.read(borne3.getId());
        readBorne3.print();

        // Read reservations
        Reservation readRes1 = reservationDAO.read(res1.getId());
        readRes1.print();
        Reservation readRes2 = reservationDAO.read(res2.getId());
        readRes2.print();
        Reservation readRes3 = reservationDAO.read(res3.getId());
        readRes3.print();

        // Test DELETE operations (in correct order due to foreign key constraints)
        // First delete reservations
        reservationDAO.delete(res1.getId());
        reservationDAO.delete(res2.getId());
        reservationDAO.delete(res3.getId());

        // Then delete charging stations
        borneRechargeDAO.delete(borne1.getId());
        borneRechargeDAO.delete(borne2.getId());
        borneRechargeDAO.delete(borne3.getId());

        // Then delete locations
        lieuRechargeDAO.delete(parking1.getId());
        lieuRechargeDAO.delete(parking2.getId());
        lieuRechargeDAO.delete(parking3.getId());

        // Finally delete users
        utilisateurDAO.delete(user1.getId());
        utilisateurDAO.delete(user2.getId());
        utilisateurDAO.delete(admin.getId());
    }
}
