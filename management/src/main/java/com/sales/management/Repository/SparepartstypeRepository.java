package com.sales.management.Repository;

import com.sales.management.Model.Spareparts;
import com.sales.management.Model.Sparepartstype;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface SparepartstypeRepository extends JpaRepository<Sparepartstype, Integer> {
    Optional<Sparepartstype> findBySparepartstypeId(int sparepartstypeId);


}
