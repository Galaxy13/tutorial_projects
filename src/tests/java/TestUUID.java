package tests.java;

import main.java.UUIDCustom;

import org.junit.Assert;
import org.junit.Test;

import java.util.Random;
public class TestUUID {
    UUIDCustom uuid_gen = new UUIDCustom();
    String pattern = "[\\da-f|A-F]{8}-*[\\da-f|A-F]{4}-*[\\da-f|A-F]{4}-*[\\da-f|A-F]{4}-*[\\da-f|A-F]{12}";
    UUIDCustom.Dashes withDashes = UUIDCustom.Dashes.WithDashes;
    UUIDCustom.Dashes noDashes = UUIDCustom.Dashes.NoDashes;
    UUIDCustom.Case upperCase = UUIDCustom.Case.UpperCase;
    UUIDCustom.Case lowerCase = UUIDCustom.Case.LowerCase;

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
    public void testRandomUUIDIdiomatic(){
        // containing dashes
        assert !uuid_gen.createRandomUUID(noDashes, lowerCase).contains("-");
        assert uuid_gen.createRandomUUID(withDashes, lowerCase).contains("-");
        // length check
        Assert.assertEquals(uuid_gen.createRandomUUID(noDashes, upperCase).length(), 32);
        Assert.assertEquals(uuid_gen.createRandomUUID(withDashes, lowerCase).length(), 36);
        // case test
        assert checkCase(uuid_gen.createRandomUUID(noDashes, lowerCase), true);
        assert checkCase(uuid_gen.createRandomUUID(noDashes, upperCase), false);
        // pattern matching
        assert uuid_gen.createRandomUUID(noDashes, lowerCase).matches(pattern);
        assert uuid_gen.createRandomUUID(withDashes, upperCase).matches(pattern);
        assert uuid_gen.createRandomUUID(withDashes, lowerCase).matches(pattern);
        assert uuid_gen.createRandomUUID(noDashes, upperCase).matches(pattern);
    }
    @Test
    public void testUUID(){
        // containing dashes
        Random rand = new Random();
        long low = rand.nextInt();
        long high = rand.nextInt();
        assert !uuid_gen.createUUID(low, high, noDashes, lowerCase).contains("-");
        assert uuid_gen.createUUID(low, high, withDashes, lowerCase).contains("-");
        // length check
        Assert.assertEquals(uuid_gen.createUUID(low, high, noDashes, upperCase).length(), 32);
        Assert.assertEquals(uuid_gen.createUUID(low, high, withDashes, lowerCase).length(), 36);
        // case test
        assert checkCase(uuid_gen.createUUID(low, high, noDashes, lowerCase), true);
        assert checkCase(uuid_gen.createUUID(low, high, noDashes, upperCase), false);
        // pattern matching
        assert uuid_gen.createUUID(low, high, noDashes, lowerCase).matches(pattern);
        assert uuid_gen.createUUID(low, high, withDashes, lowerCase).matches(pattern);
        assert uuid_gen.createUUID(low, high, withDashes, upperCase).matches(pattern);
        assert uuid_gen.createUUID(low, high, noDashes, upperCase).matches(pattern);
    }
}
