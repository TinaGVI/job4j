package ru.job4j.tracker;

/**
 * @author TinaGVI
 * @since 19.08.2018
 */
public class StubInput implements Input {
    /**
     * Это поле содержит последовательность ответов пользователя.
     */
    private final String[] value;

    /**
     * Подчет количества вызовов метода ask.
     */
    private int position;

    public StubInput(final String[] value) {
        this.value = value;
    }

    /**
     * Реализация вопроса пользователю и возврат результата из консоли.
     */
    @Override
    public String ask(String question) {
        return this.value[this.position++];
    }

    public int ask(String question, int[] range) {
        throw new UnsupportedOperationException("Unsupported Operation Exception");
    }
}
