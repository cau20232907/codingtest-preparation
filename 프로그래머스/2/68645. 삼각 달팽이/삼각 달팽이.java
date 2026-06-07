class Solution {
    public int[] solution(int n) {
        int[] answer = new int[n*(n+1)/2];
        int num = 1;
        
        for(int line = 0; line < n / 3; line++) {
            for(int i = line * 2; i < n - line; i++) {
                answer[i*(i+1)/2 + line] = num++;
            }
            for(int i = 1 + line; i < n - line * 2; i++) {
                answer[(n-1-line)*(n-line)/2 + i] = num++;
            }
            for(int i = n - line - 1; i > line * 2 + 1; i--) {
                answer[i*(i+1)/2 - 1 - line] = num++;
            }
        }
        
        if (n % 3 != 0) {
            int line = n / 3;
            // 나머지가 1
            for(int i = line * 2; i < n - line; i++) {
                answer[i*(i+1)/2+line] = num++;
            }
            if (n % 3 == 2) {
                // 나머지가 2
                for(int i = 1 + line; i < n - line * 2; i++) {
                    answer[(n-1-line)*(n-line)/2+i] = num++;
                }
            }
        }
        
        return answer;
    }
}