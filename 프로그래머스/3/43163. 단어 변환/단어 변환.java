import java.util.*;

class Solution {
    public int solution(String begin, String target, String[] words) {
        Set<String> thisWord=new HashSet<>();
        Set<String> nextWord=new HashSet<>();
        thisWord.add(begin);
        boolean[] visited=new boolean[words.length];
        int changedTimes=0;
        while(!thisWord.contains(target)){
            if(thisWord.isEmpty()) return 0;
            for(String word:thisWord){
                for(int i=0;i<words.length;i++){
                    String opponentWord=words[i];
                    if(visited[i]||word.length()!=opponentWord.length())
                        continue;
                    boolean diffFlag=false;
                    boolean flag=true;
                    for(int j=0;j<word.length();j++){
                        if(word.charAt(j)!=opponentWord.charAt(j)){
                            if(diffFlag){
                                flag=false;
                                break;
                            }
                            else diffFlag=true;
                        }
                    }
                    if(flag) {
                        nextWord.add(opponentWord);
                        visited[i]=true;
                    }
                }
            }
            changedTimes++;
            thisWord=nextWord;
            nextWord=new HashSet<>();
        }
        return changedTimes;
    }
}