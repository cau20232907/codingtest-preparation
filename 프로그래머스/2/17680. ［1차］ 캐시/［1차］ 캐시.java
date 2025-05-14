import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        if(cacheSize<=0) return cities.length*5;
        int answer = 0;
        ArrayDeque<String> cache=new ArrayDeque<>(cacheSize);
        for(String city:cities){
            city=city.toLowerCase();
            if(cache.remove(city)){
                //cache.stream().anyMatch(city::equals)와 동일
                answer++;
            } else {
                answer+=5;
                if(cache.size()==cacheSize)
                    cache.poll();
            }
            cache.add(city);
        }
        return answer;
    }
}