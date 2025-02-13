package com.cricket.kpl11.utility;

import java.util.Random;

public class GenerateRandom {

    private static  final Random random = new Random();

    public static long generateRandom(){

        return 1+random.nextInt(10);
    }
}
