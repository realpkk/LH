package com.luxury.hotel.common.utils;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MD5Util {

    public static String encode(String inputPassword){
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("MD5").digest(inputPassword.getBytes());
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        String MD5code = new BigInteger(1,secretBytes).toString(16);
        for (int i = 0;i<32-MD5code.length();i++){
            MD5code = MD5code + "0";
        }
        return MD5code;
    }
}


