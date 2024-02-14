package main.java;

import java.util.UUID;

public class UUIDCustom {
    public enum Dashes {
        WithDashes,
        NoDashes,
    }

    public enum Case {
        UpperCase,
        LowerCase
    }

    private String formatUUID(String uuidString, Dashes dashes, Case setCase) {
        if (dashes == Dashes.NoDashes) {
            uuidString = uuidString.replaceAll("-", "");
        }
        if (setCase == Case.UpperCase) {
            uuidString = uuidString.toUpperCase();
        }
        return uuidString;
    }

    public String createUUID(long low, long high, Dashes dashes, Case setCase) {
        final UUID uuid = new UUID(low, high);
        String uuidString = uuid.toString();
        return formatUUID(uuidString, dashes, setCase);
    }

    public String createRandomUUID(Dashes dashes, Case setCase) {
        String uuid = UUID.randomUUID().toString();
        return formatUUID(uuid, dashes, setCase);
    }
}
