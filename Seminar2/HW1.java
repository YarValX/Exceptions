package Seminar2;

import java.util.Scanner;

public class HW1 {
    public static float getFloatInput() {
        Scanner scanner = new Scanner(System.in);
        float number = 0.0f;
        boolean validInput = false;

        while (!validInput) {
            try {
                System.out.print("Введите дробное число: ");
                String input = scanner.nextLine();
                number = Float.parseFloat(input);
                validInput = true;
            } catch (NumberFormatException e) {
                System.out.println("Ошибка: введено некорректное значение. Пожалуйста, повторите ввод.");
            }
        }

        return number;
    }

    public static void main(String[] args) {
        float userInput = getFloatInput();
        System.out.println("Введенное число: " + userInput);
    }
}