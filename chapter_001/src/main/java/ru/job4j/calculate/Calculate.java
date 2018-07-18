package ru.job4j.calculate;
/**
* @author TinaGVI (mailto:eleonor111@list.ru)
* @since 18.07.18
*/
public class Calculate {
	private double result;

	public void add(double first, double second) {
		this.result = first + second;
	}

	public double getResult() {
		return this.result;
	}

	public void subtract(double first, double second) {
		this.result = first - second;
	}

	public void div(double first, double second) {
		this.result = first / second;
	}

	public void multiple(double first, double second) {
		this.result = first * second;
	}
}