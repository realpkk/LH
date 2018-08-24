package com.luxury.hotel.common.utils;

import java.util.Date;
import java.util.List;

public class PriceCalculateUtil {

    public static Integer priceCalculate(Date checkInTime,Date checkOutTime, List<Integer> roomPrice){
        int interval = DateUtil.timeInterval(checkInTime,checkOutTime);
        Integer totalPrice = 0;
        for (Integer price:roomPrice){
            totalPrice += price * interval;
        }
        return totalPrice;
    }
}
