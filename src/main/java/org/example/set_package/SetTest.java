package org.example.set_package;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetTest {
    public static void main(String[] args) {
        Set<Integer> setInt = new HashSet<>();

        setInt.add(1);
        setInt.add(2);
        setInt.add(3);

        System.out.println(setInt.contains(1));
        setInt.removeIf(i -> i == 2);
        System.out.println(setInt);

        Set<User> treeSet = new TreeSet<>((User u1, User u2) -> {
            int compare = 0;
            if (u1.getId() < u2.getId()) compare--;
            if (u1.getId() > u2.getId()) compare++;
            return compare;
        });
        treeSet.add(new User(1, "Renan"));
        treeSet.add(new User(8, "Renata"));
        treeSet.add(new User(5, "Afonso"));
        treeSet.add(new User(3, "Zelia"));

        System.out.println(treeSet);
    }
}
