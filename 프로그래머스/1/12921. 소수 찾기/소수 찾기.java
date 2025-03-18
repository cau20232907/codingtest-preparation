import java.util.stream.*;

class Solution {
    public int solution(int n) {
        return (int) IntStream.range(2,n+1)
            .filter(i->{
                int fin=(int)(Math.sqrt(i)+1);
                for(int j=2;j<fin;j++)
                    if(i%j==0) return false;
                return true;
            })
            .count();
    }
}