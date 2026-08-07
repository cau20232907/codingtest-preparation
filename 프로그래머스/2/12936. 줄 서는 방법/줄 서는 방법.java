class Solution {
    public int[] solution(int n, long k) {
        int[] orderPerPosition = new int[n];
        k--;
        long currentDigit = 1;
        for (int i = 2; i <= n; i++) {
            orderPerPosition[n - i] =
                (int) ((k % (currentDigit * i)) / currentDigit);
            currentDigit *= i;
        }
        
        boolean[] used = new boolean[n];
        int[] answer = new int[n];
        for (int i = 0; i < n; i++) {
            int order = orderPerPosition[i];
            int number = 0;
            while (true) {
                if (!used[number]) {
                    order--;
                    if (order < 0) {
                        used[number] = true;
                        break;
                    }
                }
                number++;
            }
            number++;
            answer[i] = number;
        }
        return answer;
    }
}