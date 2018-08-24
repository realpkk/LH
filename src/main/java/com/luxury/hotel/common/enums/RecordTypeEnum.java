package com.luxury.hotel.common.enums;

public enum RecordTypeEnum {
    UNPAID(1,"未支付"),PAID(2,"已支付"),CANCEL(3,"已取消");

    int key;
    String value;

    RecordTypeEnum(int key,String value){
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

    public static RecordTypeEnum getEnumByKey(int key){
        for (RecordTypeEnum objEnum:RecordTypeEnum.values()){
            if (key == objEnum.key){
                return objEnum;
            }
        }
        return null;
    }
}

