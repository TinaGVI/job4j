package ru.job4j.strategy;

/**
 * @author TinaGVI
 * @since 19.08.2018
 */
public class Paint {
    /**
     * Вспомогательный класс для рисования фигур для проверки полиморфизма.
     *
     * @param shape - фигуры.
     */
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    /**
     * Рисуем фигуру.
     *
     * @param args
     */
    public static void main(String[] args) {
        Paint paint = new Paint();
        Shape[] shape = new Shape[2];
        shape[0] = new Square();
        shape[1] = new Triangle();
        for (int i = 0; i < shape.length; i++) {
            paint.draw(shape[i]);
        }
    }
}