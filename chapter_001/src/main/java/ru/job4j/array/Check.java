package ru.job4j.array;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 22.07.2018
 */
public class Check {
    /**
     * Массив заполнен true или false, нужно вывести true или false.
     *
     * @param data Массив заполнен true или false.
     * @return выводим true или false.
     */
    public boolean mono(boolean[] data) {
        boolean result = true;
        for (int i = 1; i < data.length; i++) {
            if (data[i] != data[i - 1]) {
                result = false;
                break;
            }
        }
        return result;
    }
}