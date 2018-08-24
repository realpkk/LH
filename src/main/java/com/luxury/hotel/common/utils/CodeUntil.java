package com.luxury.hotel.common.utils;

public class CodeUntil {

    /**
     * 起始时间
     */
    private final long startTime = 0L;

    /**
     *  序列位数
     */
    private long sequenceBits = 12L;

    /**
     *  时间戳左移 12位
     */
    private long timeStampLeftShift = sequenceBits;

    /**
     *  生成序列掩码 1111 1111 1111
     */
    private long sequenceMask = -1 ^ (-1 << sequenceBits);

    /**
     *  同一时间内生成的系列数，初始值0
     */
    private long sequence = 0L;

    /**
     *  上次生成id的时间戳
     */
    private long lastTimeStamp = -1L;

    public synchronized long nextId(){
        long timeStamp = timeGen();
        if (timeStamp < lastTimeStamp){
            throw new RuntimeException(String.format("时间发生回退，%d 秒内不再生成id"));
        }
        if (timeStamp == lastTimeStamp){
            sequence = (sequence + 1) & sequenceMask;
            if (sequence == 0){
                timeStamp = tilNextMills();
                sequence = 0L;
            }
        }else {
            sequence = 0L;
        }
        lastTimeStamp = timeStamp;
        return ((timeStamp - startTime) << timeStampLeftShift)| sequence;
    }

    protected long tilNextMills() {
        long timeStamp = timeGen();
        if (timeStamp <= lastTimeStamp){
            timeStamp = timeGen();
        }
        return timeStamp;
    }

    protected long timeGen() {
        return System.currentTimeMillis();
    }

    public static String getCode(){
        CodeUntil codeGen = new CodeUntil();
        long code = codeGen.nextId();
        return String.valueOf(code);
    }

}
