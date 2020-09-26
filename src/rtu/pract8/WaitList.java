package rtu.pract8;

import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.Collection;

/**
 * Класс, реализующий простой список ожидания без дополнительной функциональности
 * (реализующий методы интерфейса {@code IWaitList}, и ничего более)
 *
 * @param <E> тип элементов данного списка ожидания
 *
 * @author Тугушев Тимур
 * @version 1.0
 *
 * @see IWaitList
 */

public class WaitList<E> implements IWaitList<E> {

    /**
     * Очередь, выполняющая функцию хранения всех элементов списка ожидания
     */

    protected ConcurrentLinkedQueue<E> content;

    /**
     * Конструктор класса, формирующий пустой список ожидания
     */

    public WaitList() {
        content = new ConcurrentLinkedQueue<>();
    }

    /**
     * Конструктор класса, формирующий список ожидания с элементами
     * коллекции, поданной в аргумент данного конструктора
     *
     * @param c коллекция, содержащая элементы формируемого списка ожидания
     */

    public WaitList(Collection<E> c) {
        content = new ConcurrentLinkedQueue<>();
        content.addAll(c);
    }

    /**
     * Метод, ответственный за добавление в список ожидания нового элемента
     *
     * @param element элемент, который необходимо добавить в список ожидания
     */

    public void add(E element) {
        content.add(element);
    }

    /**
     * Метод, который "вытаскивает" первый элемент из списка ожидания
     * (удаляет из списка и возвращает его в качестве возвращаемого значения метода)
     *
     * @param element элемент, который необходимо удалить из списка ожидания
     */

    public void remove(E element) {
        content.remove(element);
    }

    /**
     * Метод, возвращающий {@code true}, если список ожидания содержит поданный в аргумент
     * метода элемент, или {@code false} в случае отсутствия
     *
     * @param element элемент, который необходимо проверить на наличие в списке
     * @return {@code true}, если список ожидания содержит элемент
     */

    public boolean contains(E element) {
        return content.contains(element);
    }

    /**
     * Метод, возвращающий {@code true}, если список ожидания содержит все элементы
     * поданной в аргумент метода коллекции, или {@code false} в обратном случае
     *
     * @param c коллекция, которую необходимо проверить на наличие в списке
     * @return {@code true}, если список ожидания содержит все элементы коллекции
     */

    public boolean containsAll(Collection<E> c) {
        return content.containsAll(c);
    }

    /**
     * Метод, возвращающий {@code true}, если список ожидания не содержит ни одного элемента
     * (является пустым), или {@code false} в обратном случае
     *
     * @return {@code true}, если список ожидания является пустым
     */

    public boolean isEmpty() {
        return content.isEmpty();
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
