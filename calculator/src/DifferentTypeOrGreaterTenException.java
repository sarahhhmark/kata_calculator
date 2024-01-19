class DifferentTypeOrGreaterTenException extends Exception {
    // Исключение, если:
    // 1. Введенные числа разным систем счисления
    // 2. Одно из чисел больше 10 (или сразу оба числа)
    // 3. Введено не число.
    public DifferentTypeOrGreaterTenException(String message) {
        super(message);
    }
}
