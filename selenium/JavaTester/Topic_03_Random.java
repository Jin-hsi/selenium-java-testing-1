package JavaTester;

import java.util.List;
import java.util.Random;

public class Topic_03_Random {
    public static void main (String[] args)
    {
        Random rand =new Random();
        System.out.println(rand.nextBoolean());
        System.out.println(rand.nextDouble());
        System.out.println(rand.nextFloat());
        System.out.println(rand.nextInt());
        System.out.println(rand.nextLong());
        System.out.println(rand.nextInt(9999));
        System.out.println("Alcoh" + rand.nextInt(9999) + "@gmail.com");
        System.out.println("Alcoh" + new Random().nextInt(9999) + "@gmail.com");

    }
}
