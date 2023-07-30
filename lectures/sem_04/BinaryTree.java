package lectures.sem_04;

public class BinaryTree<T extends Comparable<T>> {    
    Node root; // Самая первая Node
    
    private int size; // Для удобства

    public boolean add(T value){ // Выделил метод отдельно, чтобы запускать его рекурсивно
        if(root == null){
            root = new Node(value);
            size = 1;
            return true;
        }
        return (addNode(root, value) != null);

    }

    public Node addNode(Node node, T value) {
        if (node.value.compareTo(value) == 0)
            return null;
        if (node.value.compareTo(value) > 0) { // Если значение Node больше чем значение, которое хочу добавить
            if (node.left == null) { // и Если слева нет значения, то
                node.left = new Node(value); // Создаю новую Node
                size++;
                return node.left; // и возвращаю созданную Node.
            }
            return addNode(node.left, value); // Для продолжения повторно запуская метод addNode() от node.left
            // и он уже выполняется для нового значения.
        }
        if (node.right == null) { // для правого значения.
            node.right = new Node(value);
            size++;
            return node.right;
        }
        return addNode(node.right, value);
    }

    private class Node{
        T value;
        Node left; // первая ссылка
        Node right; // вторая 

        Node () {} // Конструктор

        Node (T value) { this.value = value; }
    }
}
