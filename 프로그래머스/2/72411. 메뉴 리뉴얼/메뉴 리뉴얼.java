import java.util.*;
import java.util.stream.*;

class Solution {
    public String[] solution(String[] orders, int[] course) {
        Map<Integer,Map<String,Integer>> combinations=new HashMap<>(); //DB
        for(int i=0;i<course.length;i++)
            combinations.put(course[i],new HashMap<>());
        
        for(int i=0;i<orders.length;i++){
            byte[] ordered=orders[i].getBytes();
            Arrays.sort(ordered);
            boolean[] toPick=new boolean[ordered.length];
            while(true){
                //대상이 맞는지 확인 및 넣기(빈 문자열 포함)
                StringBuilder collectTarget=new StringBuilder();
                for(int j=0;j<toPick.length;j++)
                    if(toPick[j])
                        collectTarget.append((char)ordered[j]);
                if(combinations.containsKey(collectTarget.length())){
                    //course에 들어온 문자 길이와 맞을 때만 그에 맞게 추가
                    String collected=collectTarget.toString();
                    Map<String,Integer> saveTarget=
                        combinations.get(collected.length());
                    saveTarget.put(collected,saveTarget.getOrDefault(collected,0)+1);
                }
                
                //다음 들어갈 문자 설정
                int target=0;
                while(toPick[target]){
                    toPick[target]=false;
                    target++;
                    if(target==toPick.length) break;
                }
                if(target==toPick.length) break;
                else toPick[target]=true;
            }
        }
        
        List<String> result=new ArrayList<>();
        for(int i=0;i<course.length;i++){
            Map<String,Integer> totalOrdered=combinations.get(course[i]);
            totalOrdered.values().stream()
                .max((j,k)->j.compareTo(k)).ifPresent(maxCount->{
                if(maxCount>1)
                    result.addAll(totalOrdered.entrySet().stream()
                                 .filter(s->s.getValue()==maxCount)
                                 .map(s->s.getKey()).collect(Collectors.toList()));
            });
        }
        return result.stream().sorted().toArray(String[]::new);
    }
}
/*
가능한 모든 조합을 저장함
2~10개짜리 Map을 두어 저장하고 entry를 정렬해 최대인 것의 값을 가져오고, filter링 진행
*/