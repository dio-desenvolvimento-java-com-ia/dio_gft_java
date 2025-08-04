package org.example.switch_case;

import java.util.Scanner;

public class CalculoFreteRapido {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // TODO: Leia o peso em quilos:
        System.out.println("Peso em kilos:");
        double peso = scanner.nextDouble();
        // TODO: Leia o valor do frete por quilo:
        System.out.println("Frete por kilo");
        double frete = scanner.nextDouble();
        // TODO: Calcule o valor total do frete:
        double totalFrete = peso * frete;
        // TODO: Exiba o valor formatado com duas casas decimais:
        System.out.printf("Total frete: %.2f%n", totalFrete);

        scanner.close();
    }
}
