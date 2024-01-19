import javax.script.ScriptException;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws ScriptException, DifferentTypeOrGreaterTenException, UnknownOperationException,
            NegativeRomanResult, IncorrectExpressionFormat {

        Scanner expression_scanner = new Scanner(System.in); //это сканнер для ввода математического выражения, которое необходимо посчитать
        Scanner on_off_scanner = new Scanner(System.in); //это сканнер для ввода 0 или 1 (для переменной on_off, которая отвечает за работу цикла do while)

        int on_off = 1; // изначально ставим значение для данной переменной, а затем у нас будет возможность изменить значение через ввод

        System.out.println("Это приложение калькулятор!\n" +
                "Оно умеет находить сумму (+), разность (-), умножение (*) и деление (/) двух чисел.\n" +
                "Числа должны быть от 1 до 10 включительно (римские или арабские).");

        do {
            System.out.println("Для того, чтобы что-то посчитать, введи выражение, например: 5 * 7 или X / V (пробелы между знаком и число обязательны!)");
            String math_expression = expression_scanner.nextLine(); // вводим выражение, которое необходимо посчитать
            String result = calc(math_expression);
            // В этом методе производятся все проверки на правильность введенных данных и в случае чего, этот метод возбуждает исключение

            System.out.printf("%s = %s\n", math_expression, result); // если метод checker не выкинул нас из программы,
            // то значит, что выражение посчитано, и программа может вывести результат на экран, что тут и производится.
            System.out.println("Нужно еще что=то посчитать? Введи \n1 - да\n" +
                    "0 - нет.");
            on_off = on_off_scanner.nextInt(); // вводим значение для переменной on_off. Если введем 1, то программа предложит нам еще что-то посчитать,
            // если введем 0 (или любое другое значение), то программа прекратит свою работу.
        }
        while (on_off == 1); // программа работает, пока переменная on_off равна 1.
    }
    public static String calc(String input) throws UnknownOperationException, NegativeRomanResult, DifferentTypeOrGreaterTenException, IncorrectExpressionFormat {
        return Checker.check(input); // отправляем выражение на проверку в класс Checker метод checker.
    }
}

