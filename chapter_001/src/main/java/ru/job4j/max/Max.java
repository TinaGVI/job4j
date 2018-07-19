package ru.job4j.max;

/**
 *
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 20.07.2018
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
	/**
	 * Сравниваем числа.
	 * @param first первое число.
	 * @param second второе число.
	 * @param third третье число.
	 * @return максимум из трех чисел.
	 */
	public int max(int first, int second, int third) {
		return this.max(max(first, second), third);
	}
}