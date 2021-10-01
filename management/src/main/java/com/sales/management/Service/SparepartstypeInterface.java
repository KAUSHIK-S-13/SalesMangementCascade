package com.sales.management.Service;

import com.sales.management.DTO.SparepartstypeDTO;
import com.sales.management.Model.Sparepartstype;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface SparepartstypeInterface {

    Sparepartstype addSparepartstype(SparepartstypeDTO sparepartstypeDTO);

    Optional<Sparepartstype> updateSparepartstype(SparepartstypeDTO sparepartstypeDTO);


    List<Sparepartstype> Listall();

    Sparepartstype deletebyid(int id);
}
