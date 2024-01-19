class IncorrectExpressionFormat extends Exception {
    // Исключение, если выражение введено неправильно (не соответствует формату), например:
    // 6* 9 (отсутствует пробел)
    // 6*9 (пробелы отсутствуют совсем)
    // 6 * 7 - 4 (сразу 3 числа)
    public IncorrectExpressionFormat(String message) {
        super(message);
    }
}
