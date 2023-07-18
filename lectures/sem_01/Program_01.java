// Урок 1. Вводная лекция. Алгоритмы. Сложность алгоритмов
// ==============================================================================================
// Вопрос: Что такое сложность алгоритма и какие они бывают?

// Константная - O(1);
// Линейная - O(n);
// Логарифмическа - O(log n);
// Квадратная - O(n^2).

package lectures.sem_01;

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
public class Program_01 {
    public static void main (String[] args){

        int [] array = new int [10000];
        for (int i = 0; i < array.length; i++) 
            array[i] = new Random().nextInt(100);

// Создал массив array2, чтобы проверить работоспособность функции bubbleStort3,
// т.к. array получался уже отсортированным, ответ был 0, что не верно.

        int [] array2 = new int [1000];
        for (int i = 0; i < array2.length; i++) 
            array2[i] = new Random().nextInt(100);

        long timeStart1 = System.currentTimeMillis(); 
        bubbleStort(array);
        long timeEnd1 = System.currentTimeMillis(); 

        long timeStart2 = System.currentTimeMillis(); 
        bubbleStort2(array);
        long timeEnd2 = System.currentTimeMillis(); 

        long timeStart3 = System.currentTimeMillis(); 
        bubbleStort3(array2);
        long timeEnd3 = System.currentTimeMillis(); 

        System.out.println(timeEnd1 - timeStart1);
        System.out.println(timeEnd2 - timeStart2);
        System.out.println(timeEnd3 - timeStart3);

        // for (int i : array) // Актуально при рассмотрении функции bubbleStort.
        //     System.out.print(i + " ");
        
    }

// Бобл сорт - если левый больше, тогда они меняются местами.

    public static void bubbleStort(int[] array){ // Квадратная сложность - O(n^2).
        for (int k = 0; k < array.length - 1; k++) { // Повтор алгоритма перемещениея.
            for (int i = 0; i < array.length - 1; i++) { // Тут само перемещение элемента.
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }              
            }           
        }
    }

    // Как изменить количество шагов, чтобы функция bubbleStort работала быстрее?
    // Оптимизирую 

    public static void bubbleStort2(int[] array){ 
        int length = array.length - 1; //  Убрал повторную проверку элемента.
        for (int k = 0; k < array.length - 1; k++) { 
            for (int i = 0; i < array.length - 1; i++) { 
                if (array[i] > array[i + 1]) {
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }              
            }
            length--; // Сократил длинну списка на один последний элемент, при каждом следующем шаге.           
        }
        
    }
    // Сложность получается ниже: 
    // O(n * (n - 1) / 2)
    // Если раскрыть и убрать 2, т.к. константа у нас не учитывается при подсчете сложностей.
    // O(n^2 - n)   - получается вот так и надо не забывать, что все делиться на 2.

// -----------------------------------------------------------------------------------------------
// Можно ещё оптимизировать, ускорев работу bubbleStort2.

    public static void bubbleStort3(int[] array){ 
        int length = array.length - 1; 
        boolean flag = true; // Ограничет проверку уже отсортированного массива. 
        for (int k = 0; k < array.length - 1 && flag; k++) { 
            flag = false;
            for (int i = 0; i < array.length - 1; i++) { 
                if (array[i] > array[i + 1]) {
                    flag = true;
                    int temp = array[i];
                    array[i] = array[i + 1];
                    array[i + 1] = temp;
                }              
            }
            length--;          
        }
        
    }  


}



/**
 * Задача 1. 
 * Необходимо написать алгоритм, считающий сумму всех чисел
 * от 1 до N. Согласно свойствам линейной сложности,
 * количество итераций цикла будет линейно изменяться
 * относительно изменения размера N.
 */