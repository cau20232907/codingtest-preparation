class Solution {
    public String solution(String s) {
        StringBuilder answer = new StringBuilder();
        char[] original = s.toCharArray();
        int wordStartIdx = 0;
        for(int i = 0; i < original.length; i++) {
            if (Character.isWhitespace(original[i])) {
                answer.append(original[i]);
                wordStartIdx = i + 1;
            } else if((i - wordStartIdx) % 2 == 0) {
                answer.append(Character.toUpperCase(original[i]));
            } else {
                answer.append(Character.toLowerCase(original[i]));
            }
        }
        return answer.toString();
    }
}