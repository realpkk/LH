package com.luxury.hotel.common.enums;

public enum PromptMessageEnum {
    PHONE_PASSWORD_ERROR("手机号或密码错误"),PHONE_NUMBER_REGISTERED("手机号已注册"),CURRENT_TIME_ORDERED("当前时间段已被预订");

    String value;

    PromptMessageEnum(String value){
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
