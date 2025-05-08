import java.util.Scanner;

public class Lab6Var5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();
        scanner.nextLine(); // Очистка буфера

        switch(task) {
            case 1:
                System.out.println("Введите строку:");
                String str = scanner.nextLine();
                System.out.println("Результат: " + processAsterisks(str));
                break;

            case 2:
                System.out.println("Введите строку:");
                String input = scanner.nextLine();
                System.out.println("Количество вхождений 'abc': " + countAbcOccurrences(input));
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    // Задание 1: Обработка звездочек
    private static String processAsterisks(String str) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c != '*') {
                result.append(c).append(c); // Повторяем символ
            }
            // Символ '*' пропускаем
        }
        return result.toString();
    }

    // Задание 2: Подсчет вхождений "abc"
    private static int countAbcOccurrences(String str) {
        int count = 0;
        for (int i = 0; i <= str.length() - 3; i++) {
            if (str.substring(i, i + 3).equals("abc")) {
                count++;
            }
        }
        return count;
    }
}