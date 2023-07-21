// Урок 2. Структуры данных. Массивы. Алгоритмы массивов.
// ==========================================================================================
// Простые алгоритмы сортировки.
// --------------------------------------------------------------------------------------

// Пузырьковая сортировка

package lectures.les_02;

// public class Sort {

//     public static void main(String[] args){
//         int[] array = new int[]{
//             4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5
//         };

//         bubbleSort(array); // Делаю вызов метода bubbleSort для массива array.

//         for (int i = 0; i < array.length; i++ ){ // Создал цикл для печати всего массива.
//             System.out.print(array[i] + " ");
//         }

//     }

//     public static void bubbleSort(int[] array){ // Пузырьковая сортировка
//         boolean finish;
//         do {
//             finish = true;
// // Обход массива. Пишу array.length-1 чтобы не было переполнения массива.
//             for (int i = 0; i < array.length - 1; i++) { 
//                 if (array[i] > array[i + 1]) { // Делаю сравнение текущего элемента со следующим.
//                     int temp = array[i];
//                     array[i] = array[i+1];
//                     array[i+1] = temp;
//                     finish = false; // Чтобы цикл проверки не заканчивался пока все элементы не будут отсортированны.
//                 }
//             }
//         }
//         while (!finish);

//     }
// }

// Сортировка выбором (она немного быстрее чем пузырьковая сортировка)

public class Sort {

    public static void main(String[] args){
        int[] array = new int[]{
            4, 2, 5, 8, 1, 9, 2, 3, 6, 8, 5
        };

        // bubbleSort(array); 
        directSort(array);

        for (int i = 0; i < array.length; i++ ){ 
            System.out.print(array[i] + " ");
        }

    }

    public static void directSort(int[] array){
        for (int i = 0; i < array.length - 1; i++) { // запускаю цикл поиска и каждый раз сокращаю длинну.
            int minPosition = i; // Беру первый элемент и говорю, что он минимальный
            for (int j = i + 1; j < array.length; j++) { // в цикле ищу элемент меньше чем первый
                if (array[j] < array[minPosition]){
                    minPosition = j; // Если такой найден запоминаю его
                }
            }
            if (i != minPosition){ // Сравниваю первый и минимальный
                int temp = array[i];
                array[i] = array[minPosition];
                array[minPosition] = temp; // Запоминаю минимальный.
            }
        }
    }

    public static void bubbleSort(int[] array){ // Пузырьковая сортировка
        boolean finish;
        do {
            finish = true;
            for (int i = 0; i < array.length - 1; i++) { 
                if (array[i] > array[i + 1]) { 
                    int temp = array[i];
                    array[i] = array[i+1];
                    array[i+1] = temp;
                    finish = false;
                }
            }
        }
        while (!finish);

    }
}