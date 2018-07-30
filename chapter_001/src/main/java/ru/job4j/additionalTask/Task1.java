package ru.job4j.additionalTask;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 27.07.2018
 */
public class Task1 {
    /**
     * Объединяем два отсортированных массива в третий отсортированый.
     *
     * @param first первый  массив.
     * @param second второй  массив.
     * @return третий объединеный массив.
     */
    public static int[] unite(int[] first, int[] second) {
        int[] third = new int[first.length + second.length];

        for (int i = 0, i1 = 0, i2 = 0; i < third.length; i++) {

            if (i1 < first.length  && i2 < second.length) {
                third[i] = first[i1] < second [i2] ? first [i1++] : second [i2++];

            } else if (i1 < first.length  && i2 >= second.length) {
                third[i] = first[i1++];
            } else if (i1 >= first.length  && i2 < second.length) {
                third[i] = second[i2++];
            }
        }
        return third;
    }
}
