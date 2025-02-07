class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int startingPoint=1; //1부터
        final int divider=w*2+1; //상수 취급
        for(int i=0;i<stations.length;i++){
            answer+=(stations[i]-startingPoint+w)/divider; //round up
            //((끝지점:stations[i]-w)-(시작지점)+(round를 위한 w*2(나누는 값에서 1 뺀 것)))
            startingPoint=stations[i]+w+1;
        }
        return answer+(n-startingPoint+divider)/divider; //마지막 기지국 이후 구간
        //((끝지점:n+1)-(시작지점)+(round를 위한 w*2(나누는 값에서 1 뺀 것)))
        //divider를 빼면 round 문제 발생함
    }
}