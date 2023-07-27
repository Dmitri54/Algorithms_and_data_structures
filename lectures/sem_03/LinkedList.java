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
// Добавление в конец.
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

    public void removeAt(int index){ // Удаление по индексу
        if (index < 0 || index >= size) // Если вышел за границы списка.
            throw new IndexOutOfBoundsException();
        if (index == 0) { // Если удаляю первый элемент.
            root = root.next; 
            size--;
            return;
        }
        Node preDeleted = this.getNode(index - 1); // Беру Node предыдущего и 
        preDeleted.next = preDeleted.next.next; // в следующую Node записываю значение Node после удаляемого Node.
        size--;

    }

    public int removeAll(int value){ // Удаление всех элементов по значению
        int prevSize = size; // Чтобы можно было посмотреть сколько элементов удалил.
        while (root != null && root.value == value){
            root = root.next; // Удалит первые элементы если есть совпадение
            size--; 
        }
        if (root == null)
            return prevSize - size;
            
        Node currentNode = root;
        while (currentNode.next != null) {
            if (currentNode.next.value == value) { // Удалит все совпадения по значению
                currentNode.next = currentNode.next.next; 
                size--;
            } else 
                currentNode = currentNode.next;
        }
        return prevSize - size;
        
    }

// Удаление списка
    public void clear() { 
        root = null;
        size = 0;
    }
// Копирование списка
    public LinkedList copyList() {  
        LinkedList copyList = new LinkedList();
        Node currentNode = root;
        while (currentNode != null) {
            copyList.add(currentNode.value);
            currentNode = currentNode.next;
        }
        return copyList;
    }
// Вспомогательные методы getNode и getValue, setValue, swap:
    private Node getNode(int index){ // Будет вытаскивать нужную Node по index
        if (root == null)
            return null;
        if (index < 0 || index >= size) // Проверяю, что не вышел за пределы списка
            throw new IndexOutOfBoundsException();
        Node currentNode = root; // Начитаю с первой ссылки
        for (int i = 0; i < index; i++) { // Цикл до значения index
            currentNode = currentNode.next; // Сохраняю найденный Node
        }
        return currentNode; // Нашел Node по index.
    }

    public int getValue(int index) { // Будет вытаскивать значение по index.
        Node value = this.getNode(index); // Записал значение Node найденную по index в переменную
        return value.value; // Нашел value по index.

        // return this.getNode(index).value; // Так короче.
    }

// Вставка значения по index
    public void setValue(int index, int value) { // Вставка значения по index (забираю Node и меняю значение).
        this.getNode(index).value = value;
    }

    public void swap(int index1, int index2){ // Метод будет брать два index и менять значение Node.
        if (index1 < 0 || index1 >= size || index2 < 0 || index2 >= size)
            return;
            // throw new IndexOutOfBoundsException(); // Можно так написать, тогда будет видно, что за ошибка.
        if (index1 == index2)
            return;
        Node node1 = null, node2 = null, currentNode = root;
        for (int i = 0; currentNode != null; i++) {
            if (index1 == i)
                node1 = currentNode;
            else if (index2 == i)
                node2 = currentNode;
            if (node2 != null && node1 != null)
                break;
            currentNode = currentNode.next; // Перехожу к следующему
        }
        int temp = node1.value; // меняю местами значения.
        node1.value = node2.value;
        node2.value = temp;
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

    private class Node { // Класс Node (Ссылка на значение)
        int value; // Значение
        Node next; // Ссылка на следующее значение.

        Node (){} // Конструктор

        

        Node (int value){ this.value = value;}
    }
    
}
