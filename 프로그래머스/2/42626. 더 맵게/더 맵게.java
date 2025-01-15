import java.util.*;

class Solution {
    public int solution(int[] scoville, int K) {
        int answer = 0;
        TreeMap<Integer,Integer> foodBySco=new TreeMap<>();
        Arrays.stream(scoville)
            .forEach(i->foodBySco.put(i,foodBySco.getOrDefault(i,0)+1));
        // {
        //     StringBuilder sb=new StringBuilder();
        //     for(int key:foodBySco.keySet()){
        //         sb.append(key+": "+foodBySco.getOrDefault(key,0)+"; ");
        //     }
        //     System.out.println(sb.toString());
        // }
        
        int minSco=foodBySco.firstKey();
        while(minSco<K){
            if(foodBySco.get(minSco)==1){
                //삭제
                foodBySco.remove(minSco);
                
                if(foodBySco.size()==0) return -1;
                
                int nextSco=foodBySco.firstKey();
                int value=minSco+nextSco*2;
                foodBySco.put(value,foodBySco.getOrDefault(value,0)+1);
                
                if(foodBySco.get(nextSco)==1) foodBySco.remove(nextSco);
                else foodBySco.put(nextSco,foodBySco.get(nextSco)-1);
            }else{ //최소가 여러 개
                int value=minSco*3;
                foodBySco.put(value,foodBySco.getOrDefault(value,0)+1);
                
                //삭제
                if(foodBySco.get(minSco)==2) foodBySco.remove(minSco);
                else foodBySco.put(minSco,foodBySco.get(minSco)-2);
            }
            
            answer++;
            if(foodBySco.size()==0) break;
            minSco=foodBySco.firstKey();
        }
        return answer;
    }
}