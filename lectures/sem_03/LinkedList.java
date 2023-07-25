package lectures.sem_03;

public class LinkedList { // Связанный список
    private Node root; // Ссылка на первый элемент
    private int size; // Размер списка

    public void add(int value){ // Добавление элемента
        if (root == null){ // Если root равен null значит класс пустой
            root = new Node(value); // Тогда создаю новую Node по значению.
            size = 1; 
            return;
        }
// Добавление в конец
        Node currentNode = root; // Начинаю с первой ссылки
        while (currentNode.next != null) // запускаю цикл (пока следующий элемент не равен null)
            currentNode = currentNode.next; // Перезаписываю на новое значение пока не закончится цикл.
        currentNode.next = new Node(value); // Записываю новую Node, т.е. ссылку на последний злемент.
        size++;
    }
// Удаление по значению
    public boolean remove(int value){
        if (root == null) // Если равен нулю возвращаю false.
            return false; 
        if (root.value == value){ // Если нужно удалить первый элемент
            root = root.next; // Перезаписываю значение root на ссылку следующего элемента.
            size--;
            return true;
        }
        Node currentNode = root; // Создаю переменную со ссылкой на первый элемент.
        while (currentNode.next != null){ // При удалении элемента в середине списка
            if (currentNode.next.value == value) { // Если значение найдено, то в следующую Node
                currentNode.next = currentNode.next.next; // записываю значение после следующего.
                size--;
                return true;
            }
            currentNode = currentNode.next; // Если не нашел элемент перехожу к следующему.
        }
        return false; // Если значение так и не было найдено.
        
    }

// Метод для вывода в консоль
    public void print(){ 
        System.out.print("[ ");
        Node currentNode = root; // Начало
        while (currentNode != null){
            System.out.print(currentNode.value + " "); // Сначало печатаю первый элемент
            currentNode = currentNode.next; // Потом перехожу к следующемей ссылке на элемент.
        }
        System.out.println("] size: " + size);
    }

    public int size(){ return size;}

    private class Node { // Класс Node (Ссылка на значение)
        int value; // Значение
        Node next; // Ссылка на следующее значение.

        Node () { // Конструктор

        }

        Node (int value){ this.value = value;}
    }
    
}
