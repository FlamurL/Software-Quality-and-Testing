package lab1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindElements {

    public static List<Integer> findElementsInTargetSumPairs(List<Integer> numbers, int target) {
        if (numbers == null) {
            throw new NullPointerException("Input list cannot be null");
        }

        Set<Integer> seen = new HashSet<>();


        Set<Integer> valid = new HashSet<>();

        for (int num : numbers) {
            int complement = target - num;


            if (seen.contains(complement)) {
                valid.add(num);
                valid.add(complement);
            }

            seen.add(num);
        }


        List<Integer> result = new ArrayList<>();
        Set<Integer> added = new HashSet<>();

        for (int num : numbers) {
            if (valid.contains(num) && !added.contains(num)) {
                result.add(num);
                added.add(num);
            }
        }

        return result;
    }
}