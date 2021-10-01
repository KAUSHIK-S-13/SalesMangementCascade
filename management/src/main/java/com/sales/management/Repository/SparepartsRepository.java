package com.sales.management.Repository;

import com.sales.management.Model.Spareparts;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SparepartsRepository extends JpaRepository<Spareparts, Integer> {


    Optional<Spareparts> findBySparepartsId(Integer sparepartsId);

    Page<Spareparts> searchAllBySparepartsNameLike(String s, Pageable paging);
}
