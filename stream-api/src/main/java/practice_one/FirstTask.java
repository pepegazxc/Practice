package practice_one;

import java.util.List;
import java.util.stream.Stream;

public class FirstTask {
    public static void main(String[] args){
        List<String> list = List.of("PostgreSQL", "Redis", "Swagger");
        Stream<String> stream = list.stream()
                .filter(length -> length.length() > 5);

        stream.forEach(System.out::println);
    }
}
