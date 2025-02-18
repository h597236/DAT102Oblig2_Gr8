package no.dat.hvl102.veke7.oppg1;

public class InsettingsSorteringB {

    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }


    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int n = a.length;

        for (int i = 0; i < n; i += 2) {
            if (i + 1 >= n) {
                T last = a[i];
                int j = i - 1;

                while (j >= 0 && a[j].compareTo(last) > 0) {
                    a[j + 1] = a[j];
                    j--;
                }
                a[j + 1] = last;
                break;
            }

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
