package ru.job4j.tracker.actions.input;

import java.util.List;

public interface Input {
    /**
     * Задаем вопрос пользователю.
     *
     * @param question Любой вопрос пользователю, после которого пользователь должен ввести ответ.
     * @return String Ответ пользователя.
     */
    String ask(String question);
    int ask(String question, List<Integer> range);
}
