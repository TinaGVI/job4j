package ru.job4j.loop;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 20.07.2018
 */

public class Counter {
    /**
     * Подсчет суммы четных чисел в диапазоне.
     *
     * @param start  начальное число.
     * @param finish конечное число.
     * @return сумма четных чисел диапазона.
     */
    public int add(int start, int finish) {
        int sum = 0;
        for (int i = start; i <= finish; i++) {
            if (i % 2 == 0) {
                sum += i;
            }
        }
        return sum;
    }
}
