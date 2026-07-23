import java.util.stream.*;

class Solution {
    public String solution(String myString) {
        return myString.replaceAll("[^l-z]", "l");
    }
}