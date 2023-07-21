// Пирамидальная сортировка

package lectures.les_02;

public class HeapSort {

    public static void sort(int[] array){
        // Построение кучи (перегрупперую массив)
        for (int i = array.length / 2 - 1; i >= 0; i--) 
            heapify(array, array.length, i);
        
        // Один за другим извлекаю элементы из кучи
        for (int i = array.length - 1; i >= 0; i--) {
            //Перемещаю текущий корень в конец
            int temp = array[0];
            array[0] = array[i];
            array[i] = temp;

            // Вызываю процедуру heapify на уменьшенной куче
            heapify(array, i, 0);
        }
    }
    private static void heapify(int[] array, int heapSize, int rootIndex){
        int largest = rootIndex; // инициализирую наибольший элемент как корень
        int leftChild = 2 * rootIndex + 1; // левый = 2*rootIndex + 1
        int rightChild = 2 * rootIndex + 2; // правый

        // Если левый дочерний элемент больше корня
        if (leftChild < heapSize && array[leftChild] > array[largest])
            largest = leftChild;

        // Если правый дочерний элемент больше, чем самый большой элемент на данный момент
        if (rightChild < heapSize && array[rightChild] > array[largest])
            largest = rightChild;
        
        // Если самый большой элемент не корень
        if (largest != rootIndex){
            int temp = array[rootIndex];
            array[rootIndex] = array[largest];
            array[largest] = temp;

            // Рекурсивно преобразую в двоичную кучу затронутое поддерево
            heapify(array, heapSize, largest);
        }
    }
}
