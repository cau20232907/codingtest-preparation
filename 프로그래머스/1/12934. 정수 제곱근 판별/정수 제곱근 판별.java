class Solution {
    public long solution(long n) {
        long i = 0;
        while(i * i < n) {
            i++;
        }
        if (i * i == n) {
            return (i + 1) * (i + 1);
        } else {
            return -1;
        }
    }
}