package com.luxury.hotel.repository.server;

import com.luxury.hotel.entity.server.Room;
import com.luxury.hotel.repository.base.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoomRepository extends AbstractRepository<Room,Long> {

    Room findRoomByRoomNumber(String roomNumber);
}
