package commandPackages;

import java.util.concurrent.ThreadLocalRandom;

public class randomService {
    public static int randomNumber(int dieSize){
        int number = ThreadLocalRandom.current().nextInt(1, dieSize+1);
        return number;
    }
}
