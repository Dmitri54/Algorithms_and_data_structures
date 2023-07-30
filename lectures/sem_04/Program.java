// Урок 4. Структуры данных дерево и хэш-таблица
// ==================================================================

package lectures.sem_04;

public class Program {
    public static void main(String[] args) {
// Hash-функция - берёт любой объект и преобразует его в интовое число.
        String str = "Abc"; // Пример: создал строку
        String str1 = "A";
        String str2 = "J";

        System.out.println(str.hashCode()); // и при помощи встроенной функции .hashCode() могу узнать Hash
        System.out.println(str1.hashCode());
        System.out.println(str2.hashCode());
        

    }
    
}
