package org.example.backend.Repository;

import org.example.backend.Entity.Commande;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface CommandeRepository extends JpaRepository<Commande, Long> {

    @Query("SELECT c FROM Commande c WHERE c.trackingId= :x")
    Optional<Commande> findByTrackingId(@Param("x") UUID trackingId);

    @Query("SELECT c FROM Commande c ORDER BY c.date DESC")
    List<Commande> findCommandeOrderByDate();
}
