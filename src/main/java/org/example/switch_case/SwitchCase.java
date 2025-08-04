package org.example.switch_case;

import java.util.Scanner;

public class SwitchCase {
    public static void main(String[] args) {
        // scanner padrão
        Scanner sc = new Scanner(System.in);
        System.out.println("De 1 a 3 como ta seu humor");
        int option = sc.nextInt();
        switch (option) {
            case 1:
                System.out.println("Vixo");
                break;
            case 2:
                System.out.println("melhor que nada");
                break;
            case 3:
                System.out.println("excelente");
                break;
            default:
                System.out.println("so de 1 a 3 !");
        }

        // Outra forma de trabalhar com switch case
        Scanner sc2 = new Scanner(System.in);
        System.out.println("Você está feliz? sim ou nao");
        String option2 = sc2.next();
        option2 = option2.toLowerCase();
        switch (option2) {
            case "sim" -> System.out.println("Que bom !!!");
            case "nao" -> System.out.println("Que pena !!!");
            default -> System.out.println("Sim ou Não !!!");
        }
        // switch case também retorna valores
        String message = switch (option2) {
            case "sim" -> {
                var teste = "Que bom !!!";
                yield "seu resultado: %s".formatted(teste);
            }
            case "nao" -> "Que pena !!!";
            default -> "Sim ou Não !!!";
        };
        System.out.println(message);

    }
}
