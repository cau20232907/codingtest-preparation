import java.util.*;

class Solution {
    public int solution(String numbers) {
        byte[] digits=new byte[10]; //0~9, 다이어그램 방식, 숫자 중복 시 용이함
        for(byte eachDigit: numbers.getBytes()){
            digits[eachDigit-'0']++;
        }
        
        int answer = 0;
        for(int i=1;i<10;i++){
            if(digits[i]==0) continue;
            if(i==2||i==3||i==5||i==7) answer++;
            digits[i]--;
            answer+=writeOneDigit(digits,i);
            digits[i]++;
        }
        
        return answer;
    }
    
    private int writeOneDigit(byte[] remains, int currentNum){
        int answer=0;
        currentNum*=10;
        for(int i=0;i<10;i++){
            if(remains[i]==0) continue;
            int nextNum=currentNum+i;
            if((i==1||i==3||i==7||i==9)&& //자릿수로 확인 가능하면 제외
                checkPrimeWithoutLastdigit(nextNum)) answer++;
            remains[i]--;
            answer+=writeOneDigit(remains,nextNum);
            remains[i]++;
        }
        return answer;
    }
    
    private boolean checkPrimeWithoutLastdigit(int num){
        double checkUpTo=Math.sqrt(num)+1;
        for(int i=3;i<checkUpTo;i+=2){
            if(num%i==0) return false;
        }
        return true;
    }
}