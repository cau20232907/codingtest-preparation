class Solution {
    public int[] solution(int m, int n, int startX, int startY, int[][] balls) {
        int[] answer = new int[balls.length];
        for(int i=0;i<balls.length;i++){
            int dist=Integer.MAX_VALUE;
            if(!(startY==balls[i][1]&&startX>balls[i][0]))
                dist=(startX+balls[i][0])*(startX+balls[i][0])+
                    (startY-balls[i][1])*(startY-balls[i][1]);
            if(!(startX==balls[i][0]&&startY>balls[i][1]))
                dist=Math.min(dist,(startX-balls[i][0])*(startX-balls[i][0])+
                    (startY+balls[i][1])*(startY+balls[i][1]));
            if(!(startY==balls[i][1]&&startX<balls[i][0]))
                dist=Math.min(dist,(startX+balls[i][0]-m*2)*(startX+balls[i][0]-m*2)+
                    (startY-balls[i][1])*(startY-balls[i][1]));
            if(!(startX==balls[i][0]&&startY<balls[i][1]))
                dist=Math.min(dist,(startX-balls[i][0])*(startX-balls[i][0])+
                    (startY+balls[i][1]-n*2)*(startY+balls[i][1]-n*2));
            answer[i]=dist;
        }
        return answer;
    }
}