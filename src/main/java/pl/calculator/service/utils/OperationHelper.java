package pl.calculator.service.utils;

public class OperationHelper {
    public static int parseInt(String value) {
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Value incompatible with operation type.");
        }
    }
}
