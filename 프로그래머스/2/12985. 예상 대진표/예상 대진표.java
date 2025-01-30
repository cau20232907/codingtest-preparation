class Solution{
    public int solution(int n, int a, int b){
        a--;
        b--;
        int answer = 0;
        while(a!=b){
            a/=2;
            b/=2;
            answer++;
        }
        return answer;
    }
}
/*
0부터 시작으로 변경
/2시 다음 번호
언제 같아지는지 보면 됨
3,6 -> 1,3 -> 0,1 -> 0,0 3
*/