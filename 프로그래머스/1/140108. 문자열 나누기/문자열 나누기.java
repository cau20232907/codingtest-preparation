class Solution {
    public int solution(String s) {
        char[] input = s.toCharArray();
        int answer = 1;
        char x = input[0];
        int xCount = 1;
        int yCount = 0;
        for (int i = 1; i < input.length; i++) {
            if (input[i] == x) {
                xCount++;
            } else {
                yCount++;
            }
            if (xCount == yCount && i + 1 < input.length) {
                answer++;
                i++;
                x = input[i];
                xCount = 1;
                yCount = 0;
            }
        }
        return answer;
    }
}