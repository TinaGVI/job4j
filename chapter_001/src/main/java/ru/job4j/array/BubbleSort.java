package ru.job4j.array;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 23.07.2018
 */
public class BubbleSort {
    /**
     * Сортируем массив методом перестановки (пузырковый метод).
     *
     * @param array массив который надо отсортировать.
     * @return отсортированный массив.
     */
    public int[] sort(int[] array) {
        int temp;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }

            }
        }
        return array;
    }
}
