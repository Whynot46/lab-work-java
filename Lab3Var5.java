import java.util.Scanner;
import java.lang.Math;

public class Lab3Var5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1, 2 или 3):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Возможные сочетания кроликов и гусей с 64 лапами:");
                System.out.println("Кролики | Гуси");
                System.out.println("--------------");

                // У кролика 4 лапы, у гуся 2 лапы
                for (int rabbits = 0; rabbits <= 16; rabbits++) {
                    int geese = (64 - 4 * rabbits) / 2;
                    if (geese >= 0 && (4 * rabbits + 2 * geese) == 64) {
                        System.out.println(rabbits + "       | " + geese);
                    }
                }
                break;

            case 2:
                System.out.println("Введите x:");
                double x = scanner.nextDouble();
                double sum = 0;

                for (int n = 0; n <= 6; n++) {
                    int exponent = 2 * n + 1;
                    double term = Math.pow(x, exponent) / factorial(exponent);
                    sum += (n % 2 == 0) ? term : -term;
                }

                System.out.println("Сумма ряда: " + sum);
                break;

            case 3:
                double epsilon = 1e-3;
                double sumSeries = 0;
                int nTerm = 1;
                double term;

                do {
                    term = Math.pow(10, nTerm) / factorial(nTerm);
                    sumSeries += term;
                    nTerm++;
                } while (term >= epsilon);

                System.out.println("Сумма ряда с точностью 0.001: " + sumSeries);
                System.out.println("Количество слагаемых: " + (nTerm - 1));
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    private static long factorial(int n) {
        long result = 1;
        for (int i = 2; i <= n; i++) {
            result *= i;
        }
        return result;
    }
}