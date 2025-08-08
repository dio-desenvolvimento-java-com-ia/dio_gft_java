package org.example.JAVANIO;

import org.example.JAVAIO.FilePercistence;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        FilePercistence percistence = new NIOFilePersistence("user.csv");
        System.out.println(percistence.write("bianca;bianca@bia.com;22/09/1997;"));
        System.out.println("1====");
        System.out.println(percistence.write("bernado;bernado@bernado.com;28/11/1999;"));
        System.out.println("2=====");
        System.out.println(percistence.write("Ricardo;ricardo@ricardo.com;12/01/2000;"));
        System.out.println("3======");
        System.out.println(percistence.findAll());
        System.out.println("4======");
        System.out.println(percistence.findBy("bianca"));
        System.out.println("5======");
        System.out.println(percistence.remove("bianca"));
        System.out.println("6=======");
        System.out.println(percistence.findAll());
        System.out.println("7=====");
        System.out.println(percistence.replace("bernado", "bernado;bernado.ber@gmail.com;28/11/1999;"));
    }
}
