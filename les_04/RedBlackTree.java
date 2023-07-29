package les_04;

public class RedBlackTree { // Красно-черное дерево

    private Node node;

    private boolean addNode(Node node, int value){ // Добавление Node
        if (node.value == value){
            return false;
        } else {
            if (node.value > value){
                if (node.leftChild != null) {
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
    }

    private Node rebalance(Node node) {
        Node result = node;
        boolean needRebalance;
        do {
            needRebalance = false;
            if (result.rightChild != null && result.rightChild.color == Color.RED &&
                    (result.leftChild == null || result.leftChild.color == Color.BLACK)) {
                needRebalance = true;
                result = rightSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED &&
                    result.leftChild.leftChild == null && result.leftChild.leftChild.color == Color.RED){
                needRebalance = true;
                result = leftSwap(result);
            }
            if (result.leftChild != null && result.leftChild.color == Color.RED && 
                    result.rightChild != null && result.rightChild.color == Color.RED){
                needRebalance = true;
                colorSwap(node);
            }
        }
        while (needRebalance);
        return result;
        
    }

    private Node rightSwap(Node node) { // Правосторонний перевод
        Node rightChild = node.rightChild;
        Node betweenChild = rightChild.leftChild;
        rightChild.leftChild = node;
        node.rightChild = betweenChild;
        rightChild.color = node.color;
        node.color = Color.RED;
        return rightChild;
    }

    private Node leftSwap(Node node) { // Левосторонний перевод
        Node leftChild = node.leftChild; // Беру левого ребенка
        Node betweenChild = leftChild.rightChild; // Беру промежуточного ребенка, для смены родителей местами
        leftChild.rightChild = node; // текущий родитель
        node.leftChild = betweenChild; // 
        leftChild.color = node.color;
        node.color = Color.RED;
        return leftChild;
    }

    private void colorSwap(Node node){ // Смена цвета
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
