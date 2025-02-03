import java.util.*;

class Solution {
    int solution(int[][] land) {
        int[] maxVals=land[0]; //원래는 복사를 하는 게 맞음
        for(int i=1;i<land.length;i++){
            int[] newMaxs=land[i]; //이 역시 원래는 복사가 맞음
            int[][] maxRes=max2(maxVals);
            for(int j=0;j<newMaxs.length;j++){
                if(maxRes[0][1]!=j) newMaxs[j]+=maxRes[0][0];
                else newMaxs[j]+=maxRes[1][0];
            }
            maxVals=newMaxs;
        }
        return Arrays.stream(maxVals).max().getAsInt();
    }
    
    private int[][] max2(final int[] arr){
        int[][] result=new int[][]{{arr[0],0},{Integer.MIN_VALUE,-1}};
        for(int i=1;i<arr.length;i++){
            if(result[1][0]<arr[i]){
                result[1][0]=arr[i];
                result[1][1]=i;
                if(result[0][0]<arr[i]) {
                    //swap
                    int[] tmp=result[1];
                    result[1]=result[0];
                    result[0]=tmp;
                }
            }
        }
        return result;
    }
}