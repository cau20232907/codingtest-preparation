class Solution {
    public int[] solution(String s) {
        int[] index=new int[26];
        for(int i=0;i<index.length;i++) index[i]=-1;
        int[] answer = new int[s.length()];
        for(int i=0;i<answer.length;i++){
            int ch=s.charAt(i)-'a';
            if(index[ch]==-1) answer[i]=-1;
            else answer[i]=i-index[ch];
            index[ch]=i;
        }
        return answer;
    }
}