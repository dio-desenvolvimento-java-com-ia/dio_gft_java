package org.example.lambda;

import java.util.List;
import java.util.function.Consumer;

public class ConsumerTeste {
    public static void main(String[] args) {
        List<User> lista = List.of(new User("João"), new User("Maria"));
        lista.forEach(System.out::println);
        Consumer<User> consumer = new Consumer<>() {
            @Override
            public void accept(final User user) {
                System.out.println(user.toString());
            }
        };
        lista.forEach(consumer);
    }
}
