// Необходимо реализовать метод разворота связного списка (двухсвязного или односвязного на выбор). 

package lectures.hw_03;

public class Program {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();

        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(0);

        list.print();
        list.revert();
        list.print();

    }
}
