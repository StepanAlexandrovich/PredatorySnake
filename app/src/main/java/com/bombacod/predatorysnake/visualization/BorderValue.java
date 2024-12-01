package com.bombacod.predatorysnake.visualization;

public class BorderValue {
    public final static int array[] = array();

    private static int[] array(){
        int[] array = new int[1500000];

        int value = 0;
        int vector = 1;
        for (int i = 0; i < array.length; i++) {
            array[i] = value;

            value += vector;

            if(value == 400){
                vector = -1;
            }else
            if(value == 0){
                vector = +1;
            }
        }

        return array;
    }

    public static int borderPlus(int value){
        return array[value];
    }

}
