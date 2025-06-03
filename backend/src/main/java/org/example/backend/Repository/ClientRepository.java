package org.example.backend.Repository;

import org.example.backend.Entity.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;
import java.util.UUID;

public interface ClientRepository extends JpaRepository<Client, Long> {

    @Query("SELECT c FROM Client c WHERE c.trackingId=:x")
    Optional<Client> findByTrackingId(@Param("x") UUID trackingId);
}
