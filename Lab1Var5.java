import java.util.Scanner;
import java.lang.Math;

public class Lab1Var5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1, 2 или 3):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Введите x:");
                double x = scanner.nextDouble();
                double result1 = x - Math.pow(x,3)/3 + Math.pow(x,5)/5;
                System.out.println("Результат: " + result1);
                break;

            case 2:
                System.out.println("Введите x, y, z (z ≠ π/2 + πk):");
                double x2 = scanner.nextDouble();
                double y = scanner.nextDouble();
                double z = scanner.nextDouble();

                if (Math.abs(z % (Math.PI/2)) < 0.0001) {
                    System.out.println("Тангенс не определен для этого z");
                    break;
                }

                double numerator = 3 + Math.exp(y - 1);
                double denominator = 1 + Math.pow(x2,2) * Math.abs(y - Math.tan(z));
                double result2 = numerator / denominator;

                System.out.println("Результат: " + result2);
                break;

            case 3:
                System.out.println("Введите два числа:");
                double num1 = scanner.nextDouble();
                double num2 = scanner.nextDouble();

                double avgCubes = (Math.pow(num1,3) + Math.pow(num2,3)) / 2;
                double geomAvg = Math.sqrt(Math.abs(num1) * Math.abs(num2));

                System.out.println("Среднее арифметическое кубов: " + avgCubes);
                System.out.println("Среднее геометрическое модулей: " + geomAvg);
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }
}