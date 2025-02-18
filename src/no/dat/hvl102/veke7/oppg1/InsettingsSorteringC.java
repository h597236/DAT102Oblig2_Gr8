package no.dat.hvl102.veke7.oppg1;

public class InsettingsSorteringC {

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

        for (int i = 2; i < n; i += 2) {
            T min = a[i];
            T max = a[i + 1];

            if (min.compareTo(max) > 0) {
                swap(a, i, i + 1);
                min = a[i];
                max = a[i + 1];
            }

            int j = i - 1;

            while (j >= 0 && a[j].compareTo(max) > 0) {
                a[j + 2] = a[j];
                j--;
            }

            a[j + 2] = max;

            while (j >= 0 && a[j].compareTo(min) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = min;
        }

        if (n % 2 != 0) {
            T last = a[n - 1];
            int j = n - 2;

            while (j >= 0 && a[j].compareTo(last) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = last;
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
