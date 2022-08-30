package Task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ArraysTest {
    @Test
    void testRandom_array_value() {
        int[][] array = new int[4][6];
        Arrays.fillRandomNumbers(array);
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                int value = array[i][j];
                assertTrue(value >= -10 && value <= 10);
            }
        }
    }

    @Test
    void testMaxValueInArray() {
        int[][] array = {{43, 2, 1767, -12}, {0, 34, 6, 8, 12}, {65, -100, 65, 2, -9}};
        assertEquals(1767, Arrays.getMax(array));
    }

    @Test
    void testMinValueInArray() {
        int[][] array = {{43, 2, 1767, -12}, {0, 34, 6, 8, 12}, {65, -100, 65, 2, -9}};
        assertEquals(-100, Arrays.getMin(array));
    }

    @Test
    void testAverageValueInArray() {
        int[][] array = {{43, 2, 1767, -12}, {0, 34, 6, 8, 12}, {65, -100, 65, 2, -9}};
        assertEquals(134.5, Arrays.getAverage(array));
    }
}