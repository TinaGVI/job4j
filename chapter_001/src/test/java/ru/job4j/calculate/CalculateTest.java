package ru.job4j.calculate;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

/**
* Test.
*
* @author TinaGVI (mailto:eleonor111@list.ru)
* @since 18.07.2018
*/

public class CalculateTest {
    @Test
    public void whenAddOnePlusOneThenTwo() {
        Calculate calc = new Calculate();
        calc.add(1D, 1D);
        double result = calc.getResult();
        double expected = 2D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenSubOneSubtractOneThenNull() {
        Calculate calc = new Calculate();
        calc.subtract(11.12, 10.11);
        double result = calc.getResult();
        double expected = 1.01;
//        assertThat(result, is(expected));
        assertEquals(result, expected, 0.01);
    }
    @Test
    public void whenDiOneDivOneThenOne() {
        Calculate calc = new Calculate();
        calc.div(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
    @Test
    public void whenMultOneMultipleOneThenOne() {
        Calculate calc = new Calculate();
        calc.multiple(1D, 1D);
        double result = calc.getResult();
        double expected = 1D;
        assertThat(result, is(expected));
    }
}