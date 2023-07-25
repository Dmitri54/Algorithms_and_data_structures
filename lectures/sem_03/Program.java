// Урок 3. Структуры данных. Связный список.
// ====================================================================================


package lectures.sem_03;

public class Program {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.print();

        list.add(5);
        list.add(5);
        list.add(5);
        list.add(8);
        list.add(1);
        list.add(7);
        list.add(5);
        list.add(5);

        list.print(); // [ 5 8 1 7 2 4 ] size: 6
        list.remove(1);
        list.print(); // [ 5 8 7 2 4 ] size: 5

        System.out.println(list.getValue(2));

        list.setValue(0, 2);
        list.print();
        

        // list.removeAll(5);
        int n = list.removeAll(5);
        list.print();
        System.out.println(n);


        
    }
    
}
