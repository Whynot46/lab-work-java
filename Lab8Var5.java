import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Lab8Var5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите размеры матрицы n и m:");
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[][] matrix = new int[n][m];

        // Заполняем матрицу случайными числами от -50 до 50
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                matrix[i][j] = random.nextInt(101) - 50;
            }
        }

        System.out.println("Сгенерированная матрица:");
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                System.out.println("Введите координаты точки (строка и столбец):");
                int row = scanner.nextInt();
                int col = scanner.nextInt();

                if (row < 0 || row >= n || col < 0 || col >= m) {
                    System.out.println("Координаты вне границ матрицы");
                    break;
                }

                int value = matrix[row][col];
                System.out.println("Значение: " + value);

                if (value == 0) {
                    System.out.println("Точка находится на пересечении осей");
                } else {
                    String quadrant = "";
                    if (row < n/2 && col < m/2) quadrant = "I";
                    else if (row < n/2 && col >= m/2) quadrant = "II";
                    else if (row >= n/2 && col < m/2) quadrant = "III";
                    else quadrant = "IV";

                    System.out.println("Точка находится в квадранте " + quadrant);
                }
                break;

            case 2:
                System.out.println("Введите индексы трех элементов (i1,j1 i2,j2 i3,j3):");
                int i1 = scanner.nextInt();
                int j1 = scanner.nextInt();
                int a = matrix[i1][j1];

                int i2 = scanner.nextInt();
                int j2 = scanner.nextInt();
                int b = matrix[i2][j2];

                int i3 = scanner.nextInt();
                int j3 = scanner.nextInt();
                int c = matrix[i3][j3];

                if (a >= b && b >= c) {
                    matrix[i1][j1] *= 2;
                    matrix[i2][j2] *= 2;
                    matrix[i3][j3] *= 2;
                    System.out.println("Элементы удвоены");
                } else {
                    matrix[i1][j1] = Math.abs(a);
                    matrix[i2][j2] = Math.abs(b);
                    matrix[i3][j3] = Math.abs(c);
                    System.out.println("Элементы заменены абсолютными значениями");
                }

                System.out.println("Измененная матрица:");
                for (int[] r : matrix) {
                    System.out.println(Arrays.toString(r));
                }
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }
}