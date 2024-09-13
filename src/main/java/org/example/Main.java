package org.example;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int[][] jaggedArray = new int[12][];
        jaggedArray[0] = new int[31];
        jaggedArray[1] = new int[28];
        jaggedArray[2] = new int[31];
        jaggedArray[3] = new int[30];
        jaggedArray[4] = new int[31];
        jaggedArray[5] = new int[30];
        jaggedArray[6] = new int[31];
        jaggedArray[7] = new int[31];
        jaggedArray[8] = new int[30];
        jaggedArray[9] = new int[31];
        jaggedArray[10] = new int[30];
        jaggedArray[11] = new int[31];

        // Заполнение массива случайными значениями температуры
        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                jaggedArray[i][j] = (int) (Math.random() * 50 - 25);
            }
        }

        // Вывод массива
        for (int i = 0; i < jaggedArray.length; i++) {
            System.out.println("Month " + (i + 1) + ": " + Arrays.toString(jaggedArray[i]));
        }

        // Ввод данных от пользователя
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter month: ");
        int month = scanner.nextInt() - 1;
        System.out.println("Enter day: ");
        int day = scanner.nextInt() - 1;



        // Поиск максимальной и минимальной температуры
        int maxTemp = Integer.MIN_VALUE;
        int minTemp = Integer.MAX_VALUE;
        int minDay = 0, minMonth = 0, maxDay = 0, maxMonth = 0;

        for (int i = 0; i < jaggedArray.length; i++) {
            for (int j = 0; j < jaggedArray[i].length; j++) {
                if (jaggedArray[i][j] < minTemp) {
                    minTemp = jaggedArray[i][j];
                    minDay = j;
                    minMonth = i;
                }
                if (jaggedArray[i][j] > maxTemp) {
                    maxTemp = jaggedArray[i][j];
                    maxDay = j;
                    maxMonth = i;
                }
            }
            // Вычисление и вывод средней температуры по каждому месяцу
            System.out.println("Month " + (i + 1) + " average temperature: " + Arrays.stream(jaggedArray[i]).average().getAsDouble());
        }

        // Вывод самой холодной и самой горячей даты
        System.out.println("Hottest day: Month " + (maxMonth + 1) + ", Day " + (maxDay + 1) + " with temperature " + maxTemp);
        System.out.println("Coldest day: Month " + (minMonth + 1) + ", Day " + (minDay + 1) + " with temperature " + minTemp);

        // Закрытие сканера
        scanner.close();
    }
}
