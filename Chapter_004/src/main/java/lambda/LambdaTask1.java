package lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 06.12.2018
 *
 * Класс реализует подсчет функций в диапазоне.
 *
 * Линейная функция.
 * Квадратичная функция.
 * Логарфмическая функция.
 *
 */
public class LambdaTask1 {
    Function<Double, Double> lineFunction = x -> 2 * x + 1;

    Function<Double, Double> quadraticFunction = x -> Math.pow(x, 2) + 2 * x + 3;

    Function<Double, Double> logarithmicFunction = x -> Math.log(x);

    /**
     * Считает функцию переданную в параметре.
     * @param first
     * @param second
     * @param func
     * @return
     */
    public List<Double> diapason(int first, int second, Function<Double, Double> func) {
        List<Double> result = new ArrayList<Double>();
        for (int i = first; i < second; i++) {
            result.add(func.apply((double) i));
        }
        return result;
    }
}