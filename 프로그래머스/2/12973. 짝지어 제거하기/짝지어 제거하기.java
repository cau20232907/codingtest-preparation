class Solution
{
    public int solution(String s) {
        byte[] input=s.getBytes();
        byte[] stack=new byte[input.length/2]; //Stack 직접 구현
        //짝지어 사라지려면 길이 절반 이상으로 stack이 쌓이면 안됨
        //남은 글자로 stack을 전부 지울 수 없기 때문(==모두 제거 불가)
        int pos=-1; //stack len
        for(byte ch:input){
            if(pos==-1||ch!=stack[pos]){
                if(pos==stack.length-1) return 0;
                else stack[++pos]=ch;
            }
            else pos--;
        }
        if(pos==-1) return 1;
        else return 0;
    }
}