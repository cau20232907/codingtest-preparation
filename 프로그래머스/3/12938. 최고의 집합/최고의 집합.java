class Solution {
    public int[] solution(int n, int s) {
        int avg = s / n;
        if (avg == 0) {
            return new int[]{-1};
        }
        int[] result = new int[n];
        int remainder = s % n;
        for(int i = 0; i < n - remainder; i++) {
            result[i] = avg;
        }
        for(int i = n - remainder; i < n; i++) {
            result[i] = avg + 1;
        }
        return result;
    }
}