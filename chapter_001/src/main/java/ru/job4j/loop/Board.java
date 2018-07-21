package ru.job4j.loop;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 21.07.2018
 */
public class Board {
    /**
     * Построение шахматной доски в псевдографике.
     *
     * @param width  вводим ширину.
     * @param height вводим высоту.
     * @return визуальную шахматную доску.
     */
    public String paint(int width, int height) {
        StringBuilder screen = new StringBuilder();
        String ln = System.lineSeparator();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                if ((i + j) % 2 == 0) {
                    screen.append("X");
                } else {
                    screen.append(" ");
                }
            }
            screen.append(ln);
        }
        return screen.toString();
    }
}