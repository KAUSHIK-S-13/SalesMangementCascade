package com.sales.management.Service;

import com.sales.management.BaseResponse.APIResponse;
import com.sales.management.DTO.UserDTO;
import com.sales.management.DTO.UserRoleDTO;
import com.sales.management.Model.User;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface UserInterface {


    Optional<User> updateUser(UserDTO userDTO);

    Optional<User> FindByUserId(int id);

    User Saveuser(UserDTO userDTO);

    UserRoleDTO logOfUser(UserRoleDTO userRoleDTO);

    APIResponse<User> pageOfUser(int offset, int pageSize, String name);


    User deletebyid(int id);
}
