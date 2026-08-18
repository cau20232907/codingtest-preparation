import java.util.*;
import java.util.stream.*;

class Solution {
    public String solution(String my_string) {
        Set<Character> vowels = Set.of('a','e','i','o','u');
        StringBuilder sb = new StringBuilder();
        my_string.chars()
            .filter(c->!vowels.contains((char)c))
            .forEach(c->sb.append((char)c));
        return sb.toString();
    }
}