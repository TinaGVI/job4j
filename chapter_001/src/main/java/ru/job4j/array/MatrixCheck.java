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
            if (data[0][0] != data[i][i]) {
                result = false;
                break;
            }
            if (data[0][data.length - 1] != data[i][data.length - 1 - i]) {
                result = false;
                break;
            }
        }
        return result;
    }
}