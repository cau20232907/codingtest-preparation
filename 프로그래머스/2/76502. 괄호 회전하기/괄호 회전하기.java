import java.util.Stack;
/*
처음으로 여는 괄호가 시작되는 지점에서부터 직전 위치까지 반복하면서
Stack이 빈 횟수를 측정하면 됨
Stack 불일치시 0, Stack size 0일때 닫는 괄호가 나오면 이후 여는 괄호를 시작점이라 가정하고 시작
*/
class Solution {
    private boolean isCorrectParentheses(byte open, byte close){
        return switch(open){
            case '('->close==')';
            case '{'->close=='}';
            case '['->close==']';
            default -> throw new RuntimeException();
                //이런 형태의 switch문 사용시 default 필수
        };
    }
    
    public int solution(String s) {
        byte[] input=s.getBytes();
        //한번에 복사해서 쟁이는게 여러 번 가져오는 것보다 빠를 듯
        int startPoint=0; //시작점
        boolean isStarted=false;//시작 여부
        int count=0;//result(return 대상)
        Stack<Byte> checkStack=new Stack<>(); //이건 직접 구현하는게 빠르긴 함
        
        //loop 1
        for(int i=0;i<input.length;i++){
            switch(input[i]){
                case '(': case '{': case '[':{
                    if(!isStarted){ //계산 시작 안함
                    //계산 시작(계산 설정값 입력)
                    startPoint=i;
                    isStarted=true;
                    }
                    checkStack.push(input[i]);
                    break;
                }
                case ')': case '}': case ']':{
                    if(isStarted){ //계산 시작
                        //if(!isStarted); else if...로 쓰는 게 깔끔하긴 함
                        if(checkStack.isEmpty()){
                            //계산 초기화 (loop 2에서는 진행 안하며,
                            //loop 2에서 이런 상황이 발생하면
                            //어떠한 때에서도 올바른 문자열이 될 수 없음)
                            isStarted=false;
                            checkStack.clear();
                            count=0;
                        }
                        //pop을 if문 안에 욱여넣었기 때문에 else로 감쌀 이유 없음
                        else if(!isCorrectParentheses
                           (checkStack.pop(),input[i])) return 0;
                        //위 if문: 괄호가 맞지 않는지 확인
                        //(괄호가 안 맞으면 어떠한 때에서도 올바른 문자열이 될 수 없음)
                        else if(checkStack.isEmpty()) count++;
                        //stack이 비면 이 이후 지점부터 시작해도(i만큼 밀어도)
                        //올바른 문자열이 됨
                    }
                }
            }
        }
        
        if(!isStarted) return 0;
        //loop 2, startPoint가 고정이며 Stack이 빌 때 pop이 필요하면 return 0
        for(int i=0;i<startPoint;i++){
            switch(input[i]){
                case '(': case '{': case '[':{
                    checkStack.push(input[i]);
                    break;
                }
                case ')': case '}': case ']':{
                    if(checkStack.isEmpty()) return 0;
                    //pop을 if문 안에 욱여넣었기 때문에 else로 감쌀 이유 없음
                    else if(!isCorrectParentheses
                       (checkStack.pop(),input[i])) return 0;
                    else if(checkStack.isEmpty()) count++;
                }
            }
        }
        //여는 괄호가 남아있으면 return 0
        if(checkStack.isEmpty()) return count;
        else return 0;
    }
}