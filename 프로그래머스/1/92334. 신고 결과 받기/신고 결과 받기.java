import java.util.*;
import java.util.stream.Collectors;

class Solution {
    Map<String,Set<String>> reportSet=new HashMap<>();
    Map<String,Integer> reportedSet=new HashMap<>();
    Set<String> resultSet;
    public int[] solution(String[] id_list, String[] report, int k) {
        for(int i=0;i<report.length;i++){
            String[] cmd=report[i].split(" ");
            if(!reportSet.containsKey(cmd[0])){
                reportSet.put(cmd[0],new HashSet<>());
            }else if(reportSet.get(cmd[0]).contains(cmd[1]))
                continue;
            
            reportSet.get(cmd[0]).add(cmd[1]);
            reportedSet.put(cmd[1],reportedSet.getOrDefault(cmd[1],0)+1);
        }
        
        resultSet=reportedSet.entrySet().stream()
            .filter(entry->entry.getValue()>=k)
            .map(entry->entry.getKey()).collect(Collectors.toSet());
        //toList() 사용 불가(버전 19~)
        
        List<Integer> wrapper = Arrays.stream(id_list)
            .map(id->getEmailCount(id)).collect(Collectors.toList());
        //toIntStream(Integer::intValue)가 먹지 않아 임시조치
        int[] answer=new int[wrapper.size()];
        for(int i=0;i<answer.length;i++){
            answer[i]=wrapper.get(i);
        }
        return answer;
    }
    
    private int getEmailCount(String id){
        if(!reportSet.containsKey(id)) return 0;
        else return reportSet.get(id).stream()
            .filter(report->resultSet.contains(report))
                .toArray().length;
    }
}

/*
report set 만들기(신고자 기준 신고한 사람)
reported map(신고당한 횟수)
신고당한 횟수가 k 넘는 것만 필터링
각 entry에서 신고당한 것만 필터링해 수 세기
*/