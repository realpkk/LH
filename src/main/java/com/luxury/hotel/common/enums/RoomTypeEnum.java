package com.luxury.hotel.common.enums;

public enum RoomTypeEnum {
    SINGLE_ROOM(1,"单人房 "),DOUBLE_ROOM(2,"双人房");

    int key;
    String value;

    RoomTypeEnum(int key,String value){
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
