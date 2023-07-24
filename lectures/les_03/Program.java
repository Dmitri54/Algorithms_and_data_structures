// Урок 3. Структуры данных. Связный список
// ==============================================================


package lectures.les_03;

public class Program {
    Node head; // Начало списка
    Node tail; // Ссылка на последний элемент списка.
    
    // Добавление элемента в конец связанного списока.
    public void add(int value){
        Node node = new Node();
        node.value = value;

        if(head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            node.previous = tail;
            tail = node;
        }
    }

    // Добавление элемента в середину связанного списка.
    public void add(int value, Node node){
        Node next = node.next;
        Node newNode = new Node();
        newNode.value = value;
        node.next = newNode;
        newNode.previous = node;

        if (next == null){
            tail = newNode;
        } else {
            next.previous = newNode;
            newNode.next = next;
        }
    }

    // Удаление элемента
    public void delete(Node node){
        Node previous = node.previous;
        Node next = node.next;

        if(previous == null){
            node.previous = null;
            head = next;
        } else {
            if (next == null){
                previous.next = null;
                tail = previous;
            } else {
                previous.next = next;
                next.previous = previous;
            }
        }
    }

    // Поиск элемента
    public Node find(int value){
        Node currentNode = head;
        while (currentNode != null){
            if (currentNode.value == value){
                return currentNode;
            }
            currentNode = currentNode.next;
        }
        return null;
    } 
    
    public class Node{ // Узел (Node)
        int value;
        Node next; // Следующий элемент по списку

        Node previous; // Предыдущее значение
    }
}
