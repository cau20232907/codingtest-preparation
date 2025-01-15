class Solution {
    public int[] solution(int brown, int yellow) {
        int acr=0,dwn=3; //dwn은 작아야 3
        acr=brown/2-1; //(brown/2+2 -3(dwn))
        //brown은 맞았으니 yellow만 확인
        while(acr>dwn){ //예외처리 안함
            if(yellow==(acr-2)*(dwn-2)) break;
            acr--;
            dwn++;
        }
        return new int[]{acr,dwn}; //예외처리 안함
    }
}
/*
acr, dwn -> 구할 것
(acr+dwn)*2-4 == brown 수 (반드시 짝수)
(acr-2)*(dwn-2) == yellow 수
acr>=dwn>2 //yellow가 존재함

acr+dwn == brown/2 +2
*/