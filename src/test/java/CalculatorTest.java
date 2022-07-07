import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigDecimal;
import java.util.stream.Stream;

public class CalculatorTest {

    public static Calculating calculating = null; // здесь будет реализация метода

    @ParameterizedTest
    @MethodSource("monthPayTest")
    public void testOverPay(BigDecimal years, BigDecimal sum, BigDecimal procent, BigDecimal result) {
        BigDecimal monthlyPay = calculate.monthlyPay(years, sum, procent);
        Assertions.assertEquals(result, monthlyPay);
    }

    @ParameterizedTest
    @MethodSource("sumPayTest")
    public void testSum(BigDecimal years, BigDecimal sum, BigDecimal procent, BigDecimal result) {
        BigDecimal sumToPay = calculate.monthlyPay(years, sum, procent);
        Assertions.assertEquals(result, sumToPay);
    }

    @ParameterizedTest
    @MethodSource("overPayTest")
    public void testSum(BigDecimal years, BigDecimal sum, BigDecimal procent, BigDecimal result) {
        BigDecimal overPay = calculate.monthlyPay(years, sum, procent);
        Assertions.assertEquals(result, overPay);
    }

    public static Stream<Arguments> monthPayTest2() {
        return Stream.of(Arguments.of(new BigDecimal(1), new BigDecimal(10000), new BigDecimal(20), new BigDecimal("1000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(5000), new BigDecimal(20), new BigDecimal("500.00")),
                Arguments.of(new BigDecimal(2), new BigDecimal(6000), new BigDecimal(10), new BigDecimal("300.00")),
                Arguments.of(new BigDecimal("0.5"), new BigDecimal(10000), new BigDecimal(40), new BigDecimal("2000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(1000), new BigDecimal("12.5"), new BigDecimal("93.75")));
    }

    public static Stream<Arguments> sumPayTest() {
        return Stream.of(Arguments.of(new BigDecimal(1), new BigDecimal(10000), new BigDecimal(20), new BigDecimal("12000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(5000), new BigDecimal(20), new BigDecimal("6000.00")),
                Arguments.of(new BigDecimal(2), new BigDecimal(6000), new BigDecimal(10), new BigDecimal("7200.00")),
                Arguments.of(new BigDecimal("0.5"), new BigDecimal(10000), new BigDecimal(40), new BigDecimal("12000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(1000), new BigDecimal("12.5"), new BigDecimal("1125.00")));
    }

    public static Stream<Arguments> overPayTest() {
        return Stream.of(Arguments.of(new BigDecimal(1), new BigDecimal(10000), new BigDecimal(20), new BigDecimal("2000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(5000), new BigDecimal(20), new BigDecimal("1000.00")),
                Arguments.of(new BigDecimal(2), new BigDecimal(6000), new BigDecimal(10), new BigDecimal("1200.00")),
                Arguments.of(new BigDecimal("0.5"), new BigDecimal(10000), new BigDecimal(40), new BigDecimal("2000.00")),
                Arguments.of(new BigDecimal(1), new BigDecimal(1000), new BigDecimal("12.5"), new BigDecimal("125.00")));
    }

}
