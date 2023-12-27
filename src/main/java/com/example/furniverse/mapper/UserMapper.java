package com.example.furniverse.mapper;

import com.example.furniverse.dto.UserDTO;
import com.example.furniverse.entity.User;
import com.example.furniverse.security.MyUserDetails;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDTO toUserDTO(User user);
    User toUserEntity(UserDTO userDTO);


    MyUserDetails toMyUserDetails(User user);
}

