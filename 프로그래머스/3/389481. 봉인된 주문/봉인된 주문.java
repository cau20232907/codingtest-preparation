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
        int pos=Arrays.binarySearch(orders,n);
        if(pos<0) pos=(pos+1)*(-1); //n보타 큰 최초의 수 idx
        n+=pos;
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