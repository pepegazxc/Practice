package practice_three;

import java.util.List;

public class ForthTask {
    public static void main(String[] args){
        List<Integer> numbers = List.of(4, 8, 15, 16, 23, 42);
        System.out.println(
                numbers.stream().allMatch(n -> n > 0)
        );
    }
}
