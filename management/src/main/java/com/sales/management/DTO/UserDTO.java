package com.sales.management.DTO;


import com.sales.management.Model.Role;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserDTO {

    private int id;

    private String name;

    private String password;

    private int isActive;

    private int isDelete;

    private String roleName;

    private List<Role> roles;


}
