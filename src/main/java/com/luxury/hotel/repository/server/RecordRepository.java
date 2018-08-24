package com.luxury.hotel.repository.server;

import com.luxury.hotel.entity.server.Record;
import com.luxury.hotel.repository.base.AbstractRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecordRepository extends AbstractRepository<Record,Long> {

    Record findRecordByRecordCode(String recordCode);
}
