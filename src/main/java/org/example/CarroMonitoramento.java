package org.example;

import java.util.Scanner;

public class CarroMonitoramento {
    // TODO: Crie o método estático que verifica se o carro está apto:
    static boolean isApto(int anoFabricacao, int anoAtual) {
        int diferenca = anoAtual-anoFabricacao;
        return diferenca<=10;
    }


    public static void main(String[] args) {
        // Criando o scanner para entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Lendo os dados de entrada
        String modelo = scanner.nextLine();
        int anoFabricacao = scanner.nextInt();
        int anoAtual = scanner.nextInt();

        // TODO Implemente a chamada do método para verificar se o carro está apto:
        String resultado = isApto(anoFabricacao, anoAtual) ? "Apto" : "Nao Apto";
        // Exibindo o resultado
        System.out.println("%s: %s".formatted(modelo, resultado));

        scanner.close();
    }
}
