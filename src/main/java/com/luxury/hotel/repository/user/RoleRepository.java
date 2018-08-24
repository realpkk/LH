package com.luxury.hotel.repository.user;

import com.luxury.hotel.entity.user.Role;
import com.luxury.hotel.repository.base.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends AbstractRepository<Role,Long> {

    Role findRoleById(Long id);
}
