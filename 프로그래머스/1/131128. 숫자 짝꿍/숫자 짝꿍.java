class Solution {
    public String solution(String X, String Y) {
        int[] countX = new int[10];
        int[] countY = new int[10];
        int[] countResult = new int[10];
        char[] str = X.toCharArray();
        for(int i = 0; i < str.length; i++) {
            countX[str[i] - '0']++;
        }
        str = Y.toCharArray();
        for(int i = 0; i < str.length; i++) {
            countY[str[i] - '0']++;
        }
        
        for(int i = 0; i < countResult.length; i++) {
            countResult[i] = Math.min(countX[i], countY[i]);
        }
        
        StringBuilder result = new StringBuilder();
        for(int i = 9; i >= 0; i--) {
            result.append(Integer.toString(i).repeat(countResult[i]));
        }
        
        if (result.length() == 0) {
            return "-1";
        } else if (result.charAt(0) == '0') {
            return "0";
        } else {
            return result.toString();
        }
    }
}