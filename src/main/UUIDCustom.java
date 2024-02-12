package main;

import java.util.Iterator;
import java.util.Random;
import java.util.Arrays;
import java.util.UUID;

public class UUIDCustom {
    int[] uuid_schema = {8, 4, 1, 3, 1, 3, 12};

//    public class IncorrectTimeHighLow extends Exception{
//        public IncorrectTimeHighLow(String errorMessage){
//            super(errorMessage);
//        }
//    }

    public String createRandomUUID(boolean withDashes, boolean isUpperCase){
        int [] versionVariant = {4, 8};
        Iterator<Integer> vVIter = Arrays.stream(versionVariant).iterator();
        StringBuilder uuid = new StringBuilder(32);
        Random rand = new Random();
        for (int partSize: uuid_schema){
            if (partSize == 1){
                uuid.append(Integer.toHexString(vVIter.next()));
                continue;
            }
            for (int i = 0; i < partSize; i++){
                int random_hex = rand.nextInt(16);
                uuid.append(Integer.toHexString(random_hex));
            }
            if (withDashes && partSize != 12){
                uuid.append('-');
            }
        }
        if (isUpperCase) {
            return uuid.toString().toUpperCase();
        } else {
            return uuid.toString();
        }

    }

    public String createUUID(long low, long high, boolean withDashes, boolean isUpperCase){
        final UUID uuid = new UUID(low, high);
        String uuidString = uuid.toString();
        if (!withDashes){
            uuidString =  uuidString.replace("-", "");
        }
        if (isUpperCase){
            uuidString =  uuidString.toUpperCase();
        }
        return uuidString;
    }

    public String createRandomUUIDIdiomatic(boolean withDashes, boolean isUpperCase){
        String uuid = UUID.randomUUID().toString();
        if (!withDashes){
            uuid = uuid.replace("-", "");
        }
        if (isUpperCase){
            uuid = uuid.toUpperCase();
        }
        return uuid;
    }
}
