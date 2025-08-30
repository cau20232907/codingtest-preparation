function solution(want, number, discount) {
    const diffs = {};
    for(let i=0;i<want.length;i++)
        diffs[want[i]]=-number[i];
    for(let i=0;i<10;i++){
        diffs[discount[i]]=(diffs[discount[i]]||0)+1;
    }
    let result=0;
    let countCurrent=Object.values(diffs).filter(c=>c!==0).length===0;
    countCurrent&&result++;
    for(let i=10;i<discount.length;i++){
        if(discount[i]===discount[i-10]){
            countCurrent&&result++;
        } else {
            diffs[discount[i-10]]--;
            diffs[discount[i]]=(diffs[discount[i]]||0)+1;
            if(countCurrent) countCurrent=false;
            else {
                countCurrent=Object.values(diffs).filter(c=>c!==0).length===0;
                countCurrent&&result++;
            }
        }
    }
    return result;
}