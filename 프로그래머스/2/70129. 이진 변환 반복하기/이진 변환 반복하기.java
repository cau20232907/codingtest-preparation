import java.util.*;

class Solution {
    public int[] solution(String s) {
        int removed=0,count=0;
        while(!s.equals("1")){
            int sizeAfter=0;
            for(int i=0;i<s.length();i++){
                if(s.charAt(i)=='1') sizeAfter++;
                else removed++;
            }
            count++;
            s=Integer.toBinaryString(sizeAfter);
        }
        return new int[]{count,removed};
    }
}
//filter 0, size 구함, toBinaryString
//size diff를 구해 저장해야 함
