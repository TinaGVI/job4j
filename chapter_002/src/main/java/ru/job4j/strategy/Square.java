package ru.job4j.strategy;

/**
 * @author TinaGVI
 * @since 19.08.2018
 */
public class Square implements Shape {
    /**
     * Метод возвращение фигуры.
     *
     * @return - нарисованый квадрат.
     */
    @Override
    public String draw() {
        StringBuilder pic = new StringBuilder();
        pic.append("++++\n");
        pic.append("+  +\n");
        pic.append("+  +\n");
        pic.append("++++\n");
        return pic.toString();
    }
}