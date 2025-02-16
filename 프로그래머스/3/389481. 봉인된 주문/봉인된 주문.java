import java.util.*;

class Solution {
    public String solution(long n, String[] bans) {
        long[] orders=Arrays.stream(bans)
            .mapToLong(s->{
                long result=0;
                for(byte letter:s.getBytes())
                    result=result*26+letter-'a'+1;
                return result;
            }).sorted().toArray();
        //이진 탐색 라이브러리 에러로 임시조치
        int pos=0;
        while(pos<orders.length&&orders[pos]<=n){
            n++;
            pos++;
        }
        //다시 문자로 변경
        StringBuilder answer=new StringBuilder();
        while(n!=0){
            n--;
            answer.append((char)(n%26+'a'));
            n/=26;
        }
        return answer.reverse().toString();
    }
}

//정렬 후 각 bans 단어의 순서 확인
/*
a:1
b:2
z:26
aa:27=1*26+1
ab:28
ba:53=2*26+1
zz:26*26+26
=>26진수임
*/