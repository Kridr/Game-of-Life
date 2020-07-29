import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (x, y) -> {
        long res = 1;

        for (var i = x; i <= y; i++) {
            res *= i;
        }

        return res;
    };
}