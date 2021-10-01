package com.sales.management.Service.impl;

import com.sales.management.DTO.OrderDTO;
import com.sales.management.ExceptionHandling.CustomException;
import com.sales.management.Model.Order;
import com.sales.management.Model.Spareparts;
import com.sales.management.Model.User;
import com.sales.management.Repository.OrderRepository;
import com.sales.management.Repository.SparepartsRepository;
import com.sales.management.Repository.UserRepository;
import com.sales.management.Service.OrderInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
@Transactional

public class OrderServiceImpl implements OrderInterface {

    @Autowired
    private OrderRepository orderRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SparepartsRepository sparepartsRepository;

    @Override
    public Order addOrder(OrderDTO orderDTO) {
        Order order=new Order();
        order.setOrderQuantity(orderDTO.getOrderQuantity());
        order.setOrderDestination(orderDTO.getOrderDestination());
        Order finalOrder = order;
        orderDTO.getSparepartsId().forEach(sparepartsDTO -> {
            Optional<Spareparts> sparepartss=sparepartsRepository.findBySparepartsId(sparepartsDTO.getSparepartsId());
            if(sparepartss.isPresent())
            {
                finalOrder.setSparepartss(sparepartss.get());
            }
            else
            {
                throw new CustomException("404","Not Found");
            }
        });
        Order finalOrder1 = order;
        orderDTO.getUserId().forEach(userDTO -> {
            Optional<User> Users=userRepository.findById(userDTO.getId());

            if(Users.isPresent())
            {
                finalOrder1.setUsers(Users.get());
            }
            else
            {
                throw new CustomException("404","Not Found");
            }
        });
        order=orderRepository.save(order);
        return order;
    }

    @Override
    public Optional<Order>  updateOrder(OrderDTO orderDTO) {
        Optional<Order> existOrder= orderRepository.findById(orderDTO.getOrderId());
        if(existOrder.isPresent())
        {
            existOrder.get().setOrderQuantity(orderDTO.getOrderQuantity());
            existOrder.get().setOrderDestination(orderDTO.getOrderDestination());
        }
        else
        {
            throw new CustomException("404","Not Found");
        }
        orderDTO.getSparepartsId().forEach(sparepartsDTO -> {
            Optional<Spareparts> sparepartss=sparepartsRepository.findBySparepartsId(sparepartsDTO.getSparepartsId());
            if(sparepartss.isPresent())
            {
                existOrder.get().setSparepartss(sparepartss.get());
            }
            else
            {
                throw new CustomException("404","Not Found");
            }
        });
        orderDTO.getUserId().forEach(userDTO -> {
            Optional<User> Users=userRepository.findById(userDTO.getId());
            if(Users.isPresent())
            {
                existOrder.get().setUsers(Users.get());
            }
            else
            {
                throw new CustomException("404","Not Found");
            }
        });
        orderRepository.save(existOrder.get());
        return existOrder;
    }

    @Override
    public List<Order> getAllOrder(){
        List<Order> orders=orderRepository.findAll();
        return orders;
    }


    @Override
    public Order deletebyid(int id) {
        Order order = new Order();
        userRepository.deleteById(id);
        return order;
    }
}
