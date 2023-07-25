// Урок 3. Структуры данных. Связный список.
// ====================================================================================


package lectures.sem_03;

public class Program {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();

        list.add(5);
        list.add(8);
        list.add(1);
        list.add(7);
        list.add(2);
        list.add(4);

        list.print(); // [ 5 8 1 7 2 4 ] size: 6
    }
    
}
