package main.java;

import java.util.Random;
public class Main {
    public static void main(String [] args){
        UUIDCustom uuid = new UUIDCustom();
        Random rand = new Random();
        long low = rand.nextInt();
        long high = rand.nextInt();
        System.out.println(uuid.createRandomUUID(true, true));
        System.out.println(uuid.createRandomUUIDIdiomatic(false, false));
        System.out.println(uuid.createUUID(low, high, false, false));
    }
}