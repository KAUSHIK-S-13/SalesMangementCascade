package com.sales.management.Service;

import com.sales.management.DTO.OrderDTO;
import com.sales.management.Model.Order;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public interface OrderInterface {
    Order addOrder(OrderDTO orderDTO);

    Optional<Order> updateOrder(OrderDTO orderDTO);

    List<Order> getAllOrder();

    Order deletebyid(int id);
}
