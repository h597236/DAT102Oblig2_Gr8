package no.dat.hvl102.veke7.oppg2;

import java.util.Arrays;

public class sorteringsMetoder {
    public static void insertionSort(Integer[] arr) {
        for (int i = 1; i < arr.length; i++) {
            Integer key = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j].compareTo(key) > 0) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
        }
    }


    public static void selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            Integer temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }


    public static void quickSort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }


    private static int partition(Integer[] arr, int low, int high) {
        Integer pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j].compareTo(pivot) < 0) {
                i++;
                Integer temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        Integer temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }


    public static void mergeSort(Integer[] arr) {
        if (arr.length < 2) return;
        int mid = arr.length / 2;
        Integer[] left = Arrays.copyOfRange(arr, 0, mid);
        Integer[] right = Arrays.copyOfRange(arr, mid, arr.length);
        mergeSort(left);
        mergeSort(right);
        merge(arr, left, right);
    }


    private static void merge(Integer[] arr, Integer[] left, Integer[] right) {
        int i = 0, j = 0, k = 0;
        while (i < left.length && j < right.length) {
            if (left[i].compareTo(right[j]) <= 0) {
                arr[k++] = left[i++];
            } else {
                arr[k++] = right[j++];
            }
        }
        while (i < left.length) arr[k++] = left[i++];
        while (j < right.length) arr[k++] = right[j++];
    }


    public static void measureSortTime(String sortType, Integer[] arr) {
        long startTime = System.nanoTime();

        // Kall sorteringsmetode basert på sortType
        switch (sortType) {
            case "insertion":
                insertionSort(arr);
                break;
            case "selection":
                selectionSort(arr);
                break;
            case "quick":
                quickSort(arr, 0, arr.length - 1);
                break;
            case "merge":
                mergeSort(arr);
                break;
            default:
                throw new IllegalArgumentException("Unknown sort type");
        }

        long endTime = System.nanoTime();
        long duration = endTime - startTime;
        System.out.println("Sortering (" + sortType + ") tid: " + duration + " nanosekunder.");
    }


}

