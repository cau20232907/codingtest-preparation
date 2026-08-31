import java.util.*;

class Solution {
    public int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);
        
        int answer = 0;
        int bPos = B.length - 1;
        for (int aPos = A.length - 1; aPos >= 0; aPos--) {
            if (A[aPos] < B [bPos]) {
                answer++;
                bPos--;
            }
        }
        return answer;
    }
}