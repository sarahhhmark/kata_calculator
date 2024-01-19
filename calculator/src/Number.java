import org.jetbrains.annotations.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

class Number {

    static String[] roman_digit = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X"};
    static String[] roman_num = {"C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    static String[] arabic_digit = {"1", "2", "3", "4", "5", "6", "7", "8", "9", "10"};
    static int[] arabic_num = {100, 90, 50, 40, 10, 9, 5, 4, 1};
    // выше объявленные переменные необходимы для того, чтобы с их помощью сформировать словари типа

    static Map <String, String> roman_arabic_digits = new LinkedHashMap<>(); // {"I": 1, "II": 2 ... "X": 10} - словарь для перевода римских чисел от 1 до 10 в арабские
    static Map <Integer, String> arabic_roman_num = new LinkedHashMap<>(); // {100: "C", 90: "XC" ... 1: "I"} - словарь необходим для перевода
    // римских чисел в арабские (от 1 до 399 для экономии памяти, т.к. максимальный результат, который можно получить - это 100 (10 * 10).

    static void initializeNumberMap() { // этот метод лишь автоматизированно формирует необходимые нам словари
        for (int i = 0; i < 10; i++) {
            roman_arabic_digits.put(roman_digit[i], arabic_digit[i]);
        }
        for (int i = 0; i < 9; i++) {
            arabic_roman_num.put(arabic_num[i], roman_num[i]);
        }
    }
    static @NotNull String numbersType(String first_num, String second_num) { // этот метод проверяет,
        // переданные ему числа - оба римские или оба арабские. В первом случае метод возвращает строку "roman",
        // во втором "arabic", иначе возвращает "exception"

        initializeNumberMap(); // вызываем данный метод, чтобы он сформировал нам словари.
        if (roman_arabic_digits.containsKey(first_num) && roman_arabic_digits.containsKey(second_num)) return "roman";
        else if (roman_arabic_digits.containsValue(first_num) && roman_arabic_digits.containsValue(second_num)) return "arabic";
        else return "exception";
    }

    @org.jetbrains.annotations.NotNull
    static String fromIntToRoman(int number) { // этот метод переводит арабские числа от 1 до 399 в римские
        StringBuilder result = new StringBuilder();

        while (number > 0) {
            for (Map.Entry<Integer, String> entry : arabic_roman_num.entrySet()) {
                Integer key = entry.getKey();
                String value = entry.getValue();
                while (number >= key) {
                    result.append(value);
                    number -= key;
                }
            }
        }
        return result.toString();
    }
}

