// Урок 2. Структуры данных. Массивы. Алгоритмы массивов.
// ==========================================================================================
// Простые алгоритмы сортировки.
// --------------------------------------------------------------------------------------

// Пузырьковая сортировка

package lectures.les_02;

public class Sort {

    public static void main(String[] args){
        int[] array = new int[]{
            4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5
        };

        bubbleSort(array);

        for (int i = 0; i < array.length; i++ ){
            System.out.print(array[i] + " ");
        }

    }

    public static void bubbleSort(int[] array){ // Пузырьковая сортировка
        boolean finish;
        do {
            finish = true;
// Обход массива. Пишу array.length-1 чтобы не было переполнения массива.
            for (int i = 0; i < array.length - 1; i++) { 
                if (array[i] > array[i + 1]) { // Делаю сравнение текущего элемента со следующим.
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    finish = false; // Чтобы цикл проверки не заканчивался пока все элементы не будут отсортированны.
                }
            }
        }
        while (!finish);

    }
}
