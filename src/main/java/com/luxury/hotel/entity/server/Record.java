package com.luxury.hotel.entity.server;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "record")
public class Record implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(nullable = false,unique = true)
    private String recordCode;

    @Column(nullable = false)
    private String phoneNumber;

    @Column(nullable = false)
    private Integer recordPrice;

    @JsonFormat(pattern = "MM/dd/yyyy HH:mm:ss", timezone = "GMT+08:00")
    @Temporal(TemporalType.TIMESTAMP)
    private Date createTime;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinTable(name = "room_rel_record",joinColumns = {@JoinColumn(name = "record_code")},inverseJoinColumns = {@JoinColumn(name = "room_number")})
    @Fetch(FetchMode.SELECT)
    private Room room;

    @OneToMany
    @JoinTable(name = "record_rel_info",joinColumns = {@JoinColumn(name = "record_code")},inverseJoinColumns = {@JoinColumn(name = "info_id")})
    @Fetch(FetchMode.SUBSELECT)
    private List<Info> infoList;

    public String getRecordCode() {
        return recordCode;
    }

    public void setRecordCode(String recordCode) {
        this.recordCode = recordCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Integer getRecordPrice() {
        return recordPrice;
    }

    public void setRecordPrice(Integer recordPrice) {
        this.recordPrice = recordPrice;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Room getRoom() {
        return room;
    }

    public void setRoom(Room room) {
        this.room = room;
    }

    public List<Info> getInfoList() {
        return infoList;
    }

    public void setInfoList(List<Info> infoList) {
        this.infoList = infoList;
    }
}
