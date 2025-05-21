package com.humanbooster.dao;

import com.humanbooster.model.BorneRecharge;
import com.humanbooster.model.Reservation;
import jakarta.persistence.criteria.*;
import org.hibernate.Session;

import java.time.LocalDate;
import java.util.List;

public class BorneRechargeDAO extends GenericDAOImpl<BorneRecharge, Long> implements GenericDAO<BorneRecharge, Long> {
    public BorneRechargeDAO(boolean verbose) {
        super(BorneRecharge.class, verbose);
    }

    /**
     * Find all available charging stations for a given time slot
     * @param dateDebut Start date of the time slot
     * @param dateFin End date of the time slot
     * @return List of available charging stations
     */
    public List<BorneRecharge> findAvailableStations(LocalDate dateDebut, LocalDate dateFin) {
        if (isVerbose()) {
            System.out.println("==========================================");
            System.out.println("  Searching available stations operation");
            System.out.println("==========================================");
        }

        List<BorneRecharge> availableStations = null;

        try (Session session = sessionFactory.openSession()) {
            CriteriaBuilder cb = session.getCriteriaBuilder();
            CriteriaQuery<BorneRecharge> cr = cb.createQuery(BorneRecharge.class);
            Root<BorneRecharge> root = cr.from(BorneRecharge.class);

            Subquery<Long> subquery = cr.subquery(Long.class);
            Root<Reservation> reservationRoot = subquery.from(Reservation.class);

            Predicate reservationPredicate = cb.and(
                cb.equal(reservationRoot.get("borneRecharge"), root),
                cb.notEqual(reservationRoot.get("statut"), "ANNULEE"),
                cb.or(
                    cb.and(
                        cb.lessThanOrEqualTo(reservationRoot.get("dateDebut"), dateFin),
                        cb.greaterThanOrEqualTo(reservationRoot.get("dateFin"), dateDebut)
                    ),
                    cb.and(
                        cb.greaterThanOrEqualTo(reservationRoot.get("dateDebut"), dateDebut),
                        cb.lessThanOrEqualTo(reservationRoot.get("dateDebut"), dateFin)
                    ),
                    cb.and(
                        cb.greaterThanOrEqualTo(reservationRoot.get("dateFin"), dateDebut),
                        cb.lessThanOrEqualTo(reservationRoot.get("dateFin"), dateFin)
                    )
                )
            );

            subquery.select(reservationRoot.get("borneRecharge").get("id"))
                   .where(reservationPredicate);

            Predicate mainPredicate = cb.and(
                cb.equal(root.get("etat"), "DISPONIBLE"),
                cb.not(cb.exists(subquery))
            );

            cr.select(root)
              .where(mainPredicate)
              .distinct(true);

            availableStations = session.createQuery(cr).getResultList();
        } catch (Exception e) {
            System.err.println("ERROR: Unable to search for available stations");
            e.printStackTrace();
        }

        if (isVerbose()) {
            System.out.println("\n");
        }

        return availableStations;
    }
}
