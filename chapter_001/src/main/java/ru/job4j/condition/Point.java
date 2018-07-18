package ru.job4j.condition;
/**
 * Расстояние между точками.
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 18.07.18
 */
public class Point {
    private int x;
    private int y;

    /**
     * Вписываем координаты.
     * @param x координата по оси X.
     * @param y координата по оси Y.
     */

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * Возвращаем расстояние между координат.
     * @param that другая точка, до которой нужно узнать расстояние.
     * @return расстояние между координатами.
     */
    public double distanceTo(Point that) {
        return Math.sqrt(
                Math.pow(this.x - that.x, 2) + Math.pow(this.y - that.y, 2)
        );
    }

    /**
     * main.
     * @param args
     */
    public static void main(String[] args) {
        Point a = new Point(0, 1);
        Point b = new Point(2, 5);

        System.out.println("x1 = " + a.x);
        System.out.println("y1 = " + a.y);
        System.out.println("x2 = " + b.x);
        System.out.println("y2 = " + b.y);

        double result = a.distanceTo(b);
        System.out.println("Расстояние между точками А и В : " + result);
    }
}
