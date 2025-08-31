function solution(topping) {
    const lastPos=topping.reduce((map,value,idx)=>{
        map[value]=idx
        return map;
    },{});
    let toppingCountFromLast=Object.keys(lastPos).length;
    const toppingFromFirst=new Set();
    let result=0;
    let i=-1; //첫 반복문 진입 시 0으로 초기화
    while(toppingFromFirst.size<=toppingCountFromLast){
        i++;
        toppingFromFirst.add(topping[i]);
        lastPos[topping[i]]===i&&toppingCountFromLast--;
        if(toppingFromFirst.size===toppingCountFromLast)
            result++;
    }
    return result;
}