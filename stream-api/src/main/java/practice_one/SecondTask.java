package practice_one;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class SecondTask {
    public static void main (String[] args){
        int[] numbers = {4, 8, 15, 16, 23, 42};

        List<Integer> list = Arrays.stream(numbers)
                        .map(map -> Math.powExact(map, 2))
                                .boxed()
                                        .toList();

        list.forEach(System.out::println);
    }
}
