class Solution {
    public String solution(String[] cards1, String[] cards2, String[] goal) {
        for(int idx1=0,idx2=0,idxGoal=0; idxGoal<goal.length; idxGoal++){
            if(idx1<cards1.length&&cards1[idx1].equals(goal[idxGoal]))
                idx1++;
            else if(idx2<cards2.length&&cards2[idx2].equals(goal[idxGoal]))
                idx2++;
            else return "No";
        }
        return "Yes";
    }
}
/*
idx 포인터 2개 두고
goal 하나씩 보면서 1인가 2인가 확인해 포인터 조정하고
둘다 아니면 No
*/