import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        Arrays.sort(lost); //왜 이게 기본 사양이 아닌거지?
        Arrays.sort(reserve);
        n-=lost.length;
        for(int i=0,j=0;i<lost.length;i++){
            while(j<reserve.length&&reserve[j]<lost[i]-1) j++;
            
            if(j==reserve.length) return n; //여분 없음
            //체격이 적절함
            else if(reserve[j]<=lost[i]+1) {
                //원주인이 도둑맞아 빌려줄 수 없음, 그러나 원주인은 입을 수 있기에 원주인을 셈
                if(i+1!=lost.length&&lost[i+1]==reserve[j]) i++;
                //원주인이 도둑맞았으나 이전 주인의 체육복을 가리킴
                else if(j+1!=reserve.length&&lost[i]==reserve[j+1]) j++;
                j++; //체육복 사용
                n++;
            }
        }
        return n;
    }
}
//내 것을 도둑맞았으나 내 것은 빌려주고 내가 다른 사람 것을 빌려 입을 수는 없음 -> 확인 절차 필요
//즉 lost: [2,3,4], reserve:[3,4,5]면 2번 학생은 수업을 들을 수 없음