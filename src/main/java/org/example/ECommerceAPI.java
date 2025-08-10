package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class ECommerceAPI {
    static class Produto {
        String nome;
        double preco;
        int quantidadeEmEstoque;

        // Construtor da classe Produto
        public Produto(String nome, double preco, int quantidadeEmEstoque) {
            this.nome = nome;
            this.preco = preco;
            this.quantidadeEmEstoque = quantidadeEmEstoque;
        }
    }

    public static void main(String[] args) {
        // Scanner para ler entrada do usuário
        Scanner scanner = new Scanner(System.in);

        // Lendo a quantidade de produtos
        int n = scanner.nextInt();
        scanner.nextLine();


        String linha = scanner.nextLine();

        // TODO: Crie a lista para armazenar os produtos:
        List<Produto> produtos = new ArrayList<>();

        // Divisão das linha por vírgula para obter os dados de cada produto
        String[] partes = linha.split(",\\s*");

        // TODO: Implemente loop para percorrer a lista de partes, processando as informações de cada produto:

        List<String> parteTemp = new ArrayList<>(Arrays.asList(partes));

        for (int j = 0; j < n; j++) {
            String nome = parteTemp.getFirst().trim();
            double preco = Double.parseDouble(parteTemp.get(1).trim());
            int quantidadeEmEstoque = Integer.parseInt(parteTemp.get(2).trim());
            produtos.add(new Produto(nome, preco, quantidadeEmEstoque));
            parteTemp.removeAll(parteTemp.subList(0, 3));
        }

        // TODO: Adicione o produto na lista:

        String resultado = String.join(", ", produtos.stream()
                .filter(p -> p.quantidadeEmEstoque > 50)
                .map(p -> p.nome)
                .toList());

        System.out.println(resultado);

    }

    // TODO: Crie a lista para armazenar os produtos com mais de 50 unidades em estoque:


    // TODO: Filtre os produtos com mais de 50 unidades em estoque:


    // TODO: Exiba os nomes dos produtos com mais de 50 unidades em estoque:


}
