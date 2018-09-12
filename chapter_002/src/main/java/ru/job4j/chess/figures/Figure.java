package ru.job4j.chess.figures;

import ru.job4j.chess.ImpossibleMoveException;

/**
 * Class
 *
 * @author TinaGVI
 * @since 12.09.18
 */
public abstract class Figure {
    /**
     * Координата фигуры
     */
    public final Cell position;

    /**
     * Конструктор для добавления фигуры.
     *
     * @param cell начальное поле фигуры.
     */
    Figure(Cell cell) {
        this.position = cell;
    }

    /**
     * Метод определения траектории хода фигурой.
     *
     * @param source начальное поле фигуры.
     * @param dest   поле назначения.
     */
    public Cell[] way(Cell source, Cell dest) throws ImpossibleMoveException, ImpossibleMoveException {
        return null;
    }

    /**
     * Метод создания копии текущей фигуры в новой ячейке.
     *
     * @param dest поле назначения.
     */
    public abstract Figure copy(Cell dest);
}
