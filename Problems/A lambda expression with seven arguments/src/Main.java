class Seven {

    public static MultipleArgumentsLambda.SeptenaryStringFunction fun =
            (a, b, c, d, e, f, g) -> {
                String result = a + b + c + d + e + f + g;
                return result.toUpperCase();
            };
}