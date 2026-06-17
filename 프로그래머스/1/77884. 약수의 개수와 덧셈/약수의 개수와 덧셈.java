class Solution {
    public int solution(int left, int right) {
        // 약수의 수가 홀수: 어떤 수의 제곱
        int subtract = 0;
        int i = 1;
        while(i * i < left) {
            i++;
        }
        while(i * i <= right) {
            subtract += i * i;
            i++;
        }
        return (right * (right + 1) / 2) // right까지의 모든 수의 합
            - (left * (left - 1) / 2) // left - 1까지의 모든 수의 합
            - subtract * 2;
    }
}