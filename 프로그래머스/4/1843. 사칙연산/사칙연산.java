class Solution {
    public int solution(String arr[]) {
        boolean[] isAdd=new boolean[arr.length/2];
        int[][][] maxNumEach=new int[arr.length/2+1][arr.length/2+1][2];
        //[최대, 최소]
        for(int i=0;i<isAdd.length;i++){
            maxNumEach[0][i][0]=Integer.parseInt(arr[i*2]);
            maxNumEach[0][i][1]=maxNumEach[0][i][0];
            isAdd[i]=arr[i*2+1].equals("+");
        }
        maxNumEach[0][isAdd.length][0]=Integer.parseInt(arr[isAdd.length*2]);
        maxNumEach[0][isAdd.length][1]=maxNumEach[0][isAdd.length][0];
        for(int j=0;j<maxNumEach.length-1;j++){
            if(isAdd[j])
                maxNumEach[1][j][0]=maxNumEach[0][j][0]+maxNumEach[0][j+1][0];
            else
                maxNumEach[1][j][0]=maxNumEach[0][j][0]-maxNumEach[0][j+1][0];
            maxNumEach[1][j][1]=maxNumEach[1][j][0];
        }
        for(int i=2;i<maxNumEach.length;i++){
            for(int j=0;j<maxNumEach.length-i;j++){
                if(isAdd[j]){
                    maxNumEach[i][j][0]=maxNumEach[0][j][0]+maxNumEach[i-1][j+1][0];
                    maxNumEach[i][j][1]=maxNumEach[0][j][1]+maxNumEach[i-1][j+1][1];
                }else{
                    maxNumEach[i][j][0]=maxNumEach[0][j][0]-maxNumEach[i-1][j+1][1];
                    maxNumEach[i][j][1]=maxNumEach[0][j][1]-maxNumEach[i-1][j+1][0];
                }
                for(int k=1;k<i;k++){
                    int num1,num2;
                    if(isAdd[j+k]){
                        num1=maxNumEach[k][j][0]+maxNumEach[i-k-1][j+k+1][0];
                        num2=maxNumEach[k][j][1]+maxNumEach[i-k-1][j+k+1][1];
                    }else{
                        num1=maxNumEach[k][j][0]-maxNumEach[i-k-1][j+k+1][1];
                        num2=maxNumEach[k][j][1]-maxNumEach[i-k-1][j+k+1][0];
                    }
                    maxNumEach[i][j][0]=Math.max(maxNumEach[i][j][0],num1);
                    maxNumEach[i][j][1]=Math.min(maxNumEach[i][j][1],num2);
                }
            }
        }
        return maxNumEach[maxNumEach.length-1][0][0];
    }
}
//연산자, 숫자 분리해 저장