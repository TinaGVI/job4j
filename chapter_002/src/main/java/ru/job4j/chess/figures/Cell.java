package ru.job4j.chess.figures;

/**
 * Class
 *
 * @author TinaGVI
 * @since 12.09.18
 */
public class Cell {
    /**
     * Координата ячейки по горизонтали
     */
    public int h;
    /**
     * Координата ячейки по вертикали
     */
    public int v;

    public Cell(int h, int v) {
        this.h = h;
        this.v = v;
    }
}
