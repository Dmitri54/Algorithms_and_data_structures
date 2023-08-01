package lectures.hw_04;

public class Program {
    public static void main(String[] args) {
        
        RedBlackTree<Integer> tree = new RedBlackTree<>();

        tree.add(5);
        tree.add(9);
        tree.add(4);
        tree.add(6);
        tree.add(12);
        tree.add(3);
        tree.add(15);
        tree.add(8);

        tree.print();
        tree.add(2);
        tree.add(7);
        tree.add(20);
        tree.add(17);

        System.out.println();
        tree.print();

    }
    
}
