package Task2;

public class Sort {
    public static void main(String[] args) {

        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};

        quickSort(array, 0, array.length - 1);

        for (int i = 0; i < array.length; i++) {
            System.out.print(array[i] + " ");
        }
    }

    public static void quickSort(int[] array, int low, int high) {
        if (array.length == 0) {
            return;
        }
        if (low >= high) {
            return;
        }

        int pi = partition(array, low, high);

        quickSort(array, low, pi - 1);
        quickSort(array, pi + 1, high);

    }

    public static int partition(int[] array, int low, int high) {
        int pivot = array[high];
        int ptr = low - 1;

        for (int i = low; i < high; i++) {
            if (array[i] < pivot) {
                ptr++;
                swap(ptr, i, array);
            }
        }
        swap(ptr + 1, high, array);
        return ptr + 1;
    }

    public static void swap(int ptr, int i, int[] array) {
        int tmp = array[ptr];
        array[ptr] = array[i];
        array[i] = tmp;
    }
}
