package org.example;

import java.util.Scanner;

// Classe principal
public class Bicicleta {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String modelo = scanner.nextLine();

        String nivelStr = scanner.nextLine();

        // Converte a string para inteiro
        int nivelBateria = Integer.parseInt(nivelStr);

        // TODO: Crie um objeto da classe BicicletaInterna com os valores lidos:
        BicicletaSistem bicicleta = new BicicletaSistem(modelo, nivelBateria);


        // Chama o método que retorna a mensagem formatada e exibe no console
        System.out.println(bicicleta.obterMensagem());

        // Fecha o scanner (boa prática para liberar o recurso)
        scanner.close();
    }

    // TODO: Crie a classe interna que representa a bicicleta:
    static class BicicletaSistem {
        // TODO: Adicione seus atributos privados: modelo e nível de bateria:
        private final String modelo;
        private final int nivel;

        // TODO: Crie o construtor para inicializar os atributos:


        public BicicletaSistem(String modelo, int nivel) {
            this.modelo = modelo;
            this.nivel = nivel;
        }

        // TODO: Implemente o método para calcular a distância máxima estimada
        public double calcularDistancia() {
            return nivel * 0.5;
        }

        // Método para gerar a mensagem de saída formatada
        public String obterMensagem() {
            // Retorna a mensagem no formato solicitado, com uma casa decimal
            return String.format("%s: Distancia estimada = %.1f km", modelo, calcularDistancia());
        }
    }
}