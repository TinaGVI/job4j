package ru.job4j.search;

/**
 * Класс заметок, с приоритетами.
 *
 * @author TinaGVI
 * @since 08.10.2018
 */

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();

    /**
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определять по полю приоритет.
     * Для вставик использовать add(int index, E value)
     *
     * @param task задача
     */
    public void put(Task task) {
        if (this.tasks.size() == 0) {
            this.tasks.add(task);
        } else {
            for (int i = 0; i != this.tasks.size(); i++) {
                if (this.tasks.get(i).getPriority() >= task.getPriority()) {
                    this.tasks.add(i, task);
                    break;
                }
            }
        }
    }

    public Task take() {
        return this.tasks.poll();
    }
}
