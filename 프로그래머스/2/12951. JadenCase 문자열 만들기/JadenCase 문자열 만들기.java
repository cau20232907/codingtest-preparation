class Solution {
    public String solution(String s) {
        char[] original = s.toCharArray();
        StringBuilder answer = new StringBuilder();
        boolean afterSpace = true;
        for(int i = 0; i < original.length; i++) {
            if(Character.isWhitespace(original[i])) {
                answer.append(' ');
                afterSpace = true;
            } else if (Character.isUpperCase(original[i]) && !afterSpace) {
                answer.append(Character.toLowerCase(original[i]));
                afterSpace = false;
            } else if (Character.isLowerCase(original[i]) && afterSpace) {
                answer.append(Character.toUpperCase(original[i]));
                afterSpace = false;
            } else {
                answer.append(original[i]);
                afterSpace = false;
            }
        }
        return answer.toString();
    }
}