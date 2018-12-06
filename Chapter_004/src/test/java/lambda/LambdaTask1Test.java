package lambda;

import com.sun.org.apache.xerces.internal.util.PropertyState;
import org.junit.Test;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

/**
 * Test
 *
 * @author TinaGVI (mailto:eleonor111@list.ru)
 * @since 06.12.2018
 *
 * Класс реализует тест подсчета функций в диапазоне.
 *
 * Линейная функция.
 * Квадратичная функция.
 * Логарфмическая функция.
 *
 */
public class LambdaTask1Test {
    @Test
    public void lineFunction() {
        LambdaTask1 lambdaTask1 = new LambdaTask1();
        List<Double> result = new ArrayList<Double>();
        result = lambdaTask1.diapason(1, 4, lambdaTask1.lineFunction);
        assertThat(result, is(Arrays.asList(3D, 5D, 7D)));
    }

    @Test
    public void quadraticFunction() {
        LambdaTask1 lambdaTask1 = new LambdaTask1();
        List<Double> result = new ArrayList<Double>();
        result = lambdaTask1.diapason(1, 4, lambdaTask1.quadraticFunction);
        assertThat(result, is(Arrays.asList(6D, 11D, 18D)));
    }

    @Test
    public void logarithmicFunction() {
        LambdaTask1 lambdaTask1 = new LambdaTask1();
        List<Double> result = new ArrayList<Double>();
        result = lambdaTask1.diapason(1, 4, lambdaTask1.logarithmicFunction);
        assertThat(result, is(Arrays.asList(0D, 0.6931471805599453D, 1.0986122886681098D)));
    }

    private void assertThat(List<Double> result, PropertyState propertyState) {
    }
}