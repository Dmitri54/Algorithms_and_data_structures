package lectures.les_04;

import java.util.ArrayList;
import java.util.List;

public class Tree { // Дерево
    Node root;

// Обход в глубину (рекурсия)
//     public boolean exist(int value){ // Публичный вид функции find
//         if (root != null) { // Проверка на наличие root, т.к. дерево может быть пустым
//             Node node = find(root, value);
//             if(node != null){ // Если значение найдено
//                 return true; // возвращаю true
//             }
//         }
//         return false; // Если не найдено false.
//     }
//     private Node find (Node node, int value){
//         if (node.value == value){ // Проверяю текущую Node, если в Node есть нужное значение
//             return node; // возвращаю Node
//         } else { // Если значения нет
//             for (Node child : node.children) { // перебераю его детей
//                 Node result = find(child, value); // для каждого ребенка рекурсивно запускается поиск.
//                 if (result != null){
//                     return result;
//                 }
//             }
//         }
//         return null; // Если не найдено значение.
//     }
// -------------------------------------------------------------------------------------
// Обход в ширину (циклы)
    private Node find(int value){
        List<Node> line = new ArrayList<>(); // Создаю список
        line.add(root); // Добавляю root
        while (line.size() > 0){ // Пока в моём объекте существуют дети делаю
            List<Node> nexttLine = new ArrayList<>(); // Создаю список
            for (Node node : line) { // перебераю линию, для каждого элемента
                if (node.value == value){
                    return node; // возвращаю Node
                }
                nexttLine.addAll(node.children); // Если не найдено, добавляю всех его детей
            }
            line = nexttLine; // нет вхождений в цикл, добавляю линию и перезапускаю цикл.
        }
        return null;
    }


    public class Node{
        int value; // Значение
        List<Node> children; // Список детей
    }
}

