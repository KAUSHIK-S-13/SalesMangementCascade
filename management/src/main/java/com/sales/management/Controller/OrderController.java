package com.sales.management.Controller;

import com.sales.management.BaseResponse.baseresp;
import com.sales.management.DTO.OrderDTO;
import com.sales.management.Model.Order;
import com.sales.management.Service.OrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RequestMapping("/order")
@RestController
public class OrderController {

    @Autowired
    private OrderInterface orderInterface;

    @RolesAllowed(value="USER")
    @PostMapping("/add")
    public baseresp<Order> addorder(@Valid @RequestBody OrderDTO orderDTO) {
        baseresp<Order> base=null;
        base=baseresp.<Order>builder().Data(orderInterface.addOrder(orderDTO)).build();
        return base ;
    }

    @RolesAllowed(value="USER")
    @PutMapping("/update")
    public baseresp<Optional<Order>> updateorder(@Valid @RequestBody OrderDTO orderDTO) {
        baseresp<Optional<Order>> base=null;
        base=baseresp.<Optional<Order>>builder().Data(orderInterface.updateOrder(orderDTO)).build();
        return base ;
    }

    @RolesAllowed(value="USER")
   @GetMapping("/getall")
    public baseresp<List<Order>> listall(){
        baseresp<List<Order>> base=null;
        base =baseresp.<List<Order>>builder().Data(orderInterface.getAllOrder()).build();
        return base;
    }

    @RolesAllowed("USER")
    @DeleteMapping("/delete/{id}")
    public String delete (@PathVariable int id){
        orderInterface.deletebyid(id);
        return "Success";
    }


}
