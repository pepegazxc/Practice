package practice_three;

import java.util.List;
import java.util.Optional;

public class SecondTask {
    public static void main(String[] args){
        List<String> list = List.of("apple", "banana", "apricot", "cherry", "avocado");

        Optional<String> opt =  list.stream()
                .filter(w -> w.length() == 6)
                .findFirst();

        opt.ifPresent(System.out::println);
    }
}
