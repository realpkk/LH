package com.luxury.hotel.repository.server;

import com.luxury.hotel.entity.server.Info;
import com.luxury.hotel.repository.base.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InfoRepository extends AbstractRepository<Info,Long> {
}
