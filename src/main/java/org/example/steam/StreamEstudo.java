package org.example.steam;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamEstudo {

    private static List<User> generateUsers() {
        var contracts1 = List.of(
                new Contract("", ContractType.PHONE),
                new Contract("", ContractType.EMAIL)
        );
        var contracts2 = List.of(
                new Contract("", ContractType.PHONE),
                new Contract("", ContractType.EMAIL)
        );
        var contracts3 = List.of(
                new Contract("", ContractType.PHONE),
                new Contract("", ContractType.EMAIL)
        );
        var contracts4 = List.of(
                new Contract("", ContractType.PHONE),
                new Contract("", ContractType.EMAIL)
        );
        var user1 = new User("", 0, Sex.MALE, new ArrayList<>(contracts1));
        var user2 = new User("", 0, Sex.MALE, new ArrayList<>(contracts2));
        var user3 = new User("", 0, Sex.MALE, new ArrayList<>(contracts3));
        var user4 = new User("", 0, Sex.MALE, new ArrayList<>(contracts4));
        return List.of(user1, user2, user3, user4);
    }
    public static void main(String[] args) {
        List<String> value = Stream.of("Renan", "Renata", "Afonso", "Zelia")
                /*
                Usado principalmente para debug
                 */
                //.peek(System.out::println)
                .filter(name -> name.endsWith("a"))
                .toList();

        System.out.println(value);
        System.out.println(value.stream().allMatch(name -> name.contains("a")));

        //reduce
        String values =  Stream.of("Renan", "Renata", "Afonso", "Zelia")
                .reduce("", (a, b) -> a + b + ";");

        System.out.println(values);

        //IntStream

        var intValues = IntStream.of(1,4,6,7,4,3,2,5,9)
                .average();

        System.out.println(intValues);

        List<Integer> valores1 = List.of(3,6,9,12), valores2 = List.of(1,2,3,4,5,6,7,8,9,10,11,12);

        var newValues = valores2.stream()
                .filter(valores1::contains)
                .map(n -> valores1.stream().reduce(n, (n1, n2) -> n1 - n2))
                .collect(Collectors.toSet());

        System.out.println(newValues);

        // Retornando contatos que tenham email

        List<User> users = new ArrayList<>(generateUsers());
        var valores = users.stream().filter(u -> u.contracts()
                .stream().anyMatch(c -> c.contractType() == ContractType.EMAIL)).toList();

        valores.forEach(System.out::println);

        //  Usando flatmap
        var contractList = users.stream()
                .flatMap(u -> u.contracts().stream())
                .toList();
        contractList.forEach(System.out::println);
    }
}
