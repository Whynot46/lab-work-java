import java.util.Scanner;
import java.lang.Math;

public class Lab2Var5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите задание (1, 2 или 3):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Введите x:");
                double x = scanner.nextDouble();
                double result;
                if (x <= 7) {
                    result = -3 * x + 9;
                } else {
                    result = 1 / (x - 7);
                }
                System.out.println("f(x) = " + result);
                break;

            case 2:
                System.out.println("Введите координаты точки (x, y):");
                double xCoord = scanner.nextDouble();
                double yCoord = scanner.nextDouble();

                if (xCoord == 0 && yCoord == 0) {
                    System.out.println("Точка в начале координат");
                } else if (xCoord == 0) {
                    System.out.println("Точка на оси Y");
                } else if (yCoord == 0) {
                    System.out.println("Точка на оси X");
                } else {
                    int quadrant = 0;
                    if (xCoord > 0 && yCoord > 0) quadrant = 1;
                    else if (xCoord < 0 && yCoord > 0) quadrant = 2;
                    else if (xCoord < 0 && yCoord < 0) quadrant = 3;
                    else if (xCoord > 0 && yCoord < 0) quadrant = 4;

                    System.out.println("Точка в " + quadrant + " координатном угле");
                }
                break;

            case 3:
                System.out.println("Введите три числа a, b, c:");
                double a = scanner.nextDouble();
                double b = scanner.nextDouble();
                double c = scanner.nextDouble();

                if (a >= b && b >= c) {
                    a *= 2;
                    b *= 2;
                    c *= 2;
                    System.out.println("Удвоенные значения: " + a + ", " + b + ", " + c);
                } else {
                    a = Math.abs(a);
                    b = Math.abs(b);
                    c = Math.abs(c);
                    System.out.println("Абсолютные значения: " + a + ", " + b + ", " + c);
                }
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }
}