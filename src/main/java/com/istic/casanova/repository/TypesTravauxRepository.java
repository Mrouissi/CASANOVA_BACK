package com.istic.casanova.repository;

import com.istic.casanova.model.ElementARenover;
import com.istic.casanova.model.TypesTravaux;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface TypesTravauxRepository extends JpaRepository<TypesTravaux,Long> {

    @Query("select t.elementARenover from TypesTravaux t where t.id = ?1")
    List<ElementARenover> findElementARenoverByTypesTravauxId(Long travaux_id);

}

