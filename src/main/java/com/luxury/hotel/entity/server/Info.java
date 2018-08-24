package com.luxury.hotel.entity.server;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "detail")
public class Info implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Long id;

    @Column(nullable = false)
    private String roomNumber;

    @Column(nullable = false)
    private String identityCode;

    @Column(nullable = false)
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss", timezone = "GMT+08:00")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkInTime;

    @Column(nullable = false)
    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss", timezone = "GMT+08:00")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutTimeOrder;

    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss", timezone = "GMT+08:00")
    @Temporal(TemporalType.TIMESTAMP)
    private Date checkOutTimeFact;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "record_rel_info",joinColumns = {@JoinColumn(name = "info_id")},inverseJoinColumns = {@JoinColumn(name = "record_code")})
    @Fetch(FetchMode.SELECT)
    private Record record;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "room_rel_info",joinColumns = {@JoinColumn(name = "info_id")},inverseJoinColumns = {@JoinColumn(name = "room_number")})
    @Fetch(FetchMode.SELECT)
    private Room room;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public String getIdentityCode() {
        return identityCode;
    }

    public void setIdentityCode(String identityCode) {
        this.identityCode = identityCode;
    }

    public Date getCheckInTime() {
        return checkInTime;
    }

    public void setCheckInTime(Date checkInTime) {
        this.checkInTime = checkInTime;
    }

    public Date getCheckOutTimeOrder() {
        return checkOutTimeOrder;
    }

    public void setCheckOutTimeOrder(Date checkOutTimeOrder) {
        this.checkOutTimeOrder = checkOutTimeOrder;
    }

    public Date getCheckOutTimeFact() {
        return checkOutTimeFact;
    }

    public void setCheckOutTimeFact(Date checkOutTimeFact) {
        this.checkOutTimeFact = checkOutTimeFact;
    }

    public Record getRecord() {
        return record;
    }

    public void setRecord(Record record) {
        this.record = record;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }
}
