package ru.job4j.chess;

import org.junit.Test;
import ru.job4j.chess.figures.Bishop;
import ru.job4j.chess.figures.Cell;

public class BoardTest {
    Board board = new Board();
    /**
     * Тест при добавлении нескольких фигур в одну ячейку.
     */
    @Test(expected = ImpossibleToAddFigure.class)
    public void whenAddFigureToTheSameCellThenThrowsException() throws ImpossibleToAddFigure {
        Bishop bishop = new Bishop(new Cell(1, 1));
        board.add(bishop);
        Bishop bishop2 = new Bishop(new Cell(1, 1));
        board.add(bishop2);
    }
    /**
     * Тест когда движение из пустой ячейки, нет фигуры.
     */
    @Test(expected = FigureNotFoundException.class)
    public void whenMovesFromTheEmptyCellThenThrowsException() throws Exception {
        this.board.move(new Cell(2, 2), new Cell(3, 3));
    }
    /**
     * Тест когда фигура двигается на занятую ячейку.
     */
    @Test(expected = ImpossibleMoveException.class)
    public void whenDestinationCellIsBusyThenThrowsException()
            throws ImpossibleMoveException, ImpossibleToAddFigure, OccupiedWayException, FigureNotFoundException,
            FigureWasNotMoved {
        Bishop bishop = new Bishop(new Cell(1, 1));
        board.add(bishop);
        Bishop bishop2 = new Bishop(new Cell(2, 2));
        board.add(bishop2);
        board.move(bishop.position, new Cell(2, 2));
    }
    /**
     * Тест когда по ходу движения фигуры заняты клетки.
     */
    @Test(expected = OccupiedWayException.class)
    public void whenTheWayIsBusyThenThrowsException() throws Exception {
        Bishop bishop = new Bishop(new Cell(1, 1));
        board.add(bishop);
        Bishop bishop2 = new Bishop(new Cell(2, 2));
        board.add(bishop2);
        this.board.move(new Cell(1, 1), new Cell(3, 3));
    }
}

