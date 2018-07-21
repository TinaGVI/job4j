package ru.job4j.array;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 21.07.2018
 */
public class Square {
    /**
     * Заполняем массив степенями чисел.
     *
     * @param bound длина массива.
     * @return заполненый массив.
     */
    public int[] calculate(int bound) {
        int[] rst = new int[bound];
        for (int i = 1; i <= bound; i++) {
            rst[i - 1] = i * i;
        }
        return rst;
    }
}