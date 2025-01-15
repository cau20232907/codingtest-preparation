class Solution {
    public int solution(int[] nums) {
        boolean[] isExist=new boolean[200001]; //[0]은 버림
        int numOfType=0;
        
        for(int i=0;i<nums.length;i++){
            if(!isExist[nums[i]]){
                isExist[nums[i]]=true;
                numOfType++;
            }
        }
        
        if(nums.length/2>numOfType) return numOfType;
        else return nums.length/2;
    }
}

/*
min(nums.length/2, 종류 수)
*/