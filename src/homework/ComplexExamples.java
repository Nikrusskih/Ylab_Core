package homework;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.summarizingInt;

public class ComplexExamples {

    static class Person {
        final int id;

        final String name;

        Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Person person)) return false;
            return getId() == person.getId() && getName().equals(person.getName());
        }

        @Override
        public int hashCode() {
            return Objects.hash(getId(), getName());
        }
    }

    private static Person[] RAW_DATA = new Person[]{
            new Person(0, "Harry"),
            new Person(0, "Harry"), // дубликат
            new Person(1, "Harry"), // тёзка
            new Person(2, "Harry"),
            new Person(3, "Emily"),
            new Person(4, "Jack"),
            new Person(4, "Jack"),
            new Person(5, "Amelia"),
            new Person(5, "Amelia"),
            new Person(6, "Amelia"),
            new Person(7, "Amelia"),
            new Person(8, "Amelia"),
    };

    public static void main(String[] args) {
        int sum = 10;
        int[] array = {3, 4, 2, 7};
        int[] result = twoSum(array, sum);

        System.out.println(Arrays.toString(result));

        System.out.println(fuzzySearch("car", "ca6$$#_rtwheel"));
        ; // true
        System.out.println(fuzzySearch("cwhl", "cartwheel"));
        ; // true
        System.out.println(fuzzySearch("cwhee", "cartwheel"));
        ; // true
        System.out.println(fuzzySearch("cartwheel", "cartwheel"));
        ; // true
        System.out.println(fuzzySearch("cwheeel", "cartwheel"));
        ; // false
        System.out.println(fuzzySearch("lw", "cartwheel"));
        ; // false

         /*
    Task1
        Убрать дубликаты, отсортировать по идентификатору, сгруппировать по имени

        Что должно получиться
            Key:Amelia
            Value:4
            Key: Emily
            Value:1
            Key: Harry
            Value:3
            Key: Jack
            Value:1
     */
        Arrays.stream(RAW_DATA)
                .filter(Objects::nonNull)
                .collect(Collectors.toSet())
                .stream()
                .collect(groupingBy(Person::getName, summarizingInt(i -> 1)))
                .entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> System.out.println("Key:" + entry.getKey() + "\nValue:" + entry.getValue().getSum()));

    }

    /*
     Task2

         [3, 4, 2, 7], 10 -> [3, 7] - вывести пару менно в скобках, которые дают сумму - 10
      */
    public static int[] twoSum(int[] array, int sum) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            int numberToFind = sum - array[i];
            if (set.contains(numberToFind)) {
                return new int[]{numberToFind, array[i]};
            }
            set.add(array[i]);
        }
        return new int[0];
    }
        /*
        Task3
            Реализовать функцию нечеткого поиска
                    fuzzySearch("car", "ca6$$#_rtwheel"); // true
                    fuzzySearch("cwhl", "cartwheel"); // true
                    fuzzySearch("cwhee", "cartwheel"); // true
                    fuzzySearch("cartwheel", "cartwheel"); // true
                    fuzzySearch("cwheeel", "cartwheel"); // false
                    fuzzySearch("lw", "cartwheel"); // false
         */
    public static boolean fuzzySearch(String query, String term) {
        if (query.length() > term.length()) {
            return false;
        }
        if (query.length() == term.length() && query.equals(term)) {
            return true;
        }
        int current = 0;
        for (int i = 0; i < term.length(); i++) {
            if (term.charAt(i) == query.charAt(current)) {
                current++;
            }
            if (current == query.length()) {
                return true;
            }
        }
        return false;
    }


}