import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

public class Calculator implements Calculating {
    public static final BigDecimal MONTHS_IN_YEAR = new BigDecimal(12);
    public static final BigDecimal PROCENT = new BigDecimal(100);

    @Override
    public BigDecimal monthPay(BigDecimal years, BigDecimal sum, BigDecimal procent) {
        return allSum(years, sum, procent).divide(MONTHS_IN_YEAR.multiply(years), MathContext.DECIMAL64).setScale(2,RoundingMode.CEILING);
    }

    @Override
    public BigDecimal allSum(BigDecimal years, BigDecimal sum, BigDecimal procent) {
        return sum.add(overPay(years,sum,procent)).setScale(2, RoundingMode.CEILING);
    }

    @Override
    public BigDecimal overPay(BigDecimal years, BigDecimal sum, BigDecimal procent) {
        return sum.divide(PROCENT).multiply(procent.multiply(years).setScale(2, RoundingMode.CEILING));
    }
}
