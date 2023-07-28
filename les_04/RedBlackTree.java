package les_04;

public class RedBlackTree { // Красно-черное дерево

    private Node node;

    private boolean addNode(Node node, int value){ // Добавление Node
        if (node.value == value){
            return false;
        } else {
            if (node.value > value){
                boolean result = addNode(node.leftChild, value);
                node.leftChild = rebalance(node.leftChild);
                return result;
            } else {
                node.leftChild = new Node();
                node.leftChild.color = Color.RED;
                node.leftChild.value = value;
                return true;
            }
        } else {
            if (node.rightChild != null){
                boolean result = addNode(node.rightChild, value);
                node.rightChild = rebalance(node.rightChild);
                return result;
            } else {
                node.rightChild = new Node();
                node.rightChild.color = Color.RED;
                node.rightChild.value = value;
                return true;
            }
        }
    }

    private Node leftSwap(Node node) { // Левосторонний перевод
        Node leftChild = node.leftChild;
        Node betweenChild = leftChild.rightChild;
        leftChild.rightChild = node;
        node.leftChild = betweenChild;
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private void colorsSwap(Node node){ // Смена цвета
        node.rightChild.color = Color.BLACK; //Беру детей, присваиваю им цвета
        node.leftChild.color = Color.BLACK;
        node.color = Color.RED; // а сам он становиться красным. 
    }

    private class Node{
        private int value; // Значение в узле
        private Color color;
        private Node leftChild;
        private Node rightChild;

        @Override
        public String toString(){
            return "Node{" + 
                    "value=" + value + 
                    ", color=" + color + 
                    "}";
        }
    }

    private enum Color{
        RED, BLACK
    }
}
