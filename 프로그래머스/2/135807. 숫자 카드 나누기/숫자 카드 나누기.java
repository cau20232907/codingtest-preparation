import java.util.*;

class Solution {
    public int solution(int[] arrayA, int[] arrayB) {
        int gcdA = getGcd(arrayA);
        int gcdB = getGcd(arrayB);
        
        // 상대의 숫자로 나눌 수 있는지 확인
        for(int i=0; i<arrayB.length; i++) {
            if(arrayB[i]%gcdA == 0) {
                gcdA = 0;
                break;
            }
        }
        for(int i=0; i<arrayA.length; i++) {
            if(arrayA[i]%gcdB == 0) {
                gcdB = 0;
                break;
            }
        }
        
        return Math.max(gcdA, gcdB);
    }
    
    int getGcd(int[] array) {
        ArrayDeque<Integer> nums = new ArrayDeque<>();
        for(int i=0; i<array.length; i++) {
            nums.add(array[i]);
        }
        while(nums.size() != 1) {
            int max = nums.pollFirst();
            int min = nums.peekLast();
            int next = max % min; // gcd 연산
            switch(next) {
                case 0:
                    break;
                case 1: //최대공약수가 1
                    return 1;
                default:
                    nums.add(next);
            }
        }
        return nums.pollLast();
    }
}