package practice_one;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ForthTask {
    public static void main(String[] args){
        Random rand = new Random();

        Stream.generate(() -> rand.nextInt(100) + 1)
                        .limit(5)
                                .forEach(System.out::println);
    }
}
