package ru.job4j.list;

/**
 * Test конвертации двумерного массива в ArrayList.
 *
 * @author TinaGVI
 * @since 10.10.2018
 */

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ConvertMatrix2ListTest {
    @Test
    public void when2on2ArrayThenList4() {
        ConvertMatrix2List list = new ConvertMatrix2List();
        int[][] input = {
                {7, 3},
                {2, 9}
        };
        List<Integer> expect = Arrays.asList(
                7, 3, 2, 9
        );
        List<Integer> result = list.toList(input);
        assertThat(result, is(expect));
    }
}