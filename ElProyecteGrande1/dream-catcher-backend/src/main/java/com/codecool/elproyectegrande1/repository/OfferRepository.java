package com.codecool.elproyectegrande1.repository;

import com.codecool.elproyectegrande1.entity.Offer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@Repository
public interface OfferRepository extends JpaRepository<Offer, Long> {
    @Modifying
    @Query("update Offer o set o = :savedOffer where o.id = :id")
    void update(Offer savedOffer, Long id);
}