package ru.job4j.loop;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 20.07.2018
 */

public class Factorial {
    /**
     * Вычисляем факториал числа.
     *
     * @param n вводим число.
     * @return факториал введеного числа.
     */
    public int add(int n) {
        int factorial = 1;
        for (int i = 1; i <= n; i++) {
            factorial *= i;
            }
        if (n == 0) {
            return 1;
        } else {
            return factorial;
        }
    }
}