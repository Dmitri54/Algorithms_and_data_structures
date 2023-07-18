// Урок 1.

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Program_01 {

    public static void main (String[] args) {
        // Убрал, чтобы запустить findSimpleNumbers.
        // List<Integer> availbleDivider = findAvalibleDivider(12);
        // Убрал, чтобы посчитать Фибоначчи.
        // List<Integer> availbleDivider = findSimpleNumbers(100);

        // Убрал, чтобы не мешало считать counter.
        // for (Integer integer : availbleDivider) {
        //     System.out.println(integer);
        // }
        AtomicInteger counter = new AtomicInteger(0);
        int fib = fib(10, counter);
        System.out.println("Fib number: " + fib);
        System.out.println("Counter: " + counter.get());
    }

// Алгоритм поиска допустимых делителей:

    public static List<Integer>  findAvalibleDivider(int number) {
        int counter = 0;
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i < number; i++){
            if (number % i == 0){
                result.add(i);
            }
        }
        System.out.println("Counter: " + counter);
        return result;
    }

// Алгоритм поиска простых чисел:

    public static List<Integer> findSimpleNumbers(int max) {
        int counter = 0; // Добавил счеткик, чтобы видеть количество шагов
        List<Integer> result = new ArrayList<>();
        for (int i = 1; i <= max; i++) {
            boolean simple = true;
            for (int j = 2; j < i; j++) {
                if (i % j == 0) {
                    simple = false;
                }
            }
            if (simple) {
                result.add(i);
            }
        }
        System.out.println("Counter: " + counter);
        return result;
    }


// Задача поиска шанса выпадения определенной суммы на игральный костях.

    public static double findSum (int sum){
        int count = 0;
        int successResult = 0;
        for (int i = 1; i <= 6; i++){
            for (int j = 1; j <= 6; j++){
                for (int k = 1; k <= 6; k++){
                    if (i + j + k == sum){
                        successResult++;
                    }
                    count++;
                }
            }
        }
        return ((double) successResult) / ((double) count);
    }

// Функция вычисления чисел Фибоначчи

    public static int fib(int position, AtomicInteger counter) {
        counter.incrementAndGet(); // Чтобы посчитать количество шагов.
        if (position == 1){
            return 0;
        }
        if (position == 2){
            return 1;
        }
        return fib(position - 1, counter) + fib(position - 2, counter);
    }
}

