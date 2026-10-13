package practice_two;

import java.util.List;

public class SecondTask {
    public static void main (String[] args){
        List<String> list = List.of("stream", "api", "java", "code");
        List<Integer> newList = list.stream()
                .map(String::length)
                .toList();

        newList.forEach(System.out::println);
    }
}
