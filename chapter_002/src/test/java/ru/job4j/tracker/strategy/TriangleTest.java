package ru.job4j.tracker.strategy;

import org.junit.Test;
import ru.job4j.strategy.Triangle;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * @author TinaGVI
 * @since 19.08.2018
 */
public class TriangleTest {
    @Test
    public void whenDrawTriangle() {
        Triangle triangle = new Triangle();
        assertThat(triangle.draw(), is(new StringBuilder()
                        .append("  +\n")
                        .append(" +++\n")
                        .append("+++++\n")
                        .toString()
                )
        );
    }
}
