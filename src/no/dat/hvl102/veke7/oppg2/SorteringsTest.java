package no.dat.hvl102.veke7.oppg2;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class SorteringsTest {

    // Test for Insertion Sort
    @Test
    public void testInsertionSort() {
        Integer[] arr = {10, 2, 30, 4, 5, 1};
        Integer[] expected = {1, 2, 4, 5, 10, 30};
        sorteringsMetoder.insertionSort(arr); // Kall på din metode for Insertion Sort
        assertArrayEquals(expected, arr, "Insertion Sort fungerer ikke som forventet.");
        long startTime = System.currentTimeMillis();
        sorteringsMetoder.quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("QuickSort tid: " + (endTime - startTime) + " millisekunder.");
    }

    // Test for Selection Sort
    @Test
    public void testSelectionSort() {
        Integer[] arr = {10, 2, 30, 4, 5, 1};
        Integer[] expected = {1, 2, 4, 5, 10, 30};
        sorteringsMetoder.selectionSort(arr); // Kall på din metode for Selection Sort
        assertArrayEquals(expected, arr, "Selection Sort fungerer ikke som forventet.");
        long startTime = System.currentTimeMillis();
        sorteringsMetoder.quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("QuickSort tid: " + (endTime - startTime) + " millisekunder.");
    }

    // Test for Quick Sort
    @Test
    public void testQuickSort() {
        Integer[] arr = {10, 2, 30, 4, 5, 1};
        Integer[] expected = {1, 2, 4, 5, 10, 30};
        sorteringsMetoder.quickSort(arr, 0, arr.length - 1); // Kall på din metode for Quick Sort
        assertArrayEquals(expected, arr, "Quick Sort fungerer ikke som forventet.");
        long startTime = System.currentTimeMillis();
        sorteringsMetoder.quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("QuickSort tid: " + (endTime - startTime) + " millisekunder.");
    }

    // Test for Merge Sort
    @Test
    public void testMergeSort() {
        Integer[] arr = {10, 2, 30, 4, 5, 1};
        Integer[] expected = {1, 2, 4, 5, 10, 30};
        sorteringsMetoder.mergeSort(arr); // Kall på din metode for Merge Sort
        assertArrayEquals(expected, arr, "Merge Sort fungerer ikke som forventet.");
        long startTime = System.currentTimeMillis();
        sorteringsMetoder.quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("QuickSort tid: " + (endTime - startTime) + " millisekunder.");
    }

    // Test for tom array
    @Test
    public void testEmptyArray() {
        Integer[] arr = {};
        Integer[] expected = {};
        sorteringsMetoder.insertionSort(arr); // Eller en hvilken som helst sorteringsmetode
        assertArrayEquals(expected, arr, "Tom array skal forbli uendret.");
        long startTime = System.currentTimeMillis();
        sorteringsMetoder.quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("QuickSort tid: " + (endTime - startTime) + " millisekunder.");
    }

    // Test for array med én verdi
    @Test
    public void testSingleElementArray() {
        Integer[] arr = {5};
        Integer[] expected = {5};
        sorteringsMetoder.selectionSort(arr); // Eller en hvilken som helst sorteringsmetode
        assertArrayEquals(expected, arr, "Array med ett element skal forbli uendret.");
        long startTime = System.currentTimeMillis();
        sorteringsMetoder.quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("QuickSort tid: " + (endTime - startTime) + " millisekunder.");
    }

    // Test for array med like verdier
    @Test
    public void testArrayWithDuplicates() {
        Integer[] arr = {5, 5, 5, 5};
        Integer[] expected = {5, 5, 5, 5};
        sorteringsMetoder.quickSort(arr, 0, arr.length - 1); // Eller en hvilken som helst sorteringsmetode
        assertArrayEquals(expected, arr, "Array med like verdier skal ikke endres.");
        long startTime = System.currentTimeMillis();
        sorteringsMetoder.quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("QuickSort tid: " + (endTime - startTime) + " millisekunder.");
    }

    // Test for sortering med stor array
    @Test
    public void testLargeArray() {
        Integer[] arr = new Integer[10000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = (int) (Math.random() * 10000); // Fyll med tilfeldige tall
        }
        Integer[] expected = arr.clone();
        Arrays.sort(expected); // Bruk innebygd Java-sortering for å finne forventet resultat
        sorteringsMetoder.mergeSort(arr); // Eller en hvilken som helst sorteringsmetode
        assertArrayEquals(expected, arr, "Stort array ble ikke sortert riktig.");
        long startTime = System.currentTimeMillis();
        sorteringsMetoder.quickSort(arr, 0, arr.length - 1);
        long endTime = System.currentTimeMillis();
        System.out.println("QuickSort tid: " + (endTime - startTime) + " millisekunder.");
    }
}
