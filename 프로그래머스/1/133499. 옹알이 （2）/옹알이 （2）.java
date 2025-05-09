class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] possibles={"aya","ye","woo","ma"};
        for(String data:babbling){
            int past=-1;
            while(true){
                int current=0;
                for(;current<possibles.length;current++)
                    if(data.startsWith(possibles[current]))
                        break;
                if(current==possibles.length||
                   past==current) break;
                else {
                    data=data.substring(possibles[current].length());
                    past=current;
                }
                if(data.length()==0){
                    answer++;
                    break;
                }
            }
        }
        return answer;
    }
}