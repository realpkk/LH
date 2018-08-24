package com.luxury.hotel.repository.user;

import com.luxury.hotel.entity.user.User;
import com.luxury.hotel.repository.base.AbstractRepository;

public interface UserRepository extends AbstractRepository<User,Long> {

    User findUserByPhoneNumber(String phoneNumber);
}
