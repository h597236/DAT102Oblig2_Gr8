package no.dat.hvl102.veke7.oppg1;

public class InsettingsSorteringB {

    // Hjelpemetode for å bytte to elementer i en tabell
    private static <T> void swap(T[] a, int i, int j) {
        T temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    // Modifisert insertion sort: Sett inn to elementer om gangen
    public static <T extends Comparable<T>> void insertionSort(T[] a) {
        int n = a.length;

        for (int i = 0; i < n; i += 2) {
            // Håndter tilfelle med odde antall elementer
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

            // Velg to elementer og sørg for at min <= max
            T min = a[i];
            T max = a[i + 1];
            if (min.compareTo(max) > 0) {
                swap(a, i, i + 1);
                min = a[i];
                max = a[i + 1];
            }

            int j = i - 1;

            // Flytt elementer to plasser til høyre så lenge max er mindre enn elementet i sortert del
            while (j >= 0 && a[j].compareTo(max) > 0) {
                a[j + 2] = a[j];
                j--;
            }

            // Sett inn max
            a[j + 2] = max;

            // Sett inn min
            while (j >= 0 && a[j].compareTo(min) > 0) {
                a[j + 1] = a[j];
                j--;
            }
            a[j + 1] = min;
        }
    }

    // Hjelpemetode for å generere tilfeldige data
    public static Integer[] generateRandomData(int n) {
        Integer[] data = new Integer[n];
        for (int i = 0; i < n; i++) {
            data[i] = (int) (Math.random() * 1000);
        }
        return data;
    }

    // Hovedmetode for testing
    public static void main(String[] args) {
        int n = 100000; // Antall elementer
        Integer[] data = generateRandomData(n);

        long startTime = System.currentTimeMillis();
        insertionSort(data);
        long endTime = System.currentTimeMillis();

        System.out.println("Tid brukt: " + (endTime - startTime) + " ms");
    }
}
