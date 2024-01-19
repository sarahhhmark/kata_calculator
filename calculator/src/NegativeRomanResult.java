class NegativeRomanResult extends Exception {
    //Исключение, если для римских чисел получен отрицательный результат, например для: I - X или I / V
    public NegativeRomanResult(String message) {
        super(message);
    }
}