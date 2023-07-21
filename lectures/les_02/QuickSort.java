// Быстрая сортировка
// --------------------------------------------------------------------------

package lectures.les_02;

public class QuickSort {

    public static void sort(int[] array) {sort(array, 0, array.length - 1);}

    
    
    public static void sort(int[] array, int startPosition, int endPosition){ // Быстрая сортировка
        int leftPosition = startPosition;
        int rightPosition = endPosition;
        int pivot = array[(startPosition + endPosition) / 2]; // Определяю середину
        do {
            while (array[leftPosition] < pivot){ // Ищу элемент в левой части, который больше pivot
                leftPosition++;
            }
            while (array[rightPosition] > pivot){ // Ищу элемент в правой части, который меньше pivot
                rightPosition--;
            }
            if (leftPosition <= rightPosition){ 
                if(leftPosition < rightPosition){
                    int temp = array[leftPosition]; // Меняю местами
                    array[leftPosition] = array[rightPosition];
                    array[rightPosition] = temp;
                }
                leftPosition++;
                rightPosition--;
            }
        } while (leftPosition <= rightPosition);

        if (leftPosition < endPosition){
            sort(array, leftPosition, endPosition);
        }
        if (startPosition < rightPosition){
            sort(array, startPosition, rightPosition);
        }
    }
}
