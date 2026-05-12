class Solution {
    public int solution(int num) {
        long currentNumber = num;
        for(int i = 0; i < 500; i++) {
            if (currentNumber == 1) {
                return i;
            } else if (currentNumber % 2 == 0) {
                currentNumber /= 2;
            } else {
                currentNumber = currentNumber * 3 + 1;
            }
        }
        if (currentNumber == 1) {
            return 500;
        }
        return -1;
    }
}