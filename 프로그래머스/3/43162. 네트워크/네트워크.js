function solution(n, computers) {
    const root=new Array(n);
    for(let i=0;i<root.length;i++)
        root[i]=i;
    for(let i=0;i<computers.length;i++)
        for(let j=i+1;j<computers[i].length;j++)
            if(computers[i][j]===1){
                //propagation
                let value;
                let idx;
                let prevValue;
                if(root[i]<root[j]){
                    value=root[i];
                    idx=j;
                }else{
                    value=root[j];
                    idx=i;
                }
                prevValue=idx; //while문 첫 진입을 위한 코드 맞추기
                do{
                    idx=prevValue;
                    prevValue=root[idx];
                    root[idx]=value;
                }while(prevValue!==idx);
            }
    for(let i=0;i<root.length;i++)
        root[i]=root[root[i]]; //root 최종 업데이트
    return new Set(root).size;
}