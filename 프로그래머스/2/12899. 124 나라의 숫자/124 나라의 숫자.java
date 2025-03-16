import java.util.stream.Collectors;

class Solution {
    public String solution(int n) {
        byte[] str=Integer.toString(n,3).getBytes();
        for(int i=str.length-1;i>0;i--){
            if(str[i]<='0'){
                str[i]+=3;
                str[i-1]--;
            }
            if(str[i]=='3') str[i]++;
        }
        int startPoint=str[0]=='0'?1:0;
        return new String(str,startPoint,str.length-startPoint);
    }
}
/*
 1   1   1
 2   2   2
 3  10   4
 4  11  11
 5  12  12
 6  20  14
 7  21  21
 8  22  22
 9 100  24
10 101  41
11 102  42
12 110  44
13 111 111
14 112 112
15 120 114
'4'=="10"

*/