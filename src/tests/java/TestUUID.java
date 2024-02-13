package tests.java;

import main.java.UUIDCustom;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
public class TestUUID {
    UUIDCustom uuid_gen = new UUIDCustom();
    String pattern = "[\\da-f|A-F]{8}-*[\\da-f|A-F]{4}-*[\\da-f|A-F]{4}-*[\\da-f|A-F]{4}-*[\\da-f|A-F]{12}";

    private boolean checkCase(String uuid, boolean lower){
        for (char ch: uuid.toCharArray()) {
            if (Character.isLowerCase(ch) && !lower) {
                return false;
            } else if (Character.isUpperCase(ch) && lower) {
                return false;
            }
        }
        return true;
    }
    @Test
    public void testRandomUUID(){
        // contains dashes
        assert !uuid_gen.createRandomUUID(false, true).contains("-");
        assert uuid_gen.createRandomUUID(true, false).contains("-");
        // length check
        assert uuid_gen.createRandomUUID(false, false).length() == 32;
        assert uuid_gen.createRandomUUID(true, false).length() == 36;
        // pattern matching
        assert uuid_gen.createRandomUUID(false, false).matches(pattern);
        assert uuid_gen.createRandomUUID(true, false).matches(pattern);
        assert uuid_gen.createRandomUUID(true, true).matches(pattern);
        assert uuid_gen.createRandomUUID(false, true).matches(pattern);
    }
    @Test
    public void testRandomUUIDIdiomatic(){
        // containing dashes
        assert !uuid_gen.createRandomUUIDIdiomatic(false, false).contains("-");
        assert uuid_gen.createRandomUUIDIdiomatic(true, false).contains("-");
        // length check
        Assert.assertEquals(uuid_gen.createRandomUUIDIdiomatic(false, true).length(), 32);
        Assert.assertEquals(uuid_gen.createRandomUUIDIdiomatic(true, false).length(), 36);
        // case test
        assert checkCase(uuid_gen.createRandomUUIDIdiomatic(false, false), true);
        assert checkCase(uuid_gen.createRandomUUIDIdiomatic(false, true), false);
        // pattern matching
        assert uuid_gen.createRandomUUIDIdiomatic(false, false).matches(pattern);
        assert uuid_gen.createRandomUUIDIdiomatic(true, false).matches(pattern);
        assert uuid_gen.createRandomUUIDIdiomatic(true, true).matches(pattern);
        assert uuid_gen.createRandomUUIDIdiomatic(false, true).matches(pattern);
    }
    @Test
    public void testUUID(){
        // containing dashes
        Random rand = new Random();
        long low = rand.nextInt();
        long high = rand.nextInt();
        assert !uuid_gen.createUUID(low, high, false, false).contains("-");
        assert uuid_gen.createUUID(low, high, true, false).contains("-");
        // length check
        Assert.assertEquals(uuid_gen.createUUID(low, high, false, true).length(), 32);
        Assert.assertEquals(uuid_gen.createUUID(low, high, true, false).length(), 36);
        // case test
        assert checkCase(uuid_gen.createUUID(low, high, false, false), true);
        assert checkCase(uuid_gen.createUUID(low, high, false, true), false);
        // pattern matching
        assert uuid_gen.createUUID(low, high, false, false).matches(pattern);
        assert uuid_gen.createUUID(low, high, true, false).matches(pattern);
        assert uuid_gen.createUUID(low, high, true, true).matches(pattern);
        assert uuid_gen.createUUID(low, high, false, true).matches(pattern);
    }
}
