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

        System.out.println(find(array, 5));
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
