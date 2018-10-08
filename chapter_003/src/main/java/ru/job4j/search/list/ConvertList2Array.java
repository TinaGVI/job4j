package ru.job4j.search.list;

/**
 * Класс конвертация ArrayList в двухмерный массив.
 *
 * @author TinaGVI
 * @since 08.10.2018
 */

import java.util.List;

public class ConvertList2Array {
    /**
     * @param list
     * @param rows
     * @return
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int size = list.size();
        int cells = size % rows == 0 ? size / rows : size / rows + 1;
        int[][] array = new int[rows][cells];
        int count = 0;
        for (int row = 0; row != rows; row++) {
            for (int cell = 0; cell != cells; cell++) {
                array[row][cell] = count >= size ? 0 : list.get(count++);
            }
        }
        return array;
    }
}

