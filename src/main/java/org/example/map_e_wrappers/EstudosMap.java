package org.example.map_e_wrappers;

import java.util.HashMap;
import java.util.Map;

public class EstudosMap {
    public static void main(String[] args) {
        Map<String, User> map = new HashMap<>();
        map.put("joao@gmail.com", new User("joao", 20));
        map.put("maria@gmail.com", new User("maria", 21));
        map.put("zeze@gmail.com", new User("zeze", 22));
        map.put("iguinho@gmail.com", new User("iguinho", 23));
        map.put("lulinha@gmail.com", new User("lulinha", 24));

        map.keySet().forEach(System.out::println);
        System.out.println("========================================");
        map.values().forEach(System.out::println);

        // Replace de valores
        System.out.println("========================================");
        map.merge("joao@gmail.com", new User("teste", 1), (user1, user2) -> {
            System.out.println(user1);
            System.out.println(user2);
            return user2;
        });

        System.out.println("========================================");
        map.values().forEach(System.out::println);
    }

    static class User {
        String name;
        Integer age;

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    ", age=" + age +
                    '}';
        }
    }
}
