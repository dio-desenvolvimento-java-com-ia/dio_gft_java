package org.example.multithread;

import java.util.ArrayList;
import java.util.List;

public class Main {
    /**
     * O trecho que código a seguir irá gerar o erro ConcurrentModificationException.
     * Isso o ocorre poder porque as três threads startadas logo abaixo estão acessando
     * numbers ao mesmo tempo de forma concorrente.
     */
    private static final  List<Integer> numbers = new ArrayList<>();

    /**
     * Para que esse erro seja solucionado as seguintes funções abaixo foram criadas
     */

//    private static void inc(int number){
//        synchronized (numbers){
//            numbers.add(number);
//        }
//    }
//
//    private static void show() {
//        synchronized (numbers){
//            System.out.println(numbers);
//        }
//    }

    /**
     * Outra forma de fazer seria a seguinte.
     */

    private synchronized static void inc(int number){
        numbers.add(number);
    }

    private synchronized static void show() {
        System.out.println(numbers);
    }

    public static void main(String[] args) {
        /*
            Com erro !
         */

//        Runnable inc = () -> {
//            for (int i = 0; i < 100_000; i++){
//                numbers.add(i);
//            }
//        };
//
//        Runnable dec = () -> {
//            for (int i = 100_000; i > 0 ; i--){
//                numbers.add(i);
//            }
//        };
//
//        Runnable show = () -> {
//            for (int i = 0; i < 250_000; i++){
//                System.out.println(numbers);
//            }
//        };
//
//        new Thread(inc).start();
//        new Thread(dec).start();
//        new Thread(show).start();

        /*
            Sem erro !
         */
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
