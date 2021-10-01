package com.sales.management.Controller;

import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.BaseResponse.baseresp;
import com.sales.management.DTO.SparepartsDTO;
import com.sales.management.Model.Spareparts;
import com.sales.management.Service.SparepartsInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.Optional;

@RequestMapping("/spareparts")
@RestController
public class SparepartsController {

    @Autowired
    private SparepartsInterface sparepartsInterface;

    @RolesAllowed(value="USER")
    @PostMapping("/add")
    public baseresp<Spareparts> addspareparts(@Valid @RequestBody SparepartsDTO sparepartsDTO) {
        baseresp<Spareparts> base=null;
        base=baseresp.<Spareparts>builder().Data(sparepartsInterface.addSpareparts(sparepartsDTO)).build();
        return base ;
    }

   /* @RolesAllowed(value="USER")
    @GetMapping("/page")
    private APIResponse<Spareparts> getSparepartsWithPagination(@RequestParam int offset, @RequestParam  int pageSize, @RequestParam  String sparepartsName) {
       return sparepartsInterface.SparepartsWithPagination(offset, pageSize, sparepartsName);
   }*/

    @RolesAllowed(value="USER")
    @GetMapping("/page")
     public APIResponse<Spareparts> sparepatswithpage(@RequestParam int offset, @RequestParam  int pageSize, @RequestParam  String sparepartsName){
        return sparepartsInterface.sparepatswithpage(offset, pageSize, sparepartsName);
    }

    @RolesAllowed(value="USER")
    @PutMapping("/update")
    public baseresp<Optional<Spareparts>> updatespareparts(@RequestBody SparepartsDTO sparepartsDTO) {
       baseresp<Optional<Spareparts>> base=null;
       base=baseresp.<Optional<Spareparts>>builder().Data(sparepartsInterface.updateSpareparts(sparepartsDTO)).build();
        return base ;
    }

    @RolesAllowed(value="USER")
    @GetMapping("/{id}")
    public baseresp<Optional<Spareparts>> findsparepartsById(@PathVariable int id){
        baseresp<Optional<Spareparts>> base=null;
        base =baseresp.<Optional<Spareparts>>builder().Data(sparepartsInterface.findSparepartsById(id)).build();
        return base;
    }


    @RolesAllowed("USER")
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
       sparepartsInterface.deletebyid(id);
        return "Success";
    }

}
