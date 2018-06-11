package day9;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Permutations {

    private Permutations() {
    }

    static <T> List<List<T>> compute(Set<T> elements) {
        // Terminal
        if (elements.size() == 1) {
            T element = elements.iterator().next();
            List<List<T>> result = new ArrayList<>();
            List<T> terminal = new ArrayList<>();
            terminal.add(element);
            result.add(terminal);
            return result;
        } else {
            List<List<T>> result = new ArrayList<>();
            for (T element : elements) {
                Set<T> remains = new HashSet<>(elements);
                remains.remove(element);
                List<List<T>> subPermutations = compute(remains);
                for (List<T> subPermutation : subPermutations) {
                    subPermutation.add(0, element);
                }
                result.addAll(subPermutations);
            }

            return result;
        }
    }

}
