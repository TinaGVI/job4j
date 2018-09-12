package ru.job4j.strategy;

import org.junit.Test;
import ru.job4j.strategy.Square;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author TinaGVI
 * @since 19.08.2018
 */
public class SquareTest {
    @Test
    public void whenDrawSquare() {
        Square square = new Square();
        assertThat(square.draw(), is(new StringBuilder()
                        .append("++++\n")
                        .append("+  +\n")
                        .append("+  +\n")
                        .append("++++\n")
                        .toString()
                )
        );
    }
}