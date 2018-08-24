package com.luxury.hotel.repository.user;

import com.luxury.hotel.entity.user.Menu;
import com.luxury.hotel.repository.base.AbstractRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MenuRepository extends AbstractRepository<Menu,Long> {

    List<Menu> findMenusByParentId(Long parentId);

    @Query("select m from Role r join r.menuList m where r.id =:id")
    List<Menu> findMenusByRoleId(@Param("id") Long id);
}
