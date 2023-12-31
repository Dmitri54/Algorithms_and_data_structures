# Алгоритмы и структуры данных.

## Урок 1. Вводная лекция. Алгоритмы. Сложность алгоритмов.


* __Алгоритм__  — это точно определённая инструкция,
последовательно применяя которую к исходным данным, можно получить решение задачи.

Часто алгоритм можно представить в виде блок-схемы.
Например - алгоритм вычисления, является ли введенное
число четным.

### Program_01.java 
* Алгоритм поиска допустимых делителей.

Линейная зависимость характеризуется симметричным
ростом количества шагов относительно увеличения
объема входных данных.

* Алгоритм поиска простых чисел.

Квадратичная зависимость характеризуется резким ростом
сложности относительно роста размера входных данных.

## Как описывается сложность алгоритма?

Для описания сложности существует общепринятая нотация  
        __О(f(n)),__ 
где n - размер входных данных.

---------------------------------------------------------------
Например, алгоритм перебора массива циклом for
имеет сложность O(n). С ростом n на x, количество
шагов алгоритма тоже вырастает на x.

for (int i = 0; i < n; i++){
    // do something
}

А использование вложенного цикл for уже будет
имеет сложность O(n^2), например, при n = 3 цикл
сделает 9 итераций, а при n = 4 уже 16 и т.д.


for (int i = 0; i < n; i++){
    for (int j = 0; j < n; j++){
        // do something
    }
}
---------------------------------------------------------------
* Экспоненциальная зависимость.

Яркий пример - задача поиска шанса выпадения определенной суммы на игральный костях.

__Функция вычисления чисел Фибоначчи:__
Последовательность чисел Фибоначчи начинается с чисел 0 и 1, а все последующие элементы
вычисляется путем сложения двух предыдущих. 0, 1, 1, 2, 3, 5, 8, 13, 21,34 и т.д.


## Правила объединения сложности.

* Вызов нескольких методов на каждом шаге: 
        O(2n) == O(n)

Обход половины размерности массива:
        O(n/2) == O(n)
Цифровые множители сокращаются.

* Вызов нескольких методов вне цикла:
        O(2+n) == O(n). 
Цифровые слагаемые сокращаются

method1() - имеет сложность O(n^3)
method2() - имеет сложность O(n^2)

 - Если внутри method1() будет вызываться method2(),
то их сложности перемножаются:
        O(n^3) * O(n^2) == O(n^5)

 - Если методы будут вызываться последовательно, то
их сложности складываются, т.е. берется максимальная из них:
        O(n^3) + O(n^2) == O(n^3)

## Какая бывает сложность алгоритмов?

    ● O(1) - константная. 
Не зависит от объема данных.
Например - поиск по хэш-таблице.

    ● O(log n) - логарифмическая. 
Увеличение размер почти не сказывается на количестве итераций.
Например - бинарный поиск, поиск по
сбалансированному дереву.

    ● O(n) - линейная. 
Увеличение сложности эквивалентно увеличению размера. 
Например - поиск по неотсортированному массиву.

    ● O(n * log n) - увеличение размера заметно 
сказывается на сложности. 
Например - быстрая сортировка.

    ● O(n^2) - квадратичная. 
Увеличение размера очень сильно сказывается на сложности. Например - пузырьковая сортировка.

    ● O(2^n) - экспоненциальная. 
С увеличением размера на 1, сложность возрастает вдвое.

================================================

## Урок 2. Структуры данных. Массивы. Алгоритмы массивов.

# Структуры данных

__Структурами данных__ называют некоторый контейнер с данными, обладающий специфическим внутренним устройством (макетом) и логикой хранения. Различные макеты могут быть эффективны для некоторых операций и неэффективны для других.

# Массивы

__Массив__ - это контейнер, хранящий данные идентифицируемые по индексу.
К любому элементу массива всегда можно обратиться по его индексу и достать или заменить его.
Особенностью массива является то, что доступ к элементам по индексу осуществляется за константное время, 
т.е. имеет сложность O(1)

a b c d e f
1 2 3 4 5 6

## Основные операции с массивом

● Простые алгоритмы сортировки 
● Алгоритмы поиска
● Продвинутые алгоритмы сортировки 

## Простые алгоритмы сортировки

● Пузырьковая сортировка
● Сортировка выбором
● Сортировка вставками

__Все эти алгоритмы имеют сложность поиска O(n^2)__

Примеры: фаил Sort.java, методы: bubbleSort, directSort, insertSort
-------------------------------------------------

## Алгоритмы поиска

● Простой перебор - O(n)
● Бинарный поиск - O(log n)

Примеры: фаил Find.java, методы: find, binarySearch
-------------------------------------------------

## Продвинутые алгоритмы сортировки

● Быстрая сортировка 
● Пирамидальная сортировка

__Все эти алгоритмы имеют сложность поиска O(n * log n)__

# Быстрая сортировка

__Разделяй и властвуй__ (от анг. divide and conquer) — парадигма разработки алгоритмов, заключающаяся в
рекурсивном разбиении решаемой задачи на две или более подзадачи того же типа, но меньшего размера, и
комбинировании их решений для получения ответа к исходной задаче; 
разбиения выполняются до тех пор, пока все подзадачи не окажутся элементарными.

Пивот (от анг. pivot - поворот) - Элемент, служащий точкой сравнения элементов и их “поворота”, 
в случае необходимости.

Пример: фаил QuickSort.java

# Пирамидальная сортировка

Бинарная куча. 
Если принять элемент с индексом i за родителя, то индексы его дочерних элементов будут 
2 * i + 1 и 2 * i + 2

        array{1,2,3,4,5,6,7}

               array[0]
               /     \
              /       \
        array[1]       array[2]
       /     \          /     \
array[3]  array[4]  array[5]  array[6]


## Алгоритм просеивания
 
   10            15
  /  \    -->   /  \
13    15      13    10

Пример: HeapSort.java

================================================

## Урок 3. Структуры данных. Связный список

# Связный список

Базовая структура данных, состоящая из узлов, где каждый узел содержит одну или две ссылки, 
который ссылаются на следующий или на следующий и предыдущий узел соответственно.

+ Однонаправленный список - содержит связи только на следующий элемент списка.

+ Двунаправленный список - содержит связи на следующий и предыдущий элемент списка.

Пример: les_03.java, 

-----------------------------------------------------------------
## Основные операции со связным списком:

1. Поиск элемента;
2. Вставка элемента;
3. Удаление элемента;
4. Разворот.

### 1. Поиск элемента.
Сложность поиска - __O(n)__, т.к. поиск любой ноды требует перебора элементов. 
Использование бинарного поиска не дает выгоды, т.к. обращение по индексам 
с константной скоростью недоступно.

### 2. Вставка элемента.
__Вставка в массив O(n)__:
 - при добавлении нового элемента необходимо
обновить индексы всех элементов, находящихся правее вставляемого значения,
т.к. вставляемый элемент занимает индекс уже существующего объекта, а значит
для всех правых элементов индекс должен увеличиться на единицу.

Соответственно, чем ближе к началу вставляется новый элемент, тем более
количество элементов нужно будет сдвинуть вправо, а значит сложность
становится __O(n)__.

### 3. Удаление

При __удалении элемента из массива__, все правые индексы уменьшаются на единицу.

__Вставка в связный список O(1)__:
 - В связном списке сдвигать индексы после вставки (удалении) не требуется, т.к. они
физически не отслеживаются и не определяются. Любая операция вставки будет
похожа на операцию вставки в конец и иметь константную сложность O(1).

Остается проблема поиска нужной ноды, которая, как мы говорили ранее, __O(n)__, 
что суммарно дает сложность __O(1) + O(n) => O(n)__ для всех случаев, кроме вставки 
в начало – мы всегда имеем ссылку на первый элемент и искать его не нужно. 
Для вставки в начало сложность останется O(1).

## Преимущества связного списка:
● Массовые вставки и удаления в конец\начало списка;
● Массовые вставки и удаления в середину списка, 
если операция поиска выполняется единожды;
● Динамическая расширяемость.

### 4. Разворот 

Алгоритм перебор, где я меняю ссылки местами.

-----------------------------------------------------------------------------
## Стек
__Стеком называют__ структуру данных, реализующую функцию работы с элементами
по принципу __LIFO – Last in - First out__ – последний пришел, первый ушел.

## Очередь
Очередь очень похожа на стеку, но работает по принципу __FIFO – First in – First out__ –
первый зашел, первый ушел.

======================================
# Урок 4. Структуры данных дерево и хэш-таблица

## Дерево, внутреннее устройство
__Дерево__ – это структура данных, эмулирующая древовидную структуру в виде
набора связанных узлов. Дерево является частным случае графа, в котором
отсутствуют циклические связи. Дерево состоит из узлов, связанных между собой
ребрами по принципу родитель-ребенок.

Один узел может содержать в себе любое количество детей, но у любого ребенка
может быть только один родитель. __Самый верхний узел__, не имеющий родителя,
называется __корнем дерева__, а __узлы__, не имеющие детей – __листьями__.
С точки зрения реализации в языках программирования, дерево очень похоже на
реализацию связного списка, за тем исключением, что каждый из узлов может
ссылаться не на один, а на любое количество дочерних элементов.

Пример: Tree.java

## Алгоритмы обхода дерева

### Обход в глубину
+ __Рекурсивный подход__ - перебор всех значений в дереве, построенный на вызове 
всех доступных детей для каждого узла. Таким образом максимальная глубина рекурсии 
будет равна максимальной глубине дерева, а порядок будет идти сверху-вниз и слева-направо.

Пример: метод find и его публичная версия exist.

------------------------------------------------------------------------------------------
### Обход в ширину
+ Обход в ширину предполагает, что мы не обрабатываем детей до тех пор, 
пока все родителя одного уровня не были обработаны.

Пример: метод find.

------------------------------------------------------------------------------------------
### Бинарное дерево
+ это частный случай дерева, где все элементы обязательно строго уникальны, 
каждый родитель имеет не более 2 детей, при этом левый ребенок всегда меньше родителя, 
а правый – больше.

Благодаря своим свойствам, бинарные деревья позволяют эффективно выстраивать поисковые алгоритмы. 
Находясь на любом из узлов мы всегда точно знаем куда именно нам нужно пойти – налево или 
направо – чтобы найти искомый элемент.

### Сбалансированное дерево
+ это частный случай бинарного дерева, у которого выполняется следующее требование: 
для любого узла дерева высота его правого поддерева отличается от высоты левого поддерева 
не более чем на единицу.

## Поиск по сбалансированному дереву
Таким образом, сбалансированное дерево дает мне идеальную структуру для бинарного поиска – корень 
такого дерева — это его центральный элемент – количество элементов справа и слева от него 
различается не более чем на единицу, что характерно для выбора стартовой позиции в бинарном поиске. 

Таким образом, сложность поиска по сбалансированному дереву составляет O(log n), что дает 
очень высокую производительность.

Существуют различные типы сбалансированных деревьев – __АВЛ-дерево__,
__красно-черное дерево__, __2-3__ дерево и т.д. 
Каждое из которых имеет собственные алгоритмы **балансировки**. 

К примеру: **Красно-черное дерево**
+ Каждый узел может быть либо черным либо красныым и иметь двух потомков;
+ Корень всегда черный;
+ Дети красного узла обязательно черные;

Для частного случая - **левостороннее красно-черное дерево** - также применяется
следующий критерий: 
* Красный узел может быть только левым потомком. 

Пример: фаил RedBlackTree.

=========================================================================================
## Хеш-таблица

Структура данных, представляющая собой ассоциативный массив использующий хеш-функцию 
для выполнения операций добавления, удаления и поиска элементов.

В свою очередь **ассоциативным массивом** называют структуру данных, которая хранит 
пары ключ – значение, где ключ каждой пары является уникальным в пределах всего массива данных.

Важной особенностью хеш-таблиц является, при некотором разумном допущении, 
получить сложность каждой из перечисленных операций равной O(1).

### Этапы проектирования
Массив объектов “ключ + значение”

a: test 
b: test 
c: data 
d: info

Минусы подхода:
● Сложность O(n) для поиска элемента по ключу

----------------------------------------------------------------------------------------
### Хеш-функция
Это специальный алгоритм, позволяющий преобразовать входные данные произвольного размера
и состава в битовую строку фиксированной длины.

**Популярные хеш-алгоритмы**:
● MD5
● SHA-1
● SHA-256
● SHA-384
● SHA-512
---------------------------------------------------------------------------------------

### Этапы проектирования
**Использование хэш-функции для ключа как вычисление индекса элемента**:
                     __f(key) = i__

  1      2      3      4
a:test b:test с:data d:info

**Минусы подхода**:
● Адресное пространство в 8 байт — это не только положительные значения – Integer включает в себя
значения от −2 147 483 648 до 2 147 483 647, а обратиться к индексу с отрицательным номером невозможно.

● Каждый раз выделять в адресном пространстве место под массив размером 2 147 483 647 очень
расточительно с точки зрения эксплуатации. Скорее всего у вас не будет элементов хотя бы на одну
сотую часть этой размерности, а значит адреса в памяти будут заняты впустую.

● Наличие коллизий не позволит однозначно занять 1 ячейку массива строго одним элементом. На один и
тот же индекс может претендовать несколько элементов, чей хеш-код даст одно и тоже значение.

------------------------------------------------------------------------------------
**Учитываем наличие коллизий. Храним в ячейке не один объект, а список объектов.**

  1      2      3      4        
  |      |      |      |       |
a:test b:test с:data d:info   \|/
                |              | 
              h:nv

**Минусы подхода**:
● Перебор списка имеет сложность O(n)
Плюсы подхода:
● При корректной хеш-функции шанс коллизий минимален, а значит и размер списка будет не более
нескольких значений и сложностью перебора можно пренебречь

---------------------------------------------------------------------------------------
**Используем результат хеш-функции по модулю, чтобы избежать отрицательных индексов**

1(-1)   2(-2)   3(-3)   4(-4)
  |       |       |       |  
  |/      |/      |/      |/
a:test  b:test  с:data  d:info
                  |
                h:env

--------------------------------------------------------------------------------------
**Уменьшаем количество бакетов и используем остаток от деления на их количество для определения индекса.**
Так при 4 бакетах и результате хеш-функции 9, объект будет добавлен в ячейку с индексом (9%4=1) 1

1(5,9…)  2(6,10…) 3(7,11…) 4(8,12…)
   |        |        |        |
   |/       |/       |/       |/ 
a:test   b:test   с:data   d:info
                     |
                  h: env

-------------------------------------------------------------------------------------
**Чтобы сохранять сложность поиска O(1)**, с ростом объема данных в хеш-табилце необходимо 
корректировать количество бакетов и проводить перераспределение данных между ними.

Благодаря этому, каждый бакет будет содержать не более нескольких значений, 
что позволит пренебречь O(n) сложностью поиска по списку и сохранить 
O(1) сложность поиска по индексу массива для данных любого объема.



