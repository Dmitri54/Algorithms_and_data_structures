// Урок 3. Структуры данных. Связный список.
// ====================================================================================


package lectures.sem_03;

import java.lang.reflect.Array;
import java.util.Random;

public class Program {
    public static void main(String[] args) {
        // LinkedList list = new LinkedList();
        
        // list.print();

        // list.add(5);
        // list.add(5);
        // list.add(5);
        // list.add(8);
        // list.add(1);
        // list.add(7);
        // list.add(5);
        // list.add(5);
        
        // // LinkedList list2 = list; // Так копировать не будет!!!

        // LinkedList list2 = list.copyList();

        // list.print(); // [ 5 8 1 7 2 4 ] size: 6
        // list.remove(1);
        // list.print(); // [ 5 8 7 2 4 ] size: 5

        // System.out.println(list.getValue(2));

        // list.setValue(0, 2);
        // list.print();
        

        // // list.removeAll(5);
        // int n = list.removeAll(5);
        // list.print();
        // System.out.println(n); // 4
        
        // System.out.print("list2: ");
        // list2.print(); // [ 5 5 5 8 1 7 5 5 ] size: 8
// -------------------------------------------------------------------------------------------------
        LinkedListT<Integer> list = new LinkedListT<>(); // Создаю джинерика с типом данных Integer.

        list.add(5);
        list.add(5);
        list.add(5);
        list.add(8);
        list.add(1);
        list.add(7);
        list.add(5);
        list.add(5);

        System.out.print("list: ");
        list.print();
        LinkedListT<Integer> list2 = list.copyList();
        // Теперь я могу указать люлой тип данных при создании связанного списка.
        LinkedListT<String> list3 = new LinkedListT<>();

        list3.add("5");
        list3.add("Hello");
        list3.add("Hello");
        list3.add("World");
        list3.add("Privet");
        list3.add("GB");
        list3.add("12");
        list3.add("100");
        

        System.out.print("list3: ");
        list3.print(); // list3: [ 5 Hello Hello World Privet GB 12 100 ] size: 8
        list3.removeAll("Hello");
        list3.print(); // [ 5 World Privet GB 12 100 ] size: 6
        
// ---------------------------------------------------------------------------------------------
        // Array.sort(list3); // Так не работает, т.к. не понятно как сортировать.

        list3.quickSort();
        System.out.print("sorted list: ");
        list3.print(); // sorted list: [ 100 12 5 GB Privet World ] size: 6

        LinkedListT<String> list4 = new LinkedListT<>();

        list4.addSorted("5"); // Сортировка при добавлении элемента
        list4.addSorted("Hello");
        list4.addSorted("Hello");
        list4.addSorted("World");
        list4.addSorted("Privet");
        list4.addSorted("GB");

        System.out.println();
        System.out.print("list4: ");
        list4.print();
        list4.quickSort(); // метод quickSort() уже не нужен.
        System.out.print("sorted list: "); 
        list4.print(); 
// --------------------------------------------------------------------------------------
        LinkedListT<Integer> list5 = new LinkedListT<>();
        for (int i = 0; i < 20; i++) {
            list5.addSorted(new Random().nextInt(20));
        }

        System.out.println();
        System.out.println("list5: ");
        list5.print();
        list5.quickSort();
        System.out.println("sorted list: "); 
        list5.print();

// -------------------------------------------------------------------------------------------------
// Д/з 
        LinkedListT<Integer> list6 = new LinkedListT<>();
        list6.add(5);
        list6.add(4);
        list6.add(3);
        list6.add(2);
        list6.add(1);
        list6.add(0);

        list6.print(); // [ 5 4 3 2 1 0 ] size: 6
        list6.revert();
        list6.print(); // [ 0 1 2 3 4 5 ] size: 6
        

// ----------------------------------------------------------------------------------------------------
        // Vector a = new Vector(2, 3, 4);
        // Vector b = new Vector(2, 9, 1);

        // // if (a > b) { // Если не прописать метод compareTo, будет ошибка. Компилятор не поймет по какому значению сравнивать!
        // if (a.compareTo(b) > 0) { // a > b
        //     System.out.println("Bigger");
        // }
        // if (a.compareTo(b) < 0) { // a < b
        //     System.out.println("Smaller");
        // }
        // if (a.compareTo(b) == 0) { // a == b
        //     System.out.println("Equals");
        // }
    }
    
}

// --------------------------------------------------------------------------------------------------
// class Vector {
//     int x;
//     int y;
//     int z;

//     Vector(int x, int y, int z){
//         this.x = x;
//         this.y = y;
//         this.z = z;
//     }
// // Сомпоратор (Compare) - суть сравнивать экземпляры классов.
//     public int compareTo(Vector vector) { // Данный метод позволяет определить критерий для сравнения.
//         if (this.length() > vector.length())
//             return 1;
//         if (this.length() < vector.length())
//             return -1;
//         return 0;
//     }
// // Получение длинну текущего вектора
//     public double length() {return Math.sqrt(x * x + y * y + z * z);}
// }