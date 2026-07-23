import java.util.stream.*;

class Solution {
    public String solution(String myString) {
        return myString.chars()
            .mapToObj(c -> {
                if (c < 'l') {
                    c = 'l';
                }
                return new String(Character.toChars(c));
            })
            .collect(Collectors.joining());
    }
}