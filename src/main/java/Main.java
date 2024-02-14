package main.java;

import java.util.Random;
public class Main {
    public static void main(String [] args){
        UUIDCustom uuid = new UUIDCustom();
        Random rand = new Random();
        long low = rand.nextInt();
        long high = rand.nextInt();
        System.out.println(uuid.createRandomUUID(UUIDCustom.Dashes.WithDashes, UUIDCustom.Case.UpperCase));
        System.out.println(uuid.createUUID(low, high, UUIDCustom.Dashes.NoDashes, UUIDCustom.Case.LowerCase));
    }
}