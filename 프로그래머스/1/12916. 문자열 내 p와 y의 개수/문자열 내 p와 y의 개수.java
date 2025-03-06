class Solution {
    boolean solution(String s) {
        int p=0,y=0;
        for(int i=0;i<s.length();i++){
            char ch=s.charAt(i);
            if(ch=='p'||ch=='P') p++;
            else if(ch=='y'||ch=='Y') y++;
        }
        return p==y;
    }
}