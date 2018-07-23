package ru.job4j.array;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 23.07.2018
 */
public class MatrixCheck {
    /**
     * Квадратный массив заполнен true или false по диагоналям.
     *
     * @param data расмер массивов.
     * @return таблицу с заполнеными true или false по диагоналям.
     */
    public boolean mono(boolean[][] data) {
        boolean result = true;
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (i == j && !data[i][j]) { // !false = true; !true = false
                    result = false;
                    break;
                }
            }
        }
        return result;
    }

}