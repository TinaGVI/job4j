package ru.job4j.array;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 21.07.2018
 */
public class FindLoop {
    /**
     * Поиск элемента в массиве.
     *
     * @param data массив.
     * @param el   элемент который ищим.
     * @return индекс элемента.
     */
    public int indexOf(int[] data, int el) {
        int rst = -1;
        for (int index = 0; index < data.length; index++) {
            if (data[index] == el) {
                rst = index;
                break;
            }
        }
        return rst;
    }
}