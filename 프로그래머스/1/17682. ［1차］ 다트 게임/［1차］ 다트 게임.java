class Solution {
    public int solution(String dartResult) {
        char[] resultChars = dartResult.toCharArray();
        int i = 0;
        int total = 0;
        int prev = 0;
        while (i < resultChars.length) {
            int current = resultChars[i++] - '0';
            if (resultChars[i] == '0') {
                //10점
                current = 10;
                i++;
            }
            
            switch (resultChars[i++]) {
                case 'D':
                    current *= current;
                    break;
                case 'T':
                    current *= current * current;
                    break;
            }
            
            if (i < resultChars.length) {
                switch (resultChars[i]) {
                    case '*':
                        prev *= 2;
                        current *= 2;
                        i++;
                        break;
                    case '#':
                        current *= -1;
                        i++;
                        break;
                }
            }
            
            total += prev;
            prev = current;
        }
        
        return total + prev;
    }
}