import java.util.*;
import java.util.stream.*;

class Solution {
    public int solution(int[] sales, int[][] links) {
        Employee[] employees = new Employee[sales.length];
        for(int i = 0; i<sales.length; i++) {
            employees[i] = new Employee(sales[i]);
        }
        for(int i = 0; i<links.length; i++) {
            employees[links[i][0] - 1].teamMates
                .add(employees[links[i][1] - 1]);
        }
        return employees[0].calculateCost()[0];
    }
    
    class Employee {
        int sale;
        List<Employee> teamMates;
        
        Employee(int sale) {
            this.sale = sale;
            teamMates = new ArrayList<>();
        }
        
        int[] calculateCost() {
            // [반드시 포함하지 않을 시 cost, 팀장 반드시 포함 시 추가되는 cost]
            
            if (teamMates.size() == 0) {
                return new int[]{0,sale};
            }
            
            // 하위 팀 계산
            List<int[]> lowerTeamsCost = teamMates.stream()
                .map(Employee::calculateCost)
                .collect(Collectors.toList());
            lowerTeamsCost.add(new int[]{0,sale}); // 이 팀 팀장 정보 추가
            
            // 이 팀 제외 비용
            int costWithoutTeam = lowerTeamsCost.stream()
                .mapToInt(c->c[0])
                .sum();
            
            // 팀장 반드시 포함 시 cost 계산
            int costWithLeader = sale + costWithoutTeam;
            
            // 팀장을 반드시 포함하지 않을 시 cost 계산
            int costWithoutLeader = costWithoutTeam +
                lowerTeamsCost.stream()
                .mapToInt(c->c[1])
                .min()
                .getAsInt(); // 절대 OptionalInt.Empty가 되지 않음
            
            return new int[]{
                costWithoutLeader,
                costWithLeader - costWithoutLeader
            };
        }
    }
}