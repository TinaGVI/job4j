package ru.job4j.array;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 22.07.2018
 */
public class Turn {
    /**
     * Переворот массива.
     *
     * @param array массив изначальный.
     * @return массив перевернутый.
     */
    public int[] turn(int[] array) {
        for (int i = 0, j = array.length - 1; i < j; i++, j--) {
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
        return array;
    }
}
