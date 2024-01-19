class UnknownOperationException extends Exception {
    // Исключение, если операция НЕ +-*/. Например: 10 % 4
    public UnknownOperationException(String message) {
        super(message);
    }
}
