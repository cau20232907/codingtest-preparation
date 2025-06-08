import java.util.*;

class Solution {
    public int solution(int n, int k) {
        return (int)
            Arrays.stream(Integer.toString(n,k).split("0"))
            .filter(i->{
                if (i.length()==0) return false;
                long num=Long.parseLong(i);
                if (num<2) return false;
                double sqrt=Math.sqrt(num)+1; //부동소수 문제 해결
                if (sqrt>num) sqrt=num-0.5; //이로 인한 버그 수정
                for(long j=2;j<sqrt;j++){
                    if (num%j==0) return false;
                }
                return true;
            })
            .count();
    }
}