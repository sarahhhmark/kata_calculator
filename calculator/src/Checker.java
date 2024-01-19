class Checker {
    public static String check(String expression) throws IncorrectExpressionFormat, UnknownOperationException,
            DifferentTypeOrGreaterTenException, NegativeRomanResult {

        IncorrectExpressionFormat format_exception;
        format_exception = new IncorrectExpressionFormat("Введено выражение неверного формата. " +
                "Введите выражение наподобии a + b (через пробел)."); // исключение для ситуации, когда введено выражение неправильного формата,
        // например: 6 *9, 7 + 8 - 8, 5+9 и т.д.

        DifferentTypeOrGreaterTenException diff_types;
        diff_types = new DifferentTypeOrGreaterTenException("Введенные числа разных форматов либо одно из чисел больше 10. " +
                "Калькулятор умеет работать только с числами от 1 до 10 включительно."); // исключение для ситуации, когда одно из чисел > 10,
        // или если введено выражение: 6 + II или X * 7. Также исключение выбрасывается, вместо числа введен другой символ, например: @ * 9.

        UnknownOperationException unknown_operation;
        unknown_operation = new UnknownOperationException("Неизвестная операция. Калькулятор умеет вычислять только сумму (+), " +
                "разность (-), умножение (*) и деление (/)."); // исключение срабатывает, если в введенном выражении требуется выполнить операцию,
        // которая не является сложением, умножением, вычитанием, делением.

        NegativeRomanResult negative_result;
        negative_result = new NegativeRomanResult("Получен отрицательный результат для римской системы счисления."); //исключение выбрасывается,
        // если для римских чисел получился результат < 1.

        int first_num;
        int second_num;
        int result;
        String[] elements = expression.split(" "); // разбиваем введенное выражение

        if (elements.length != 3) throw format_exception; // проверка на соответствие введенного выражения требуемому формату,
        // если проверка не проходит, то выбрасывается соответствующее исключение

        String first = elements[0]; // присваиваем значения соответствующим переменным
        String second = elements[2];
        String operation = elements[1];
        String s = Number.numbersType(first, second); // вызываем метод, который проверяет, введенные числа принадлежат одному формату или нет.
        // Передаем в метод числа. Метод возвращает строку: "roman" - оба числа римские; "arabic" - оба числа арабские;
        // "exception" - числа разных форматов, либо одно из чисел больше 10

        if (s.equals("exception")) throw diff_types; // если метод numbersType вернул строку "exception", то выбрасывается исключение, что числа разных форматов.
        else if (s.equals("roman")) {
            first_num = Integer.parseInt(Number.roman_arabic_digits.get(first));
            second_num = Integer.parseInt(Number.roman_arabic_digits.get(second));
            // если метод вернул "roman", то мы переводим 1 и 2 число в арабские, в тип данных int, чтобы было легче посчитать результат.

        } else {
            first_num = Integer.parseInt(first);
            second_num = Integer.parseInt(second);
            // если метод вернул "arabic", то мы просто эти числа, которые пока что имеют тип данных String, переводим в тип данных int
        }

        result = switch (operation) {
            case "+" -> first_num + second_num;
            case "*" -> first_num * second_num;
            case "-" -> first_num - second_num;
            case "/" -> first_num / second_num;
            default -> throw unknown_operation;
        };
        // Проверяем, какую операцию необходимо произвести и производим ее (т.е. подсчитываем результат).
        // Если ни одна из операций не соответствует, то выбрасывается исключение о том, что введена неизвестная операция и калькулятор не умеет ее осуществлять.

        if (result < 1 && s.equals("roman")) throw negative_result; // если для римских чисел получен отрицательный результат,
        // то выбрасывается исключение

        if (s.equals("roman"))
            return Number.fromIntToRoman(result); // если римские числа, то результат нам тоже нужно перевести в римское число,
            // поэтому вызываем метод, который переводит арабское число в римское.
        else
            return String.format("%d", result); // если число арабское, то преобразовываем его в строку
    }
}
