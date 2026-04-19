package lab1;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class FindElementsTest {


    @Test
    public void baseCase() {
        List<Integer> input = Arrays.asList(1, 4, 5, 3, 2, 6);
        List<Integer> result = FindElements.findElementsInTargetSumPairs(input, 7);
        assertEquals(input, result);
    }
    // T1 - C1: empty list
    @Test
    public void emptyList() {
        List<Integer> result = FindElements.findElementsInTargetSumPairs(new ArrayList<>(), 7);
        assertTrue(result.isEmpty());
    }


    @Test
    public void singleElement() {
        List<Integer> result = FindElements.findElementsInTargetSumPairs(Arrays.asList(5), 7);
        assertTrue(result.isEmpty());
    }


    @Test
    public void nullInput() {
        assertThrows(NullPointerException.class, () -> {
            FindElements.findElementsInTargetSumPairs(null, 7);
        });
    }


    @Test
    public void noPairs() {
        List<Integer> result = FindElements.findElementsInTargetSumPairs(Arrays.asList(1, 2, 3), 100);
        assertTrue(result.isEmpty());
    }


    @Test
    public void duplicates() {
        List<Integer> result = FindElements.findElementsInTargetSumPairs(Arrays.asList(1, 4, 4, 3), 7);
        assertEquals(Arrays.asList(4, 3), result);
    }


    @Test
    public void negativeNumbers() {
        List<Integer> input = Arrays.asList(-1, 8, 2, 5);
        List<Integer> result = FindElements.findElementsInTargetSumPairs(input, 7);
        assertEquals(input, result);
    }


    @Test
    public void zeroTarget() {
        List<Integer> result = FindElements.findElementsInTargetSumPairs(Arrays.asList(-3, 3, 1, 2), 0);
        assertEquals(Arrays.asList(-3, 3), result);
    }

    @Test
    public void negativeTarget() {
        List<Integer> result = FindElements.findElementsInTargetSumPairs(Arrays.asList(-5, 2, -3, 1), -3);
        assertEquals(Arrays.asList(-5, 2), result);
    }
}