package edu.advanced.unit8.search;

import edu.advanced.unit8.sort.QuickSort;

import java.time.LocalDateTime;
import java.util.Random;

public class MainSearch {

    private static int sequentialSearch(int[] data, int valor) {
        int i = 0;
        boolean found = false;
        int index = -1;
        do {
            if (valor == data[i]) {
                found = true;
                index = i;
            }
            i++;

        } while (!found && i < data.length);

        return index;
    }

    private static int binarySearch(int[] data, int value) {
        int min = 0;
        int max = data.length - 1;

        while (min <= max) {
            int middle = (min + max) / 2;
            if (data[middle] < value) {
                min = middle + 1;
            } else if (data[middle] > value) {
                max = middle - 1;
            } else if (data[middle] == value) {
                return middle;
            }
        }

        return -1;
    }

    private static int[] generateArray(int size, int bound) {
        Random random = new Random();
        int[] data = new int[size];

        for (int i = 0; i < size; i++) {
            data[i] = random.nextInt(bound);
        }
        QuickSort quickSort = new QuickSort();
        quickSort.sort(data);
        return data;
    }

    private static void calculate(int size, int value) {
        int[] data = generateArray(size, size);
        System.out.println("Array: " + printArray(data));

        LocalDateTime start;
        int diff;

        start = LocalDateTime.now();
        System.out.println("El dato " + value + " esta en la posicion: " + sequentialSearch(data, value));
        diff = java.time.Duration.between(start, LocalDateTime.now()).getNano();
        System.out.println("La busqueda secuencial tardo : " + diff + " nonosegundos");

        start = LocalDateTime.now();
        System.out.println("El dato " + value + " esta en la posicion: " + binarySearch(data, value));
        diff = java.time.Duration.between(start, LocalDateTime.now()).getNano();
        System.out.println("La busqueda binaria tardo : " + diff + " nonosegundos");

    }

    private static String printArray(int[] data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : data) {
            stringBuilder.append(n).append(", ");
        }
        return stringBuilder.toString();
    }

    public static void main(String args[]) {
        Random random = new Random();
        calculate(10, random.nextInt(10));
        System.out.println();


        calculate(100, random.nextInt(100));
        System.out.println();

        calculate(1000, random.nextInt(1000));
        System.out.println();

    }
}
