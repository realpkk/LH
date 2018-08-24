package com.luxury.hotel.common.enums;

public enum UserTypeEnum {
    ADMIN(1,"管理员"),NORMAL_USER(2,"普通用户"),VIP(3,"VIP会员"),BLACK_LIST(4,"黑名单");

    int key;
    String value;

    UserTypeEnum(int key,String value){
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

    public static UserTypeEnum getEnumByKey(int key) {
        for (UserTypeEnum objEnum:UserTypeEnum.values()){
            if (key == objEnum.key){
                return objEnum;
            }
        }
        return null;
    }
}
