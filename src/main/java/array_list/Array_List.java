package array_list;

import java.util.Arrays;


/**
 * Класс Array_List это реализация динамического массива, который может хранить элементы любого типа.
 * Он содержит методы для добавления, удаления, получения и изменения элементов, и для сортировки элементов массива.
 *
 * @param <T> тип элементов, которые будут храниться в массиве
 */
public class Array_List<T> {

    /** Внутренний массив для хранения элементов*/
    private T[] array;

    /** Текущее количество элементов в массиве*/
    private int size;

    /** Начальная емкость массива*/
    private int initialCapacity = 2;

    /**
     * Конструктор по умолчанию, создающий массив с начальной емкостью 10.
     */
    public Array_List() {
        this.array = (T[]) new Object[10];
        this.size = 0;
    }

    /**
     * Конструктор, создающий массив с указанной начальной емкостью.
     *
     * @param initialCapacity начальная емкость массива
     */
    public Array_List(int initialCapacity) {
        this.array = (T[]) new Object[initialCapacity];
        this.size = 0;
    }

    /**
     * Добавляет элемент в конец массива.
     * Если массив заполнен, то размер массива увеличивается в два раза.
     *
     * @param element элемент, который необходимо добавить в массив
     */
    public void add(T element) {
        if (size == array.length) {
            expandArray();
        }
        array[size++] = element;
    }

    /**
     * Добавляет элемент в массив на указанную позицию.
     * Если массив заполнен, то размер массива увеличивается в два раза.
     * Все элементы, начиная с указанной позиции, сдвигаются на одну позицию вправо.
     *
     * @param index   индекс, по которому необходимо добавить элемент
     * @param element элемент, который необходимо добавить в массив
     * @throws IndexOutOfBoundsException если индекс выходит за пределы массива
     */
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        if (size == array.length) {
            expandArray();
        }
        for (int i = size; i > index; i--) {
            array[i] = array[i - 1];
        }
        array[index] = element;
        size++;
    }

    /**
     * Возвращает элемент, расположенный на указанной позиции в массиве.
     *
     * @param index индекс элемента, который необходимо получить
     * @return элемент, расположенный на указанной позиции
     * @throws IndexOutOfBoundsException если индекс выходит за пределы массива
     */
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        return array[index];
    }


    /**
     * Устанавливает новое значение элемента, расположенного на указанной позиции в массиве.
     *
     * @param index   индекс элемента, который необходимо изменить
     * @param element новое значение элемента
     * @throws IndexOutOfBoundsException если индекс выходит за пределы массива
     */
    public void set(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException();
        }
        array[index] = element;
    }

    /**
     * Удаляет элемент, расположенный на указанной позиции в массиве.
     * Все элементы, следующие за удаленным, сдвигаются на одну позицию влево.
     *
     * @param index индекс элемента, который необходимо удалить
     * @return удаленный элемент
     * @throws IndexOutOfBoundsException если индекс выходит за пределы массива
     */
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        T removedElement = array[index];
        for (int i = index; i < size - 1; i++) {
            array[i] = array[i + 1];
        }
        size--;
        return removedElement;
    }


    /**
     * Создает новый массив, устанавливая его размер равным 10.
     */
    public void clear() {
        array = (T[]) new Object[10];
        size = 0;
    }

    /**
     * Возвращает текущее количество элементов в массиве.
     *
     * @return текущее количество элементов в массиве
     */
    public int size() {
        return size;
    }

    private void expandArray() {
        T[] newArray = (T[]) new Object[array.length * initialCapacity];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }


    /**
     * Выполняет быструю сортировку (quicksort) для элементов массива, реализующих интерфейс Comparable.
     *
     * @param list массив, который необходимо отсортировать
     * @param <T>  тип элементов массива, который должен реализовывать интерфейс Comparable
     */
    public static <T extends Comparable<T>> void quickSort(Array_List<T> list) {
        quickSort(list, 0, list.size() - 1);
    }

    private static <T extends Comparable<T>> void quickSort(Array_List<T> list, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(list, low, high);
            quickSort(list, low, pivotIndex - 1);
            quickSort(list, pivotIndex + 1, high);
        }
    }

    private static <T extends Comparable<T>> int partition(Array_List<T> list, int low, int high) {
        T pivot = list.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (list.get(j).compareTo(pivot) < 0) {
                i++;
                swap(list, i, j);
            }
        }
        swap(list, i + 1, high);
        return i + 1;
    }

    private static <T> void swap(Array_List<T> list, int i, int j) {
        T temp = list.get(i);
        list.set(i, list.get(j));
        list.set(j, temp);
    }

    @Override
    public String toString() {
        return "Array_List{" +
               "array=" + Arrays.toString(array) +
               ", size=" + size +
               '}';
    }
}
