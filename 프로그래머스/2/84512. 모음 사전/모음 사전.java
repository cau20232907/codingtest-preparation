class Solution {
    private static final int numOfAlphabet=5;
    public int solution(String word) {
        int answer = 0;
        //byte[] bytes=word.toBytes();
        int[] digitValues=new int[5]; //각 위치에서의 가중치
        digitValues[digitValues.length-1]=1;
        for(int i=digitValues.length-2;i>=0;i--){
            digitValues[i]=digitValues[i+1]*numOfAlphabet+1;
        }
        for(int i=0;i<word.length();i++){
            answer++; //일단 있으면 없는 것 보다는 하나 뒤니 1 추가
            answer+=digitValues[i]*switch(word.charAt(i)){
                case 'A' -> 0;
                case 'E' -> 1;
                case 'I' -> 2;
                case 'O' -> 3;
                case 'U' -> 4;
                default -> throw new RuntimeException();
            };
        }
        return answer;
    }
}
/*
AAAA :  4
AAAAA:  5
AAAAE:  6
AAAAU:  9
AAAE : 10 (+6)
AAAEA: 11
AAAEU: 15
AAAI : 16 (+6)
AAAO : 22
AAAU : 28
AAE  : 34 (+31)
'/0': 0
A: 1
E: 2
I: 3
O: 4
U: 5
4째자리: *6
3째자리: *31 (6*5*1)
2째자리: *   (31*5*1)
*/