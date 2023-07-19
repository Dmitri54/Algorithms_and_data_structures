// Урок 1. Вводная лекция. Алгоритмы. Сложность алгоритмов
// ==============================================================================================
// Вопрос: Что такое сложность алгоритма и какие они бывают?

// Константная - O(1);
// Линейная - O(n);
// Логарифмическа - O(log n);
// Квадратная - O(n^2).

package lectures.sem_01;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

// ==================================================================================================
// Линейная - O(n);
// public class Program_01 {
//     public static void main (String[] args){
//         int a = 5;

//         System.out.println(sumN(a));
//         System.out.println(sum(a));
//     }

//     public static int sumN (int n) { // Линейная сложность- O(n); Можно ли оптимизировать? (Через арифметическую прогрессию)
//         int result = 0;
//         for (int i = 1; i <= n; i++) 
//             result += i;
//         return result;
        
//     }

//     public static int sum (int n) { // Арифметическая прогрессия

//         return n * (n + 1) / 2;         
//     }
    
// }

// =========================================================================================
// Квадратная - O(n^2).
// public class Program_01 {
//     public static void main (String[] args){

//         int [] array = new int [10000];
//         for (int i = 0; i < array.length; i++) 
//             array[i] = new Random().nextInt(100);

// // Создал массив array2, чтобы проверить работоспособность функции bubbleStort3,
// // т.к. array получался уже отсортированным, ответ был 0, что не верно.

//         int [] array2 = new int [10000];
//         for (int i = 0; i < array2.length; i++) 
//             array2[i] = new Random().nextInt(100);

//         // long timeStart1 = System.currentTimeMillis(); 
//         // bubbleStort(array);
//         // long timeEnd1 = System.currentTimeMillis(); 

//         long timeStart2 = System.currentTimeMillis(); 
//         bubbleStort2(array);
//         long timeEnd2 = System.currentTimeMillis(); 

//         long timeStart3 = System.currentTimeMillis(); 
//         bubbleStort3(array2);
//         long timeEnd3 = System.currentTimeMillis(); 

//         // System.out.println(timeEnd1 - timeStart1);
//         System.out.println(timeEnd2 - timeStart2);
//         System.out.println(timeEnd3 - timeStart3);

//         // for (int i : array) // Актуально при рассмотрении функции bubbleStort.
//         //     System.out.print(i + " ");
        
//     }

// // Бобл сорт - если левый больше, тогда они меняются местами.

//     public static void bubbleStort(int[] array){ // Квадратная сложность - O(n^2).
//         for (int k = 0; k < array.length - 1; k++) { // Повтор алгоритма перемещениея.
//             for (int i = 0; i < array.length - 1; i++) { // Тут само перемещение элемента.
//                 if (array[i] > array[i + 1]) {
//                     int temp = array[i];
//                     array[i] = array[i + 1];
//                     array[i + 1] = temp;
//                 }              
//             }           
//         }
//     }

//     // Как изменить количество шагов, чтобы функция bubbleStort работала быстрее?
//     // Оптимизирую 

//     public static void bubbleStort2(int[] array){ 
//         int length = array.length - 1; //  Убрал повторную проверку элемента.
//         for (int k = 0; k < array.length - 1; k++) { 
//             for (int i = 0; i < array.length - 1; i++) { 
//                 if (array[i] > array[i + 1]) {
//                     int temp = array[i];
//                     array[i] = array[i + 1];
//                     array[i + 1] = temp;
//                 }              
//             }
//             length--; // Сократил длинну списка на один последний элемент, при каждом следующем шаге.           
//         }
        
//     }
//     // Сложность получается ниже: 
//     // O(n * (n - 1) / 2)
//     // Если раскрыть и убрать 2, т.к. константа у нас не учитывается при подсчете сложностей.
//     // O(n^2 - n)   - получается вот так и надо не забывать, что все делиться на 2.

// // -----------------------------------------------------------------------------------------------
// // Можно ещё оптимизировать, ускорев работу bubbleStort2.

//     public static void bubbleStort3(int[] array){ 
//         int length = array.length - 1; 
//         boolean flag = true; // Ограничет проверку уже отсортированного массива. 
//         for (int k = 0; k < array.length - 1 && flag; k++) { 
//             flag = false;
//             for (int i = 0; i < array.length - 1; i++) { 
//                 if (array[i] > array[i + 1]) {
//                     flag = true;
//                     int temp = array[i];
//                     array[i] = array[i + 1];
//                     array[i + 1] = temp;
//                 }              
//             }
//             length--;          
//         } 
//     }
// // Но в расчете сложности работа flag не будет учитываться, 
// // т.к. при расчете сложности берется самым худжий вариант растановки элементов.
// }

// ===========================================================================================
// Рекурсия (recursion)

// public class Program_01 {
//     public static void main (String[] args){
//         int a = 4;

//         // long startTime1 = System.nanoTime();
//         // System.out.println(fib(a));
//         // long endTime1 = System.nanoTime();

//         // System.out.println("Time:" + (endTime1 - startTime1));

//         // long startTime2 = System.nanoTime();
//         // System.out.println(fib2(a, 0, 1));
//         // long endTime2 = System.nanoTime();

//         // System.out.println("Time2:" + (endTime2 - startTime2));

//         // long startTime3 = System.nanoTime();
//         // System.out.println(fib3(a));
//         // long endTime3 = System.nanoTime();

//         // System.out.println("Time2:" + (endTime3 - startTime3));
// // ---------------------------------------------------------------------------------------
// // Для большей точности, при проверки скорости работы алгоритма, лучше прогонять его несколько раз.

//         long startTime2 = System.nanoTime();
//         for (int i = 0; i < 100; i++) { // делаю запуск 100 раз
//             fib2(a);
//         }
//         long endTime2 = System.nanoTime();
//         long time2 = (endTime2 - startTime2) / 100; // Получаю среднее время.

//         long startTime3 = System.nanoTime();
//         for (int i = 0; i < 100; i++) {
//             fib3(a);
//         }
//         long endTime3 = System.nanoTime();
//         long time3 = (endTime3 - startTime3) / 100;

//         System.out.println("Time2:" + (time2));
//         System.out.println("Time3:" + (time3));
//     }

//     public static int fib(int n){ // Стандартная рекурсия для Фибоначи, но она медленная.
//         if (n < 1)
//             return -1;
//         if (n == 1)
//             return 0;
//         if (n <= 3)
//             return 1;
//         return fib(n - 1) + fib(n - 2);
//     }
// // Она не эффективна, потому что, много повторов и много запусков рекурсии.
// // ------------------------------------------------------------------------------------------------

//     // public static int fib2(int n, int left, int right){ // Прямая рекурсия.
//     //     if (n <= 0)
//     //         return -1;
//     //     if (n == 1)
//     //         return 0;
//     //     if (n <= 2)
//     //         return 1;
//     //     if (n <= 2)
//     //         return right;
//     //     return fib2(n - 1, right, left + right);
//     // }

// // Можно сделать перегрузку.

//     public static int fib2(int n){ 
//         if (n <= 0)
//             return -1;
//         if (n == 1)
//             return 0;
//         if (n <= 3)
//             return 1;
//         return fib2(n, 0, 1);
//     }

//     public static int fib2(int n, int left, int right){
//         if (n <= 2)
//             return right;
//         return fib2(n - 1, right, left + right);
//     }

// // ------------------------------------------------------------------------------------------------
// // Рекурсия через цикл ровна по сложности. O(n)
// // Цикл быстрее рекурсии.

//     public static int fib3(int n){
//         int left = 0;
//         int right = 1;
//         if (n <= 0)
//             return -1;
//         if (n == 1)
//             return 0;
//         for (int i = 2; i < n; i++) {
//             right = left + right;
//             left = right - left;
//         }
//         return right;
//     }
// }
// =================================================================================================
// Класс

public class Program_01 {
    public static void main (String[] args){

        Car car1 = new Car(); // Создание экземпляра класса Car, при помощи конструктора new.
        // car1.engine = new Engine(); // Убрал, т.к. прописал в классе Car.
        car1.name = "Moskvich";
        car1.seats = 5;
        // car1.tank = 40;
        car1.engine.tank = 40;
        car1.engine.V = 4;
        car1.engine.force = 100;

        Car car2 = new Car(); 
        // car2.engine = new Engine();
        car2.name = "BMW";
        car2.seats = 2;
        // car2.tank = 30;
        car2.engine.tank = 30;
        car2.engine.V = 5;
        car2.engine.force = 200;

        Car car3 = new Car("Volvo", 4);
        car3.engine.tank = 35;
        car3.engine.V = 6;
        car3.engine.force = 260;

        car1.print(); // Чтобы сделать вывод пишу имя элемента и через точку вызов метода.
        // car1.selfDestroy(); // Что придумаю, то и могу использовать )))
        car1.print();
        car2.print();
        car3.print();

        // System.out.println(car1.name);
        // System.out.println("seats: " + car1.seats);
        // System.out.println("Engine: " + car1.tank + "L");

        // System.out.println(car2.name);
        // System.out.println("seats: " + car2.seats);
        // System.out.println("Engine: " + car2.tank + "L");
// Если нужно вывести 1 - 2 раза, то хорошо, а если 1000 раз, то нужно создать метод в нутри класса Car.
        
    }

    static class Car { // Класс - просто описывает объект
        // Поле класса:
        public String name; 
        // double tank; // Объём бака

// Инкапсуляция - это предоставление или не предоставление доступа другим классам.
// public - доступен везде.
// private - доступен только внутри класса, где создан.

        private int seats; // Количество мест

        public Engine engine; // Создал внутри класса Car экзкмпляр класса Engine.

        public Car() { // Конструктор!!!
            name = ""; // Тут можно задать значения по умолчанию
            seats = 5;
            engine = new Engine(); // И вызвать создание экземпляра другово класса.
        }

        public Car (String _name, int _seats){
            name = _name;
            seats = _seats;
            engine = new Engine();
        }

        public void print(){ // Метод позволит сделать вывод нужно количество раз. Так код короче!

            System.out.println(name);
            System.out.println("seats: " + seats);
            engine.print();
            // System.out.println("Engine: ");
            // System.out.println("V: " + engine.V);
            // System.out.println("Tank: " + engine.tank + "L");
            // System.out.println(engine.force + "hp");
        }

        // void selfDestroy() { // Просто пример метода, удаления информации.
        //     name = null;
        //     tank = 0;
        //     seats = 0;
        // }

    }

    static class Engine{ // Создал отдельный класс Двигатель
        double tank; // Объём бака
        int V; // Количество цилиндров
        int force; // Сила
        boolean wasForcing; // Форсируется или нет

        void forcingEngine(){
            if (wasForcing)
                return;
            wasForcing = true;
            force *= 1.2;
        }

        void print () {
            System.out.print("Engine: ");
            System.out.print("V: " + V);
            System.out.print(", : " + tank + "L, ");
            System.out.print(force + "hp");
            if (wasForcing)
                System.out.print(" engine was forced");
            else
                System.out.print(" engine not forced");
            System.out.println();
        }
    }
}

