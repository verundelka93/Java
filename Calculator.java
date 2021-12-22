
import java.util.InputMismatchException;
import java.util.Scanner;


public class Calculator {

    static int a, b;
    static char operation;
    static int result;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input ");
        String str = scanner.nextLine();
        char[] under_char = new char[10];
        for (int i = 0; i < str.length(); i++) {
            under_char[i] = str.charAt(i);
            if (under_char[i] == '+') {
                operation = '+';
            }
            if (under_char[i] == '-') {
                operation = '-';
            }
            if (under_char[i] == '*') {
                operation = '*';
            }
            if (under_char[i] == '/') {
                operation = '/';
            }
        }
        String under_charString = String.valueOf(under_char);
        String[] blacks = under_charString.split("[+-/*]");
        String s = blacks[0];
        String s1 = blacks[1];
        String s3 = s1.trim();
        a = romanToNumber(s);
        b = romanToNumber(s3);
        if (a < 0 && b < 0) {
            result = 0;
        } else {
            result = calculated(a, b, operation);

            String resultRoman = convertNumToRoman(result);
            System.out.println("Output ");
            System.out.println(resultRoman);
        }
        a = Integer.parseInt(s);
        b = Integer.parseInt(s3);
        result = calculated(a, b, operation);
        System.out.println("Output");
        System.out.println(result);
    }

    private static String convertNumToRoman(int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX",
                "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL",
                "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L"};

        final String s = roman[numArabian];
        return s;
    }

    private static int romanToNumber(String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }
        } catch (InputMismatchException e) {
            throw new InputMismatchException("Неверный формат данных");
        }
        return -1;
    }

    public static int calculated(int a, int b, char op) {
        int result = 0;
        switch (op) {
            case '+':
                result = a + b;
                break;
            case '-':
                result = a - b;
                break;
            case '*':
                result = a * b;
                break;
            case '/':
                try {
                    result = a / b;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Exception : " + e);
                    break;
                }
                break;
            default:
                System.out.println("Ошибка! Повторите ввод");
        }
        return result;
    }
}




