package practice_two;

import java.util.List;
import java.util.stream.Stream;

public class FistTask {
    public static void main(String[] args){
        List<Integer> list = List.of(1,2,3,4,5,6,7,8,9,10,11,12,13,14,15);
        Stream<Integer> stream = list.stream()
                .filter(num -> num % 3 == 0);

        stream.forEach(System.out::println);
    }
}
