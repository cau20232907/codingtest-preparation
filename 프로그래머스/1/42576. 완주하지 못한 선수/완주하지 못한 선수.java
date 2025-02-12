import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    public String solution(String[] participant, String[] completion) {
        HashMap<String,Integer> remainingWithSameName=new HashMap<>();
        for(String entered:participant){
            if(remainingWithSameName.containsKey(entered))
                remainingWithSameName.put(entered,remainingWithSameName.get(entered)+1);
            else remainingWithSameName.put(entered,(Integer)1);
        }
        for(String finished:completion){
            if(remainingWithSameName.get(finished).equals(1))
                remainingWithSameName.remove(finished);
            else remainingWithSameName.put(finished,remainingWithSameName.get(finished)-1);
        }
        return new ArrayList<String>(remainingWithSameName.keySet()).get(0);
    }
}