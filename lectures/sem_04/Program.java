// Урок 4. Структуры данных дерево и хэш-таблица
// ==================================================================

package lectures.sem_04;

public class Program {
    public static void main(String[] args) {
// Hash-функция - берёт любой объект и преобразует его в интовое число.
        // String str = "Abc"; // Пример: создал строку
        // String str1 = "A";
        // String str2 = "J";

    // и при помощи встроенной функции .hashCode() могу узнать Hash
        // System.out.println(str.hashCode()); 
        // System.out.println(str1.hashCode());
        // System.out.println(str2.hashCode());

// -------------------------------------------------------------------------------------
// Hash-таблица (ключ: значение)
        Pair<String, Integer> pair1 = new Pair<>("B", 5);
        // Pair<String, Integer> pair2 = new Pair<>("H", 2);
        Pair<String, Integer> pair2 = new Pair<>("I", 2);
        Pair<String, Integer> pair3 = new Pair<>("K", 9);
        Pair<String, Integer> pair4 = new Pair<>("A", 7);

        // Беру остаток от деления на 4, т.к. элементов 4, для получения index при записи в таблицу
        System.out.println(pair1.key.hashCode() % 4); // 2
        System.out.println(pair2.key.hashCode() % 4); // 0
        System.out.println(pair3.key.hashCode() % 4); // 3
        System.out.println(pair4.key.hashCode() % 4); // 1
        
        Pair<String, Integer>[] pairs = new Pair[4]; // Создал массив

        int hash1 = pair1.key.hashCode() % pairs.length; // Записываю значение index в переменную
        int hash2 = pair2.key.hashCode() % pairs.length;
        int hash3 = pair3.key.hashCode() % pairs.length;
        int hash4 = pair4.key.hashCode() % pairs.length;

        pairs[hash1] = pair1; // Добавляю значение в массив
        pairs[hash2] = pair2;
        pairs[hash3] = pair3;
        pairs[hash4] = pair4;

        // for (int i = 0; i < pairs.length; i++)  // Вывожу в консоль каждый элемент по очереди
        //     System.out.print("[" + pairs[i].key + ";" + pairs[i].value + "] ");
        // System.out.println();

        // // Чтобы найти нужное значение ищу по key
        // for (int i = 0; i < pairs.length; i++) 
        //     if (pairs[i].key == "K")
        //         System.out.println(pairs[i].value);
        
        // // или можно высчитать Hash "K" и обращаюсь к массиву по индексу
        // System.out.println(pairs["K".hashCode() % pairs.length].value);

// Когда два одинаковых индекса получаются после расчета Hash, нужно создавать список, где 
// элемент первый начинается ссылаться на второй.
            
        


    }
    
}

class Pair<K, V> {
    K key;
    V value;

    Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }
}
