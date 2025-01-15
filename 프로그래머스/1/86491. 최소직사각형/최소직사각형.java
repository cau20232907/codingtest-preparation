class Solution {
    public int solution(int[][] sizes) {
        int acr=0,dwn=0; //acr>dwn
        for(int[] size:sizes){
            if(size[0]>size[1]){
                if(acr<size[0]) acr=size[0];
                if(dwn<size[1]) dwn=size[1];
            }else{
                if(dwn<size[0]) dwn=size[0];
                if(acr<size[1]) acr=size[1];
            }
        }
        return acr*dwn;
    }
}