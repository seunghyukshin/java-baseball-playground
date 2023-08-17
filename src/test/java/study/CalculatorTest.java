package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.IOException;
import java.util.Scanner;
import java.util.Stack;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {

    @Test
    public void calculate() throws IOException {
//        Scanner scanner = new Scanner(System.in);
//        String value = scanner.nextLine();
        String value = "2 + 3 * 4 / 2";
        String[] values = value.split(" ");

        int result = 0;
        String operator = "";
        for (int i = 0; i < values.length; i++) {
            if (_isDigit(values[i])) {
                result = _calculate(result, Integer.parseInt(values[i]), operator);
            } else {
                operator = values[i];
            }
        }

        assertThat(result).isEqualTo(10);
    }

    private boolean _isDigit(String value) {
        char c = value.charAt(0);

        return c >= '0' && c <= '9';
    }


    private static int _calculate(int result, int value, String operator) {
        if ("+".equals(operator)) {
            return result + value;
        }
        if ("-".equals(operator)) {
            return result - value;
        }
        if ("*".equals(operator)) {
            return result * value;
        }
        if ("/".equals(operator)) {
            return result / value;
        }
        return value;
    }

}
