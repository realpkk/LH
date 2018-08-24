package com.luxury.hotel.entity.server;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "room")
public class Room implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false,unique = true)
    private String roomNumber;

    /**
     * 1 单人间  2  双人间
     */
    @Column(nullable = false)
    private Integer roomType;

    /**
     * 0 空  1  非空   2  已预定
     */
    private Integer roomStatus;

    @Column(nullable = false)
    private Integer roomPrice;

    private String tenant;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "room_rel_record",joinColumns = {@JoinColumn(name = "room_number")},inverseJoinColumns = {@JoinColumn(name = "record_code")})
    @Fetch(FetchMode.SUBSELECT)
    private List<Record> recordList;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "room_rel_info",joinColumns = {@JoinColumn(name = "room_number")},inverseJoinColumns = {@JoinColumn(name = "info_id")})
    @Fetch(FetchMode.SUBSELECT)
    private List<Info> infoList;

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public Integer getRoomStatus() {
        return roomStatus;
    }

    public void setRoomStatus(Integer roomStatus) {
        this.roomStatus = roomStatus;
    }

    public Integer getRoomPrice() {
        return roomPrice;
    }

    public void setRoomPrice(Integer roomPrice) {
        this.roomPrice = roomPrice;
    }

    public String getTenant() {
        return tenant;
    }

    public void setTenant(String tenant) {
        this.tenant = tenant;
    }

    public List<Record> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<Record> recordList) {
        this.recordList = recordList;
    }

    public List<Info> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<Info> infoList) {
        this.infoList = infoList;
    }
}
