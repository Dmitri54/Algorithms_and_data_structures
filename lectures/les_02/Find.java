// Алгоритмы поиска:
// 
// ● Простой перебор;
// ● Бинарный поиск.
// -------------------------------------------------------------------------------------

package lectures.les_02;

public class Find {

    public static void main(String[] args){
        int[] array = new int[] {
            1, 2, 3, 4, 5, 6, 7, 8, 9,
        };

        // System.out.println(find(array, 5));
        // System.out.println(binarySearch(array, 5, 0, array.length -1));
        System.out.println(binarySearch(array, 5));

    }

    public static int binarySearch(int[] array, int value) {// Перегрузка функции.
        return binarySearch(array, value, 0, array.length - 1); // Чтобы не писать в месте вызова длинную функцию.
        
    }
    public static int binarySearch(int[] array, int value, int min, int max){ // Алгоритм бинарного поиска
        int midpoint;
        if (max < min){ // Делаю проверку.
            return -1;
        }
        else {
            midpoint = (max - min) / 2 + min; // Нахожу середину массива.
        }

        if (array[midpoint] < value){ // если меньше, то запускаю бинарный поиск, для левой части.
            return binarySearch(array, value, midpoint + 1, max);
        }
        else {
            if (array[midpoint] > value){ // если больше, делаю бинарный поиск, для правой части.
                return binarySearch(array, value, min, midpoint - 1);
            }
            else {
                return midpoint;
            }
        }


    }

    public static int find(int[] array, int value){ // Алгоритм поиска перебором
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value){
                return i;
            }
        }
        return -1;
    }
    
}
