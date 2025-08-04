package org.example.records;

// Record é tipo uma classe imutável
public record Person(String name) {
    // Para definir propriedades no corpo do record, ele deve ser estático
    static String name2 = "";

    // Contrutor compactor
    // Bom para trabalhar com validações de dados
    public Person {
        System.out.print("Meu nome é ");
        System.out.println(name);
    }

    // Para cada propriedade é gerado um método de leitura

    // Também é possível declara métodos
    public String getName() {
        return name;
    }
}
