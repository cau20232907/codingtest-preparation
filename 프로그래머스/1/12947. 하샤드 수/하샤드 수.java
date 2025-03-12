class Solution {
    public boolean solution(int x) {
        int added=0,clone=x;
        while(clone!=0){
            added+=clone%10;
            clone/=10;
        }
        return x%added==0;
    }
}