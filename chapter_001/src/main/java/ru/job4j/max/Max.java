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
	public int max(int first, int second, int third) {
		/**
		 * Сравниваем числа.
		 * @param first первое число.
		 * @param second второе число.
		 * @param third третье число.
		 * @return максимум из трех чисел.
		 */
		int maxFS = this.max(first, second);
		return this.max(maxFS, third);
	}
}