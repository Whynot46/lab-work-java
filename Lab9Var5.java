import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Lab9Var5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        switch(task) {
            case 1:
                removeDuplicatesFromFile();
                break;

            case 2:
                searchInformaticsBooks();
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    // Задание 1: Удаление дубликатов из файла
    private static void removeDuplicatesFromFile() {
        try {
            // Создаем исходный файл
            PrintWriter writer = new PrintWriter("numbers_with_duplicates.txt");
            writer.println("3 5 3 8 5 12 8 3 7 12");
            writer.close();

            // Читаем числа, сохраняя уникальные
            Scanner fileScanner = new Scanner(new File("numbers_with_duplicates.txt"));
            Set<Integer> uniqueNumbers = new HashSet<>();

            while (fileScanner.hasNextInt()) {
                uniqueNumbers.add(fileScanner.nextInt());
            }
            fileScanner.close();

            // Записываем уникальные числа в новый файл
            PrintWriter resultWriter = new PrintWriter("unique_numbers.txt");
            for (int num : uniqueNumbers) {
                resultWriter.print(num + " ");
            }
            resultWriter.close();

            System.out.println("Уникальные числа сохранены в unique_numbers.txt");

        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом: " + e.getMessage());
        }
    }

    // Задание 2: Поиск книг по названию
    private static void searchInformaticsBooks() {
        try {
            // Создаем файл с книгами
            PrintWriter writer = new PrintWriter("books.txt");
            writer.println("Иванов Информатика 2015");
            writer.println("Петров Программирование 2020");
            writer.println("Сидоров Информатика 2018");
            writer.println("Иванов Алгоритмы 2019");
            writer.println("Кузнецов Информатика 2012");
            writer.close();

            BufferedReader reader = new BufferedReader(new FileReader("books.txt"));
            String line;
            boolean found = false;

            System.out.println("Книги с названием 'Информатика':");
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(" ");
                if (parts[1].equals("Информатика")) {
                    System.out.println("Автор: " + parts[0] + ", Год: " + parts[2]);
                    found = true;
                }
            }

            if (!found) {
                System.out.println("Книги с таким названием не найдены");
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Ошибка работы с файлом: " + e.getMessage());
        }
    }
}