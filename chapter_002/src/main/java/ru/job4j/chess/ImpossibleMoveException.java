package ru.job4j.chess;

/**
 * Class
 *
 * @author TinaGVI
 * @since 12.09.18
 */
public class ImpossibleMoveException extends Exception {
    public ImpossibleMoveException() {
    }

    public String toString() {
        return "ImpossibleMoveException!";
    }
}

/**
 * Class ImpossibleToAddFigure 002.8.1.
 */
class ImpossibleToAddFigure extends Exception {
    ImpossibleToAddFigure() {
    }

    public String toString() {
        return "ImpossibleToAddFigure!";
    }
}

/**
 * Class OccupiedWayException 002.8.1.
 */
class OccupiedWayException extends Exception {
    OccupiedWayException() {
    }

    public String toString() {
        return "OccupiedWayException!";
    }
}

/**
 * Class FigureNotFoundException 002.8.1.
 */
class FigureNotFoundException extends Exception {
    FigureNotFoundException() {
    }

    public String toString() {
        return "FigureNotFoundException!";
    }
}

/**
 * Class FigureWasNotMoved 002.8.1.
 */
//Если после всех проверок фигуру всё-таки не удалось передвинуть
class FigureWasNotMoved extends Exception {
    FigureWasNotMoved() {
    }

    public String toString() {
        return "FigureWasNotMoved!";
    }
}