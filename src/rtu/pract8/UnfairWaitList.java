package rtu.pract8;

import java.util.LinkedList;

/**
 * Класс, реализующий список ожидания с дополнительной функциональностью
 * по работе с его элементами (наследующий класс {@code WaitList})
 *
 * @param <E> тип элементов данного списка ожидания
 *
 * @author Тугушев Тимур
 * @version 1.0
 *
 * @see WaitList
 * @see IWaitList
 */

public class UnfairWaitList<E> extends WaitList<E> {

    /**
     * Список удаленных элементов, которые уже нельзя вставить в список ожидания
     */

    protected final LinkedList<E> deleted = new LinkedList<>();

    /**
     * Конструктор класса, формирующий пустой список ожидания
     */

    public UnfairWaitList() {
        super();
    }

    /**
     * Метод, выполняющий удаление элемента из списка
     * ожидания, соответствующего его первому вхождению.
     * Нельзя удалить первый элемент в списке!
     *
     * @param element удаляемый элемент списка ожидания
     */

    @Override
    public void remove(E element) {
        try {
            if (!deleted.contains(element) && !element.equals(content.peek())) {
                super.remove(element);
                deleted.add(element);
            }
        } catch (Exception ignored) { }
    }

    /**
     * Метод, ответственный за добавление в список ожидания нового элемента.
     * Нельзя добавить уже удалённый элемент!
     *
     * @param element элемент, который необходимо добавить в список ожидания
     */

    @Override
    public void add(E element) {
        if (!deleted.contains(element)) {
            super.add(element);
        }
    }

    /**
     * Метод, выполняющий перемещение в конец списка ожидания элемента,
     * соответствующего его первому вхождению
     *
     * @param element элемент, перемещаемый в конец списка ожидания
     */

    public void moveToBack(E element) {
        super.remove(element);
        super.add(element);
    }
}
