package Task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SortTest {

    @Test
    void testQuickSort_positiveIntegersWithDuplicates() {
        int[] array = {5, 6, 3, 2, 5, 1, 4, 9};
        int[] expected = {1, 2, 3, 4, 5, 5, 6, 9};
        Sort.quickSort(array, 0, array.length - 1);
        assertArrayEquals(expected, array);
    }

    @Test
    void testQuickSort_negativeIntegersWithDuplicates() {
        int[] array = {-5, -6, -3, -2, -5, -1, -4, -9};
        int[] expected = {-9, -6, -5, -5, -4, -3, -2, -1};
        Sort.quickSort(array, 0, array.length - 1);
        assertArrayEquals(expected, array);
    }

    @Test
    void testQuickSort_positiveAndNegativeIntegersWithDuplicates() {
        int[] array = {5, -6, 3, -2, 5, -1, 4, -9};
        int[] expected = {-9, -6, -2, -1, 3, 4, 5, 5};
        Sort.quickSort(array, 0, array.length - 1);
        assertArrayEquals(expected, array);
    }
}