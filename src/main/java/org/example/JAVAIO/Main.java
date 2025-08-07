package org.example.JAVAIO;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePercistence filePercistence = new IOFilePecistences("user.csv");
        System.out.println();
        System.out.println(filePercistence.write("Renan;renan@gmail.com;15/01/1990"));
        System.out.println(filePercistence.write("Renata;renata@gmail.com;15/01/2005"));
        System.out.println();
        System.out.println(filePercistence.findAll());
        System.out.println();
        System.out.println(filePercistence.findBy("Renan;"));
        System.out.println();
        System.out.println(filePercistence.remove("Renata"));
        System.out.println();
        System.out.println(filePercistence.findAll());
        System.out.println();
        System.out.println(filePercistence.replace("Renan", "Renata;renata@gmail.com;15/01/2005"));
        System.out.println();
        System.out.printf("-> %s%n",filePercistence.findAll());
    }
}
