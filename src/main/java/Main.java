import java.math.BigDecimal;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)){
            Calculator calculator = new Calculator();
            System.out.println("Credit time (per year)");
            BigDecimal years = scanner.nextBigDecimal();
            System.out.println("Credit sum");
            BigDecimal sum = scanner.nextBigDecimal();
            System.out.println("Credit interest rate");
            BigDecimal procent = scanner.nextBigDecimal();
            System.out.println("Pay for month "+ calculator.monthPay(years,sum,procent));
            System.out.println("Total sum "+ calculator.allSum(years,sum,procent));
            System.out.println("Total overpay "+ calculator.overPay(years,sum,procent));
        }
    }
}
