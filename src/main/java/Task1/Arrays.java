package Task1;

import java.util.Random;

public class Arrays {
    public static final String RED = "\u001B[31m";
    public static final String BLUE = "\u001B[34m";
    public static final String YELLOW = "\u001B[33m";
    public static final String WHITE = "\u001B[0m";


    public static void main(String[] args) {

        int[][] arr = new int[10][10];
        fillRandomNumbers(arr);

        int max = getMax(arr);
        int min = getMin(arr);
        double average = getAverage(arr);

        System.out.println(wrapInColor(max, RED));
        System.out.println(wrapInColor(min, BLUE));
        System.out.println(wrapInColor(average, YELLOW));
    }

    public static String wrapInColor(String value, String color) {
        return color + value + WHITE;
    }

    public static String wrapInColor(double value, String color) {
        return wrapInColor(String.valueOf(value), color);
    }

    public static String wrapInColor(int value, String color) {
        return wrapInColor(String.valueOf(value), color);
    }

    public static void fillRandomNumbers(int[][] arr) {
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                arr[i][j] = (random.nextInt(21) - 10);
            }
        }
    }

    public static int getMax(int[][] arr) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (max < arr[i][j]) {
                    max = arr[i][j];
                }
            }
        }
        return max;
    }

    public static int getMin(int[][] arr) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (min > arr[i][j]) {
                    min = arr[i][j];
                }
            }
        }
        return min;
    }

    public static double getAverage(int[][] arr) {
        int sum = 0;
        int counter = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                sum += arr[i][j];
                counter++;
            }
        }
        double average = (double) sum / counter;
        return average;
    }
}
