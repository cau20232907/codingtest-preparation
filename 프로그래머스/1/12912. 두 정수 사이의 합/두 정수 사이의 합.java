class Solution {
    public long solution(int a, int b) {
        if (a <= 0 && b <= 0) {
            return -Math.abs(
                ((long) a) * (a - 1) / 2
                - ((long) b) * (b - 1) / 2
            ) + Math.max(a, b);
        } else if (a >= 0 && b >= 0) {
            return Math.abs(
                ((long) a) * (a + 1) / 2
                - ((long) b) * (b + 1) / 2
            ) + Math.min(a, b);
        } else if (a < 0) {
            // b >= 0
            return ((long) b) * (b + 1) / 2
                - ((long) a) * (a - 1) / 2;
        } else {
            return ((long) a) * (a + 1) / 2
                - ((long) b) * (b - 1) / 2;
        }
    }
}