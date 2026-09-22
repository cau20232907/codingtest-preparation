class Solution {
    public String solution(int[] numLog) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < numLog.length - 1; i++) {
            sb.append(
                switch(numLog[i + 1] - numLog[i]) {
                    case 10 -> 'd';
                    case -10 -> 'a';
                    case 1 -> 'w';
                    case -1 -> 's';
                    default -> throw new RuntimeException();
                }
            );
        }
        return sb.toString();
    }
}