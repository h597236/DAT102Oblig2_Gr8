package no.dat.hvl102.veke7.oppg1;

public class InsettingsSorteringA {

    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int n = a.length;

        int minIndex = 0;
        for (int i = 1; i < n; i++) {
            if (a[i].compareTo(a[minIndex]) < 0) {
                minIndex = i;
            }
        }
        swap(a, 0, minIndex);

        for (int i = 1; i < n; i++) {
            T temp = a[i];
            int j = i - 1;

            while (a[j].compareTo(temp) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = temp;
        }
    }

    public static Integer[] generateRandomData(int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = (int) (Math.random() * 1000);
        }
        return data;
    }

    public static void main(String[] args) {
        int n = 100000;
        Integer[] data = generateRandomData(n);

        long startTime = System.currentTimeMillis();
        insertionSort(data);
        long endTime = System.currentTimeMillis();

        System.out.println("Tid brukt: " + (endTime - startTime) + " ms");
    }
}