package org.github.code.algos.streams;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamExample {

    public record Employee(String name, int salary){}

    public static void main(String[] args){
        StreamExample x = new StreamExample();

        x.count1();

        x.findDuplicate();
    }

    public void count1(){
        List<Employee> employees = Arrays.asList(
                new Employee("John", 30000),
                new Employee("Alice", 40000),
                new Employee("Bob", 50000)
        );

        long x = employees.stream().count();

        System.out.println("X = " + x );
    }

    public void findDuplicate(){
        List<String> list = Arrays.asList("apple1", "banana", "apple", "orange");

        Optional<String> x = Optional.ofNullable(list.stream().distinct().findFirst().orElse(null));

        System.out.println("X = "+ x.get());
    }
}
