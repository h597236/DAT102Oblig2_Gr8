package no.dat.hvl102.veke7.oppg2;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        int iterations = 5;

        int[] sizes = {32000, 64000, 128000};

        for (int size : sizes) {
            System.out.println("Testing with array size: " + size);

            long insertionSortTotalTime = 0;
            long selectionSortTotalTime = 0;
            long quickSortTotalTime = 0;
            long mergeSortTotalTime = 0;

            for (int i = 0; i < iterations; i++) {
                Integer[] arr = generateRandomArray(size);

                long startTime, endTime;

                startTime = System.nanoTime();
                sorteringsMetoder.insertionSort(arr.clone());
                endTime = System.nanoTime();
                insertionSortTotalTime += (endTime - startTime);

                startTime = System.nanoTime();
                sorteringsMetoder.selectionSort(arr.clone());
                endTime = System.nanoTime();
                selectionSortTotalTime += (endTime - startTime);

                startTime = System.nanoTime();
                sorteringsMetoder.quickSort(arr.clone(), 0, arr.length - 1);
                endTime = System.nanoTime();
                quickSortTotalTime += (endTime - startTime);

                startTime = System.nanoTime();
                sorteringsMetoder.mergeSort(arr.clone());
                endTime = System.nanoTime();
                mergeSortTotalTime += (endTime - startTime);
            }

            System.out.println("Gjennomsnittlig tid etter " + iterations + " kjøringer for størrelse " + size + ":");
            System.out.println("Insertion Sort: " + (insertionSortTotalTime / iterations) / 1_000_000.0 + " ms.");
            System.out.println("Selection Sort: " + (selectionSortTotalTime / iterations) / 1_000_000.0 + " ms.");
            System.out.println("Quick Sort: " + (quickSortTotalTime / iterations) / 1_000_000.0 + " ms.");
            System.out.println("Merge Sort: " + (mergeSortTotalTime / iterations) / 1_000_000.0 + " ms.");
            System.out.println();
        }
    }

    public static Integer[] generateRandomArray(int size) {
        Random rand = new Random();
        Integer[] arr = new Integer[size];
        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(10000);
        }
        return arr;
    }
}
