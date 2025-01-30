import java.util.HashMap;
import java.util.ArrayList;

class Solution {
    
    private static final String[] logStr={"님이 들어왔습니다.","님이 나갔습니다."};
    
    private final HashMap<String,String> nickname=new HashMap<>();
    
    public String[] solution(String[] record) {
        ArrayList<Log> logs=new ArrayList<>();
        for(String cuiInput:record){
            String[] cmds=cuiInput.split(" ");
            switch(cmds[0]){
                case "Enter":{
                    nickname.put(cmds[1],cmds[2]);
                    logs.add(new Log(cmds[1],0));
                    break;
                }
                case "Leave":{
                    logs.add(new Log(cmds[1],1));
                    break;
                }
                case "Change":{
                    nickname.put(cmds[1],cmds[2]);
                    break;
                }
            }
        }
        
        String[] answer = new String[logs.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=logs.get(i).toString();
        }
        return answer;
    }

    private class Log{
        private final String uid;
        private final int mode;
        

        Log(String uid, int mode){
            this.uid=uid;
            this.mode=mode;
        }

        @Override
        public String toString(){
            return nickname.get(uid)+logStr[mode];
        }
    }
}
/*
Map으로 이름 저장(DB)
id, in/out 기록 저장(Array)
마지막에 정보 모아 한꺼번에 출력
*/