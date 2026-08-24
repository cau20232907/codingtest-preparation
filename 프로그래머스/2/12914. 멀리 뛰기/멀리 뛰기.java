class Solution {
    public long solution(int n) {
        long[] cases = new long[n + 1];
        cases[0] = 1;
        cases[1] = 1;
        for (int i = 2; i < cases.length; i++) {
            cases[i] = (cases[i - 1] + cases[i - 2]) % 1234567;
        }
        return cases[n];
    }
}