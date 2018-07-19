package ru.job4j.max;
/**
 * Max из двух чисел Test.
 *
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 19.07.2018
 */
import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class MaxTest {
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
}