package com.sales.management.Controller;

import com.sales.management.BaseResponse.baseresp;
import com.sales.management.DTO.SparepartstypeDTO;
import com.sales.management.Model.Sparepartstype;
import com.sales.management.Service.SparepartstypeInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;


@RequestMapping("/sparepartstype")
@RestController
public class SparepartstypeController {


    @Autowired
    private SparepartstypeInterface sparepartstypeInterface;

    @RolesAllowed(value="USER")
    @PostMapping("/add")
   public baseresp<Sparepartstype> addsparepartstype(@Valid @RequestBody SparepartstypeDTO sparepartstypeDTO) {
       baseresp<Sparepartstype> base=null;
       base=baseresp.<Sparepartstype>builder().Data(sparepartstypeInterface.addSparepartstype(sparepartstypeDTO)).build();
       return base ;
    }

    @RolesAllowed(value="USER")
    @PutMapping("/update")
    public baseresp<Optional<Sparepartstype>> updatesparepartstype(@RequestBody SparepartstypeDTO sparepartstypeDTO) {
        baseresp<Optional<Sparepartstype>> base=null;
        base=baseresp.<Optional<Sparepartstype>>builder().Data(sparepartstypeInterface.updateSparepartstype(sparepartstypeDTO)).build();
        return base ;
    }

    @RolesAllowed(value="USER")
    @GetMapping("/getall")
    public baseresp<List<Sparepartstype>> listall(){
        baseresp<List<Sparepartstype>> base=null;
        base =baseresp.<List<Sparepartstype>>builder().Data(sparepartstypeInterface.Listall()).build();
        return base;
    }


    @RolesAllowed("USER")
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        sparepartstypeInterface.deletebyid(id);
        return "Success";
    }
}
