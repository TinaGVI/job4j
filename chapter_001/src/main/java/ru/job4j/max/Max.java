package ru.job4j.max;

/**
* Max из двух чисел.
*
* @author TinaGVI (mailto:eleonor111@list.ru)
* @since 19.07.2018
*/

public class Max {
    /**
     * Сравниваем числа.
     * @param first первое число.
     * @param second второе число.
     * @return максимум из двух чисел.
     */
	public int max(int first, int second) {
		return (first > second) ? first : second;
	}
}