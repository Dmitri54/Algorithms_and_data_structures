package lectures.hw_03;

public class LinkedList<T extends Comparable<T>> {
    private Node root; 
    private int size; 

// Добавление в конец.
    public void add(T value){ 
        if (root == null){ 
            root = new Node(value); 
            size = 1; 
            return;
        }

        Node currentNode = root; 
        while (currentNode.next != null)
            currentNode = currentNode.next; 
        currentNode.next = new Node(value); 
        size++;
    }

// Метод для вывода в консоль
    public void print(){ 
        System.out.print("[ ");
        Node currentNode = root; 
        while (currentNode != null){
            System.out.print(currentNode.value + " ");
            currentNode = currentNode.next; 
        }
        System.out.println("] size: " + size);
    }

    public int size(){return size;}
    
// Разворот списка
    public void revert(){
        if (root != null && root.next != null){
            Node currentNode = root;
            revert(root.next, root);
            currentNode.next = null;
            
        }
    }
    
    private void revert(Node currentNode, Node previousNode){ // Разворот для односвязанного списка
        if (currentNode.next == null){
            root = currentNode;
        } else {
            revert(currentNode.next, currentNode);
        }
        currentNode.next = previousNode;
    }

    private class Node { 
        T value; 
        Node next; 

        Node (){} 

        Node (T value){ this.value = value;}
    }
}
