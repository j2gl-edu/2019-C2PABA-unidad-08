package edu.advanced.unit8;

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

    // this is bad fir array:  0, 0, 0, 1, 4, 4, 7, 7, 7, 8 and search for 5
    private static int binarySearch(int[] data, int value) {
        int i = 0;
        int j = data.length - 1;
        int k;

        do {
            k = (i + j) / 2;
            if (data[k] <= value) {
                i = k + 1;
            }
            if (data[k] >= value) {
                j = k - 1;
            }
        } while (i <= j);
        return k;
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
        System.out.println("El dato esta en la posicion: " + sequentialSearch(data, value));
        diff = java.time.Duration.between(start, LocalDateTime.now()).getNano();
        System.out.println("La busqueda tardo : " + diff + " nonosegundos");

        start = LocalDateTime.now();
        System.out.println("El dato esta en la posicion: " + binarySearch(data, value));
        diff = java.time.Duration.between(start, LocalDateTime.now()).getNano();
        System.out.println("La busqueda tardo : " + diff + " nonosegundos");

    }

    private static String printArray(int[] data) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int n : data) {
            stringBuilder.append(n).append(", ");
        }
        return stringBuilder.toString();
    }

    public static void main(String args[]) {
//        int[] data = {5, 8, 42, 34, 553, 6, 43, 99};
//
//        System.out.println("El dato esta en la posicion: " + sequentialSearch(data, 34));
//        System.out.println("El dato esta en la posicion: " + sequentialSearch(data, 7));
//        System.out.println("El dato esta en la posicion: " + sequentialSearch(data, 5));
//        System.out.println("El dato esta en la posicion: " + sequentialSearch(data, 99));

//        int[] data2 = {2, 8, 14, 20, 30, 32, 34, 50, 67, 100, 150, 430, 599, 653, 700, 750};
//        System.out.println("El dato esta en la posicion: " + binarySearch(data2, 750));

        calculate(10, 5);
        System.out.println();


//        calculate(100, 50);
//        System.out.println();
//
//        calculate(1000, 500);
//        System.out.println();
//


    }
}
