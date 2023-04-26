import java.util.InputMismatchException;
import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {
        System.out.println("Введите выражение");
        System.out.println(calc(scanner.nextLine()));
    }

    static Scanner scanner = new Scanner(System.in);
    static int number1, number2;
    static char operator;
    static int result;
    static int count;
    static String resultString = null;

    private static int calc(int a, int b, char operation) {
        if (operation == '+') return a + b;
        else if (operation == '*') return a * b;
        else if (operation == '-') return a - b;
        else if (operation == '/') {
            if (a > 0) return a / b;
            else throw new ArithmeticException();
        }
        return -1;
    }

    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",//нахуя 0?
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX",
                "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX",
                "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX",
                "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC",
                "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"
        };
        String s = roman[numArabian];
        return s;
    }

    private static int romeToNumber(String name) {
        return switch (name) {
            case "I" -> 1;
            case "II" -> 2;
            case "III" -> 3;
            case "IV" -> 4;
            case "V" -> 5;
            case "VI" -> 6;
            case "VII" -> 7;
            case "VIII" -> 8;
            case "IX" -> 9;
            case "X" -> 10;
            default -> -1;
        };

    }

    public static String calc(String input) {
        char[] array = new char[input.length()];
        for (int i = 0; i < input.length(); i++) {
            array[i] = input.charAt(i);
            if (array[i] == '+') {
                if (count > 0) throw new ArithmeticException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                count++;
                operator = '+';
            }
            if (array[i] == '-') {
                if (count > 0) throw new ArithmeticException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                count++;
                operator = '-';
            }
            if (array[i] == '/') {
                if (count > 0) throw new ArithmeticException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                count++;
                operator = '/';
            }
            if (array[i] == '*') {
                if (count > 0) throw new ArithmeticException("т.к. формат математической операции не удовлетворяет заданию - два операнда и один оператор (+, -, /, *)");
                count++;
                operator = '*';
            }
        }
        String text = String.valueOf(array);
        text = text.replaceAll("\\s+", "");
        if (count == 0) throw new InputMismatchException("т.к. строка не является математической операцией");
        String[] textArray = text.split("[+-/*]");
        String a = textArray[0];
        String b = textArray[1];
        number1 = romeToNumber(a);
        number2 = romeToNumber(b);
        if (number1 < 0 && number2 < 0) {
//           Арабские числа
            number1 = Integer.parseInt(a);
            number2 = Integer.parseInt(b);
            if (number1 < 1 || number1 > 10) {
                throw new InputMismatchException();
            } else if (number2 < 1 || number2 > 10) {
                throw new InputMismatchException();
            } else {
                resultString = String.valueOf(calc(number1, number2, operator));
            }

        }
//        Римские Числа
        else if (number1 < 0 || number2 < 0) {
            throw new InputMismatchException("т.к. используются одновременно разные системы счисления");
        } else {
            result = calc(number1, number2, operator);
            if (result < 1) {
                throw new ArithmeticException("т.к. в римской системе нет отрицательных чисел");
            } else {
                resultString = convertNumToRoman(result);
            }
        }
        return resultString;
    }


}

