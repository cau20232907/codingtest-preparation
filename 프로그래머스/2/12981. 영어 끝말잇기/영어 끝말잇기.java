import java.util.HashSet;

class Solution {
    public int[] solution(int n, String[] words) {
        HashSet<String> usedWords=new HashSet<>();
        String currentWord=words[0]; //현재 단어, 한 번 쓰고 버림
        int wordLen=currentWord.length(); //단어 길이, 한 번 쓰고 버림
        if(wordLen<=1) return new int[]{1,1};
        usedWords.add(currentWord);
        char nextStartCh=currentWord.charAt(wordLen-1); //단어 시작 글자, 다음 단어로 넘어가도 유지
        for(int i=1;i<words.length;i++){
            currentWord=words[i];
            wordLen=currentWord.length();
            if(wordLen<=1||
              currentWord.charAt(0)!=nextStartCh||
              usedWords.contains(currentWord))
                return new int[]{i%n+1,i/n+1};
            usedWords.add(currentWord);
            nextStartCh=currentWord.charAt(wordLen-1);
        }
        return new int[]{0,0};
    }
}
/*
중복확인: set
단어 확인: 이전 단어의 마지막 글자 가져오기 + 글자 length 확인
탈락자: i%n+1
탈락차례: i/n+1
*/