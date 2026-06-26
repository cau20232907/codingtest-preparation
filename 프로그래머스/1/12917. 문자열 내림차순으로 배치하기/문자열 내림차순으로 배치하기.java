import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String s) {
        return s.chars()
            .mapToObj(a -> String.valueOf((char) a))
            .sorted(Collections.reverseOrder())
            .collect(Collectors.joining());
    }
}