# Hub of tutorial Java Tasks

1. main.java.UUIDCustom - class implements random **UUID** creation and predefined creation with ability to remove
   dashes and make
**UUID** uppercase:

```java
import main.java.UUIDCustom;

import java.util.Random;

UUIDCustom uuid = new UUIDCustom();

String randomUUID = uuid.createRandomUUID(true, true); // with dashses, uppercase
String randomUUIDID = uuid.createRandomUUIDIdiomatic(false, true); // without dashes, uppercase
Random rand = Random();
long low = Math.abs(rand.nextInt());
long high = Math.abs(rand.nextInt(65536));
String predefinedUUID = uuid.createUUID(low, high, false, false); // pre-defined, without dashes, lowercase
```