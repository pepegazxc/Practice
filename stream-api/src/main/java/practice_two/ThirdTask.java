package practice_two;

import java.util.List;

public class ThirdTask {
    public static void main(String[] args){
        List<String> list = List.of("stream", "api", "java", "code");

        List<String> newList = list.stream()
                .map(String::toUpperCase)
                .peek(System.out::println)
                .filter(word -> word.length() > 4)
                .toList();

        newList.forEach(System.out::println);
    }
}
