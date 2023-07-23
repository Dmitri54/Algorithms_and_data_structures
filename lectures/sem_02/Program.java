// Урок 2. Структуры данных. Массивы. Алгоритмы массивов.
// =======================================================================================
// Пирамидальная сортировка (Сортировка кучей).

package lectures.sem_02;

import java.lang.reflect.Array;
import java.util.Random;

public class Program {

    public static void main(String[] args){
        int[] array = new int[10];
        int[] array2 = new int[array.length];
        randomizeArray(array, 100); 

        System.arraycopy(array, 0, array2, 0, array2.length);
        // print(array);   
        // heapSort(array);
        // print(array2);

        long quick1 = System.nanoTime();
        quickSort(array);
        long quick2 = System.nanoTime();
        
        long heap1 = System.nanoTime();
        heapSort(array2);
        long heap2 = System.nanoTime();
        
        System.out.println(quick2 - quick1);
        System.out.println(heap2 - heap1);
    }

    public static void quickSort(int[] array){ // Быстрая сортировка
        quickSort(array, 0, array.length - 1);
    }

    public static void quickSort(int[] array, int leftBorder, int rightBorder){
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = array[(leftMarker + rightMarker) / 2];

        while(leftMarker <= rightMarker) {
            while (array[leftMarker] < pivot)
                leftMarker++;
            while (array[rightMarker] > pivot)
                rightMarker--;
            if (leftMarker <= rightMarker){
                if(leftMarker < rightMarker){
                    int temp = array[leftMarker];
                    array[leftMarker] = array[rightMarker];
                    array[rightMarker] = temp;
                }
                leftMarker++;
                rightMarker--;
            }
        }
        if (leftMarker < rightBorder){
            quickSort(array, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker){
            quickSort(array, leftBorder, rightMarker);
        }
    }

    public static void randomizeArray(int[] array, int max){ // Заполнение массива рандомными значениями.
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(max);
        }
    }

    public static void print(int[] array){ // вывод в консоль
        for (int i : array) 
            System.out.print(i + " ");
        System.out.println();
        
    }

    public static void heapSort(int[] array){
        int n = array.length; // для краткости кода, т.к. часто буду обращаться.

        // Построение кучи (перегрупперую массив в дерево)
        for (int i = n / 2 - 1; i >= 0; i--) // i = n / 2 - 1 не четный индекс, так я потом за границу не выйду.
            heapify(array, n, i);

        // Один за другим извлекаю элементы из кучи
        for (int i = n - 1; i >= 0; i--){
            //Перемещаю текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываю процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }      
    }


    public static void heapify(int[] array, int n, int i){ // Пирамидальная сортировка (Сортировка кучей).
        // Суть: нужно создать три переменные для деления массима по типу дерева.
        int largest = i; // инициализирую наибольший элемент как корень.
        int left = 2 * i + 1; // индекс левого элемента
        int right = 2 * i + 2; // индекс правого элемента

        // Если левый дочерний элемент больше корня по значению
        if (left < n && array[left] > array[largest])
            largest = left;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (right < n && array[right] > array[largest])
            largest = right;

        // Если самый большой элемент не корень, меняю их местами.
        if (largest != i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразую в двоичную кучу затронутое поддерево. 
            // largest меняется (21, 25 строки) и дерево растет вниз.
            heapify(array, n, largest);
// Если нету элементов больше largest, то рекурсия остановиться.
        }
    }    
}
