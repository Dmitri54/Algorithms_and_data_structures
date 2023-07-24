// Реализовать алгоритм пирамидальной сортировки (сортировка кучей).
// ============================================================================================

package lectures.hw_02;

import java.util.Random;

public class Program {

    public static void main (String[] args){
        int[] array = new int[10];

        randArray(array, 100);

        System.out.println("Formed array");
        print(array);
        
        sort(array);
        System.out.println("Heap sort");
        print(array);

    }

    public static void sort(int[] array) {
        int n = array.length;

        for (int i = n / 2 - 1; i >= 0; i--) {
            heapSort(array, n, i);
        }

        for (int i = n - 1; i >= 0; i--) {
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            heapSort(array, i, 0);
        }
    }

    public static void heapSort(int[] array, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if (left < n && array[left] > array[largest])
            largest = left;

        if (right < n && array[right] > array[largest])
            largest = right;

        if (largest != i){
            int temp = array[i];
            array[i] = array[largest];
            array[largest] = temp;

            heapSort(array, n, largest);
        }
    }
    
    public static void print(int[] array){
        for (int i : array) 
            System.out.print( i + " ");
        System.out.println();        
    }

    public static void randArray(int[] array, int m){
        for (int i = 0; i < array.length; i++) {
            array[i] = new Random().nextInt(m);
        }
    }
}
