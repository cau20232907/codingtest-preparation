function solution(s){
    let numOfOpened=0;
    for(const char of s.split("")){
        switch(char){
            case "(":
                numOfOpened++;
                break;
            case ")":
                numOfOpened--;
                if(numOfOpened<0){
                    return false;
                }
        }
    }
    return numOfOpened===0;
}