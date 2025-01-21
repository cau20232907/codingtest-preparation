import java.util.*;
import java.util.stream.*;

class Solution {
    public int[] solution(String s) {
        String[] tmp=s.split("\\},\\{"); //처음과 마지막 빼고는 잘 분리됨
        tmp[0]=tmp[0].substring(2,tmp[0].length());
        tmp[tmp.length-1]=
            tmp[tmp.length-1].substring(0,tmp[tmp.length-1].length()-2);
        final Set<Integer>[] tupleBySet=Arrays.stream(tmp)
            .map(setStr->Arrays.stream(setStr.split(","))
                 .map(Integer::parseInt)
                 .collect(Collectors.toSet()))
            .sorted((i,j)->Integer.compare(i.size(),j.size()))
            .toArray(Set[]::new);
        int[] answer = new int[tupleBySet.length];
        answer[0]=tupleBySet[0].stream().mapToInt(Integer::intValue).sum();//아무거나 가져오는 게 기억이 안 남
        Set<Integer> tempSet=new HashSet<>();
        for(int i=1;i<tupleBySet.length;i++){
            tempSet.addAll(tupleBySet[i]);
            tempSet.removeAll(tupleBySet[i-1]);
            answer[i]=tempSet.stream()
                .mapToInt(Integer::intValue).sum();
        }
        return answer;
    }
}

/*
Set<int> 배열로 변경, 길이 순으로 정렬
길이가 가장 큰 게 return 길이
첫 원소 1개 넣기
두번째는 두번째에서 앞의 set removeAll한 결과 넣기
마지막까지 반복
*/