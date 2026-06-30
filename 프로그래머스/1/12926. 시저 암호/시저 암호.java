import java.util.stream.*;

class Solution {
    public String solution(String s, int n) {
        return s.chars()
            .map(c -> {
                if (c == ' ') {
                    return c;
                } else if (Character.isLowerCase(c)) {
                    return (c - 'a' + n) % 26 + 'a';
                } else { //isUpperCase
                    return (c - 'A' + n) % 26 + 'A';
                }
            })
            .mapToObj(Character::toString)
            .collect(Collectors.joining());
    }
}