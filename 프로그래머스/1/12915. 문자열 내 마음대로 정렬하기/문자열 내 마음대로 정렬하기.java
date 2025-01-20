import java.util.*;

class Solution {
    public String[] solution(String[] strings, int n) {
        Arrays.sort(strings,(i,j)->{
            int temp = Character.compare(i.charAt(n),j.charAt(n));
            if(temp==0) return i.compareTo(j);
            else return temp;
            });
        return strings;
    }
}