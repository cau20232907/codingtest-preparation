function solution(s) {
    let repetition=0;
    let removed=0;
    while(s!=="1"){
        const prevStr=[...s];
        const nextNum=prevStr.filter(i=>i==='1').length;
        removed+=prevStr.length-nextNum;
        s=nextNum.toString(2);
        repetition++;
    }
    return [repetition, removed];
}