package ru.job4j.search.list;

/**
 * Конвертация двумерного массива в ArrayList.
 *
 * @author TinaGVI
 * @since 10.10.2018
 */

import java.util.ArrayList;
import java.util.List;

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
        for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
        }
        return list;
    }
}