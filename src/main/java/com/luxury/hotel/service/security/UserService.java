package com.luxury.hotel.service.security;

import com.luxury.hotel.entity.user.Role;
import com.luxury.hotel.entity.user.User;
import com.luxury.hotel.repository.user.RoleRepository;
import com.luxury.hotel.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    private final long DEFAULT_ROLE = 2;

    public User getCurrentUser(String phoneNumber){
        return userRepository.findUserByPhoneNumber(phoneNumber);
    }

    public void createNewUser(User user){
        roleEdit(user,DEFAULT_ROLE);
        userRepository.save(user);
    }

    public boolean duplicateCheck(String phoneNumber){
        User user = getCurrentUser(phoneNumber);
        if (user == null) {
            return false;
        }else {
            return true;
        }
    }

    public void roleEdit(User user,Long roleId){
        Role role = roleRepository.findRoleById(roleId);
       if (role != null){
           user.setRole(role);
       }
        userRepository.save(user);
    }
}


