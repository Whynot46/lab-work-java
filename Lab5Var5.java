import java.util.Scanner;

public class Lab5Var5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                scanner.nextLine(); // Очистка буфера
                System.out.println("Введите строку:");
                String s = scanner.nextLine();

                if (isPalindrome(s, 0, s.length() - 1)) {
                    System.out.println("Строка является палиндромом");
                } else {
                    System.out.println("Строка не является палиндромом");
                }
                break;

            case 2:
                System.out.println("Введите x и y:");
                int x = scanner.nextInt();
                int y = scanner.nextInt();

                rearrangeValues(x, y);
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    // Задание 1: Рекурсивная проверка на палиндром
    private static boolean isPalindrome(String s, int left, int right) {
        if (left >= right) {
            return true;
        }

        if (s.charAt(left) != s.charAt(right)) {
            return false;
        }

        return isPalindrome(s, left + 1, right - 1);
    }

    // Задание 2: Рекурсивная перестановка значений (демонстрация)
    private static void rearrangeValues(int x, int y) {
        if (x < y) {
            // Меняем местами
            int temp = x;
            x = y;
            y = temp;
        }

        System.out.println("После перестановки: x = " + x + ", y = " + y);
    }
}