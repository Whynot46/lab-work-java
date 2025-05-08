import java.util.Scanner;
import java.util.ArrayList;

public class Lab4Var5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Введите M и N:");
                int M = scanner.nextInt();
                int N = scanner.nextInt();

                findNumbersWithMaxDivisors(M, N);
                break;

            case 2:
                System.out.println("Введите число:");
                int num = scanner.nextInt();
                checkProductOfThreeConsecutive(num);
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    // Задание 1: Найти числа с максимальным количеством делителей в интервале
    private static void findNumbersWithMaxDivisors(int M, int N) {
        if (M > N) {
            System.out.println("Некорректный интервал");
            return;
        }

        int maxDivisors = 0;
        ArrayList<Integer> numbers = new ArrayList<>();

        for (int i = M; i <= N; i++) {
            int divisors = countDivisors(i);

            if (divisors > maxDivisors) {
                maxDivisors = divisors;
                numbers.clear();
                numbers.add(i);
            } else if (divisors == maxDivisors) {
                numbers.add(i);
            }
        }

        System.out.println("Числа с наибольшим количеством делителей (" + maxDivisors + "):");
        System.out.println(numbers);
    }

    private static int countDivisors(int number) {
        if (number == 1) return 1;
        int count = 2; // 1 и само число
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                if (i == number / i) {
                    count++;
                } else {
                    count += 2;
                }
            }
        }
        return count;
    }

    // Задание 2: Проверить, можно ли представить число как произведение трех последовательных чисел
    private static void checkProductOfThreeConsecutive(int num) {
        boolean found = false;
        for (int n = 1; n * (n + 1) * (n + 2) <= num; n++) {
            if (n * (n + 1) * (n + 2) == num) {
                System.out.printf("%d = %d × %d × %d\n", num, n, n+1, n+2);
                found = true;
                break;
            }
        }

        if (!found) {
            System.out.println(num + " нельзя представить как произведение трех последовательных натуральных чисел");
        }
    }
}