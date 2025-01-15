import java.util.*;

class Solution {
    public int solution(int N, int number) {
        Set<Integer>[] numbersByUses=new Set[9];
        for(int i=1;i<numbersByUses.length;i++){
            int stick=N;
            for(int j=1;j<i;j++)
                stick=stick*10+N;
            numbersByUses[i]=new HashSet<>(List.of(stick));
            for(int j=1;j<=i/2;j++){
                for(int valA:numbersByUses[j]){
                    for(int valB:numbersByUses[i-j]){
                        numbersByUses[i].add(valA+valB);
                        numbersByUses[i].add(valA-valB);
                        numbersByUses[i].add(valB-valA);
                        numbersByUses[i].add(valA*valB);
                        if(valB!=0)
                            numbersByUses[i].add(valA/valB);
                        if(valA!=0)
                            numbersByUses[i].add(valB/valA);
                    }
                }
            }
            if(numbersByUses[i].contains(number)) return i;
        }
        return -1;
    }
}
/*
나누기 시 1을 얻음
1, 11, 111, 1111, 11111 가능
1개: 자기 자신
2개: 붙이기, 2배, 제곱, 0, 1
3개: 1개+2개 or 3개 붙이기
4개: 1개+3개 or 2개+2개
*/