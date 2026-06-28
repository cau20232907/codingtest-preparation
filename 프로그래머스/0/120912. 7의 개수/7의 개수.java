import java.util.*;

class Solution {
    public int solution(int[] array) {
        return (int) Arrays.stream(array)
            .flatMap(i -> Integer.toString(i).chars())
            .filter(i -> i == '7')
            .count();
    }
}