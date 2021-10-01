package com.sales.management.Service.impl;

import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.DTO.SparepartsDTO;
import com.sales.management.ExceptionHandling.CustomException;
import com.sales.management.Model.Spareparts;
import com.sales.management.Model.Sparepartstype;
import com.sales.management.Repository.SparepartsRepository;
import com.sales.management.Repository.SparepartstypeRepository;
import com.sales.management.Service.SparepartsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
@Transactional

public class SparepartsServiceImpl implements SparepartsInterface {
    @Autowired
    private SparepartsRepository sparepartsRepository;

    @Autowired
    private SparepartstypeRepository sparepartstypeRepository;

    @Override
    public Spareparts addSpareparts(SparepartsDTO sparepartsDTO) {
        Spareparts spareparts = new Spareparts();
        spareparts.setSparepartsName(sparepartsDTO.getSparepartsName());
        Optional<Sparepartstype> obj=sparepartstypeRepository.findBySparepartstypeId(sparepartsDTO.getSparepartstypeId());
        if(obj.isPresent())
        {
            spareparts.setSparepartstypeId(obj.get());
            sparepartsRepository.save(spareparts);
        }
        else
        {
            throw new CustomException("404","Not Found");
        }
        return spareparts;
    }


   @Override
   public APIResponse<Spareparts> sparepatswithpage(int offset, int pageSize, String sparepartsName) {
       Pageable paging= PageRequest.of(offset, pageSize);
       Page<Spareparts> Sparepartss = sparepartsRepository.searchAllBySparepartsNameLike("%" + sparepartsName + "%", paging);
       APIResponse apiResponse=new APIResponse();
       apiResponse.setResponse(Sparepartss);
       apiResponse.setRecordCount(Sparepartss.getTotalPages());
       return apiResponse;
   }



    @Override
    public Optional<Spareparts> updateSpareparts(SparepartsDTO sparepartsDTO) {
        Optional<Spareparts> existSpareparts= sparepartsRepository.findById(sparepartsDTO.getSparepartsId());
        if(existSpareparts.isPresent())
        {
            existSpareparts.get().setSparepartsName(sparepartsDTO.getSparepartsName());
        }
        else
        {
            throw new CustomException("404","Not Found");
        }
        Optional<Sparepartstype> obj=sparepartstypeRepository.findBySparepartstypeId(sparepartsDTO.getSparepartstypeId());
        if(obj.isPresent())
        {
            existSpareparts.get().setSparepartstypeId(obj.get());
        }
        else
        {
            throw new CustomException("404","Not Found");
        }
        sparepartsRepository.save(existSpareparts.get());
        return existSpareparts;
    }

    @Override
    public Optional<Spareparts> findSparepartsById(int id){
       Optional<Spareparts> Sparepartss=sparepartsRepository.findById(id);
       return Sparepartss;
    }

    @Override
    public Spareparts deletebyid(int id) {
        Spareparts spareparts = new Spareparts();
        sparepartsRepository.deleteById(id);
        return spareparts;
    }


}
