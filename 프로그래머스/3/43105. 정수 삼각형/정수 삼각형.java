import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        if(triangle.length==1) return triangle[0][0];
        int[] maxVales=new int[triangle.length];
        maxVales[0]=triangle[0][0]+triangle[1][0];
        maxVales[1]=triangle[0][0]+triangle[1][1];
        for(int i=2;i<triangle.length;i++){
            //앞의 것을 참조하므로 뒤부터 해야 중복 계산되지 않음
            maxVales[i]=maxVales[i-1]+triangle[i][i];
            for(int j=i-1;j>0;j--){
                maxVales[j]=Math.max(maxVales[j],maxVales[j-1])+triangle[i][j];
            }
            maxVales[0]+=triangle[i][0];
        }
        return Arrays.stream(maxVales).max().getAsInt();
    }
}
//그대로, 또는 하나 오른쪽으로 이동 가능
//각 공간별 최대값 저장