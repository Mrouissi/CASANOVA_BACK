package com.istic.casanova.repository;

import com.istic.casanova.model.MateriauxMiseEnPlace;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MateriauxMiseEnPlaceRepository extends JpaRepository<MateriauxMiseEnPlace, Long> {

}
