import java.util.*;

class Solution {
    public int solution(String[][] clothes) {
        HashMap<String, Integer> clothesByPart=new HashMap<>();
        for(String[] cloth: clothes){
            clothesByPart.put(cloth[1],clothesByPart.getOrDefault(cloth[1],1)+1);
        }
        int result=1;
        for(String key:clothesByPart.keySet()){
            result*=clothesByPart.get(key);
        }
        return result-1;
    }
}