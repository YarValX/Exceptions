package Seminar3;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Введите данные в формате: Фамилия Имя Отчество датарождения номертелефона пол");
        String input = scanner.nextLine();

        String[] data = input.split(" ");

        if (data.length != 6) {
            System.out.println("Ошибка: неверное количество данных");
            return;
        }

        String lastName = data[0];
        String firstName = data[1];
        String middleName = data[2];
        String birthDate = data[3];
        String phoneNumber = data[4];
        String gender = data[5];

        try {
            validateData(lastName, firstName, middleName, birthDate, phoneNumber, gender);

            String fileName = lastName + ".txt";
            String content = lastName + firstName + middleName + birthDate + " " + phoneNumber + gender;

            writeToFile(fileName, content);

            System.out.println("Данные успешно записаны в файл " + fileName);
        } catch (InvalidDataException e) {
            System.out.println("Ошибка: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл: " + e.getMessage());
            e.printStackTrace();
        }
    }

    private static void validateData(String lastName, String firstName, String middleName, String birthDate, String phoneNumber, String gender) throws InvalidDataException {
        if (lastName.isEmpty() || firstName.isEmpty() || middleName.isEmpty() || birthDate.isEmpty() || phoneNumber.isEmpty() || gender.isEmpty()) {
            throw new InvalidDataException("Некоторые данные отсутствуют");
        }

        // Ваши дополнительные проверки данных

        // Пример проверки формата даты рождения
        if (!birthDate.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) {
            throw new InvalidDataException("Неверный формат даты рождения");
        }

        // Пример проверки формата номера телефона
        if (!phoneNumber.matches("\\d+")) {
            throw new InvalidDataException("Неверный формат номера телефона");
        }

        // Пример проверки значения пола
        if (!gender.equals("f") && !gender.equals("m")) {
            throw new InvalidDataException("Неверное значение пола укажите m или f");
        }
    }

    private static void writeToFile(String fileName, String content) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName, true));
        writer.write(content);
        writer.newLine();
        writer.close();
    }

    static class InvalidDataException extends Exception {
        public InvalidDataException(String message) {
            super(message);
        }
    }
}