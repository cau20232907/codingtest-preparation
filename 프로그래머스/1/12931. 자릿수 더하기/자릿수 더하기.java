public class Solution {
    public int solution(int n) {
        // 시간 복잡도는 무시한 코드
        return Integer.toString(n)
            .chars()
            .map(i -> i - '0')
            .sum();
    }
}