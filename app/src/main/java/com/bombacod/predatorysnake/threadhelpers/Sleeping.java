package com.bombacod.predatorysnake.threadhelpers;

public class Sleeping {

    public static void sleep(int millis){
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
