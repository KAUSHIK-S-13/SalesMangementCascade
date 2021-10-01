package com.sales.management.Service;

import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.DTO.SparepartsDTO;
import com.sales.management.Model.Spareparts;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public interface SparepartsInterface {
    Spareparts addSpareparts(SparepartsDTO sparepartsDTO);

    Optional<Spareparts> updateSpareparts(SparepartsDTO sparepartsDTO);

    Optional<Spareparts> findSparepartsById(int id);


    APIResponse<Spareparts> sparepatswithpage(int offset, int pageSize, String sparepartsName);

    Spareparts deletebyid(int id);
}
