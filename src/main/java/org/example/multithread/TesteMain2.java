package org.example.multithread;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class TesteMain2 {
    /**
     * Outra coisa que da para fazer é criar uma lista sicronizada
     */

    private static final Queue<Integer> numbers = new LinkedBlockingDeque<>();

    private  static void inc(int number){
        numbers.add(number);
    }

    private  static void show() {
        System.out.println(numbers);
    }
    public static void main(String[] args) {
        Runnable inc = () -> {
            for (int i = 0; i < 100_000; i++){
                inc(i);
            }
        };

        Runnable dec = () -> {
            for (int i = 100_000; i > 0 ; i--){
                inc(i);
            }
        };

        Runnable show = () -> {
            for (int i = 0; i < 250_000; i++){
                show();
            }
        };

        new Thread(inc).start();
        new Thread(dec).start();
        new Thread(show).start();
    }
}
