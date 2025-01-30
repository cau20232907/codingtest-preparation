import java.util.HashMap;

class Solution {
    HashMap<String,Member> status=new HashMap<>();
    public int[] solution(String[] enroll, String[] referral, String[] seller, int[] amount) {
        status.put("-",new Member(null));
        for(int i=0;i<enroll.length;i++)
            status.put(enroll[i],new Member(referral[i]));
        
        for(int i=0;i<seller.length;i++)
            status.get(seller[i]).addAmount(amount[i]*100);
        
        int[] answer = new int[enroll.length];
        for(int i=0;i<enroll.length;i++)
            answer[i]=status.get(enroll[i]).getBenefit();
        return answer;
    }
    
    private class Member{
        private String referral; //key
        private int benefit;
        
        Member(String referral){
            this.referral=referral;
            this.benefit=0;
        }
        
        void addAmount(int amount){
            int guarantee=amount/10;
            benefit+=amount-guarantee; //owned
            if(guarantee>0&&referral!=null)
                status.get(referral).addAmount(guarantee);
        }
        
        int getBenefit(){
            return benefit;
        }
    }
}
/*
자신의 enroll과 referral, benefit을 저장하면 됨
*/