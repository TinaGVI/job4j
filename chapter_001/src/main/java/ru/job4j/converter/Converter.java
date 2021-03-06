package ru.job4j.converter;
/**
 * Корвертор валюты.
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 18.07.18
 */
public class Converter {

    /**
     * Конвертируем рубли в евро.
     * @param value рубли.
     * @return Евро.
     */
    public int rubleToEuro(int value) {
        return value / 70;
    }

    /**
     * Конвертируем рубли в доллары.
     * @param value рубли.
     * @return Доллары.
     */
    public int rubleToDollar(int value) {
        return value / 60;
    }

    /**
     * Конвертируем евро в рубли.
     * @param value рубли.
     * @return Рубли.
     */
    public int euroToRuble(int value) {
        return value * 70;
    }

    /**
     * Конвертируем доллары в рубли.
     * @param value рубли.
     * @return Рубли.
     */
    public int dollarToRuble(int value) {
        return value * 60;
    }
}