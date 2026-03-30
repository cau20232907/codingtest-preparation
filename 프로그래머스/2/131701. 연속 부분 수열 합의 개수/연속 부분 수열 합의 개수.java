import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] elements) {
        Set<Integer> sums = Arrays.stream(elements)
            .mapToObj(i -> i)
            .collect(Collectors.toSet());
        int prevSumStart = elements[0];
        for (int i = 2; i <= elements.length; i++) {
            prevSumStart += elements[i - 1];
            int currentSum = prevSumStart;
            sums.add(currentSum);
            for (int j = 0; j < elements.length; j++){
                currentSum += elements[(i+j)%elements.length];
                currentSum -= elements[j];
                sums.add(currentSum);
            }
        }
        return sums.size();
    }
}