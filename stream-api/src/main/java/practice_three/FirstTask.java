package practice_three;

import java.util.List;

public class FirstTask {
    public static void main(String[] args){
        List<String> list = List.of("apple", "banana", "apricot", "cherry", "avocado");

        System.out.println(
                list.stream().filter(w -> w.contains("a")).count()
        );
    }
}
