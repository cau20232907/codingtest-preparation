function solution(sequence, k) {
    let seqStart=0;
    let seqEnd=k;
    let currentStart=0;
    let currentSum=0;
    for(let i=0;i<sequence.length;i++){
        currentSum+=sequence[i];
        while(currentSum>k){
            currentSum-=sequence[currentStart++];
        }
        if(currentSum===k&&i-currentStart<seqEnd-seqStart){
            seqStart=currentStart;
            seqEnd=i;
        }
    }
    return [seqStart, seqEnd];
}