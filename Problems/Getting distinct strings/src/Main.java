import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;


class Operator {

    public static UnaryOperator<List<String>> unaryOperator = x -> {
        var iterator = x.iterator();
        List<String> result = new ArrayList<>();

        while (iterator.hasNext()) {
            var elem = iterator.next();
            if (! result.contains(elem)) {
                result.add(elem);
            }
        }

        return result;
    };
}