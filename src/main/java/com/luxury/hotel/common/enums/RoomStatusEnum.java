package com.luxury.hotel.common.enums;

public enum RoomStatusEnum {
    VACANT(0,"空房 "),OCCUPIED(1,"有人居住"),ORDERED(2,"已预定");

    int key;
    String value;

    RoomStatusEnum(int key,String value){
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public static RoomTypeEnum getEnumByKey(int key){
        for (RoomTypeEnum objEnum:RoomTypeEnum.values()){
            if (key == objEnum.key){
                return objEnum;
            }
        }
        return null;
    }
}
