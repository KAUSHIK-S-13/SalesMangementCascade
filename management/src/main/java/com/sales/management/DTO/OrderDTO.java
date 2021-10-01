package com.sales.management.DTO;


import lombok.Getter;
import lombok.Setter;

import java.util.List;


@Getter
@Setter
public class OrderDTO {

    private int orderId;

    private int orderQuantity;

    private String orderDestination;

    private List<SparepartsDTO> sparepartsId;

    private List<UserDTO> userId;

    private int isActive;

    private int isDelete;



}
