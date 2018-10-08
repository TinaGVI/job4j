package ru.job4j.search;

/**
 * Класс записи.
 * desc описание.
 * priority приоритет записи.
 *
 * @author TinaGVI
 * @since 08.10.2018
 */
public class Task {
    private String desc;
    private int priority;

    public Task(String desc, int priority) {
        this.desc = desc;
        this.priority = priority;
    }

    public String getDesc() {
        return desc;
    }

    public int getPriority() {
        return priority;
    }
}

