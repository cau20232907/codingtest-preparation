import java.util.stream.*;
import java.util.*;

class Solution {
    public String solution(int n, int t, int m, int p) {
        int[] charOrder = IntStream.range(0, t * m)
            .flatMap(i -> Integer.toString(i, n).toUpperCase().chars())
            .toArray(); // ASCII code 값 array
        
        StringBuilder answer = new StringBuilder();
        for(int i = p - 1; answer.length() < t; i += m) {
            answer.append((char) charOrder[i]);
        }
        return answer.toString();
    }
}