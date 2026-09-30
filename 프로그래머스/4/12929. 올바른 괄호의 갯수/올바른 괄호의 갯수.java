import java.util.*;

class Solution {
    public int solution(int n) {
        return calculate(0, n);
    }
    
    int calculate(int currentOpen, int leftOpen) {
        if (leftOpen == 0) {
            return 1; // 여는 괄호 모두 사용
        }
        
        // 다음에 오는 게 여는 괄호
        int total = calculate(currentOpen + 1, leftOpen - 1);
        // 다음에 오는 게 닫는 괄호
        if (currentOpen != 0) {
            total += calculate(currentOpen - 1, leftOpen);
        }
        return total;
    }
}