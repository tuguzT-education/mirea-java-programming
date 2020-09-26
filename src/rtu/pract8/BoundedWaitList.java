package rtu.pract8;

/**
 * Класс, реализующий список ожидания с ограниченным размером, задаваемом при его формировании
 * (наследующий класс {@code WaitList})
 *
 * @param <E> тип элементов данного списка ожидания
 *
 * @author Тугушев Тимур
 * @version 1.0
 *
 * @see WaitList
 * @see IWaitList
 */

public class BoundedWaitList<E> extends WaitList<E> {

    /**
     * Неизменяемый размер данного списка ожидания
     */

    private final int capacity;

    /**
     * Конструктор класса, формирующий
     * пустой список ожидания с заданным размером
     *
     * @param capacity размер формируемого списка ожидания
     */

    public BoundedWaitList(int capacity) {
        super();
        this.capacity = capacity;
    }

    /**
     * Метод, возвращающий размер сформированного списка ожидания
     *
     * @return размер сформированного списка ожидания
     */

    public int getCapacity() {
        return capacity;
    }

    /**
     * Метод, ответственный за добавление в список ожидания нового элемента
     * в случае, если не достигнут его максимальный размер
     *
     * @param element элемент, который необходимо добавить в список ожидания
     */

    public void add(E element) {
        if (content.size() < capacity) {
            content.add(element);
        }
    }

    /**
     * Метод, возвращающий строку, содержащую значения всех элементов списка ожидания
     *
     * @return строка, содержащая значения всех элементов списка ожидания
     */

    public String toString() {
        return content.toString();
    }
}
