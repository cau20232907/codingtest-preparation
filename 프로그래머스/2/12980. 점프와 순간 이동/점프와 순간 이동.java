import java.util.*;

public class Solution {
    public int solution(int n) {
        // return Integer.toBinaryString(n).replace("0","").length(); //1줄에 넣는 방법
        int answer=0;
        while(n!=0){
            answer+=n&1;
            n>>=1;
        }
        return answer;
    }
}
//뒤로는 갈 수 없음