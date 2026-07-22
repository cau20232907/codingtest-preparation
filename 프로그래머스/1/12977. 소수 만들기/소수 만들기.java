class Solution {
    int[] numbers;
    public int solution(int[] nums) {
        numbers = nums;
        return addToPrime(0, 0, 3);
    }
    
    private int addToPrime(int currentSum, int beginIndex, int remaining) {
        int total = 0;
        for(int i = beginIndex; i < numbers.length; i++) {
            if (remaining == 1) {
                int finalNumber = currentSum + numbers[i];
                boolean isPrime = true;
                for(int j = 2; j * j <= finalNumber; j++) {
                    if (finalNumber % j == 0) {
                        isPrime = false;
                        break;
                    }
                }
                if(isPrime) {
                    total++;
                }
            } else {
                total += addToPrime(
                    currentSum + numbers[i],
                    i + 1,
                    remaining - 1
                );
            }
        }
        return total;
    }
}