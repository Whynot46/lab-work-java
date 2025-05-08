import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class Lab7Var5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Введите размер массива:");
        int size = scanner.nextInt();
        int[] array = new int[size];

        // Заполняем массив случайными числами от -50 до 50
        for (int i = 0; i < size; i++) {
            array[i] = random.nextInt(101) - 50;
        }

        System.out.println("Сгенерированный массив: " + Arrays.toString(array));

        System.out.println("Выберите задание (1 или 2):");
        int task = scanner.nextInt();

        switch(task) {
            case 1:
                int multiples = countMultiplesOf3Or5(array);
                System.out.println("Количество элементов, кратных 3 или 5: " + multiples);
                break;

            case 2:
                int[] pair = findAdjacentPositivePair(array);
                if (pair != null) {
                    System.out.println("Первая пара соседних положительных: [" +
                            pair[0] + ", " + pair[1] + "] на позициях " +
                            pair[2] + " и " + (pair[2]+1));
                } else {
                    System.out.println("Нет соседних положительных элементов");
                }
                break;

            default:
                System.out.println("Неверный номер задания");
        }

        scanner.close();
    }

    // Задание 1: Подсчет элементов, кратных 3 или 5
    private static int countMultiplesOf3Or5(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 3 == 0 || num % 5 == 0) {
                count++;
            }
        }
        return count;
    }

    // Задание 2: Поиск соседних положительных элементов
    private static int[] findAdjacentPositivePair(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > 0 && arr[i+1] > 0) {
                return new int[]{arr[i], arr[i+1], i};
            }
        }
        return null;
    }
}